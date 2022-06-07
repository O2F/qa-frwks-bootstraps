package org.o2f.test.tests;

import lombok.extern.slf4j.Slf4j;
import org.o2f.pages.GoogleSearchPage;
import org.o2f.test.TestBaseLifeCycle;
import org.testng.annotations.Test;

@Slf4j
public class GoogleBasicTest9 extends TestBaseLifeCycle {

    private GoogleSearchPage googleSearchPage;

    @Test
    void simpleGoogleTest() {
        googleSearchPage = new GoogleSearchPage(driver.get());
        googleSearchPage.goToGoogle();
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Espera sempre só coisas boas");
        googleSearchPage.validateFirstResultContainsSentence("Espera sempre só coisas boas");
    }

    @Test
    void simpleGoogleTest2() {
        googleSearchPage = new GoogleSearchPage(driver.get());
        googleSearchPage.goToGoogle();
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Espera sempre só coisas boas");
        googleSearchPage.validateFirstResultContainsSentence("Espera sempre só coisas boas");
    }

    @Test
    void simpleGoogleTest3() {
        googleSearchPage = new GoogleSearchPage(driver.get());
        googleSearchPage.goToGoogle();
        googleSearchPage.acceptConditions();
        googleSearchPage.doSearch("Espera sempre só coisas boas");
        googleSearchPage.validateFirstResultContainsSentence("Espera sempre só coisas boas");
    }

}
