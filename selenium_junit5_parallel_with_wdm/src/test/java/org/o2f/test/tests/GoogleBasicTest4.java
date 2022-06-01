package org.o2f.test.tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.o2f.pages.GoogleSearchPage;
import org.o2f.test.TestBaseLifeCycle;

@Slf4j
public class GoogleBasicTest4 extends TestBaseLifeCycle {

    private GoogleSearchPage googleSearchPage;

    @Test
    void simpleGoogleTest() {
        googleSearchPage = new GoogleSearchPage(driverSimpleThreadManager.getDriver());
        googleSearchPage.goToGoogle();
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Nebula Awards");
        googleSearchPage.validateFirstResultContainsSentence("Nebula Award");
    }

    @Test
    void simpleGoogleTest2() {
        googleSearchPage = new GoogleSearchPage(driverSimpleThreadManager.getDriver());
        googleSearchPage.goToGoogle();
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Hugo Awards");
        googleSearchPage.validateFirstResultContainsSentence("Hugo Award");
    }

    @Test
    void simpleGoogleTest3() {
        googleSearchPage = new GoogleSearchPage(driverSimpleThreadManager.getDriver());
        googleSearchPage.goToGoogle();
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Nebula Awards");
        googleSearchPage.validateFirstResultContainsSentence("Nebula Award");
    }

}
