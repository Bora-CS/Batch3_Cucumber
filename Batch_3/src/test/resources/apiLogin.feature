Feature: Login feature for api testing

  Scenario: login user by api
    Given correct url
    When user login with "emailId" and "password"
    Then veirfy status code 400
