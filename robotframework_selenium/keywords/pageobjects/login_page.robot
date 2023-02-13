*** Settings ***
Resource  page.robot

*** Variables ***
${login_url}  https://www.saucedemo.com/
${username}  id:user-name
${password}  id:password
${login_btn}  id:login-button
${invalid_msg}  css:h3[data-test='error']

${valid_username}  standard_user
${valid_password}  secret_sauce

*** Keywords ***

Go To Saucedemo Login page
    Go To Page    ${login_url}
    Wait For Page Load Confirmation  timeout=10000  time_step=250

Authenticate In Saucedemo
    [Arguments]  ${usr_name}=${valid_username}  ${passwd}=${valid_password}
    Type Text On Field    locator=${username}    text=${usr_name}
    Type Text On Field    locator=${password}    text=${passwd}
    Click On Element      locator=${login_btn}

    
Validate That The Error Message Is
    [Arguments]  ${message}
    ${message_text}=  Get Element Text    ${invalid_msg}
    Should Be Equal As Strings    ${message_text}    ${message}