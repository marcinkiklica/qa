package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class JunitTest {

    final String stringTestowy = "testowy";
    final String testNullCurrent = null;

    @Test
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
    public void secondTest(){
        assertThat(stringTestowy).isEqualTo("testowy");
        assertThat(testNullCurrent).isNull();
    }
}
