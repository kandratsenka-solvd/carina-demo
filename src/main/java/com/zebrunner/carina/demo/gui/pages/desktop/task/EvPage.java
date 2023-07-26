package com.zebrunner.carina.demo.gui.pages.desktop.task;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EvPage extends AbstractPage {

    @FindBy(xpath = "//object[contains(@data, 'arenaev')]")
    private ExtendedWebElement logo;

    public EvPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoPresent() {
        return logo.isElementPresent();
    }

}
