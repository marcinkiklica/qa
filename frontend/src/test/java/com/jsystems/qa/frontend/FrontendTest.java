package com.jsystems.qa.frontend;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class FrontendTest extends ConfigFrontend{
    String myUrl = "https://kiklica.home.blog/";

    @DisplayName("First selenium test")
    @Test
    public void firstSeleniumTest(){
        driver.get("https://wordpress.com/");

        WebElement login = driver.findElement(By.cssSelector(".x-nav-item--logged-in>.x-link"));
        WebElement buildTitle = driver.findElement(By.cssSelector(".lpc-headline-title>span:nth-child(1)"));
        assertTrue(login.isDisplayed());
        assertTrue(login.getText().equals("Log In"));
        assertTrue(buildTitle.isDisplayed());
        assertTrue(buildTitle.getText().equals("Build a website,"));
        login.click();
        wait(10);
    }


}
