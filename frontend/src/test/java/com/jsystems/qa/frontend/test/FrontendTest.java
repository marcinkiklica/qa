package com.jsystems.qa.frontend.test;

import com.jsystems.qa.frontend.page.MainWordpressPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrontendTest extends ConfigFrontend {
    MainWordpressPage wordpressPage;

    @DisplayName("First selenium test")
    @Test
    public void firstSeleniumTest(){
        wordpressPage = new MainWordpressPage(driver);
        assertTrue(wordpressPage.login.isDisplayed());
        assertTrue(wordpressPage.login.getText().equals("Log In"));
        assertTrue(wordpressPage.buildTitle.isDisplayed());
        assertTrue(wordpressPage.buildTitle.getText().equals("Build a website,"));
        wordpressPage.login.click();
        wait(7);
    }
}
