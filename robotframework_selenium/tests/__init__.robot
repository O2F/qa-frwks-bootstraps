*** Setting ***
Documentation     Setting metadata for test suite directory
Suite Setup  Open The Browser Window

# --// LIBS AND RESOURCES //--

Library     SeleniumLibrary
Library     String
Library     Collections
Library     BuiltIn

*** Keywords ***

Open The Browser Window
    Open Browser   browser=chrome  executable_path=${EXECDIR}/driver/chromedriver