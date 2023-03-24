*** Settings ***

Resource  ../../../page.robot

*** Variables ***

${url_backoffice}                   https://automationintesting.online/#/admin
${usr_input}                        id=username
${password_input}                   id=password
${login_btn}                        id=doLogin


*** Keywords ***

Visit Shady Meadows B&B Backoffice
    Go To Page    ${url_backoffice}

Login In Shady Meadows B&B Backoffice
    [Arguments]  ${username}=admin    ${password}=password
    Type Text On Field    ${usr_input}    ${username}
    Type Text On Field    ${password_input}    ${password}
    Click On Element    ${login_btn}