*** Settings ***

Resource    ../../../keywords/pageobjects/examples/saucelabs/login_page.robot
Resource    ../../../keywords/pageobjects/examples/saucelabs/catalog_page.robot

*** Test Cases ***

Validate That Is Possible To Login With Valid Credentials
    Go To Saucedemo Login page
    Authenticate In Saucedemo
    Validate Catalog Is Displayed