package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Metoda szkoleniowa Junita")
public class JunitTest {

    final String stringTestowy = "testowy";
    final String testNullCurrent = null;

    @Test
    @DisplayName("First junit test case")
    public void firstTest(){


        assertTrue(true);
        assertTrue(true, "Hello world!");
        assertTrue(5 == 2+3, "Hello world!");
        assertFalse(false, "Hello world!");
        assertFalse(stringTestowy.matches("^s"));
        assertTrue(stringTestowy.equals("testowy"));
        assertEquals("testowy", stringTestowy);
        assertNotNull(stringTestowy);
        assertNull(testNullCurrent, "Mial byc null.");
        assertSame("testowy", stringTestowy);

        System.out.println(0.2 * 0.2 );
        assertTrue(new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue() == 0.04);
//        assertTrue(0.2 * 0.2 == 0.04);

    }

    @Test
    @DisplayName("Second junit test case")
    public void secondTest(){
        assertThat(stringTestowy).isEqualTo("testowy");
        assertThat(testNullCurrent).isNull();
    }

    @Test
    @Tag("All")
    @RepeatedTest(5)
    @DisplayName("Array junit test case")
    public void arrayTest(){
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(3,4,5);

        assertTrue(list1.containsAll(list2));
        assertThat(list1).hasSize(5);
        assertThat(list2).containsAnyOf(1,2,3,4,5,6,7,8);
    }

    @Test
    @DisplayName("Testowy junit test case")
    @Disabled("Empty test")
    public void testowa(){

    }
}
