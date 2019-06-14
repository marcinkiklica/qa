package com.jsystems.qa.frontend.classicfrontend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainWordpressPage extends BasePage {

    public MainWordpressPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

//    private String loginSelector = ".x-nav-item--logged-in>.x-link";
//    private String buildTitleSelector = ".lpc-headline-title>span:nth-child(1)";

//    public WebElement login = driver.findElement(By.cssSelector(loginSelector));
//
//    public WebElement buildTitle = driver.findElement(By.cssSelector(buildTitleSelector));

    @FindBy(css = ".x-nav-item.x-nav-item--wide.x-nav-item--logged-in a.x-nav-link.x-link")
    public WebElement login;

    @FindBy(css = "#lpc-headline .lpc-headline-container.lp-headline-container h1 span:nth-child(1)")
    public WebElement buildTitle;
}
