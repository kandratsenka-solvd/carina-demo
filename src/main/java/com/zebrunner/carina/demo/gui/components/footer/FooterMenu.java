/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zebrunner.carina.demo.gui.components.footer;

import com.zebrunner.carina.demo.gui.pages.desktop.*;
import com.zebrunner.carina.demo.gui.pages.desktop.internal.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class FooterMenu extends FooterMenuBase {

    @FindBy(linkText = "Home")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = ".//a[contains(text(),'Compare')]")
    private ExtendedWebElement compareLink;

    @FindBy(linkText = "News")
    private ExtendedWebElement newsLink;

    @FindBy(linkText = "Glossary")
    private ExtendedWebElement glossaryLink;

    @FindBy(linkText = "Reviews")
    private ExtendedWebElement reviewsLink;

    @FindBy(linkText = "Blog")
    private ExtendedWebElement blogLink;

    @FindBy(linkText = "Phone Finder")
    private ExtendedWebElement phoneFinderLink;

    @FindBy(linkText = "Tools")
    private ExtendedWebElement toolsLink;

    @FindBy(linkText = "Compare")
    private ExtendedWebElement compareFooterLink;

    @FindBy(linkText = "Coverage")
    private ExtendedWebElement coverageLink;

    @FindBy(linkText = "Contact us")
    private ExtendedWebElement contactLink;

    @FindBy(linkText = "GSMArena.com")
    private ExtendedWebElement teamLink;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public HomePage openHomePage() {
        homeLink.click();
        return new HomePage(driver);
    }

    public void scrollHoverClick(ExtendedWebElement element) {
        element.scrollTo();
        element.hover();
        element.click();
    }

    public CompareModelsPage openComparePage() {
        compareLink.scrollTo();
        compareLink.hover();
        compareLink.click();
        return new CompareModelsPage(driver);
    }

    public NewsPage openNewsPage() {
        newsLink.scrollTo();
        newsLink.hover();
        newsLink.click();
        return new NewsPage(driver);
    }

    public ReviewsPage openReviewsPage() {
        reviewsLink.scrollTo();
        reviewsLink.hover();
        reviewsLink.click();
        return new ReviewsPage(driver);
    }

    public GlossaryPage openGlossaryPage() {
        glossaryLink.scrollTo();
        glossaryLink.hover();
        glossaryLink.click();
        return new GlossaryPage(driver);
    }

    public BlogPage openBlogPage() {
        blogLink.scrollTo();
        blogLink.hover();
        blogLink.click();
        return new BlogPage(driver);
    }

    public PhoneFinderPage openPhoneFinderPage() {
        phoneFinderLink.scrollTo();
        phoneFinderLink.hover();
        phoneFinderLink.click();
        return new PhoneFinderPage(driver);
    }

    public ToolsPage openToolsPage() {
        toolsLink.scrollTo();
        toolsLink.hover();
        toolsLink.click();
        return new ToolsPage(driver);
    }

    public ComparePage openCompareFooterPage() {
        compareFooterLink.scrollTo();
        compareFooterLink.hover();
        compareFooterLink.click();
        return new ComparePage(driver);
    }

    public CoveragePage openCoveragePage() {
        coverageLink.scrollTo();
        coverageLink.hover();
        coverageLink.click();
        return new CoveragePage(driver);
    }

    public ContactPage openContactPage() {
        contactLink.scrollTo();
        contactLink.hover();
        contactLink.click();
        return new ContactPage(driver);
    }

    public TeamPage teamPage() {
        teamLink.scrollTo();
        teamLink.hover();
        teamLink.click();
        return new TeamPage(driver);
    }
}