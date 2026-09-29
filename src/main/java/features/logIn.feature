Feature: OrangeHRM Login

  Scenario: Successful login with valid credentials

    Given user is on the OrangeHRM login page
    When user enters valid username and password
    And user clicks on login button
    Then OrangeHRM dashboard should be displayed
    
    