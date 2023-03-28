//.title

/// <reference types="cypress" />

export class CatalogPage {

    locators = {
        catalogTitle: () => cy.get('.title'),
        cartIcon: () => cy.get('#shopping_cart_container'),
        menuIcon: () => cy.get('#react-burger-menu-btn'),
        sortDropdown: () => cy.get('.product_sort_container'),
        inventoryTableContainer: () => cy.get('#inventory_container'),
        inventoryItems: () => cy.get('.inventory_item'),
        productBackpack: () => cy.get('#add-to-cart-sauce-labs-backpack'),
        cartProductsBadge: () => cy.get('.shopping_cart_badge')
    }

    catalogPageVisible(){
        this.locators.catalogTitle().should('be.visible')
        this.locators.cartIcon().should('be.visible')
        this.locators.menuIcon().should('be.visible')
        this.locators.sortDropdown().should('be.visible')
        this.locators.inventoryTableContainer().should('be.visible')
    }

    shouldHaveInventoryItems(){
        this.locators.inventoryItems().then(els =>{
            expect(els.length).greaterThan(0)
        })
    }

    addProduct(product){
        if(product.toUpperCase() === "BACKPACK"){
            this.locators.productBackpack().click()
        }else{
            throw Error("Product not available for testing")
        }
    }

    cartProductsNrIs(number){
        this.locators.cartProductsBadge().should('have.text', number)
    }

}