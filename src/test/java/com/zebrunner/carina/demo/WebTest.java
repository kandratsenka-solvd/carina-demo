package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.components.footer.FooterMenu;
import com.zebrunner.carina.demo.gui.components.header.HamburgerMenu;
import com.zebrunner.carina.demo.gui.components.header.LoginForm;
import com.zebrunner.carina.demo.gui.pages.desktop.*;
import com.zebrunner.carina.demo.gui.pages.desktop.task.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {

    private static final String ERROR_MESSAGE_ELEMENT = "Provided element not found.";
    private static final String ERROR_MESSAGE_LINK = "Link doesn't contain a substring.";
    private static final String ERROR_MESSAGE_TITLE = "Title doesn't contain a substring.";
    private static final String ERROR_MESSAGE_HOME = "Home page is not opened!";

    @Test
    public void testLoginForm() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), ERROR_MESSAGE_HOME);
        homePage.getHeaderMenu().getHamburgerMenu();
        LoginForm loginForm = homePage.getHeaderMenu().getLoginForm();
        loginForm.enterEmail();
        loginForm.enterPassword();
        loginForm.clickSubmitButton();
        Assert.assertTrue(homePage.userIconIsPresent(), "Login failed.");
    }

    @Test
    public void testHeaderMenuElements() {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), ERROR_MESSAGE_HOME);
        homePage.allElementsPresent();
        String originalWindow = driver.getWindowHandle();
        TipUsPage tipUsPage = homePage.getHeaderMenu().openTipUsPage();
        Assert.assertTrue(tipUsPage.isUrlCorrect("tipus"), ERROR_MESSAGE_LINK);
        Assert.assertTrue(tipUsPage.titleContains("tip us"), ERROR_MESSAGE_ELEMENT);
        driver.navigate().back();
        YouTubePage youTubePage = homePage.getHeaderMenu().openYouTubePage();
        homePage.switchWindow();
        Assert.assertTrue(youTubePage.isUrlCorrect("youtube.com"), ERROR_MESSAGE_LINK);
        Assert.assertTrue(youTubePage.titleContains("youtube"), ERROR_MESSAGE_ELEMENT);
        driver.close();
        driver.switchTo().window(originalWindow);
        InstagramPage instagramPage = homePage.getHeaderMenu().openInstagramPage();
        homePage.switchWindow();
        Assert.assertTrue(instagramPage.isUrlCorrect("instagram.com"), ERROR_MESSAGE_LINK);
        Assert.assertTrue(instagramPage.titleContains("@gsmarenateam"), ERROR_MESSAGE_ELEMENT);
        driver.close();
        driver.switchTo().window(originalWindow);
        RssPage rssPage = homePage.getHeaderMenu().openRssPage();
        homePage.switchWindow();
        Assert.assertTrue(rssPage.isUrlCorrect("gsmarena.com/rss-news"), ERROR_MESSAGE_LINK);
        Assert.assertTrue(rssPage.getTitle().isEmpty());
        driver.navigate().back();
        EvPage evPage = homePage.getHeaderMenu().openEvPage();
        homePage.switchWindow();
        Assert.assertTrue(evPage.isUrlCorrect("arenaev.com"), ERROR_MESSAGE_LINK);
        Assert.assertTrue(evPage.titleContains("arenaev"), ERROR_MESSAGE_ELEMENT);
        driver.close();
        driver.switchTo().window(originalWindow);
        MerchPage merchPage = homePage.getHeaderMenu().openMerchPage();
        homePage.switchWindow();
        Assert.assertTrue(merchPage.isUrlCorrect("merch.gsmarena.com"), ERROR_MESSAGE_LINK);
        Assert.assertTrue(merchPage.titleContains("gsmarena"), ERROR_MESSAGE_ELEMENT);
        driver.close();
        driver.switchTo().window(originalWindow);
        homePage.getHeaderMenu().getLoginForm();
        SignupPage signupPage = homePage.getHeaderMenu().openSignupPage();
        Assert.assertTrue(signupPage.isUrlCorrect("gsmarena.com/register"), ERROR_MESSAGE_LINK);
        Assert.assertTrue(signupPage.titleContains("create account"), ERROR_MESSAGE_ELEMENT);
    }

    @Test
    public void testHamburgerMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), ERROR_MESSAGE_HOME);
        homePage.allElementsPresent();
        HamburgerMenu hamburgerMenu = homePage.getHeaderMenu().getHamburgerMenu();
        hamburgerMenu.clickHomeButton();
        Assert.assertTrue(homePage.isUrlCorrect(), ERROR_MESSAGE_LINK);
        Assert.assertTrue(homePage.titleContains(), ERROR_MESSAGE_TITLE);
        NewsPage newsPage = hamburgerMenu.clickNewsButton();
        Assert.assertTrue(newsPage.titleContains(), ERROR_MESSAGE_TITLE);
        Assert.assertTrue(newsPage.isUrlCorrect(), ERROR_MESSAGE_LINK);
        ReviewsPage reviewsPage = hamburgerMenu.clickReviewsButton();
        Assert.assertTrue(reviewsPage.isUrlCorrect("reviews"), ERROR_MESSAGE_LINK);
        Assert.assertTrue(reviewsPage.titleContains("reviews"), ERROR_MESSAGE_TITLE);
        VideosPage videosPage = hamburgerMenu.clickVideosButton();
        Assert.assertTrue(videosPage.isUrlCorrect("videos"), ERROR_MESSAGE_LINK);
        Assert.assertTrue(videosPage.titleContains("videos"), ERROR_MESSAGE_TITLE);
        FeaturedPage featuredPage = hamburgerMenu.clickFeaturedButton();
        Assert.assertTrue(featuredPage.isUrlCorrect("featured"), ERROR_MESSAGE_LINK);
        Assert.assertTrue(featuredPage.titleContains("featured"), ERROR_MESSAGE_TITLE);
        PhoneFinderPage phoneFinderPage = hamburgerMenu.clickPhoneFinderButton();
        Assert.assertTrue(phoneFinderPage.isUrlCorrect("search"), ERROR_MESSAGE_LINK);
        Assert.assertTrue(phoneFinderPage.titleContains("finder"), ERROR_MESSAGE_TITLE);
        DealsPage dealsPage = hamburgerMenu.clickDealsButton();
        Assert.assertTrue(dealsPage.isUrlCorrect("deals"), ERROR_MESSAGE_LINK);
        Assert.assertTrue(dealsPage.titleContains("deals"), ERROR_MESSAGE_TITLE);
        CoveragePage coveragePage = hamburgerMenu.clickCoverageButton();
        Assert.assertTrue(coveragePage.isUrlCorrect("network"), ERROR_MESSAGE_LINK);
        Assert.assertTrue(coveragePage.titleContains("coverage"), ERROR_MESSAGE_TITLE);
        ContactPage contactPage = hamburgerMenu.clickContactButton();
        Assert.assertTrue(contactPage.isUrlCorrect("contact"), ERROR_MESSAGE_LINK);
        Assert.assertTrue(contactPage.isTitleCorrect(), ERROR_MESSAGE_TITLE);
        MerchPage merchPage = hamburgerMenu.clickMerchButton();
        homePage.switchWindow();
        Assert.assertTrue(merchPage.isUrlCorrect("merch"), ERROR_MESSAGE_LINK);
    }

    @Test
    public void test() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), ERROR_MESSAGE_HOME);
        FooterMenu footerMenu = homePage.getFooterMenu();
        NewsPage newsPage = footerMenu.openNewsPage();
        Assert.assertTrue(newsPage.titleContains(), ERROR_MESSAGE_TITLE);
        Assert.assertTrue(newsPage.isUrlCorrect(), ERROR_MESSAGE_LINK);
        homePage.navigateBack();
        ReviewsPage reviewsPage = footerMenu.openReviewsPage();
        Assert.assertTrue(reviewsPage.titleContains("reviews"), ERROR_MESSAGE_TITLE);
        Assert.assertTrue(reviewsPage.isUrlCorrect("reviews"), ERROR_MESSAGE_LINK);
        homePage.navigateBack();
        GlossaryPage glossaryPage = footerMenu.openGlossaryPage();
        Assert.assertTrue(glossaryPage.titleContains("glossary"), ERROR_MESSAGE_TITLE);
        Assert.assertTrue(glossaryPage.isUrlCorrect("glossary"), ERROR_MESSAGE_LINK);
        homePage.navigateBack();
        BlogPage blogPage = footerMenu.openBlogPage();
        Assert.assertTrue(blogPage.titleContains("blog"), ERROR_MESSAGE_TITLE);
        Assert.assertTrue(blogPage.isUrlCorrect("blog"), ERROR_MESSAGE_LINK);
        homePage.navigateBack();
        PhoneFinderPage phoneFinderPage = footerMenu.openPhoneFinderPage();
        Assert.assertTrue(phoneFinderPage.titleContains("finder"), ERROR_MESSAGE_TITLE);
        Assert.assertTrue(phoneFinderPage.isUrlCorrect("search"), ERROR_MESSAGE_LINK);
        homePage.navigateBack();
        ToolsPage toolsPage = footerMenu.openToolsPage();
        Assert.assertTrue(toolsPage.titleContains("tools"), ERROR_MESSAGE_TITLE);
        Assert.assertTrue(toolsPage.isUrlCorrect("tools"), ERROR_MESSAGE_LINK);
        homePage.navigateBack();
        ComparePage comparePage = footerMenu.openCompareFooterPage();
        Assert.assertTrue(comparePage.titleContains("compare"), ERROR_MESSAGE_TITLE);
        Assert.assertTrue(comparePage.isUrlCorrect("compare"), ERROR_MESSAGE_LINK);
        homePage.navigateBack();
        CoveragePage coveragePage = footerMenu.openCoveragePage();
        Assert.assertTrue(coveragePage.titleContains("coverage"), ERROR_MESSAGE_TITLE);
        Assert.assertTrue(coveragePage.isUrlCorrect("network"), ERROR_MESSAGE_LINK);
        homePage.navigateBack();
        ContactPage contactPage = footerMenu.openContactPage();
        Assert.assertTrue(contactPage.titleContains("contact"), ERROR_MESSAGE_TITLE);
        Assert.assertTrue(contactPage.isUrlCorrect("contact"), ERROR_MESSAGE_LINK);
        homePage.navigateBack();
        TeamPage teamPage = footerMenu.teamPage();
        Assert.assertTrue(teamPage.titleContains("team"), ERROR_MESSAGE_TITLE);
        Assert.assertTrue(teamPage.isUrlCorrect("team"), ERROR_MESSAGE_LINK);
    }
}