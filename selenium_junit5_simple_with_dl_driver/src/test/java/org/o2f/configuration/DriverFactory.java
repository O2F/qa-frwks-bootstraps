package org.o2f.configuration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    WebDriver driver;
    String browserName;

    public DriverFactory(String browserName){
        this.browserName = browserName;
    }

    public WebDriver getDriver(){
        if (this.browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/java/org/o2f/drivers/geckodriver");
            FirefoxOptions ffOptions = new FirefoxOptions();
            ffOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new FirefoxDriver(ffOptions);
        }
        else if (this.browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/java/org/o2f/drivers/chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new ChromeDriver(chromeOptions);
        }
        return driver;
    }

}
