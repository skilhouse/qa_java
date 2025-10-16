package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LionParameterizedTest {

    @Mock
    private Predator predator;

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    public void testLionGenderHasMane(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, predator);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Мужчина", "Женщина", "", "Unknown", "Male", "Female"})
    public void testInvalidSexThrowsException(String invalidSex) {
        Exception exception = assertThrows(Exception.class, () -> new Lion(invalidSex, predator));
        assertTrue(exception.getMessage().contains("Используйте допустимые значения пола животного"));
    }
}