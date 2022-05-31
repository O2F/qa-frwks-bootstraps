package org.o2f.test.tests.automationpractice;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.o2f.pages.automationpractice.LandingPage;
import org.o2f.pages.automationpractice.SearchResultPage;
import org.o2f.test.TestBaseLifeCycle;

@Slf4j
public class LandingPageTest2 extends TestBaseLifeCycle {

    private static LandingPage landingPage;
    private static SearchResultPage searchResultPage;

    @BeforeEach
    void setupSuite(){
        landingPage = new LandingPage(driverSimpleThreadManager.getDriver());
        searchResultPage = new SearchResultPage(driverSimpleThreadManager.getDriver());
        landingPage.navigateToAutomationPracticeHomePage(config.getBaseUrl());
        landingPage.isLoaded();
    }

    @Test
    void shouldBePossibleToSearch() {

        log.info("Starting Search Test");
        landingPage.doSearchOf("dress");
        searchResultPage.isLoaded();
        searchResultPage.displayedSearchTermsShouldBe("DRESS");
        searchResultPage.numberOfResultsShouldBe(7);
        log.info("Ending Search Test");
    }

}
