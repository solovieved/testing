package com.soloviev.bdd.steps;

import com.soloviev.framework.core.drivers.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static com.soloviev.framework.core.lib.WigglePageURLs.START_URL;


public class OpenHomePageStep {
    private final WebDriver driver;

    public OpenHomePageStep() {
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
}
