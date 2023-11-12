package com.ridha.latihan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainV2 {
    public static void main(String[] args) {

        Family family = new Family();
        Uncle uncles = new Uncle();
        Niece nieces = new Niece();

        family.addNiece("Amy", 1, 5);
        family.addNiece("Beatrice", 3, 7);
        family.addNiece("Claire", 3, 9);
        family.addNiece("Emily", 4, 5);

        System.out.println();

        family.addUncle("Albert");
        family.addUncle("Bill");
        family.addUncle("Charlie");
        family.addUncle("David");

        Uncle albert = family.getUncles().get(0);
        Uncle bill = family.getUncles().get(1);
        Uncle charlie = family.getUncles().get(2);
        Uncle david = family.getUncles().get(3);

        Niece amy = family.getNieces().get(0);
        Niece beatrice = family.getNieces().get(1);
        Niece claire = family.getNieces().get(2);
        Niece emily = family.getNieces().get(3);

        albert.addPresent(family.getPresentsMap(), amy, "The Wonder of Computer");
        albert.addPresent(family.getPresentsMap(), beatrice, "The Old Man and The Sea");
        albert.addPresent(family.getPresentsMap(), claire, "The Curious Incident of the Dog in the Night");
        albert.addPresent(family.getPresentsMap(), emily, "Twilight Saga");

        bill.addPresent(family.getPresentsMap(), amy, "The Amazing of Traversal");
        bill.addPresent(family.getPresentsMap(), beatrice, "The Amazing Spider-Man");
        bill.addPresent(family.getPresentsMap(), claire, "Avenger");
        bill.addPresent(family.getPresentsMap(), emily, "Avenger 2");

        family.listNieces();

        System.out.println();
        family.listUncles();

        System.out.println();
        family.listPresentsByUncle(albert);
        family.listPresentsByUncle(bill);
        family.listPresentsByUncle(charlie);
        family.listPresentsByUncle(david);

        System.out.println();
        family.listPresentsByNiece(amy);
        family.listPresentsByNiece(beatrice);
        family.listPresentsByNiece(claire);
        family.listPresentsByNiece(emily);

        System.out.println();
        family.deletePresentsForNiece(amy);
        family.deletePresentsForNiece(beatrice);

        System.out.println("After Deletion");
        family.listPresentsByNiece(amy);
        family.listPresentsByNiece(beatrice);
        family.listPresentsByNiece(claire);
        family.listPresentsByNiece(emily);

    }
}
