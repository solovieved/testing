package com.soloviev.design.designtests;

import com.soloviev.design.designpages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BasicTest {

    @Test(description = "Assert the main page is loaded and the main logo is visible")
    public void assertWiggleIconIsDisplayed() {
        MainPage mainPage = new MainPage();
        mainPage.clickOnTrustButton();
        Assert.assertEquals(mainPage.isMainLogoDisplayed(), true, "The main page isn't loaded properly");
    }
}
