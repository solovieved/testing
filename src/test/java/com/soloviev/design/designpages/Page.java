package com.soloviev.design.designpages;

import com.soloviev.framework.core.drivers.Driver;
import org.openqa.selenium.WebDriver;

public abstract class Page {

    protected static WebDriver getDriver() {
        return Driver.getDriver();
    }
}
