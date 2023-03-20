package tests.simpletest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleTest {

    @BeforeMethod
    public void setup(){
        // by default the browser is chrome, so when we want other browser we need to state it
        Configuration.browser = "firefox";
    }

    @Test
    public void veryBasicTest() {

        open("https://automationintesting.online/");
        String url = WebDriverRunner.url();

        String title = title();

        assertThat(url, is("https://automationintesting.online/"));
        System.out.println(title);
    }

    @Test
    public void selectorUsageTest(){
        open("https://automationintesting.online/");
        //by css doesn't need to be specified
        SelenideElement bookingButton = $("button[class~='openBooking']");

        // by other selector type needs to be specified - xpath example below
        $(By.xpath("//button[contains(@class,'openBooking')]")).shouldHave(text("Book this room"));
        bookingButton.shouldHave(text("Book this room")).click();

        //$(By.name("user.name")).setValue("johny");
        //$("#submit").click();
        //$(".loading_progress").should(disappear); // Waits until element disappears
        //$("#username").shouldHave(text("Hello, Johny!")); // Waits until element gets text
    }

    @Test
    public void multipleSelectorsTest(){
        open("https://automationintesting.online/");
        List<String> listOfPlaceholders = List.of("Name", "Email", "Phone", "Subject");
        ElementsCollection listOfElements = $$("[class=\"input-group mb-3\"] input");

        List<String> listOfElementPlaceHolder = new ArrayList<>();

        for(SelenideElement e: listOfElements){
            listOfElementPlaceHolder.add(e.getAttribute("placeholder"));
        }
        assertThat(listOfPlaceholders, is(listOfElementPlaceHolder));
    }

}
