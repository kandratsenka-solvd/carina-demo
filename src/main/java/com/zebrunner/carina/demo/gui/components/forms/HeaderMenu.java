package com.zebrunner.carina.demo.gui.components.forms;

import com.zebrunner.carina.demo.gui.pages.desktop.task.CarPage;
import com.zebrunner.carina.demo.gui.pages.desktop.task.TipUsPage;
import com.zebrunner.carina.demo.gui.pages.desktop.task.YouTubePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractUIObject {

    @FindBy(xpath = "//*[contains(@class, 'tip-us')]")
    private ExtendedWebElement tipUsButton;

    @FindBy(xpath = " //*[contains(@class, 'youtube')]")
    private ExtendedWebElement youTubeButton;

    @FindBy(xpath = "//button//*[@class='lines']")
    private ExtendedWebElement hamburgerMenuButton;

    @FindBy(id = "menu")
    private HamburgerMenu hamburgerMenu;

    @FindBy(id = "login-active")
    private ExtendedWebElement loginButton;

    @FindBy(id = "login-popup2")
    private LoginForm loginForm;

    @FindBy(xpath = "//*[@id='social-connect']//*[contains(@href, 'arenaev')]")
    private ExtendedWebElement carButton;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginForm getLoginForm() {
        loginButton.click();
        return loginForm;
    }

    public HamburgerMenu getHamburgerMenu() {
        hamburgerMenuButton.click();
        return hamburgerMenu;
    }

    public CarPage openCarPage() {
        carButton.click();
        return new CarPage(driver);
    }

    public TipUsPage openTipUsPage() {
        tipUsButton.click();
        return new TipUsPage(driver);
    }

    public YouTubePage openYouTubePage() {
        youTubeButton.click();
        return new YouTubePage(driver);
    }
}
