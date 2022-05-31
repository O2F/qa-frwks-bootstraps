package org.o2f.configuration;

import org.openqa.selenium.WebDriver;

public class DriverSimpleThreadManager {

    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    String browserName;

    public DriverSimpleThreadManager(String browserName){
        this.browserName = browserName;
    }

    public void setDriver(){
        DriverFactory driverFactory = new DriverFactory(browserName);
        driver.set(driverFactory.createWebDriverInstance());
    }

    public WebDriver getDriver(){
        if (driver.get() == null){
            setDriver();
        }
        return driver.get();
    }
}
