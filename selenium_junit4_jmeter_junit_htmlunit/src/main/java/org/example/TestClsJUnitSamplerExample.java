package org.example;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.pageObjects.LoginPage;

public class TestClsJUnitSamplerExample {

    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setup(){
        // in case of NoSuchElementException - see: https://groups.google.com/g/selenium-users/c/k0g-IlyQKTg?pli=1
        // basically we need to enable JS in HtmlUnitDriver by setting it to true -> driver = new HtmlUnitDriver(true);
        driver = new HtmlUnitDriver(BrowserVersion.CHROME,true);
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/org/drivers/chromedriver");
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //driver = new ChromeDriver(chromeOptions);
        loginPage = new LoginPage(driver);
        loginPage.goToLogin();
    }

    @Test
    public void simpleTest() throws InterruptedException {
        loginPage.login("standard_user", "secret_sauce");
        System.out.println(loginPage.getTitle());
    }

    @After
    public void teardown(){
        driver.quit();
    }

}
