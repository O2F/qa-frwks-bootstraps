package org.o2f.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.o2f.configuration.MobileDriverFactory;
import org.o2f.helpers.spacialdirections.VerticalDirection;
import org.o2f.pages.MobileBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Slf4j
public class AppiumBaseTest {

    @Test
    public void launchAndroidAppiumBasic() {

        MobileDriverFactory driverFactory = new MobileDriverFactory();
        AndroidDriver driver = (AndroidDriver) driverFactory.getMobileDriver("Android");

        driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
        driver.quit();
    }

    @Test
    public void launchAndroidAppiumWithPackageAndActivity() throws InterruptedException {

        MobileDriverFactory driverFactory = new MobileDriverFactory();
        AndroidDriver driver = (AndroidDriver) driverFactory.getMobileDriver("Android", true);

        driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
        driver.quit();
    }

    @Test
    public void launchAndroidAppiumChromeBrowser(){

        MobileDriverFactory driverFactory = new MobileDriverFactory();
        WebDriver driver = driverFactory.getMobileDriver("Android", "Chrome");

        driver.get("https://facebook.com");
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_only_essential_button']")).click();
        driver.findElement(By.id("m_login_email")).sendKeys("Testing", Keys.ENTER);
        driver.quit();
    }

    @Test
    public void tapInViewOnHomePage() throws InterruptedException {

        MobileDriverFactory driverFactory = new MobileDriverFactory();
        AndroidDriver driver = (AndroidDriver) driverFactory.getMobileDriver("Android");

        MobileBasePage page = new MobileBasePage(driver);

        By by = AppiumBy.xpath("//android.widget.TextView[@text='Views']");

        page.rawTap(by);

        Thread.sleep(1000); //here just to visually confirm that it tapped

        driver.quit();

    }

    @Test
    public void testRawVerticalSwipeUp() throws InterruptedException {
        By graphics = AppiumBy.accessibilityId("Graphics");
        By touchPaint = AppiumBy.accessibilityId("Touch Paint");

        MobileDriverFactory driverFactory = new MobileDriverFactory();
        AndroidDriver driver = (AndroidDriver) driverFactory.getMobileDriver("Android");

        MobileBasePage page = new MobileBasePage(driver);

        page.rawTap(graphics);
        Thread.sleep(50); //needs to be here to enable the scrolling

        page.rawWindowVerticalSwipe(VerticalDirection.UP);
        page.rawTap(touchPaint);

        driver.quit();
    }

    @Test
    public void testRawVerticalSwipeDown() throws InterruptedException {
        By graphics = AppiumBy.accessibilityId("Graphics");

        MobileDriverFactory driverFactory = new MobileDriverFactory();
        AndroidDriver driver = (AndroidDriver) driverFactory.getMobileDriver("Android");

        MobileBasePage page = new MobileBasePage(driver);

        page.rawTap(graphics);
        Thread.sleep(50); //needs to be here to enable the scrolling

        page.rawWindowVerticalSwipe(VerticalDirection.UP);
        Thread.sleep(200);
        page.rawWindowVerticalSwipe(VerticalDirection.DOWN);
        Thread.sleep(5000);
        driver.quit();
    }

}
