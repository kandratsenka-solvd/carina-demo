package com.zebrunner.carina.demo.gui.pages.desktop.task;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MerchPage extends AbstractPage {

    @FindBy(xpath = "//li//*[contains(@href, 'cart')]")
    private ExtendedWebElement merchLink;

    public MerchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMerchLinkPresent() {
        return merchLink.isElementPresent();
    }
}
