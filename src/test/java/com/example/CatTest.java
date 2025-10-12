package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    private Predator predator;

    @Test
    public void testGetSound() {
        Cat cat = new Cat(predator);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Мыши", "Птицы");
        Mockito.when(predator.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(predator);
        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
        Mockito.verify(predator).eatMeat();
    }

    @Test
    public void testGetFoodException() throws Exception {
        Mockito.when(predator.eatMeat()).thenThrow(new Exception("Ошибка получения еды"));

        Cat cat = new Cat(predator);
        Exception exception = assertThrows(Exception.class, cat::getFood);

        assertEquals("Ошибка получения еды", exception.getMessage());
    }

    @Test
    public void testConstructorWithFeline() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        assertNotNull(cat);
    }

    @Test
    public void testConstructorWithPredator() {
        Cat cat = new Cat(predator);
        assertNotNull(cat);
    }
}