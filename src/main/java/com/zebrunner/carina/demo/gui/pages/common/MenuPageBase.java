package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MenuPageBase extends AbstractPage {

    public MenuPageBase(WebDriver driver) {
        super(driver);
    }

    public boolean titleContains(String subString) {
        return driver.getTitle().toLowerCase().contains(subString);
    }

    public boolean urlContains(String subString) {
        return driver.getCurrentUrl().toLowerCase().contains(subString);
    }
}
