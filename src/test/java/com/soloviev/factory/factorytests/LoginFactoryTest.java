package com.soloviev.factory.factorytests;

import com.soloviev.factory.factorypages.LoginPage;
import com.soloviev.factory.factorypages.MainFactoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFactoryTest extends BasicFactoryTest {
    public String login = "soloviev.ed16@gmail.com";
    public String password = "123456";
    public LoginPage loginPage = new LoginPage();
    public MainFactoryPage mainFactoryPage = new MainFactoryPage();

    @Test(description = "Assert the login form is loaded")
    public void assertLoginFormLoaded() {
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnAccountLink();
        Assert.assertTrue(loginPage.emailField.isDisplayed(), "Email field is not displayed");
        Assert.assertTrue(loginPage.password.isDisplayed(), "Password field is not displayed");
        Assert.assertTrue(loginPage.submit.isDisplayed(), "Password field is not displayed");
    }

    @Test(description = "Assert the login and password fields are filled in", dependsOnMethods = "assertLoginFormLoaded")
    public void assertLoginAndPasswordFilled() {
        loginPage.emailField.sendKeys(login);
        loginPage.password.sendKeys(password);
        Assert.assertEquals(loginPage.emailField.getAttribute("value"), login);
        Assert.assertEquals(loginPage.password.getAttribute("value"), password);
    }

    @Test(description = "Assert logged in", dependsOnMethods = "assertLoginAndPasswordFilled")
    public void assertLoggedIn() {
        loginPage.submit.click();
        Assert.assertFalse(mainFactoryPage.isAccountLinkDisplayed(), "Login failed");
    }
}
