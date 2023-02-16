Feature: First Test Feature

  Scenario: First Test
    Given url 'https://reqres.in/api/users?page=2'
    When method GET
    Then status 200
    #And print response
    #And print responseStatus
    #And print responseHeaders
    #And print responseCookies
    #And print responseTime


  Scenario: Config demo
    Given print env
    And print baseUrl