package com.jsystems.qa.frontend.cucumber;

import com.jsystems.qa.frontend.Configuration;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CucumberStepConfig {

    WebDriver driver;

    @Before
    public static void setUpAll(){
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemClassLoader().getResource("drivers/chromedriver.exe").getFile());
        System.setProperty("webdriver.gecko.driver", ClassLoader.getSystemClassLoader().getResource("drivers/geckodriver.exe").getFile());
    }

    @After
    public void tearDown(Scenario scenario) {

        System.out.println("=========================== @After Cucumber Test  =======================================");
        String status;
        if(!scenario.isFailed()) {
            status = "( ͡° ͜ʖ ͡°)";
//            status = "++++++++++";
            scenario.write("Scenario passed");
        } else {
            status = "(✖╭╮✖)";
//            status = "-------------";
            scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES),"images/png");
            scenario.write("Scenario failed");
        }
        System.out.println("\n"+status+" End of: " + scenario.getName() + " scenario.");
        driver.quit();
        driver = null;
    }

    public WebDriver setUp(){
        String browser = Configuration.getBROWSER();
        setBrowserConf(browser);
        setDriver();

        return driver;
    }

    private void setDriver() {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }

    private void setBrowserConf(String browser) {
        System.out.println("Browser selected: " + browser);
        switch (browser) {
            case "chrome": driver = new ChromeDriver(); System.out.println("Chrome selected."); break;
            case "firefox": driver = new FirefoxDriver(); System.out.println("Firefox selected."); break;
        }
    }

}
