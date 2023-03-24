*** Settings ***

Resource  ../../../page.robot

*** Variables ***

${url}  https://automationintesting.online

${booking_btn_list}          css=[class="row hotel-room-info"] button
${month_days_for_booking}    css=[class="rbc-day-bg"]
${first_name_input}          css=input[name="firstname"]
${last_name_input}           css=input[name="lastname"]
${email_input}               css=input[name="email"]
${phone_input}               css=input[name="phone"]
${error_msg}                 css=[class="alert alert-danger"]
${book_button}               xpath=//button[contains(@class,"book-room") and contains(text(),"Book")]
${book_confirmation_msg}     css=[class='col-sm-6 text-center'] h3
${book_close_msg}            xpath=//button[contains(@class,"btn btn-outline-primary") and contains(text(),"Close")]

*** Keywords ***

Visit Shady Meadows Bed And Breakfast
    Go To Page    ${url}

Book The Room Number 
    [Arguments]  ${room_number}

    ${room_number}=  Evaluate    ${room_number} - 1
    Click On Element Number Of Element List  ${booking_btn_list}  ${room_number}

Book Room For Days Of The Current Month
    [Arguments]  ${day_start}  ${day_end}
    # to facilitate things we will assume that all the months don't have more than 28 days
    # since the start day needs to be excluded it can never schedule the 1 of the month
    ${day_start}=  Evaluate    ${day_start} - 2  # needs to be this way so it excludes one unit when do the drag and drop
    ${day_end}=  Evaluate  ${day_end} - 1
    IF    ${day_start} > 28 or ${day_end} > 28
        Fail
    ELSE IF  ${day_start} >= ${day_end} 
        Fail
    END
    
    Manual Drag And Drop Element In List Of Elements For Room Scheduling    ${month_days_for_booking}    ${day_start}    ${day_end}

Fill Guest Information
    [Arguments]  ${firstname}  ${lastname}  ${email}  ${phone}
    Type Text On Field    ${first_name_input}    ${firstname}
    Type Text On Field    ${last_name_input}     ${lastname}
    Type Text On Field    ${email_input}         ${email}
    Type Text On Field    ${phone_input}         ${phone}

Press The Book Button
    Click On Element    ${book_button}

Validate Booking Is Successful
    Validate Element Text    ${book_confirmation_msg}    Booking Successful!



## Internal Keyword
Manual Drag And Drop Element In List Of Elements For Room Scheduling
    [Documentation]  Although it has Selenium direct mechanism this is something very particular so it should live in this 
    ...  page instead of the "page"
    [Arguments]  ${selector}  ${source_elem_index_excluded}  ${target_elem_index}
    @{elements}=  SeleniumLibrary.Get WebElements    ${selector}
    
    ${middle}=  Evaluate    ${source_elem_index_excluded}+1

    Mouse Down    ${elements}[${source_elem_index_excluded}]
    Mouse Over    ${elements}[${middle}]
    Mouse Over    ${elements}[${target_elem_index}]
    Mouse Up    ${elements}[${target_elem_index}]