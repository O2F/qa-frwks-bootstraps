import {
    When,
    Then
  } from '@badeball/cypress-cucumber-preprocessor';

import { CatalogPage } from '../../pages/catalog.page';

const catalogPage = new CatalogPage();

Then("the user see the product page", () => {
    catalogPage.catalogPageVisible()
})

Then("a table with the available products", () => {
    catalogPage.shouldHaveInventoryItems()
})

When("the user add a product to the cart", () => {
    catalogPage.addProduct("backpack")
})

Then("the cart displays the product added", () => {
    catalogPage.cartProductsNrIs(1)
})