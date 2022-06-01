package org.o2f.pages.automationpractice;

import org.o2f.pages.BasePage;
import org.o2f.pages.automationpractice.components.HeaderComponent;
import org.o2f.pages.automationpractice.components.ResultsComponent;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;

public class SearchResultPage extends BasePage {

    private HeaderComponent headerComponent;
    private ResultsComponent resultsComponent;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        this.headerComponent = new HeaderComponent(driver);
        this.resultsComponent = new ResultsComponent(driver);
    }

    public void isLoaded() {
        resultsComponent.isLoaded();
        //... in a normal automation would have the remaining components
    }

    public void displayedSearchTermsShouldBe(String text) {
        assertThat(text, equalToIgnoringCase(resultsComponent.getSearchedTermText()));

    }

    public void numberOfResultsShouldBe(int ExpectedNumberOfResults) {
        assertThat(ExpectedNumberOfResults, is(resultsComponent.getNumberOfResults()));
    }


}
