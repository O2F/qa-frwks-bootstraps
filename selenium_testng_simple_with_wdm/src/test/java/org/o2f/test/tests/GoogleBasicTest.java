package org.o2f.test.tests;

import org.o2f.pages.GoogleSearchPage;
import org.o2f.test.TestBaseLifeCycle;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleBasicTest extends TestBaseLifeCycle {

    private static GoogleSearchPage googleSearchPage;

    @BeforeClass
    void testSuiteSetup() {
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.goToGoogle();
    }

    @Test
    void simpleGoogleTest() {
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Espera sempre só coisas boas");
    }

}
