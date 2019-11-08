Feature: this feature is for testing user profile

  Background: 
    Given correct url
    When user login with "nafisa@gmail.com" and "123456"

  @ClassWork
  Scenario: update user profile for Nafisa
    When user update profile
    Then veirfy status code 200

  Scenario: update expireience in user profile for Nafisa
    When user update expirence in profile
    Then veirfy status code 200
