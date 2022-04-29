package org.o2f.test.tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.o2f.pages.GoogleSearchPage;
import org.o2f.test.TestBaseLifeCycle;

@Slf4j
public class GoogleBasicTest extends TestBaseLifeCycle {

    private static GoogleSearchPage googleSearchPage;

    @BeforeAll
    static void testSuiteSetup() {
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.goToGoogle();
    }

    @Test
    void simpleGoogleTest() {
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Espera sempre só coisas boas");
    }

}
