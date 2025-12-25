package com.example;

import java.util.List;

public class LionAlex extends Lion{
    public LionAlex(Feline feline) throws Exception {
        super("Самец", feline);
    }

    public List<String> getFriends() {
        List<String> friends = List.of("Зебра Марти", "Бегемотиха Глория", "Жираф Мелман");
        return friends;
    }

    public String getPlaceOfLiving() {
        String placeOfLiving = "Нью-Йоркский зоопарк";
        return placeOfLiving;
    }

    @Override
    public int getKittens() {
        return 0;
    }
}
