package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CatalogPage {

    SelenideElement catalogTitle = $(".title");
    SelenideElement cartIcon = $("#shopping_cart_container");
    SelenideElement menuIcon = $("#react-burger-menu-btn");
    SelenideElement dropdownSortingMenu = $(".product_sort_container");
    SelenideElement inventoryTableContainer = $("#inventory_container");
    ElementsCollection inventoryItems = $$(".inventory_item");
    SelenideElement cartProductBadge = $(".shopping_cart_badge");

    public void validateMainCatalogPageElementsVisible(){
        catalogTitle.shouldBe(visible);
        cartIcon.shouldBe(visible);
        menuIcon.shouldBe(visible);
        dropdownSortingMenu.shouldBe(visible);
        inventoryTableContainer.shouldBe(visible);
        for (SelenideElement e : inventoryItems){
            e.shouldBe(visible);
        }
    }

    public void validateCatalogIsNotEmpty(){
        inventoryItems.shouldBe(CollectionCondition.sizeGreaterThan(0));
    }

    public void addItemToCart() {
        inventoryItems.get(0).$("button").click();
    }

    public void cartShouldHaveItem(){
        var itemAddRemoveBtnText = inventoryItems.get(0).$("button").getText();
        assertThat(itemAddRemoveBtnText,is("Remove"));

        var numberOfItemsInCart = cartProductBadge.getText();
        assertThat(numberOfItemsInCart,is("1"));
    }

    public void selectSortByText(String text){
        dropdownSortingMenu.selectOption(text);
    }

    public void selectWorstPriceSort(){
        this.selectSortByText("Price (high to low)");
    }

    public void validateItemPrice(int itemPosition, String price){
        inventoryItems.get(itemPosition - 1).$(".inventory_item_price").shouldHave(text(price));
    }

    public void validateWorstPriceIsFirstItem(){
        this.validateItemPrice(1, "$49.99");
    }
}
