package com.jsystems.qa.frontend;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FrontendTest {
    String myUrl = "https://kiklica.home.blog/";
    WebDriver driver;


    @BeforeAll
    public static void setUpAll(){
//        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "D:/drivers/firefox/geckodriver.exe");
    }


    @Test
    public void firstSeleniumTest(){

//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        driver.get("https://wordpress.com/");

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement login = driver.findElement(By.cssSelector(".x-nav-item--logged-in>.x-link"));
        WebElement buildTitle = driver.findElement(By.cssSelector(".lpc-headline-title>span:nth-child(1)"));
        assertTrue(login.isDisplayed());
        assertTrue(login.getText().equals("Log In"));
        assertTrue(buildTitle.isDisplayed());
        assertTrue(buildTitle.getText().equals("Build a website,"));
        login.click();

        driver.quit();
    }

}
