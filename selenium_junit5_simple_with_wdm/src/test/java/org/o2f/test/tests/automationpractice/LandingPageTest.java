package org.o2f.test.tests.automationpractice;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.o2f.pages.automationpractice.LandingPage;
import org.o2f.pages.automationpractice.SearchResultPage;
import org.o2f.test.TestBaseLifeCycle;

@Slf4j
public class LandingPageTest extends TestBaseLifeCycle {

    private static LandingPage landingPage;
    private static SearchResultPage searchResultPage;

    @BeforeAll
    static void suiteSetup() {
        landingPage = new LandingPage(driver);
        searchResultPage = new SearchResultPage(driver);
        landingPage.navigateToAutomationPracticeHomePage(config.getBaseUrl());
        landingPage.isLoaded();
    }

    @Test
    void shouldBePossibleToSearch(TestInfo testInfo) {

        log.info("Starting Search Test");
        landingPage.doSearchOf("dress");
        searchResultPage.isLoaded();
        searchResultPage.displayedSearchTermsShouldBe("DRESS");
        searchResultPage.numberOfResultsShouldBe(7);
        log.info("Ending Search Test");
    }

}
