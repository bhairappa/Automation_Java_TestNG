Feature: Dashboard content visible

  Scenario: Successful dashboard heading verification
    Given user is logged in to OrangeHRM
    Then Dashboard heading should be displayed
    And actual url should match the expected url
    And dashboard widgets are displayed
    And actual names should match the expected names in assign leave