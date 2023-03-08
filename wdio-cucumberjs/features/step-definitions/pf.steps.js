const { Given, When, Then } = require('@wdio/cucumber-framework');

const PracticeFormPage = require('../pageobjects/pf.page');


Given(/^the user is in the practice form page$/, async () => {
    await PracticeFormPage.visitPracticeForm();
})

When(/^it fills the form$/, async () => {
    await PracticeFormPage.fillFirstName()
    await PracticeFormPage.fillLastName()
    await PracticeFormPage.fillEmail()
    await PracticeFormPage.selectAllHobbies()
    await browser.pause(2000)
})

