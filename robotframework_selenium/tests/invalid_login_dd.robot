*** Settings ***

Test Template  Validate Messages For Login With Invalid Credentials

Resource    ../keywords/pageobjects/login_page.robot

*** Test Cases ***        user                    pass            expected_msg
Invalid user              Notexists               secret_sauce    Epic sadface: Username and password do not match any user in this service
Invalid Pass              standard_usera          notexists       Epic sadface: Username and password do not match any user in this service
Locked Username           locked_out_user         secret_sauce    Epic sadface: Sorry, this user has been locked out.


*** Keywords ***
# Keyword that is the test for the data driven mechanism that is called in the Test Template
Validate Messages For Login With Invalid Credentials
    [Arguments]  ${user}  ${pass}  ${expected_msg}
    Go To Saucedemo Login page
    Authenticate In Saucedemo  ${user}  ${pass}
    Validate That The Error Message Is    ${expected_msg}