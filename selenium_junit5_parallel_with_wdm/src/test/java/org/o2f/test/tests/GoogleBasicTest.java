package org.o2f.test.tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.o2f.pages.GoogleSearchPage;
import org.o2f.test.TestBaseLifeCycle;

@Slf4j
public class GoogleBasicTest extends TestBaseLifeCycle {

    private GoogleSearchPage googleSearchPage;

    @Test
    void simpleGoogleTest() {
        googleSearchPage = new GoogleSearchPage(driverSimpleThreadManager.getDriver());
        googleSearchPage.goToGoogle();
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Espera sempre só coisas boas");
    }

    @Test
    void simpleGoogleTest2() {
        googleSearchPage = new GoogleSearchPage(driverSimpleThreadManager.getDriver());
        googleSearchPage.goToGoogle();
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Espera sempre só coisas boas");
    }

    @Test
    void simpleGoogleTest3() {
        googleSearchPage = new GoogleSearchPage(driverSimpleThreadManager.getDriver());
        googleSearchPage.goToGoogle();
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Espera sempre só coisas boas");
    }

}
