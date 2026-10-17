Feature: Dashboard content visible

  Scenario: Successful dashboard heading verification
    Given user is logged in to OrangeHRM
    Then Dashboard heading should be displayed
    Then actual url should match the expected url
    Then dashboard widgets are displayed