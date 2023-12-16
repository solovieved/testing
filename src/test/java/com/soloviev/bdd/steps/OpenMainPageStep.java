package com.soloviev.bdd.steps;

import com.soloviev.framework.core.drivers.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

import java.util.concurrent.TimeUnit;

import static com.soloviev.framework.core.lib.WigglePageURLs.START_URL;

@CucumberOptions(features = "src/test/java/com/soloviev/bdd/features/openmainpage.feature")
public class OpenMainPageStep {
    private final WebDriver driver;

    public OpenMainPageStep() {
        driver = Driver.getDriver();
    }

    @Given("I open the Wiggle website")
    public void iOpenTheWiggleWebsite() {
        driver.get(START_URL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Then("I should be on the Wiggle homepage")
    public void iShouldBeOnTheWiggleHomepage() {
        String expectedTitle = "Get Your Wiggle On | Cycle, Run & Outdoor Shop | Wiggle";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterSuite
    public void afterFeature() {
        Driver.getDriver().quit();
    }
}
