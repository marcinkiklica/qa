package com.jsystems.qa.frontend.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainWordpressPage extends BasePage {

    public MainWordpressPage(WebDriver driver) {
        super(driver);
    }

    private String loginSelector = ".x-nav-item--logged-in>.x-link";
    private String buildTitleSelector = ".lpc-headline-title>span:nth-child(1)";

    public WebElement login = driver.findElement(By.cssSelector(loginSelector));

    public WebElement buildTitle = driver.findElement(By.cssSelector(buildTitleSelector));
}
