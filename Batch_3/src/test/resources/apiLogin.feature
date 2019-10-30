Feature: Login feature for api testing

  Scenario: login user by api
    Given correct url
    When user login with "emailId" and "password"
    Then veirfy status code 400

  Scenario: login user by api by correct user info
    Given correct url
    When user login with "john.doe@gmail.com" and "123456"
    Then veirfy status code 200

    #create Scenario outline, and pass below three sets of data
    #invalid user name and password      ->400
    #valid user name and invaid password ->400
    #valid user name and valid password  ->200