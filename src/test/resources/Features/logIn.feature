Feature: OrangeHRM Login

  Scenario: Successful login with valid credentials

    Given user is on the OrangeHRM login page
    When user enters valid username and password
    And user clicks on login button
    Then OrangeHRM Dashboard should be displayed
    
  Scenario: login with invalid credentials
        
    Given user is on the OrangeHRM login page
    When user enters invalid username and password
    And user clicks on login button
    Then user should see error msg
    
  Scenario: login with empty credentials
        
    Given user is on the OrangeHRM login page
    When user keeps the username and password fields empty
    And user clicks on login button
    Then user should see error msg as required
    
    
     
    