package tests;

import objects.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.LoginPage;

public class CatalogTests extends BaseTests{

    protected LoginPage loginPage;
    protected CatalogPage catalogPage;

    @BeforeMethod
    public void setup(){

        loginPage = new LoginPage();
        catalogPage = new CatalogPage();
        loginPage.authenticateUser(new User("standard_user", "secret_sauce"));
    }

    @Test
    public void validateCatalogAsItemsTest(){

        catalogPage.validateMainCatalogPageElementsVisible();
        catalogPage.validateCatalogIsNotEmpty();
    }

    @Test
    public void validateThatIsPossibleToAddItemsToCart(){
        catalogPage.addItemToCart();
        catalogPage.cartShouldHaveItem();
    }

    @Test
    public void validateThatIsPossibleToChangeSort(){
        catalogPage.selectWorstPriceSort();
        catalogPage.validateWorstPriceIsFirstItem();
    }

}
