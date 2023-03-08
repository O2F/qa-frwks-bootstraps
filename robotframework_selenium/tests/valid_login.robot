*** Settings ***

Resource    ../keywords/pageobjects/login_page.robot
Resource    ../keywords/pageobjects/catalog_page.robot

*** Test Cases ***

Validate That Is Possible To Login With Valid Credentials
    Go To Saucedemo Login page
    Authenticate In Saucedemo
    Validate Catalog Is Displayed