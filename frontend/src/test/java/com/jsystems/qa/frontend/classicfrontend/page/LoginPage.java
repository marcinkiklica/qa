package com.jsystems.qa.frontend.classicfrontend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

//    private String emailInputSelector = "usernameOrEmail";
//    private String passwordInputSelector = "password";
//    private String continueButtonSelector = ".login__form-action .button.form-button.is-primary";
//
//    public WebElement emailInput = driver.findElement(By.id(emailInputSelector));
//    public WebElement passwordInput = driver.findElement(By.id(passwordInputSelector));
//    public WebElement buttonContinue = driver.findElement(By.cssSelector(continueButtonSelector));


    @FindBy(id = "usernameOrEmail")
    public WebElement emailInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(css = ".login__form-action .button.form-button.is-primary")
    public WebElement buttonContinue;
}
