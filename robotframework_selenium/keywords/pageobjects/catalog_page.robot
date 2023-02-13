*** Settings ***

Resource  page.robot

*** Variables ***

${catalog_title}  css:.title
${cart_icon}  id:shopping_cart_container

*** Keywords ***

Validate Catalog Is Displayed
    Wait For Page Load Confirmation  5000  250
    Webelement Should Be Visible    ${catalog_title}
    Webelement Should Be Visible    ${cart_icon}