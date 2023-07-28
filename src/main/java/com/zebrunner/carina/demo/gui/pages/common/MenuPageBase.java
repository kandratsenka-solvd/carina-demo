package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class MenuPageBase extends AbstractPage {

    public MenuPageBase(WebDriver driver) {
        super(driver);
    }

    public boolean titleContains(String subString) {
        return driver.getTitle().toLowerCase().contains(subString);
    }

    public boolean isUrlCorrect(String subString) {
        return driver.getCurrentUrl().toLowerCase().contains(subString);
    }
}
