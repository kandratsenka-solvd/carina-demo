package com.zebrunner.carina.demo.gui.components.header;

import com.zebrunner.carina.demo.gui.pages.desktop.task.*;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractUIObject {

    @FindBy(xpath = "//button//*[@class='lines']")
    private ExtendedWebElement hamburgerMenuButton;

    @FindBy(id = "menu")
    private HamburgerMenu hamburgerMenu;

    @FindBy(xpath = "//*[contains(@class, 'tip-us')]")
    private ExtendedWebElement tipUsButton;

    @FindBy(xpath = "//*[contains(@class, 'youtube')]")
    private ExtendedWebElement youTubeButton;

    @FindBy(xpath = "//*[contains(@class, 'instagram')]")
    private ExtendedWebElement instagramButton;

    @FindBy(xpath = "//i[contains(@class, 'rss')]")
    private ExtendedWebElement rssButton;

    @FindBy(xpath = "//*[@id='social-connect']//*[contains(@href, 'arenaev')]")
    private ExtendedWebElement evButton;

    @FindBy(xpath = "//*[contains(@class, 'cart')]")
    private ExtendedWebElement merchButton;

    @FindBy(id = "login-active")
    private ExtendedWebElement loginButton;

    @FindBy(id = "login-popup2")
    private LoginForm loginForm;

    @FindBy(xpath = "//*[contains(@class, 'signup')]")
    private ExtendedWebElement signupButton;

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

    public TipUsPage openTipUsPage() {
        tipUsButton.click();
        return new TipUsPage(driver);
    }

    public YouTubePage openYouTubePage() {
        youTubeButton.click();
        return new YouTubePage(driver);
    }

    public InstagramPage openInstagramPage() {
        instagramButton.click();
        return new InstagramPage(driver);
    }

    public RssPage openRssPage() {
        rssButton.click();
        return new RssPage(driver);
    }

    public EvPage openEvPage() {
        evButton.click();
        return new EvPage(driver);
    }

    public MerchPage openMerchPage() {
        merchButton.click();
        return new MerchPage(driver);
    }

    public SignupPage openSignupPage() {
        signupButton.click();
        return new SignupPage(driver);
    }
}

