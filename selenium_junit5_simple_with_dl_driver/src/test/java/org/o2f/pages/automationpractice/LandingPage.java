package org.o2f.pages.automationpractice;

import org.o2f.pages.BasePage;
import org.o2f.pages.automationpractice.components.HeaderComponent;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    private HeaderComponent headerComponent;

    public LandingPage(WebDriver driver){
        super(driver);
        this.headerComponent = new HeaderComponent(driver);
    }

    public void isLoaded(){
        headerComponent.loginBtnShouldBeDisplayed();
        headerComponent.headerDiscountShouldBeDisplayed();
        //... in a real case we would have all the components pieces of all the components here
    }

    public void doSearchOf(String text){
        headerComponent.search(text);
    }

    public void navigateToAutomationPracticeHomePage(String envUrl){
        driver.get(envUrl);
    }
}
