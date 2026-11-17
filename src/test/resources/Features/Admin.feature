Feature: Admin employee section

  @recent
  Scenario: Verify user click on Admin page
    Given user is logged in to OrangeHRM
    When user clicks on admin button
    Then user should navigate to admin page

  @recent
  Scenario Outline: Search system users by multiple filters
    Given user is logged in to OrangeHRM
    When user clicks on admin button
    And the user searches with username "<username>", role "<userRole>", and status "<status>"
    Then the results table should match the searched filter criteria

    Examples:
      | username | userRole | status  |
      | Admin    | Admin    | Enabled |