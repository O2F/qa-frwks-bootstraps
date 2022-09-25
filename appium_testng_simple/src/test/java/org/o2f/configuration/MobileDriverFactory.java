package org.o2f.configuration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Arrays;
import java.util.Locale;

@Slf4j
public final class MobileDriverFactory {

    RemoteWebDriver driver;

    @lombok.SneakyThrows
    public AppiumDriver getMobileDriver(String mobileType){

        // Correctly this should have the 2 mobile drivers but this method is created for demonstration purpose only

        switch (mobileType.toUpperCase(Locale.ROOT)){
            case "ANDROID":
                UiAutomator2Options options = new UiAutomator2Options();
                options.setApp(System.getProperty("user.dir") + "/app/ApiDemos-debug.apk");
                options.setAutomationName("uiautomator2");

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);
                break;
            default:
                throw new RuntimeException("Requested Mobile driver type is incorrect or not implemented");
        }
        return (AppiumDriver) driver;
    }

    @lombok.SneakyThrows
    public AppiumDriver getMobileDriver(String mobileType, Boolean withPkgAndActivity){
        // Correctly this should have the 2 mobile drivers but this method is created for demonstration purpose only

        switch (mobileType.toUpperCase(Locale.ROOT)){
            case "ANDROID":
                if (withPkgAndActivity){
                    UiAutomator2Options options = new UiAutomator2Options();
                    options.setAppPackage("io.appium.android.apis");
                    options.setAppActivity("io.appium.android.apis.ApiDemos");
                    options.setAutomationName("uiautomator2");

                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);
                    break;
                }
                driver = getMobileDriver(mobileType);
                break;
            default:
                throw new RuntimeException("Requested Mobile driver type is incorrect or not implemented");
        }
        return (AppiumDriver) driver;
    }

    @lombok.SneakyThrows
    public <T> T getMobileDriver(String mobileType, String browser){
        // Correctly this should have the 2 mobile drivers but this method is created for demonstration purpose only

        String[] supportedBrowsers = {"Chrome"};
        if( !Arrays.asList(supportedBrowsers).contains(browser) ){
            throw new RuntimeException("browser not supported");
        }


        switch (mobileType.toUpperCase(Locale.ROOT)){
            case "ANDROID":
                if (browser.equalsIgnoreCase("")){
                    return (T) getMobileDriver(mobileType);
                }
                UiAutomator2Options options = new UiAutomator2Options();
                options.withBrowserName(browser);
                options.setPlatformName("Android");
                options.setAutomationName("uiautomator2");

                return (T) new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);
            default:
                throw new RuntimeException("Requested Mobile driver type is incorrect or not implemented");
        }
    }
}
