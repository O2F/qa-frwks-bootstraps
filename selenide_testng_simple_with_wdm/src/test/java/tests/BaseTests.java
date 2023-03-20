package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTests {

    @BeforeSuite
    public void generalSetup(){
        final String configFile = "automation.properties";
        try (InputStream input = LoginTests.class.getClassLoader().getResourceAsStream(configFile)) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Property file not found");
            } else {
                prop.load(input);

                Configuration.baseUrl = System.getProperty("baseUrl", prop.getProperty("baseUrl"));
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
