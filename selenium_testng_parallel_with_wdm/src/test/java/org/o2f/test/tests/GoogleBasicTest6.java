package org.o2f.test.tests;

import lombok.extern.slf4j.Slf4j;
import org.o2f.pages.GoogleSearchPage;
import org.o2f.test.TestBaseLifeCycle;
import org.testng.annotations.Test;

@Slf4j
public class GoogleBasicTest6 extends TestBaseLifeCycle {

    private GoogleSearchPage googleSearchPage;

    @Test
    void simpleGoogleTest() {
        googleSearchPage = new GoogleSearchPage(driver.get());
        googleSearchPage.goToGoogle();
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Nebula Awards");
        googleSearchPage.validateFirstResultContainsSentence("Nebula Award");
    }

    @Test
    void simpleGoogleTest2() {
        googleSearchPage = new GoogleSearchPage(driver.get());
        googleSearchPage.goToGoogle();
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Hugo Awards");
        googleSearchPage.validateFirstResultContainsSentence("Hugo Award");
    }

    @Test
    void simpleGoogleTest3() {
        googleSearchPage = new GoogleSearchPage(driver.get());
        googleSearchPage.goToGoogle();
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Nebula Awards");
        googleSearchPage.validateFirstResultContainsSentence("Nebula Award");
    }

}
