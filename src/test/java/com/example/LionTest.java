package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private Predator predator;

    @Test
    public void testGetKittens() throws Exception {
        Mockito.when(predator.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", predator);
        assertEquals(3, lion.getKittens());

        Mockito.verify(predator).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Рыба");
        Mockito.when(predator.eatMeat()).thenReturn(expectedFood);

        Lion lion = new Lion("Самка", predator);
        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
        Mockito.verify(predator).eatMeat();
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion maleLion = new Lion("Самец", predator);
        Lion femaleLion = new Lion("Самка", predator);

        assertTrue(maleLion.doesHaveMane());
        assertFalse(femaleLion.doesHaveMane());
    }
}