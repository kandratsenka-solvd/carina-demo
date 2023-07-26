package com.zebrunner.carina.demo.gui.pages.desktop.task;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InstagramPage extends AbstractPage {


    @FindBy(xpath = "//h2[contains(text(), 'gsmarenateam')]")
    private ExtendedWebElement titleText;

    public InstagramPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleTextPresent() {
        return titleText.isElementPresent();
    }
}
