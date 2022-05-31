package org.o2f.pages.automationpractice.components;

import org.o2f.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ResultsComponent extends BasePage {

    @FindBy(id = "center_column")
    private WebElement resultsContainer;

    @FindBy(className = "lighter")
    private WebElement termSearched;

    @FindBy(className = "product-container")
    private List<WebElement> resultsBoxes;

    public ResultsComponent(WebDriver driver) {
        super(driver);
    }

    public void isLoaded() {
        wait.until(ExpectedConditions.visibilityOf(resultsContainer));
        wait.until(ExpectedConditions.visibilityOf(termSearched));
        wait.until(ExpectedConditions.visibilityOf(resultsBoxes.get(0))); // 1st result loaded
    }

    public String getSearchedTermText() {
        return termSearched.getText().replace("\"", "");
    }

    public int getNumberOfResults() {
        return resultsBoxes.size();
    }
}
