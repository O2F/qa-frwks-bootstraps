package pages;

import com.codeborne.selenide.SelenideElement;
import objects.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private SelenideElement usernameField = $(By.id("user-name"));
    private SelenideElement passwordField = $(By.id("password"));
    private SelenideElement loginButton = $(By.id("login-button"));
    private SelenideElement errorMsgContainer = $("h3[data-test='error']");

    public LoginPage() {
        open("/");
    }

    public void authenticateUser(User user) {
        usernameField.should(be(visible)).val(user.getUsername());
        passwordField.should(be(visible)).val(user.getPassword());
        loginButton.should(be(visible)).click();
    }

    public void verifyErrorMessage(String expectedMsg) {
        errorMsgContainer.shouldHave(text(expectedMsg));
    }

    public void errorIsNotDisplayed(){
        errorMsgContainer.should(not(be(visible)));
    }

}
