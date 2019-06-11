package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.*;

public class ConfigJunit {

    @BeforeAll
    public static void setUpAll(TestInfo testInfo){
        System.out.println("========== BeforeAll ==========");
        System.out.println("========== Class  Name: " + testInfo.getTestClass().getClass().getSimpleName());
    }

    @AfterAll
    public static void tearDownAll(TestInfo testInfo){
        System.out.println("========== After All ==========");
        System.out.println("========== Class  Name: " + testInfo.getTestClass().getClass().getSimpleName());
    }

}
