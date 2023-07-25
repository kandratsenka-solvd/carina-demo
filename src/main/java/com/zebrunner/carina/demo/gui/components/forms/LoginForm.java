package com.zebrunner.carina.demo.gui.components.forms;

import com.zebrunner.carina.demo.utils.FileManagerUtil;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends AbstractUIObject {

    @FindBy(id = "email")
    private ExtendedWebElement emailTextField;

    @FindBy(id = "upass")
    private ExtendedWebElement passwordTextField;

    @FindBy(id = "nick-submit")
    private ExtendedWebElement submitButton;

    public LoginForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void enterEmail() {
        emailTextField.type(FileManagerUtil.getValue("credentials.json", "email"), 5);
    }

    public void enterPassword() {
        passwordTextField.type(FileManagerUtil.getValue("credentials.json", "password"));
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
