package org;

import lombok.Getter;
import org.o2f.configuration.BaseConfigModel;
import org.o2f.configuration.YamlConfigParser;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;

import static java.lang.Integer.parseInt;
import static java.util.Objects.requireNonNull;


public class BaseTestConfig {
    /**
     * This class implements the configuration based on the BaseConfigModel belonging to the configuration package
     */

    // Collectors from command line variables
    private static final String ENVIRONMENT_ENV_OR_CMD_VAR = "env";
    private static final String BASE_URL_ENV_OR_CMD_VAR = "baseUrl";
    private static final String PORT_ENV_OR_CMD_VAR = "port";

    private static YamlConfigParser yamlConfigParser;

    @Getter
    private static final BaseConfigModel testConfig;

    static {

        String env = requireNonNull(System.getProperty(ENVIRONMENT_ENV_OR_CMD_VAR,"qa"), "Environment was not defined");

        final String configFile = String.format("test-%s.yaml", env);

        // Read values from the property file if the same exists and set them
        try (InputStream input = BaseTestConfig.class.getClassLoader().getResourceAsStream(configFile)) {

            Yaml yaml = new Yaml();

            if (input == null) {
                System.out.println("Property file not found, trying to load envs from the command line");
            } else {
                yamlConfigParser = yaml.loadAs(input, YamlConfigParser.class);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Load properties either from command-line or yaml file, if not found send error message.
        final String baseUrl = requireNonNull(System.getProperty(BASE_URL_ENV_OR_CMD_VAR, yamlConfigParser.getBaseUri()), "Base URL not found anywhere");
        //final Integer port = parseInt((System.getProperty(PORT_ENV_OR_CMD_VAR, yamlConfigParser.getPort().toString())));

        // Test configuration builder
        testConfig = BaseConfigModel
                .builder()
                .env(env)
                .baseUri(baseUrl)
                //.port(port)
                .build();
    }

}
