package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class FelineParameterizedTest {

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "-1, -1",
            "100, 100",
            "999, 999",
            "-999, -999"
    })
    public void testGetKittensWithDifferentCounts(int inputCount, int expectedCount) {
        Feline feline = new Feline();
        assertEquals(expectedCount, feline.getKittens(inputCount));
    }
}