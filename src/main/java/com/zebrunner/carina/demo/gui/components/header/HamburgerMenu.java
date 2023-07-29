package com.zebrunner.carina.demo.gui.components.header;

import com.zebrunner.carina.demo.gui.pages.desktop.*;
import com.zebrunner.carina.demo.gui.pages.desktop.internal.*;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HamburgerMenu extends AbstractUIObject {

    @FindBy(xpath = "//li//*[contains(@href, '/') and contains(text(), 'Home')]")
    private ExtendedWebElement homeButton;

    @FindBy(xpath = "//li//*[contains(@href, 'news') and contains(text(), 'News')]")
    private ExtendedWebElement newsButton;

    @FindBy(xpath = "//li//*[contains(@href, 'reviews') and contains(text(), 'Reviews')]")
    private ExtendedWebElement reviewsButton;

    @FindBy(xpath = "//li//*[contains(@href, 'videos') and contains(text(), 'Videos')]")
    private ExtendedWebElement videosButton;

    @FindBy(xpath = "//li//*[contains(@href, 'Featured') and contains(text(), 'Featured')]")
    private ExtendedWebElement featuredButton;

    @FindBy(xpath = "//li//*[contains(@href, 'search') and contains(text(), 'Finder')]")
    private ExtendedWebElement phoneFinderButton;

    @FindBy(xpath = "//li//*[contains(@href, 'deals') and contains(text(), 'Deals')]")
    private ExtendedWebElement dealsButton;

    @FindBy(xpath = "//li//*[contains(@href, 'merch') and contains(text(), 'Merch')]")
    private ExtendedWebElement merchButton;

    @FindBy(xpath = "//li//*[contains(@href, 'network') and contains(text(), 'Coverage')]")
    private ExtendedWebElement coverageButton;

    @FindBy(xpath = "//li//*[contains(@href, 'contact') and contains(text(), 'Contact')]")
    private ExtendedWebElement contactButton;


    public HamburgerMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage clickHomeButton() {
        homeButton.click();
        return new HomePage(driver);
    }

    public NewsPage clickNewsButton() {
        newsButton.click();
        return new NewsPage(driver);
    }

    public ReviewsPage clickReviewsButton() {
        reviewsButton.click();
        return new ReviewsPage(driver);
    }

    public VideosPage clickVideosButton() {
        videosButton.click();
        return new VideosPage(driver);
    }

    public FeaturedPage clickFeaturedButton() {
        featuredButton.click();
        return new FeaturedPage(driver);
    }

    public PhoneFinderPage clickPhoneFinderButton() {
        phoneFinderButton.click();
        return new PhoneFinderPage(driver);
    }

    public DealsPage clickDealsButton() {
        dealsButton.click();
        return new DealsPage(driver);
    }

    public MerchPage clickMerchButton() {
        merchButton.click();
        return new MerchPage(driver);
    }

    public CoveragePage clickCoverageButton() {
        coverageButton.click();
        return new CoveragePage(driver);
    }

    public ContactPage clickContactButton() {
        contactButton.click();
        return new ContactPage(driver);
    }
}
