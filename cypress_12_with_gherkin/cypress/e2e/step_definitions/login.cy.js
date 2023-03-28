import {
    When,
    Then,
    Given,
    Step,
  } from '@badeball/cypress-cucumber-preprocessor';

  import { LoginPage } from '../../pages/login.page';

const loginPage = new LoginPage();

Given("the user is in the login page", () => {
    loginPage.visitLoginPage()
    loginPage.confirmLoginPageDisplayed()
})

When("the user inserts valid credentions", () => {
    loginPage.authenticateUser()
})

When("the user tries to login using the user {string} and password {string}", (user, pass) => {
    loginPage.authenticateUser(user, pass)
})

Then("he receives the message {string}", (msg) => {
    loginPage.validateInvalidLoginMsg(msg)
})

Given("a valid user as login in the saucedemo shop", () => {
    Step(this, "the user is in the login page")
    Step(this, "the user inserts valid credentions")
})