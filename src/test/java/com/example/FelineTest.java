package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        List<String> actualFood = feline.eatMeat();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensWithoutCount() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }
}