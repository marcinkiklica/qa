package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Parameterized tests")
public class ParameterizedClassTest extends ConfigJunit {


    @BeforeEach
    public void setUp(TestInfo testInfo){
        System.out.println("========== BeforeEach =========");
        System.out.println("========== DisplayName: " + testInfo.getDisplayName());
        System.out.println("========== Test name:   " + testInfo.getTestMethod().get().getName()+ ".");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("========== After Each =========");
    }

    @DisplayName("First parameterized test")
    @ParameterizedTest(name = "Run test with value \"{0}\"")
    @ValueSource(ints = {5,15,25})
    public void paramFirstTest(int number){
        assertTrue(number % 5 == 0);
    }

    @DisplayName("First parameterized test")
    @ParameterizedTest(name = "Run test with value \"{0}\"")
    @ValueSource(strings = {"Hello","Hello Junit","Hello World"})
    public void paramSecondTest(String value){
        assertTrue(value.contains("Hello"));
    }

    @DisplayName("Csv value parameterized test")
    @ParameterizedTest(name = "Run test with values name-\"{0}\" and value {1}.")
    @CsvSource( value = {"Hello, 5","HelloJunit 5, 15","HelloWorld 5!, 25"}, delimiter = ',')
    public void paramMultiArgTest(String param1, int param2){
        assertTrue(param1.contains("Hello"));
        assertTrue(param2 % 5 ==  0);
    }

    @DisplayName("Csv file source parameterized test")
    @ParameterizedTest(name = "Run test with data from csv file:, name: \"{0}\" and {1}.")
    @CsvFileSource(resources = "/plik.csv", delimiter = ',')
    public void paramCsvFileSourceTest(String param1, int param2){
        assertTrue(param1.contains("Hello"));
        assertTrue(param2 % 5 ==  0);
    }
}
