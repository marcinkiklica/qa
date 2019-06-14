package com.jsystems.qa.frontend.classicfrontend.test;

import com.jsystems.qa.frontend.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ConfigFrontend {

    WebDriver driver;
    String chromePath;
    String fireFoxPath;

    {
        try {
            chromePath = Paths.get(getClass().getClassLoader().getResource("drivers/chromedriver.exe").toURI()).toFile().getAbsolutePath();
            fireFoxPath = Paths.get(getClass().getClassLoader().getResource("drivers/geckodriver.exe").toURI()).toFile().getAbsolutePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void setUpAll(){
//        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
//        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemClassLoader().getResource("drivers/chromedriver.exe").getFile());
//
//        System.setProperty("webdriver.gecko.driver", ClassLoader.getSystemClassLoader().getResource("drivers/geckodriver.exe").getFile());

    }

    @BeforeEach
    public void setUpEach(){
        System.setProperty("webdriver.chrome.driver", chromePath);
        System.setProperty("webdriver.gecko.driver", fireFoxPath);
        String browser = Configuration.getBROWSER();
        setBrowserConf(browser);
        setDriver();

        driver.get(Configuration.BASE_URL);
    }

    private void setBrowserConf(String browser) {

        System.out.println("Browser selected: " + browser);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        FirefoxOptions ffOptions = new FirefoxOptions();
        ffOptions.addArguments("--no-sandbox");

        switch (browser) {
            case "chrome": driver = new ChromeDriver(); System.out.println("Chrome selected."); break;
            case "firefox": driver = new FirefoxDriver(); System.out.println("Firefox selected."); break;
        }
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
            sleep(seconds * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
