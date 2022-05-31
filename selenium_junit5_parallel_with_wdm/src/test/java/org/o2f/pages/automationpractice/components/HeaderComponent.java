package org.o2f.pages.automationpractice.components;

import org.o2f.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderComponent extends BasePage {

    @FindBy(css = "#header .banner .img-responsive")
    private WebElement headerDiscounts;

    @FindBy(css = "[class='logo img-responsive']")
    private WebElement logo;

    @FindBy(name = "submit_search")
    private WebElement submitSearchBtn;

    @FindBy(name = "search_query")
    private WebElement searchInputBox;

    @FindBy(css = "a.login")
    private WebElement loginBtn;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public void headerDiscountShouldBeDisplayed() {
        wait.until((driver1) -> headerDiscounts.isDisplayed());
    }

    public void logoShouldBeDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(logo));
    }

    public void loginBtnShouldBeDisplayed() {
        wait.until(driver1 -> loginBtn.isDisplayed());
    }

    public void search(String text) {
        inputText(searchInputBox, text);
        clickOnBtn(submitSearchBtn);
    }

}
