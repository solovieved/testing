package com.soloviev.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends FactoryPage {
    @FindBy(name = "email")
    public WebElement emailField;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(css = "[data-action='toggle']")
    public WebElement showPasswordBtn;
    @FindBy(className = "show-password-tooltip")
    public WebElement showPasswordTooltip;
}
