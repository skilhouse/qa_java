package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class IntegrationTest {

    @Mock
    private Predator mockPredator;

    @Test
    public void testLionAndCatWithSamePredator() throws Exception {
        Mockito.when(mockPredator.getKittens()).thenReturn(2);
        Mockito.when(mockPredator.eatMeat()).thenReturn(List.of("Мясо", "Рыба"));

        Lion lion = new Lion("Самец", mockPredator);
        Cat cat = new Cat(mockPredator);

        assertTrue(lion.doesHaveMane());
        assertEquals(2, lion.getKittens());
        assertEquals(List.of("Мясо", "Рыба"), lion.getFood());

        assertEquals("Мяу", cat.getSound());
        assertEquals(List.of("Мясо", "Рыба"), cat.getFood());

        Mockito.verify(mockPredator, Mockito.times(1)).getKittens();
        Mockito.verify(mockPredator, Mockito.times(2)).eatMeat();
    }
}