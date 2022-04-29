package org.o2f.test;

import lombok.Getter;
import org.o2f.configuration.BaseConfigModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.util.Objects.requireNonNull;


public class BaseTestConfig {
    /**
     * This class implements the configuration based on the BaseConfigModel belonging to the configuration package
     */

    // Collectors from command line variables
    private static final String ENVIRONMENT_ENV_OR_CMD_VAR = "env";
    private static final String BASE_URL_ENV_OR_CMD_VAR = "baseUrl";
    private static final String BROWSER_ENV_OR_CMD_VAR = "browser";

    private static String propBaseUrl;
    private static String propBrowser;

    @Getter
    private static final BaseConfigModel testConfig;

    static {

        String env = requireNonNull(System.getProperty(ENVIRONMENT_ENV_OR_CMD_VAR), "Environment was not defined");

        final String configFile = String.format("test-%s.properties", env);

        // Read values from the property file if the same exists and set them
        try (InputStream input = BaseTestConfig.class.getClassLoader().getResourceAsStream(configFile)) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Property file not found, trying to load envs from the command line");
            } else {
                //load a properties file from class path, inside static method
                prop.load(input);

                // try to get the properties
                propBaseUrl = prop.getProperty("app.url");
                propBrowser = prop.getProperty("browser");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Load properties either from command-line or properties file, if not found send error message.
        final String baseUrl = requireNonNull(System.getProperty(BASE_URL_ENV_OR_CMD_VAR, propBaseUrl), "Base URL not found anywhere");
        final String browser = requireNonNull(System.getProperty(BROWSER_ENV_OR_CMD_VAR, propBrowser), "browser not found anywhere");

        // Test configuration builder
        testConfig = BaseConfigModel
                .builder()
                .env(env)
                .baseUrl(baseUrl)
                .browser(browser)
                .build();
    }

}
