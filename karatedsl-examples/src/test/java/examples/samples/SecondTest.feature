Feature: Second Test Scenarios

  Background: Test background
    * url 'https://reqres.in/api'
    * header Accept = 'application/json'

  Scenario: Using path params
    Given path '/users?page=2'
    When method GET
    Then status 200

  Scenario: Using query params
    Given path '/users'
    And param page = 2
    When method GET
    Then status 200

  Scenario: Basic assertion
    Given path '/users'
    And param page = 2
    When method GET
    Then status 200
    And match response.data[0].first_name != null
    And assert response.data.length == 6
    And match $.data[3].id == 10
