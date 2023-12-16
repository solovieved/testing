package com.soloviev.factory.factorypages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainFactoryPage extends FactoryPage {

    @FindBy(css = "[aria-label='Sign in']")
    private WebElement accountLink;

    @FindBy(xpath = "//button[contains(text(),'Accept all')]")
    private WebElement trustButton;

    public boolean isAccountLinkDisplayed() {
        try {
            return accountLink.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickOnAccountLink() {
        accountLink.click();
    }

    public void clickOnTrustButton() {
        trustButton.click();
    }
}
