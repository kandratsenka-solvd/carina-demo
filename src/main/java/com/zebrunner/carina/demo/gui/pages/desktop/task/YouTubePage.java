package com.zebrunner.carina.demo.gui.pages.desktop.task;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YouTubePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='text' and text()='GSMArena Official']")
    private ExtendedWebElement titleText;

    public YouTubePage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleTextPresent() {
        return titleText.isElementPresent();
    }
}
