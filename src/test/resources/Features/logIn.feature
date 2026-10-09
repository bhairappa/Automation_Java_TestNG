Feature: OrangeHRM Login

  Scenario: Successful login with valid credentials

    Given user is on the OrangeHRM login page
    When user enters valid username and password
    And user clicks on login button
    Then OrangeHRM Dashboard should be displayed
    
     Scenario: login with invalid credentials
     
     Given user is on the  OrangeHRM login page
     When user  enters invalid username and passwovd
     And  user clocks on login button
     Then user should see error msg 
     
     Scenario: login with empty fields
     
     Given user is on the OrangeHRM login page
     When user enters empty fields
     And user clicks on login button
     Then user should see required as error msg
    