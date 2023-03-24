*** Settings ***

Resource    ../../../keywords/pageobjects/examples/automationintesting/booking/booking_page.robot
Resource    ../../../keywords/pageobjects/examples/automationintesting/admin_console/admin_console_login_page.robot
Resource    ../../../keywords/pageobjects/examples/automationintesting/admin_console/admin_console_page.robot

Suite Setup  Create Single Room
Suite Teardown  Delete Single Room

*** Test Cases ***

Validate That Is Possible To Book A Room
    Visit Shady Meadows Bed And Breakfast
    Book The Room Number    2
    Book Room For Days Of The Current Month    7    8
    Fill Guest Information    
    ...  Manel    
    ...  Jakin
    ...  Jakin_Manel@Manelitos.xom
    ...  12345678911
    Press The Book Button
    Validate Booking Is Successful
    

*** Keywords ***
# Setup keywords

Create Single Room
    #temp
    Visit Shady Meadows B&B Backoffice
    Login In Shady Meadows B&B Backoffice
    Create Room Without Extras    110    Family    true    200
    Perform Logout
    
    
Delete Single Room
    Visit Shady Meadows B&B Backoffice
    Login In Shady Meadows B&B Backoffice
    Delete Room Position From List    2