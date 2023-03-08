const { Given, When, Then } = require('@wdio/cucumber-framework');

const LoginPage = require('../pageobjects/login.page')

Given(/^the user is in the login page$/, async () => {
    await browser.url(`https://www.saucedemo.com`)
    await browser.pause(2000)
    await LoginPage.confirmLoginPageDisplayed()
})

When(/^the user inserts valid credentions$/, async () => {
    await LoginPage.authenticateUser()
})

When(/^the user tries to login using the user (.*) and password (.*)$/, async (user, pass) => {
    await LoginPage.authenticateUser(user, pass)
})

Then(/^he receives the message (.*)$/, async (msg) => {
    await LoginPage.validateInvalidLoginMsg(msg)
})