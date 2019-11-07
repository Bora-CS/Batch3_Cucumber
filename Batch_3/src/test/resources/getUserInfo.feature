Feature: get user infomation

  Background: 
    Given correct url

  Scenario Outline: get user info
    When user login with name "<email>" and password "<password>"
    Then verify user infomation

    Examples: 
      | email              | password |
      | john.doe@gmail.com |   123456 |
