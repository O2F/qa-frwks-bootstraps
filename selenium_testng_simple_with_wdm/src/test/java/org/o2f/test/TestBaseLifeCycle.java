package org.o2f.test;

import lombok.extern.slf4j.Slf4j;

import org.o2f.configuration.BaseConfigModel;
import org.o2f.configuration.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Locale;

@Slf4j
public class TestBaseLifeCycle {

    public static BaseConfigModel config;

    public static WebDriver driver;

    @BeforeSuite
    public void baseSetup() {

        //Unwrap config from the BaseTestConfig
        config = BaseTestConfig.getTestConfig();

        log.info(String.format("Using the Base URL: %s", config.getBaseUrl()));
        log.info(String.format("Using the Browser URL: %s", config.getBrowser().toUpperCase(Locale.ROOT)));

        driver = new DriverFactory(config.getBrowser()).getDriver();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
