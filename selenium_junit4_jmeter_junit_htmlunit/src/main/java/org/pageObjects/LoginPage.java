package org.pageObjects;

import org.apache.jmeter.protocol.java.sampler.JUnitSampler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    //this is only to see if it works and for now will be a raw impl

    WebDriver driver;
    WebDriverWait wait;

    By username_locator = By.xpath("//input[@data-test='username']");
    By password_locator = By.id("password");
    By submit_btn_locator = By.id("login-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToLogin(){
        // get variables from JMeter
        // in this example we are getting the url variable that is present in the JMeter project
        JUnitSampler sampler = new JUnitSampler();
        String url = sampler.getThreadContext().getVariables().get("url");

        driver.get(url);
    }

    public void login(String username, String password) throws InterruptedException {
        String teste = driver.getCurrentUrl();
        System.out.println(teste);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(username_locator)));
        driver.findElement(username_locator).click();
        driver.findElement(username_locator).sendKeys(username);
        driver.findElement(password_locator).click();
        driver.findElement(password_locator).sendKeys(password);
        driver.findElement(submit_btn_locator).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("title"))));
    }

    public String getTitle(){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("title")))).getText();
    }
}
