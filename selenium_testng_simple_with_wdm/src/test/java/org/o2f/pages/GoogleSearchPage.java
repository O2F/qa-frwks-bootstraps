package org.o2f.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleSearchPage extends BasePage{

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchBtn;

    @FindBy(id = "L2AGLb")
    private WebElement agreeBtn;

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
}
