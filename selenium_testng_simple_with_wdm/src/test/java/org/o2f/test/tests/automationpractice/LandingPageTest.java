package org.o2f.test.tests.automationpractice;

import lombok.extern.slf4j.Slf4j;
import org.o2f.pages.automationpractice.LandingPage;
import org.o2f.pages.automationpractice.SearchResultPage;
import org.o2f.test.TestBaseLifeCycle;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Slf4j
public class LandingPageTest extends TestBaseLifeCycle {

    private static LandingPage landingPage;
    private static SearchResultPage searchResultPage;

    @BeforeClass
    static void suiteSetup() {
        landingPage = new LandingPage(driver);
        searchResultPage = new SearchResultPage(driver);
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
