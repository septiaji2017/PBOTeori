package com.ridha.latihan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Niece {
    private String name;
    private Integer[] birthday;

    public Niece() {

    }

    public Niece(String name, int day, int month) {
        this.name = name;
        this.birthday = new Integer[]{day, month};
    }
    public String getName() {
        return name;
    }

    public Integer[] getBirthday() {
        return birthday;
    }

    private List<Uncle> uncles = new ArrayList<>();
    private List<String> presents = new ArrayList<>();

    public boolean hasReceivedPresent(Uncle uncle, String presentDescription) {
        return presents.contains(presentDescription) && uncles.contains(uncle);
    }


    public void addPresent(Uncle uncle, String presentDescription) {
        uncles.add(uncle);
        presents.add(presentDescription);
    }

    public String getPresentForUncle(int uncleIndex) {
        if (uncleIndex >= 0 && uncleIndex < uncles.size()) {
            Uncle uncle = uncles.get(uncleIndex);
            return presents.get(uncleIndex);
        }
        return null;
    }

}
