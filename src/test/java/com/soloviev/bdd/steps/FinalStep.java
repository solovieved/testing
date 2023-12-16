package com.soloviev.bdd.steps;

import com.soloviev.factory.factorypages.LoginPage;
import com.soloviev.factory.factorypages.MainFactoryPage;
import com.soloviev.factory.factorypages.RegisterPage;
import com.soloviev.framework.core.drivers.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static com.soloviev.framework.core.lib.WigglePageURLs.START_URL;

public class FinalStep {
    WebDriver driver;
    MainFactoryPage mainFactoryPage = new MainFactoryPage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    public FinalStep() {
        driver = Driver.getDriver();
    }

    @Given("I open the {string} website")
    public void iAmOnTheWebsite(String website) {
        driver.get(website);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainFactoryPage.clickOnTrustButton();
    }

    @When("I navigate to the sign in page")
    public void iNavigateToTheSignInPage() {
        mainFactoryPage.clickOnAccountLink();
    }

    @Then("I see fields for entering email and password")
    public void iSeeFieldsForEnteringEmailAndPassword() {
        Assert.assertTrue(loginPage.emailField.isDisplayed(), "Email field is not displayed");
        Assert.assertTrue(loginPage.password.isDisplayed(), "Password field is not displayed");
    }

    @When("I navigate to the sign up page")
    public void iNavigateToTheSignUpPage() {
        loginPage.signUpLink.click();
    }

    @Then("I see a field for entering a password")
    public void iSeeAFieldForEnteringAPassword() {
        Assert.assertTrue(registerPage.emailField.isDisplayed(), "Email field is not displayed");
        Assert.assertTrue(registerPage.password.isDisplayed(), "Password field is not displayed");
    }

    @When("I click the show password button")
    public void iClickTheShowPasswordButton() {
        registerPage.showPasswordBtn.click();
    }

    @Then("I see the hide button tooltip")
    public void iSeeHideButtonTooltip() {
        boolean hasClass = registerPage.showPasswordTooltip.getAttribute("class").contains("hide");
        Assert.assertTrue(hasClass, "Password is not showing");
    }

    @When("I enter {string} in the password field")
    public void iEnterInThePasswordField(String password) {
        registerPage.password.sendKeys(password);
        Assert.assertEquals(registerPage.password.getAttribute("value"), password);
    }

    @When("I clear the entered characters")
    public void iClearTheEnteredCharacters() {
        registerPage.password.clear();
        Assert.assertEquals(registerPage.password.getAttribute("value"), "");
    }
}
