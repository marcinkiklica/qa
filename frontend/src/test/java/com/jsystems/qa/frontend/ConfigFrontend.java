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
        System.setProperty("webdriver.gecko.driver", ClassLoader.getSystemClassLoader().getResource("drivers/geckodriver.exe").getFile());
    }

    @BeforeEach
    public void setUpEach(){
        String browser = Configuration.getBROWSER();
        setBrowserConf(browser);
        setDriver();

        driver.get(Configuration.BASE_URL);
    }

    private void setBrowserConf(String browser) {
        System.out.println("Browser selected: " + browser);
        switch (browser) {
            case "chrome": driver = new ChromeDriver(); System.out.println("Chrome selected."); break;
            case "firefox": driver = new FirefoxDriver(); System.out.println("Firefox selected."); break;
//            default: driver = new ChromeDriver();
        }
//        if (browser.equals("chrome")){
//            driver = new ChromeDriver();
//        }
//        else if (browser.equals("Firefox")) {
//            driver = new FirefoxDriver();
//        }
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
