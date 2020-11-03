Feature: API testing

  Scenario: 1 Demonstrating that user is able to send request and get appropriate request for SINGLE user info
    Given User sets the link and contentType for request
    When User sends the request to the api
    Then Status Code is 200
    And Response body is equal to test.json
    And Response body contains FIRST_NAME filed with JANET value

  Scenario: 2 Demonstrating that user is able to send request and get appropriate request for Multiply users info
    Given User sets the link and contentType for request
    When User sends GET request to /api/users/page=2 api
    Then Status Code is 200
    And Response body is equal to listOfUsers.json
    And Response body contains data-1.email filed with lindsay.ferguson@reqres.in value
