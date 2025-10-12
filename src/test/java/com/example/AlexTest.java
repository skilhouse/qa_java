package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AlexTest {

    @Test
    public void testAlexConstructor() throws Exception {
        Alex alex = new Alex();
        assertTrue(alex.doesHaveMane());
    }

    @Test
    public void testGetFriends() throws Exception {
        Alex alex = new Alex();
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");

        List<String> actualFriends = alex.getFriends();

        assertEquals(expectedFriends, actualFriends);
        assertEquals(3, actualFriends.size());
        assertTrue(actualFriends.contains("Марти"));
        assertTrue(actualFriends.contains("Глория"));
        assertTrue(actualFriends.contains("Мелман"));
    }

    @Test
    public void testGetPlaceOfLiving() throws Exception {
        Alex alex = new Alex();
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void testGetKittens() throws Exception {
        Alex alex = new Alex();
        assertEquals(0, alex.getKittens());
    }

    @Test
    public void testAlexInheritance() throws Exception {
        Alex alex = new Alex();
        assertTrue(true);
        assertTrue(alex.doesHaveMane());
        List<String> food = alex.getFood();
        assertNotNull(food);
        assertFalse(food.isEmpty());
    }

    @Test
    public void testAlexSpecificBehavior() throws Exception {
        Alex alex = new Alex();

        assertEquals(0, alex.getKittens());
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());

        List<String> friends = alex.getFriends();
        assertEquals(3, friends.size());
        assertEquals("Марти", friends.get(0));
        assertEquals("Глория", friends.get(1));
        assertEquals("Мелман", friends.get(2));
    }
}