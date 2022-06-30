package org.o2f;

import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.o2f.configuration.BaseConfigModel;

@Slf4j
public class CommonTestLifeCycle {

    public static BaseConfigModel config;

    @BeforeAll
    static void setup(){

        config = BaseTestConfig.getTestConfig();

        RestAssured.baseURI = config.getBaseUri();
        RestAssured.port = config.getPort();

        log.info(String.format("Using the Base Uri - %s", RestAssured.baseURI));
        log.info(String.format("Using the port - %d", RestAssured.port));
    }
}
