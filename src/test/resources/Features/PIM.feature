Feature: Add employee detail in Pim

  @Priority1
  Scenario Outline: Successful add employee details in PIM
    Given user is logged in to OrangeHRM
    When user navigates to pim field
    And user clicks on add employee
    And user enters employee First Name "<firstName>"
    And user enters employee Second Name "<middleName>"
    And user enters employee Last Name "<lastName>"
    And user enters employee_id "<employeeId>"
    And user click on save button
    Then add employee success msg displayed
    When user Navigates to employeeList option
    And user searches employee "<firstName>"
    And user scroll the page
    Then verify employee "<firstName>" and employee_id "<employeeId>" created successfully

    Examples:
      | firstName | middleName | lastName | employeeId |
      | Jivan     | Martin     | b        | 1225       |

  @Priority2
  Scenario: Successful error msg display for repeated employee
    Given user is logged in to OrangeHRM
    When user navigates to pim field
    And user clicks on add employee
    And user enters employee First Name "Jivan"
    And user enters employee Second Name "Martin"
    And user enters employee Last Name "b"
    And user enters employee_id "1225"
    Then verify employeeId exist error msg

  @Priority3
  Scenario: Successful error msg display for empty required employee fields
    Given user is logged in to OrangeHRM
    When user navigates to pim field
    And user clicks on add employee
    And user enters employee_id "122"
    And user click on save button
    Then required error messages should be displayed