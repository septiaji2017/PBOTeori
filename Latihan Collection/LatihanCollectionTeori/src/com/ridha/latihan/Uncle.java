package com.ridha.latihan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Uncle {
    private String name;
    public Uncle() {

    }
    public Uncle(String name) {
        this.name = name;
    }
    String getName() {
        return name;
    }
    public void addPresent(Map<Uncle, List<String>> presentsMap, Niece niece, String presentDescription) {
        List<String> presents = presentsMap.getOrDefault(this, new ArrayList<>());

        if (!presents.contains(presentDescription)) {
            presents.add(presentDescription);
            presentsMap.put(this, presents);

            if (!niece.hasReceivedPresent(this, presentDescription)) {
                niece.addPresent(this, presentDescription);
            }
        }
    }
}
