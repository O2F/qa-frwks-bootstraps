package org.o2f.test.tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.o2f.pages.GoogleSearchPage;
import org.o2f.test.TestBaseLifeCycle;

@Slf4j
public class GoogleBasicTest6 extends TestBaseLifeCycle {

    private GoogleSearchPage googleSearchPage;

    @Test
    void simpleGoogleTest() {
        googleSearchPage = new GoogleSearchPage(driverThreadManager.getDriver());
        googleSearchPage.goToGoogle();
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Espera sempre só coisas boas");
    }

    @Test
    void simpleGoogleTest2() {
        googleSearchPage = new GoogleSearchPage(driverThreadManager.getDriver());
        googleSearchPage.goToGoogle();
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Espera sempre só coisas boas");
    }

    @Test
    void simpleGoogleTest3() {
        googleSearchPage = new GoogleSearchPage(driverThreadManager.getDriver());
        googleSearchPage.goToGoogle();
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Espera sempre só coisas boas");
    }

}
