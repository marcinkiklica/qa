package com.jsystems.qa.frontend.cucumber.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationPage extends BasePage {
    public NotificationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "#primary > main > div:nth-child(4) > div.card.notification-settings-blog-settings.is-expanded > div > div.notification-settings-form > div.notification-settings-form__streams > div:nth-child(2) > ul > li:nth-child(1) > input")
    public WebElement firstCheckbox;

    @FindBy(css = "#primary > main > div:nth-child(4) > div:nth-child(2) > header > div.blogs-settings__header-legend")
    public WebElement firstPagePowiadomienia;
}
