package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class JunitTest {

    @Test
    public void firstTest(){
        String testCurrent = "testowy";
        String testNullCurrent = null;
        assertTrue(true);
        assertTrue(true, "Hello world!");
        assertTrue(5 == 2+3, "Hello world!");
        assertFalse(false, "Hello world!");
        assertFalse(testCurrent.matches("^s"));
        assertFalse(testCurrent.equals("testowy"));
        assertEquals("testowy", testCurrent);
        assertNotNull(testCurrent);
        assertNull(testNullCurrent, "Mial byc null.");
        assertSame("testowy", testCurrent);

    }
}
