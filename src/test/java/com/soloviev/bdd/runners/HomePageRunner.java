package com.soloviev.bdd.runners;

import com.soloviev.framework.core.drivers.Driver;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;

@CucumberOptions(features = "src/test/java/com/soloviev/bdd/features/homepage.feature", glue = "com.soloviev.bdd.steps")
public class HomePageRunner {
    @AfterSuite
    public void afterFeature() {
        Driver.getDriver().quit();
    }
}
