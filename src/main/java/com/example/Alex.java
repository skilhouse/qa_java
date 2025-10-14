package com.example;

import java.util.List;

public class Alex extends Lion {

    public Alex(Predator predator) throws Exception {
        super("Самец", predator);
    }

    public List<String> getFriends() {
        return List.of("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return 0;
    }
}