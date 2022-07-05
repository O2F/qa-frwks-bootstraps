package org.o2f;

import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.o2f.configuration.BaseConfigModel;
import org.testng.annotations.BeforeSuite;

@Slf4j
public class TestLifeCycle {

    protected static BaseConfigModel config;

    @BeforeSuite
    public void setup(){

        config = BaseTestConfig.getTestConfig();

        RestAssured.baseURI = config.getBaseUri();
        RestAssured.port = config.getPort();

        log.info(String.format("Using the Base Uri - %s", RestAssured.baseURI));
        log.info(String.format("Using the port - %d", RestAssured.port));
    }
}
