package com.zebrunner.carina.demo.gui.pages.desktop.task;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='article-info-name' and contains(text(), 'Sign Up')]")
    private ExtendedWebElement titleText;

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleTextPresent() {
        return titleText.isElementPresent();
    }
}
