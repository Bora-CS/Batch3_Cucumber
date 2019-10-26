Feature: Title of your feature
  I want to use this template for my feature file

  Background: 
    Given user in the Homapage

  @plp
  Scenario: validate PLP sort functionality
    When user type "camera" in the searchBox
    Then user should able to land on search result page
    And verify sort functionality by "lowToHigh"
    Then End the test

  @regression @plp @testDemo
  Scenario: validate PLP sort functionality by High to Low
    When user type "camera" in the searchBox
    Then user should able to land on search result page
    And verify sort functionality by "hightoLow"
    Then End the test
