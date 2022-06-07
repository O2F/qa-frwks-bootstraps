package org.o2f.test;

import lombok.extern.slf4j.Slf4j;
import org.o2f.configuration.BaseConfigModel;
import org.o2f.configuration.DriverFactory;
import org.o2f.configuration.DriverSimpleThreadManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.lang.management.ThreadInfo;

@Slf4j
public class TestBaseLifeCycle {

    protected BaseConfigModel config;
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    //protected DriverSimpleThreadManager driverSimpleThreadManager;


    @BeforeMethod
    public void setup(){
        config = BaseTestConfig.getTestConfig();
        driver.set(new DriverFactory(config.getBrowser()).createWebDriverInstance());
        //driverSimpleThreadManager = new DriverSimpleThreadManager(config.getBrowser());
        //driverSimpleThreadManager.setDriver();
    }

    @AfterMethod
    public void teardown(){
        log.error("Closing thread - " + Thread.currentThread() );
        driver.get().quit();
        //driverSimpleThreadManager.getDriver().close();
        //driverSimpleThreadManager.getDriver().quit();
    }

}
