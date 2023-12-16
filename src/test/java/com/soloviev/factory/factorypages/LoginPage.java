package com.soloviev.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends FactoryPage {
    @FindBy(xpath = "//*[contains(text(),'Please log in')]")
    private WebElement loginContainer;
    @FindBy(name = "username")
    public WebElement emailField;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(xpath = "//button[@data-action-button-primary='true']")
    public WebElement submit;
    @FindBy(linkText = "Sign up")
    public WebElement signUpLink;

    public boolean isLoginContainerDisplayed() {
        return loginContainer.isDisplayed();
    }
}
