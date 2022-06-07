package org.o2f.test.tests;

import lombok.extern.slf4j.Slf4j;
import org.o2f.pages.GoogleSearchPage;
import org.o2f.test.TestBaseLifeCycle;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class GoogleBasicTest extends TestBaseLifeCycle {

    private GoogleSearchPage googleSearchPage;

    @Test
    public void GOOGLE1() {
        System.out.println("Google1 Test Started! " + "Thread Id: " +  Thread.currentThread().getId());
        driver.get().navigate().to("http://www.google.com");
        System.out.println("Google1 Test's Page title is: " + driver.get().getTitle() +" " + "Thread Id: " +  Thread.currentThread().getId());
        Assert.assertEquals(driver.get().getTitle(), "Google");
        googleSearchPage = new GoogleSearchPage(driver.get());
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Hugo Awards");
        googleSearchPage.validateFirstResultContainsSentence("Hugo Award");
        System.out.println("Google1 Test Ended! " + "Thread Id: " +  Thread.currentThread().getId());
    }
    @Test
    public void GOOGLE2() {
        System.out.println("Google2 Test Started! " + "Thread Id: " +  Thread.currentThread().getId());
        driver.get().navigate().to("http://www.google.com");
        System.out.println("Google2 Test's Page title is: " + driver.get().getTitle() +" " + "Thread Id: " +  Thread.currentThread().getId());
        Assert.assertEquals(driver.get().getTitle(), "Google");
        googleSearchPage = new GoogleSearchPage(driver.get());
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Hugo Awards");
        googleSearchPage.validateFirstResultContainsSentence("Hugo Award");
        System.out.println("Google2 Test Ended! " + "Thread Id: " +  Thread.currentThread().getId());
    }
    @Test
    public void GOOGLE3() {
        System.out.println("Google3 Test Started! " + "Thread Id: " +  Thread.currentThread().getId());
        driver.get().navigate().to("http://www.google.com");
        System.out.println("Google3 Test's Page title is: " + driver.get().getTitle() +" " + "Thread Id: " +  Thread.currentThread().getId());
        Assert.assertEquals(driver.get().getTitle(), "Google");
        googleSearchPage = new GoogleSearchPage(driver.get());
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Hugo Awards");
        googleSearchPage.validateFirstResultContainsSentence("Hugo Award");
        System.out.println("Google3 Test Ended! " + "Thread Id: " +  Thread.currentThread().getId());
    }

}
