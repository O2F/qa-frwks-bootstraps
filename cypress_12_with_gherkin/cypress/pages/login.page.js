/// <reference types="cypress" />

import test_credentials from '../fixtures/test_credentials.json'

export class LoginPage {

    locators = {
        username: () => cy.get('#user-name'),
        password: () => cy.get('#password'),
        loginBtn: () => cy.get('#login-button'),
        loginLogo: () => cy.get('.login_logo'),
        errorMsgContainer: () => cy.get('h3[data-test="error"]')
    }

    visitLoginPage(){
        cy.visit("/")
    }

    confirmLoginPageDisplayed(){
        this.locators.loginBtn().should('be.visible')
        this.locators.username().should('be.visible')
        this.locators.password().should('be.visible')
    }

    authenticateUser(user, pass){
        if(user === undefined){
            user = test_credentials.valid_username
        }
        if (pass === undefined) {
            pass = test_credentials.valid_password
        }
        this.locators.username().type(user)
        this.locators.password().type(pass)
        this.locators.loginBtn().click()
    }

    validateInvalidLoginMsg(msg){
        this.locators.errorMsgContainer().should('have.text', msg)
    }

}