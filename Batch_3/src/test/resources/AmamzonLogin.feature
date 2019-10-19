#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: AmazonLogin
  Test login functionality in the Amamzon

  Background: 
    Given user in the Homapage

  @smoke
  Scenario: Bora_1 Verify login
    When user click on SignIn button
    Then SignIn page display
    And email address textbox display
    Then End the test

  @regression
  Scenario: Bora_2 Verify wrong password
    When user click on SignIn button
    Then SignIn page display
    And enter email "Ahmed@gmail.com"
    And enter password "Test1234"
    Then End the test

  @regression
  Scenario: Bora_2 Verify correct password
    When user click on SignIn button
    Then SignIn page display
    And enter email "Ahmed@gmail.com"
    And enter password "TEST1234"
    Then End the test
    
  @testDemo
  Scenario Outline: Bora_2 Verify wrong infomation
    When user click on SignIn button
    Then SignIn page display
    And enter email "<emailAddress>"
    And enter password "<password>"
    Then End the test

    Examples: 
      | emailAddress    | password |
      | ahmed           | Test1234 |
      | Ahmed@gmail.com |     1234 |
      | ahmed           |     1234 |
