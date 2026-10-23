Feature: Dashboard content visible

  Scenario: Successful dashboard heading verification
    Given user is logged in to OrangeHRM
    Then Dashboard heading should be displayed
    Then actual url should match the expected url
    Then dashboard widgets are displayed
    Then actual names should match the expected names in assign leave
    
  Scenario: Verify valid employee selection
     Given user is logged in to OrangeHRM
     When user navigates to Assign Leave page
     And user enters employee name "vi"
     Then employee suggestions should be displayed
     When user selects name "Ravi M B"
     Then selected employee name should be "Ravi M B"
   
     
     