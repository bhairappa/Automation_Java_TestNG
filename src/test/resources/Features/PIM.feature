Feature: Add employee detail in Pim

  Scenario: Successful add employee details in PIM
    Given user is logged in to OrangeHRM
    When user navigates to pim field
    And user clicks on add employee
    And user enters employee First Name "John"
    And user enters employee Second Name "Martin"
    And user enters employee Last Name "Bankapur"
    And user enters employee_id "121"
    And user click on save button
    Then employee name should be added
    
    