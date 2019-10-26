Feature: Amazon Search
  This feature file is for validate search functionality

  Background: 
    Given user in the Homapage

  @regression @search
  Scenario: Validate search functionality
    When user type "test" in the searchBox
    Then user should able to land on search result page
    Then End the test
@search
  Scenario Outline: validate search term
    When user type "<search>" in the searchBox
    Then user should able to land on search result page
    And search result should match "<result>"
    Then End the test

    Examples: 
      | search | result  |
      | camera | 100,000 |
      | Toy    | 200,000 |
      | Laptop |  10,000 |
