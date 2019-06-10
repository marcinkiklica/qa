package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Parameterized tests")
public class ParameterizedClassTest {

    @DisplayName("First parameterized test")
    @ParameterizedTest
    @ValueSource(ints = {5,15,25})
    public void paramFirstTest(int number){
        assertTrue(number % 5 == 0);
    }
}
