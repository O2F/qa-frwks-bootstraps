*** Settings ***
Resource    ../../../page.robot
Resource    admin_console_login_page.robot
*** Variables ***
#Room manipulation
${room_number_inp}                    id=roomName
${room_type_dropdown}                 id=type
${room_accessibility_dropdown}        id=accessible
${room_price_inp}                     id=roomPrice
${extras_checkbox_list}               css=[type="checkbox"]
${room_create_btn}                    id=createRoom
${delete_room_btn_lst}                css=[class="row detail"] span[class*="roomDelete"]

${logout}                             xpath=//a[@class="nav-link" and contains(text(),"Logout")]


*** Keywords ***

Delete Room
    [Documentation]    User when there is only a sigle room
    Click On Element    ${delete_room_btn_lst}

Delete Room Position From List
    [Documentation]    Deletes a room based on it position in the list of rooms
    ...  It start in position "1" and internally the keyword handles the indexes
    [Arguments]    ${room_position}    
    ${position}=  Evaluate  ${room_position} - 1
    Click On Element Number Of Element List    ${delete_room_btn_lst}    ${position}
    # Needs some time to remove the line
    Sleep    500ms

Create Room Without Extras
    [Arguments]  ${room_nr}  ${room_type}  ${room_access}  ${room_price}
    Type Text On Field    ${room_number_inp}     ${room_nr}
    Select Value From Dropbox  ${room_type_dropdown}  ${room_type}
    Select Value From Dropbox    ${room_accessibility_dropdown}    ${room_access}
    Type Text On Field    ${room_price_inp}    ${room_price}
    Click On Element    ${room_create_btn}

Perform Logout
    Click On Element    ${logout}
    Webelement Should Be Visible  ${login_btn}  #Ensure that the login form is displayed again