Feature: Add employee detail in Pim

  @recent
  Scenario: Successful add employee details in PIM
    Given user is logged in to OrangeHRM
    When user navigates to pim field
    And user clicks on add employee
    And user enters employee First Name "Jivan"
    And user enters employee Second Name "Martin"
    And user enters employee Last Name "b"
    And user enters employee_id "1211"
    And user click on save button
    And user Navigates to employeeList option
    And user searches employee "Jivan"
    Then verify employee "Jivan Martin" and last name "b" created successfully
    