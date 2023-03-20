package tests;

import objects.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.LoginPage;

public class LoginTests extends BaseTests {

    protected LoginPage loginPage;
    protected CatalogPage catalogPage;

    // data providers examples
    // first example
    @DataProvider(name="invalid logins")
    protected Object[][] dataProvider(){
        return new Object[][] {
                {
                    new User("standard_usera", "secret_sauce"),
                    "Epic sadface: Username and password do not match any user in this service"
                },
                {
                    new User("locked_out_user", "secret_sauce"),
                    "Epic sadface: Sorry, this user has been locked out."
                }
        };
    }

    @BeforeMethod
    public void setup(){

        loginPage = new LoginPage();
        catalogPage = new CatalogPage();
    }

    @Test
    public void successfulLoginTest(){
        User user = new User("standard_user", "secret_sauce");
        loginPage.authenticateUser(user);
        loginPage.errorIsNotDisplayed();
        catalogPage.validateMainCatalogPageElementsVisible();
    }

    //example for datadriven tests using a data provider
    @Test(dataProvider = "invalid logins")
    public void incorrectLoginTest(User user, String msg){
        loginPage.authenticateUser(user);
        loginPage.verifyErrorMessage(msg);
    }

}
