package com.jsystems.qa.frontend.cucumber.steps;

import com.jsystems.qa.frontend.Configuration;
import com.jsystems.qa.frontend.cucumber.CucumberStepConfig;
import com.jsystems.qa.frontend.cucumber.page.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {
    WebDriver driver;
    MainWordpressPage wordpressPage;
    LoginPage loginPage;
    UserPage userPage;
    UserProfilePage userProfilePage;
    NotificationPage notificationPage;
    private final int TIMEOUT = 120;

    public LoginSteps(CucumberStepConfig stepConfig) {
        driver = stepConfig.setUp();

    }

    @Given("^User start on main page$")
    public void userStartOnMainPage() {
        driver.get(Configuration.BASE_URL);
    }

    @When("^User log in to the user page$")
    public void userLogInToTheUserPage() {
        logIn();

        userPage = new UserPage(driver);

        userPage.waitForVisibilityOfElement(userPage.userAvatar, TIMEOUT);
        assertTrue(userPage.userAvatar.isDisplayed());
        assertTrue(userPage.userAvatar.isEnabled());
    }

    @Then("^User can modified user profile$")
    public void userCanModifiedUserProfile() {
        userPage = new UserPage(driver);
        userPage.waitForVisibilityOfElement(userPage.userAvatar, TIMEOUT);
        userPage.userAvatar.click();
        userProfilePage = new UserProfilePage(driver);
        userProfilePage.waitForVisibilityOfElement(userProfilePage.buttonSave, TIMEOUT);

        assertTrue(userProfilePage.avatar.isDisplayed());
        assertTrue(userProfilePage.avatar.isEnabled());

        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", userProfilePage.buttonSave);
        assertTrue(userProfilePage.buttonSave.isDisplayed());
        assertFalse(userProfilePage.buttonSave.isEnabled());
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

    @Given("^User start on page \"([^\"]*)\"$")
    public void userStartOnPage(String arg0) throws Throwable {
        driver.get(arg0);
    }

    @Then("^User can modified notification$")
    public void userCanModifiedNotification() {
        userProfilePage = new UserProfilePage(driver);
        userProfilePage.waitForVisibilityOfElement(userProfilePage.notification, TIMEOUT);
        userProfilePage.notification.click();
        notificationPage = new NotificationPage(driver);
        notificationPage.waitForVisibilityOfElement(notificationPage.firstPagePowiadomienia, TIMEOUT);
        notificationPage.firstPagePowiadomienia.click();
        notificationPage.waitForVisibilityOfElement(notificationPage.firstCheckbox, TIMEOUT);
        assertTrue(notificationPage.firstCheckbox.isSelected());
    }
}
