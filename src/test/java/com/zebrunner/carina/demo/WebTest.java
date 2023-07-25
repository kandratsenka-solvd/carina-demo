package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.components.forms.LoginForm;
import com.zebrunner.carina.demo.gui.pages.desktop.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {

    @Test
    public void testLoginForm() throws InterruptedException {
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
    public void testElements() {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        homePage.refresh(5);
        homePage.allElementsPresent();
        String originalWindow = driver.getWindowHandle();
        homePage.getHeaderMenu().openYouTubePage();
        homePage.switchWindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("youtube.com"));
        driver.switchTo().window(originalWindow);
        homePage.getHeaderMenu().openCarPage();
        homePage.switchWindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("arenaev.com"));
        driver.switchTo().window(originalWindow);
        homePage.getHeaderMenu().openTipUsPage();
        homePage.switchWindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("tipus"));
        getDriver().switchTo().window(originalWindow);
        homePage.getHeaderMenu().getLoginForm();
        homePage.getHeaderMenu().getHamburgerMenu();
    }
}
