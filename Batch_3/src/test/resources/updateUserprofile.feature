Feature: this feature is for testing user profile

  Background: 
    Given correct url
    When user login with "nafisa@gmail.com" and "123456"


  Scenario: update user profile for Nafisa
    When user update profile
    Then veirfy status code 200

  Scenario: update expireience in user profile for Nafisa
    When user update expirence in profile
    Then veirfy status code 200

    

    Scenario: delete experince
    When user update expirence in profile
    Then delete user expirence from profile
    Then veirfy status code 200
    
         @ClassWork 
    Scenario: delete all of experience
    When user update expirence in profile
    Then delete all of user expirence from profile
    Then veirfy all of expirence been delete