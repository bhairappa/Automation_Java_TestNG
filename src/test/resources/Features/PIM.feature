Feature: Add employee detail in Pim

  @Priority1 @recent
  Scenario: Successful add employee details in PIM
    Given user is logged in to OrangeHRM
    When user navigates to pim field
    And user clicks on add employee
    And user enters employee First Name "Jivan"
    And user enters employee Second Name "Martin"
    And user enters employee Last Name "b"
    And user enters employee_id "1214"
    And user click on save button
    Then add employee success msg displayed
    And user Navigates to employeeList option
    And user searches employee "Jivan"
    And user scroll the page
    Then verify employee "Jivan" and employee_id "1214" created successfully
    
@Priority2 @recent
Scenario: Successful error msg display for repeated employee
    Given user is logged in to OrangeHRM
    When user navigates to pim field
    And user clicks on add employee
    And user enters employee First Name "Jivan"
    And user enters employee Second Name "Martin"
    And user enters employee Last Name "b"
    And user enters employee_id "1214"
    Then verify employeeId exist error msg

@Priority3 @recent
Scenario: Successful error msg display for repeated employee
    Given user is logged in to OrangeHRM
    When user navigates to pim field
    And user clicks on add employee
    And user enters employee_id "122"
    And user click on save button
    Then required error messages should be displayed
