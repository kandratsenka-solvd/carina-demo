package com.zebrunner.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.demo.gui.pages.common.MenuPageBase;
import org.openqa.selenium.WebDriver;

public class ContactPage extends MenuPageBase {

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleCorrect() {
        return driver.getTitle().toLowerCase().contains("contact");
    }
}
