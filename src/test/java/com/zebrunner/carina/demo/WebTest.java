package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.components.header.LoginForm;
import com.zebrunner.carina.demo.gui.pages.desktop.HomePage;
import com.zebrunner.carina.demo.gui.pages.desktop.task.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {

    @Test
    public void testLoginForm() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        homePage.getHeaderMenu().getHamburgerMenu();
        LoginForm loginForm = homePage.getHeaderMenu().getLoginForm();
        loginForm.enterEmail();
        loginForm.enterPassword();
        loginForm.clickSubmitButton();
//        Assert.assertTrue(homePage.successTextIsPresent(), "Login failed.");
        Assert.assertTrue(homePage.userIconIsPresent(), "Login failed.");
    }

    @Test
    public void testHeaderMenuElements() {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        homePage.allElementsPresent();
        String originalWindow = driver.getWindowHandle();

        TipUsPage tipUsPage = homePage.getHeaderMenu().openTipUsPage();
        homePage.switchWindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("tipus"), "Link does not contain a substring.");
        Assert.assertTrue(tipUsPage.isTitleTextPresent(), "Provided element not found.");
        driver.switchTo().window(originalWindow);
        driver.navigate().back();

        YouTubePage youTubePage = homePage.getHeaderMenu().openYouTubePage();
        homePage.switchWindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("youtube.com"), "Link does not contain a substring.");
        Assert.assertTrue(youTubePage.isTitleTextPresent(), "Provided element not found.");
        driver.close();
        driver.switchTo().window(originalWindow);

        InstagramPage instagramPage = homePage.getHeaderMenu().openInstagramPage();
        homePage.switchWindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("instagram.com"), "Link does not contain a substring.");
        Assert.assertTrue(instagramPage.isTitleTextPresent(), "Provided element not found.");
        driver.close();
        driver.switchTo().window(originalWindow);

        RssPage rssPage = homePage.getHeaderMenu().openRssPage();
        homePage.switchWindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("gsmarena.com/rss-news"), "Link does not contain a substring.");
        Assert.assertTrue(rssPage.isTitlePresent());
        driver.navigate().back();

        EvPage evPage = homePage.getHeaderMenu().openEvPage();
        homePage.switchWindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("arenaev.com"), "Link does not contain a substring.");
        Assert.assertTrue(evPage.isLogoPresent(), "Provided element not found.");
        driver.close();
        driver.switchTo().window(originalWindow);

        MerchPage merchPage = homePage.getHeaderMenu().openMerchPage();
        homePage.switchWindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("merch.gsmarena.com"), "Link does not contain a substring.");
        Assert.assertTrue(merchPage.isMerchLinkPresent(), "Provided element not found.");
        driver.close();
        driver.switchTo().window(originalWindow);

        homePage.getHeaderMenu().getLoginForm();

        SignupPage signupPage = homePage.getHeaderMenu().openSignupPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("gsmarena.com/register"), "Link does not contain a substring.");
        Assert.assertTrue(signupPage.isTitleTextPresent(), "Provided element not found.");
    }
}
