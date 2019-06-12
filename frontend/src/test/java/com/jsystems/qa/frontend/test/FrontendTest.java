package com.jsystems.qa.frontend.test;

import com.jsystems.qa.frontend.Configuration;
import com.jsystems.qa.frontend.page.LoginPage;
import com.jsystems.qa.frontend.page.MainWordpressPage;
import com.jsystems.qa.frontend.page.UserPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrontendTest extends ConfigFrontend {
    MainWordpressPage wordpressPage;
    LoginPage loginPage;
    UserPage userPage;

    private final int TIMEOUT = 30;

    @DisplayName("First selenium test")
    @Test
    public void firstSeleniumTest(){
        wordpressPage = new MainWordpressPage(driver);
        loginPage.waitForVisibilityOfElement(wordpressPage.login, TIMEOUT);
        assertTrue(wordpressPage.login.isDisplayed());
        assertTrue(wordpressPage.login.getText().equals("Log In"));
        assertTrue(wordpressPage.buildTitle.isDisplayed());
        assertTrue(wordpressPage.buildTitle.getText().equals("Build a website,"));
        wordpressPage.login.click();
        wait(7);
    }

    @Test
    public void loginTest(){
        logIn();

        userPage = new UserPage(driver);
        userPage.waitForVisibilityOfElement(userPage.userAvatar, TIMEOUT);
        assertTrue(userPage.userAvatar.isDisplayed());
        assertTrue(userPage.userAvatar.isEnabled());
        wait(7);
    }

    private void logIn() {
        wordpressPage = new MainWordpressPage(driver);
        wordpressPage.waitForVisibilityOfElement(wordpressPage.login, TIMEOUT);
        wordpressPage.login.click();

        loginPage = new LoginPage(driver);
        loginPage.waitForVisibilityOfElement(loginPage.emailInput, TIMEOUT);
        loginPage.emailInput.clear();
        loginPage.emailInput.sendKeys(Configuration.LOGIN);
        loginPage.buttonContinue.click();
        loginPage.waitForVisibilityOfElement(loginPage.passwordInput, TIMEOUT);
        loginPage.passwordInput.clear();
        loginPage.passwordInput.sendKeys(Configuration.PASSWORD);
        loginPage.buttonContinue.click();
    }
}
