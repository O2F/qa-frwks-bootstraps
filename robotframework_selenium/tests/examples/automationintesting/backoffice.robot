*** Settings ***
Resource    ../../../keywords/pageobjects/examples/automationintesting/admin_console/admin_console_login_page.robot
Resource    ../../../keywords/pageobjects/examples/automationintesting/admin_console/admin_console_page.robot

Suite Setup  Perform Login In Shady Meadows B&B Backoffice
Suite Teardown  Perform Logout In Shady Meadows B&B Backoffice

*** Test Cases ***

It is Possible To Create A Room
    # Count list of rooms
    Create Room Without Extras    102    Family  true  100
    # list of rooms has one more room


*** Keywords ***

Perform Login In Shady Meadows B&B Backoffice
    Visit Shady Meadows B&B Backoffice
    Login In Shady Meadows B&B Backoffice

Perform Logout In Shady Meadows B&B Backoffice
    Sleep    500ms
    Delete Room Position From List    2
    Perform Logout