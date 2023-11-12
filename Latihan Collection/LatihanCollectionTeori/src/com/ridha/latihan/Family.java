package com.ridha.latihan;

import java.time.LocalDate;
import java.util.*;

public class Family {
    private List<Niece> nieces;
    private List<Uncle> uncles;
    private Map<Uncle, List<String>> presentsMap;

    public Family(){
        nieces = new ArrayList<>();
        uncles = new ArrayList<>();
        presentsMap = new HashMap<>();
    }

    public boolean addNiece(String name, int day, int month){
        for (Niece niece : nieces) {
            if (niece.getName().equals(name)) {
                return false;
            }
        }
        nieces.add(new Niece(name, day, month));
        return true;
    }

    public boolean addUncle(String name){
        for (Uncle uncle: uncles) {
            if (uncle.getName().equals(name)) {
                return false;
            }
        }
        uncles.add(new Uncle(name));
        presentsMap.put(new Uncle(name), new ArrayList<>());
        return true;
    }

    public List<Niece> getNieces() {
        return nieces;
    }

    public List<Uncle> getUncles() {
        return uncles;
    }

    public Map<Uncle, List<String>> getPresentsMap() {
        return presentsMap;
    }

    public void listNieces(){
        System.out.println("Nieces:");
        for (Niece niece : nieces) {
            System.out.println("  " + niece.getName());
        }
    }

    public void listUncles(){
        System.out.println("Uncles:");
        for (Uncle uncle : uncles) {
            System.out.println("  " + uncle.getName());
        }
    }


    public void listPresentsByUncle(Uncle uncle) {
        List<String> presents = presentsMap.getOrDefault(uncle, new ArrayList<>());

        System.out.println("Uncle: " + uncle.getName());

        if(presents.isEmpty()){
            System.out.println(uncle.getName() + " presents nothing");
        }

        for (String present : presents) {
            Niece niece = findNieceByPresent(uncle, present);
            System.out.println("  Present: " + present + ", Niece: " + (niece != null ? niece.getName() : "No niece assigned"));
        }

        List<Niece> niecesWithoutPresent = getNiecesWithoutPresent();
        System.out.println("  Nieces without present:");
        for (Niece niece : niecesWithoutPresent) {
            System.out.println("    Niece: " + niece.getName());
        }
    }

    public void listPresentsByNiece(Niece niece) {

        System.out.println("Niece: " + niece.getName());

        List<Uncle> unclesWithoutPresent = new ArrayList<>(uncles);
        for (Uncle uncle : uncles) {
            List<String> presents = presentsMap.getOrDefault(uncle, new ArrayList<>());
            String present = niece.getPresentForUncle(uncles.indexOf(uncle));

            if (present != null && presents.contains(present)) {
                System.out.println("  Present: " + present + ", Uncle: " + uncle.getName());
                unclesWithoutPresent.remove(uncle);
            }
        }

        System.out.println("  Uncles without present:");
        for (Uncle uncle : unclesWithoutPresent) {
            System.out.println("    Uncle: " + uncle.getName());
        }
    }

    public Niece findNieceByPresent(Uncle uncle, String present) {
        for (Niece niece : nieces) {
            if (niece.hasReceivedPresent(uncle, present)) {
                return niece;
            }
        }
        return null;
    }

    public List<Niece> getNiecesWithoutPresent() {
        List<Niece> niecesWithoutPresent = new ArrayList<>(nieces);
        for (Map.Entry<Uncle, List<String>> entry : presentsMap.entrySet()) {
            Uncle uncle = entry.getKey();
            List<String> presents = entry.getValue();
            for (String present : presents) {
                Niece niece = findNieceByPresent(uncle, present);
                if (niece != null) {
                    niecesWithoutPresent.remove(niece);
                }
            }
        }
        return niecesWithoutPresent;
    }

    public void deletePresentsForNiece(Niece niece) {
        for (Map.Entry<Uncle, List<String>> entry : presentsMap.entrySet()) {
            Uncle uncle = entry.getKey();
            List<String> presents = entry.getValue();

            if (isBirthdayPast(niece)) {
                presents.removeIf(present -> niece.hasReceivedPresent(uncle, present));
            }
        }
    }


    private boolean isBirthdayPast(Niece niece) {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthday = LocalDate.of(currentDate.getYear(), niece.getBirthday()[1], niece.getBirthday()[0]);
        return currentDate.isAfter(birthday);
    }

}
