*** Settings ***
Library     SeleniumLibrary  

*** Keywords ***

Click On Element
    [Documentation]  Keyword responsible for the function of clicking on an element and waiting for the element to be visible.
    [Arguments]  ${locator}
    SeleniumLibrary.Wait Until Element Is Visible    ${locator}
    SeleniumLibrary.Click Element    ${locator}

Go To Page
    [Documentation]  Keyword responsible for opening the specific URL for each type of platform.
    [Arguments]  ${url}
    Go To   ${url}

Type Text On Field
    [Documentation]  Keyword responsible for insert a text on a field
    [Arguments]  ${locator}  ${text}

    Click On Element  ${locator}
    SeleniumLibrary.Input Text    ${locator}    ${text}

Verify Target Page Url
    [Documentation]  Keyword responsible for check the target page
    [Arguments]  ${expected_url}
    ${URL}=  Get Location
    Should be equal  ${URL}  ${expected_url}

Webelement Should Be Visible
    [Documentation]  This keyword returns true if the expected element is visible
    [Arguments]  ${locator}
    
    ${is_element_visible}=  SeleniumLibrary.Wait Until Element Is Visible    ${locator}
    
Webelement Should Not Be Visible
    [Documentation]  This keyword returns true if the expected element is not visible
    [Arguments]  ${locator}
    
    ${is_element_visible}=  SeleniumLibrary.Wait Until Element Is Not Visible    ${locator}

Get Element Text
    [Documentation]  This keyword returns the text of element
    [Arguments]  ${locator}

    SeleniumLibrary.Wait Until Element Is Visible  ${locator}
    ${text}=  SeleniumLibrary.Get Text   ${locator}

    [Return]  ${text}

Wait For Page Load Confirmation
    [Documentation]  This keyword will wait until the desired time to receive the indication that the page load is complete.
    ...  If it doesn't receive the same indication passing that time it will throw an error stating that the page is either not loaded 
    ...  or there is some internal element that is not loaded and the page then can't be fully loaded.
    ...  In case of error a screenshot will also be retrieved.
    [Arguments]  ${timeout}=${PAGE_LOAD_TIMEOUT_MILISEC}  ${time_step}=${PAGE_LOAD_TIME_STEP_MILISEC}

    ${ready_state_status_js}=  Catenate  return document.readyState

    ${nr_of_iterations}=  Evaluate  ${timeout}/${time_step}
    ${nr_of_iterations}=  Convert To Integer  ${nr_of_iterations}

    ${max_iteration_range}=  Evaluate  ${nr_of_iterations}-1
    ${max_iteration_range}=  Convert To Integer  ${max_iteration_range}

    FOR  ${iterator}  IN RANGE  ${nr_of_iterations}
        
        ${page_loaded_result}=  SeleniumLibrary.Execute Javascript    ${ready_state_status_js}
        
        IF  "${page_loaded_result}"=="complete"
            Exit For Loop
        END  
        
        IF  ${iterator}==${max_iteration_range}
            Fail  msg=The page that is trying to be loaded could not be loaded within ${timeout}
        END

        Sleep  ${time_step}ms
        
    END

Scroll Down
    Execute JavaScript    window.scrollTo(0, document.body.scrollHeight)
    Sleep   3  
    

Refresh The Page
    [Documentation]  Keyword responsible for refreshing the page
    
    SeleniumLibrary.Reload Page