package com.zebrunner.carina.demo.gui.pages.desktop.task;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RssPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(text(), 'Latest articles')]")
    private ExtendedWebElement titleText;

    public RssPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitlePresent() {
        return titleText.isElementPresent();
    }
}
