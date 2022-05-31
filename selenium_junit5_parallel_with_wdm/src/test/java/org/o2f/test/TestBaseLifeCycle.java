package org.o2f.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.o2f.configuration.BaseConfigModel;
import org.o2f.configuration.DriverFactory;
import org.o2f.configuration.DriverThreadManager;

@Slf4j
public class TestBaseLifeCycle {

    public static BaseConfigModel config;
    protected DriverThreadManager driverThreadManager;

    @BeforeAll
    public static void baseSetup() {

        //Unwrap config from the BaseTestConfig
        config = BaseTestConfig.getTestConfig();
        //log.info(String.format("Using the Base URL: %s", config.getBaseUrl()));
        //log.info(String.format("Using the Browser URL: %s", config.getBrowser().toUpperCase(Locale.ROOT)));

    }

    @BeforeEach
    public void setup(){
        driverThreadManager = new DriverThreadManager(config.getBrowser());
        driverThreadManager.setDriver();
    }

    @AfterEach
    public void teardown(){
        driverThreadManager.getDriver().quit();
    }


}
