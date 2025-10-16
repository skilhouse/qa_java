package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AlexTest {

    @Mock
    private Predator predator;

    @Test
    public void testAlexIsMaleWithMane() throws Exception {
        Alex alex = new Alex(predator);
        assertTrue(alex.doesHaveMane());
    }

    @Test
    public void testGetFriendsReturnsCorrectList() throws Exception {
        Alex alex = new Alex(predator);
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        assertEquals(expectedFriends, alex.getFriends());
    }

    @Test
    public void testGetPlaceOfLivingReturnsZoo() throws Exception {
        Alex alex = new Alex(predator);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void testGetKittensReturnsZero() throws Exception {
        Alex alex = new Alex(predator);
        assertEquals(0, alex.getKittens());
    }
}