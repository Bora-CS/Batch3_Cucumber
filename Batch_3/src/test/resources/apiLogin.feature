Feature: Login feature for api testing

  Background: 
    Given correct url

  Scenario: login user by api
    When user login with "emailId" and "password"
    Then veirfy status code 400

  Scenario: login user by api by correct user info
    When user login with "john.doe@gmail.com" and "123456"
    Then veirfy status code 200

  #create Scenario outline, and pass below three sets of data
  #invalid user name and password      ->404
  #valid user name and invaid password ->400
  #valid user name and valid password  ->200
  Scenario Outline: login user by api by correct user info
    When user login with "<email>" and "<password>"
    Then veirfy status code <statusCode>

    Examples: 
      | email              | password | statusCode |
      | invalid@gmail.com  |      234 |        404 |
      | john.doe@gmail.com |      123 |        400 |
      | john.doe@gmail.com |   123456 |        200 |

  @inClass
  Scenario: register user by api call
    When register user by "Nafisa" "nafisa4@gmail.com" "123456" "123456"
    Then veirfy status code 400
  #  And verify name "Nafisa" and email "nafisa@gmail.com" is correct

  @inClass
  Scenario Outline: register user by api call
    When register user by "<name>" "<email>" "<password>" "<password2>"
    Then veirfy status code <statusCode>
   # And verify name "<name>" and email "<email>" is correct

    Examples: 
      | name   | email             | password | password2 | statusCode |
      | Nafisa | nafisa4@gmail.com |   123456 |    123456 |        400 |
      | Nafisa | nafisa4@gmail.com |   123456 |    123456 |        400 |
      | Nafisa | nafisa4@gmail.com |   123456 |    123456 |        400 |
      | Nafisa | nafisa4@gmail.com |   123456 |    123456 |        400 |
      | Nafisa | nafisa4@gmail.com |   123456 |    123456 |        400 |
      | Nafisa | nafisa4@gmail.com |   123456 |    123456 |        400 |
      | Nafisa | nafisa4@gmail.com |   123456 |    123456 |        400 |      
      | Nafisa | nafisa4@gmail.com |   123456 |    123456 |        400 |
                                          
      
      
      
      
      
      
      
      
