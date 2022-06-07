package org.o2f.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class GoogleSearchPage extends BasePage{

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchBtn;

    @FindBy(id = "L2AGLb")
    private WebElement agreeBtn;

    @FindBy(xpath = "//h3")
    private List<WebElement> resultsLinks;

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void goToGoogle(){
        driver.get("https://www.google.com");
    }

    public void acceptConditions(){
        clickOnBtn(agreeBtn);
    }

    public void doSearch(String text){
        inputText(searchBox,text);
        clickOnKey(searchBox,Keys.ENTER);
    }

    public void validateFirstResultContainsSentence(String sentence){
        if (resultsLinks.size() > 0){
            String text = resultsLinks.get(0).getText();
            assertThat(text,containsString(sentence));
        }
    }
}
