package com.jsystems.qa.frontend;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ConfigFrontend {

    WebDriver driver;

    @BeforeAll
    public static void setUpAll(){
//        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemClassLoader().getResource("drivers/chromedriver.exe").getFile());
//        System.setProperty("webdriver.gecko.driver", ClassLoader.getSystemClassLoader().getResource("drivers/geckodriver.exe").getFile());
    }

    @BeforeEach
    public void setUpEach(){
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        setDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    private void setDriver() {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }

    public void wait(int seconds){
        try {
            sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
