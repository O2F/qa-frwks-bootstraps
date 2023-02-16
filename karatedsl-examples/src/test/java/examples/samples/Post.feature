Feature: Post feature

  Background:
    * url 'https://reqres.in/api'
    * header Accepts = 'application/json'
    # Get path (2 ways)
    # def projectPath = java.lang.System.getProperty('user.dir')
    * def projectPath = karate.properties['user.dir']


  Scenario: Inline body
    Given path '/users'
    And request {"name": "Jakin", "job": "Tester"}
    When method POST
    Then status 201


  Scenario: Assertions with hashes (special assertions)
    Given path '/users'
    And request {"name": "Jakin", "job": "Tester"}
    When method POST
    Then status 201
    And match response == {"id": "#string", "createdAt": "#ignore", "name": "Jakin", "job": "Tester"}

  Scenario: Response assertion from file

    # this 'def' can also be added in the background instead of here
    * def expectedResponse = read('../test_data/response.json')

    Given path '/users'
    And request {"name": "Jakin", "job": "Tester"}
    When method POST
    Then status 201
    And match response == expectedResponse

  Scenario: Passing request from file

    # this 'def' can also be added in the background instead of here

    * def requestPost = read('../test_data/requestPost.json')

    Given path '/users'
    And request requestPost
    When method POST
    Then status 201
    # using '$' instead of response since it is the same
    And match $ == {"id": "#string", "createdAt": "#ignore", "name": "Jakin", "job": "Tester"}

  Scenario: Setting new values for request body from the file
    * def requestPost = read('../test_data/requestPost.json')

    Given path '/users'
    And request requestPost
    And set requestPost.name = "Manel"
    When method POST
    Then status 201
    # using '$' instead of response since it is the same
    And match $ == {"id": "#string", "createdAt": "#ignore", "name": "Manel", "job": "Tester"}