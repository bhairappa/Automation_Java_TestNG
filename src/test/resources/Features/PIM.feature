Feature: Add employee detail in Pim

  Scenario: Successful add employee details in PIM
    Given user is logged in to OrangeHRM
    When user navigates to pim field
    And user enters employee First Name 
    And user enters employee Second Name
    And user enters employee Last Name
    And user enters employee_id 
    And user click on save button
    Then employee name should be added
    
    