package org.o2f.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Date;
import java.util.List;

public class CaroucelCyclePage extends BasePage{

    // -- //
    @FindBy(xpath = "//div[@id='carouselExampleCaptions']")
    private WebElement carouselElementContainer;

    @FindBy(xpath = "//div[@id='carouselExampleCaptions']//div[@class='carousel-inner']/div")
    private List<WebElement> carouselElements;

    public CaroucelCyclePage(WebDriver driver) {
        super(driver);
    }

    public void deltaTimeForCarouselElementSelect(){

        //site with carousel that automatically switch images
        driver.get("https://getbootstrap.com/docs/4.0/components/carousel/");

        wait.until(ExpectedConditions.visibilityOf(carouselElementContainer));

        wait.until(ExpectedConditions.attributeContains(carouselElements.get(0), "class", "carousel-item active"));

        double time1 = getMilliSecTime();
        System.out.printf("Time for first event: %s milliseconds %n", time1);

        wait.until(ExpectedConditions.attributeContains(carouselElements.get(carouselElements.size() - 1), "class", "active"));
        double time2 = getMilliSecTime();

        System.out.printf("Time for last event: %s milliseconds %n", time2);

        double DeltaInMilli =  time2 - time1;

        System.out.printf("Time that took between the two events - %f milliseconds %n", DeltaInMilli);
    }

    private long getMilliSecTime(){
        Date date = new Date();

        return date.getTime();
    }
}
