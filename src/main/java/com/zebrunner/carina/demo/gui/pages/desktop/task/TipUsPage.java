package com.zebrunner.carina.demo.gui.pages.desktop.task;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TipUsPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='article-info-name' and contains(text(), 'Tip us')]")
    private ExtendedWebElement headerText;

    public TipUsPage(WebDriver driver) {
        super(driver);
    }
}
