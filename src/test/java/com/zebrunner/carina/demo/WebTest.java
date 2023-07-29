package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.components.footer.FooterMenu;
import com.zebrunner.carina.demo.gui.components.header.HamburgerMenu;
import com.zebrunner.carina.demo.gui.components.header.LoginForm;
import com.zebrunner.carina.demo.gui.constants.WebConst;
import com.zebrunner.carina.demo.gui.pages.desktop.*;
import com.zebrunner.carina.demo.gui.pages.desktop.external.EvPage;
import com.zebrunner.carina.demo.gui.pages.desktop.external.InstagramPage;
import com.zebrunner.carina.demo.gui.pages.desktop.external.YouTubePage;
import com.zebrunner.carina.demo.gui.pages.desktop.internal.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {

    private static final String ERROR_MESSAGE_ELEMENT = "Provided element not found.";
    private static final String ERROR_MESSAGE_LINK = "Link doesn't contain a substring.";
    private static final String ERROR_MESSAGE_TITLE = "Title doesn't contain a substring.";
    private static final String ERROR_MESSAGE_HOME = "Home page is not opened!";
    private static final String ERROR_MESSAGE_LOGIN = "Login failed.";

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
        Assert.assertTrue(homePage.userIconIsPresent(), ERROR_MESSAGE_LOGIN);
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
        Assert.assertTrue(tipUsPage.urlContains(WebConst.URL_TIP), ERROR_MESSAGE_LINK);
        Assert.assertTrue(tipUsPage.titleContains(WebConst.TITLE_TIP), ERROR_MESSAGE_ELEMENT);
        driver.navigate().back();
        YouTubePage youTubePage = homePage.getHeaderMenu().openYouTubePage();
        homePage.switchWindow();
        Assert.assertTrue(youTubePage.urlContains(WebConst.URL_YOUTUBE), ERROR_MESSAGE_LINK);
        Assert.assertTrue(youTubePage.titleContains(WebConst.TITLE_YOUTUBE), ERROR_MESSAGE_ELEMENT);
        driver.close();
        driver.switchTo().window(originalWindow);
        InstagramPage instagramPage = homePage.getHeaderMenu().openInstagramPage();
        homePage.switchWindow();
        Assert.assertTrue(instagramPage.urlContains(WebConst.URL_INSTAGRAM), ERROR_MESSAGE_LINK);
        Assert.assertTrue(instagramPage.titleContains(WebConst.TITLE_INSTAGRAM), ERROR_MESSAGE_ELEMENT);
        driver.close();
        driver.switchTo().window(originalWindow);
        RssPage rssPage = homePage.getHeaderMenu().openRssPage();
        homePage.switchWindow();
        Assert.assertTrue(rssPage.urlContains(WebConst.URL_RSS), ERROR_MESSAGE_LINK);
        Assert.assertTrue(rssPage.getTitle().isEmpty());
        driver.navigate().back();
        EvPage evPage = homePage.getHeaderMenu().openEvPage();
        homePage.switchWindow();
        Assert.assertTrue(evPage.urlContains(WebConst.URL_EV), ERROR_MESSAGE_LINK);
        Assert.assertTrue(evPage.titleContains(WebConst.TITLE_EV), ERROR_MESSAGE_ELEMENT);
        driver.close();
        driver.switchTo().window(originalWindow);
        MerchPage merchPage = homePage.getHeaderMenu().openMerchPage();
        homePage.switchWindow();
        Assert.assertTrue(merchPage.urlContains(WebConst.URL_MERCH), ERROR_MESSAGE_LINK);
        Assert.assertTrue(merchPage.titleContains(WebConst.TITLE_MERCH), ERROR_MESSAGE_ELEMENT);
        driver.close();
        driver.switchTo().window(originalWindow);
        homePage.getHeaderMenu().getLoginForm();
        SignupPage signupPage = homePage.getHeaderMenu().openSignupPage();
        Assert.assertTrue(signupPage.urlContains(WebConst.URL_SIGNUP), ERROR_MESSAGE_LINK);
        Assert.assertTrue(signupPage.titleContains(WebConst.TITLE_SIGNUP), ERROR_MESSAGE_ELEMENT);
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
        Assert.assertTrue(newsPage.urlContains(), ERROR_MESSAGE_LINK);
        ReviewsPage reviewsPage = hamburgerMenu.clickReviewsButton();
        Assert.assertTrue(reviewsPage.urlContains(WebConst.URL_REVIEWS), ERROR_MESSAGE_LINK);
        Assert.assertTrue(reviewsPage.titleContains(WebConst.TITLE_REVIEWS), ERROR_MESSAGE_TITLE);
        VideosPage videosPage = hamburgerMenu.clickVideosButton();
        Assert.assertTrue(videosPage.urlContains(WebConst.URL_VIDEOS), ERROR_MESSAGE_LINK);
        Assert.assertTrue(videosPage.titleContains(WebConst.TITLE_VIDEOS), ERROR_MESSAGE_TITLE);
        FeaturedPage featuredPage = hamburgerMenu.clickFeaturedButton();
        Assert.assertTrue(featuredPage.urlContains(WebConst.URL_FEATURED), ERROR_MESSAGE_LINK);
        Assert.assertTrue(featuredPage.titleContains(WebConst.TITLE_FEATURED), ERROR_MESSAGE_TITLE);
        PhoneFinderPage phoneFinderPage = hamburgerMenu.clickPhoneFinderButton();
        Assert.assertTrue(phoneFinderPage.urlContains(WebConst.URL_FINDER), ERROR_MESSAGE_LINK);
        Assert.assertTrue(phoneFinderPage.titleContains(WebConst.TITLE_FINDER), ERROR_MESSAGE_TITLE);
        DealsPage dealsPage = hamburgerMenu.clickDealsButton();
        Assert.assertTrue(dealsPage.urlContains(WebConst.URL_DEALS), ERROR_MESSAGE_LINK);
        Assert.assertTrue(dealsPage.titleContains(WebConst.TITLE_DEALS), ERROR_MESSAGE_TITLE);
        CoveragePage coveragePage = hamburgerMenu.clickCoverageButton();
        Assert.assertTrue(coveragePage.urlContains(WebConst.URL_COVERAGE), ERROR_MESSAGE_LINK);
        Assert.assertTrue(coveragePage.titleContains(WebConst.TITLE_COVERAGE), ERROR_MESSAGE_TITLE);
        ContactPage contactPage = hamburgerMenu.clickContactButton();
        Assert.assertTrue(contactPage.urlContains(WebConst.URL_CONTACT), ERROR_MESSAGE_LINK);
        Assert.assertTrue(contactPage.titleContains(WebConst.TITLE_CONTACT), ERROR_MESSAGE_TITLE);
        MerchPage merchPage = hamburgerMenu.clickMerchButton();
        homePage.switchWindow();
        Assert.assertTrue(merchPage.urlContains(WebConst.URL_MERCH), ERROR_MESSAGE_LINK);
    }

    @Test
    public void testFooterMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), ERROR_MESSAGE_HOME);
        FooterMenu footerMenu = homePage.getFooterMenu();
        NewsPage newsPage = footerMenu.openNewsPage();
        Assert.assertTrue(newsPage.urlContains(), ERROR_MESSAGE_LINK);
        Assert.assertTrue(newsPage.titleContains(), ERROR_MESSAGE_TITLE);
        homePage.navigateBack();
        ReviewsPage reviewsPage = footerMenu.openReviewsPage();
        Assert.assertTrue(reviewsPage.urlContains(WebConst.URL_REVIEWS), ERROR_MESSAGE_LINK);
        Assert.assertTrue(reviewsPage.titleContains(WebConst.TITLE_REVIEWS), ERROR_MESSAGE_TITLE);
        homePage.navigateBack();
        GlossaryPage glossaryPage = footerMenu.openGlossaryPage();
        Assert.assertTrue(glossaryPage.urlContains(WebConst.URL_GLOSSARY), ERROR_MESSAGE_LINK);
        Assert.assertTrue(glossaryPage.titleContains(WebConst.TITLE_GLOSSARY), ERROR_MESSAGE_TITLE);
        homePage.navigateBack();
        BlogPage blogPage = footerMenu.openBlogPage();
        Assert.assertTrue(blogPage.urlContains(WebConst.URL_BLOG), ERROR_MESSAGE_LINK);
        Assert.assertTrue(blogPage.titleContains(WebConst.TITLE_BLOG), ERROR_MESSAGE_TITLE);
        homePage.navigateBack();
        PhoneFinderPage phoneFinderPage = footerMenu.openPhoneFinderPage();
        Assert.assertTrue(phoneFinderPage.urlContains(WebConst.URL_FINDER), ERROR_MESSAGE_LINK);
        Assert.assertTrue(phoneFinderPage.titleContains(WebConst.TITLE_FINDER), ERROR_MESSAGE_TITLE);
        homePage.navigateBack();
        ToolsPage toolsPage = footerMenu.openToolsPage();
        Assert.assertTrue(toolsPage.urlContains(WebConst.URL_TOOLS), ERROR_MESSAGE_LINK);
        Assert.assertTrue(toolsPage.titleContains(WebConst.TITLE_TOOLS), ERROR_MESSAGE_TITLE);
        homePage.navigateBack();
        ComparePage comparePage = footerMenu.openCompareFooterPage();
        Assert.assertTrue(comparePage.urlContains(WebConst.URL_COMPARE), ERROR_MESSAGE_LINK);
        Assert.assertTrue(comparePage.titleContains(WebConst.TITLE_COMPARE), ERROR_MESSAGE_TITLE);
        homePage.navigateBack();
        CoveragePage coveragePage = footerMenu.openCoveragePage();
        Assert.assertTrue(coveragePage.urlContains(WebConst.URL_COVERAGE), ERROR_MESSAGE_LINK);
        Assert.assertTrue(coveragePage.titleContains(WebConst.TITLE_COVERAGE), ERROR_MESSAGE_TITLE);
        homePage.navigateBack();
        ContactPage contactPage = footerMenu.openContactPage();
        Assert.assertTrue(contactPage.urlContains(WebConst.URL_CONTACT), ERROR_MESSAGE_LINK);
        Assert.assertTrue(contactPage.titleContains(WebConst.TITLE_CONTACT), ERROR_MESSAGE_TITLE);
        homePage.navigateBack();
        TeamPage teamPage = footerMenu.teamPage();
        Assert.assertTrue(teamPage.urlContains(WebConst.URL_TEAM), ERROR_MESSAGE_LINK);
        Assert.assertTrue(teamPage.titleContains(WebConst.TITLE_TEAM), ERROR_MESSAGE_TITLE);
    }
}