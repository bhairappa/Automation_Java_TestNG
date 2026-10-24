  Feature: Assign Leave employee selection
  
  Scenario: Verify valid employee selection
     Given user is logged in to OrangeHRM
     When user navigates to Assign Leave page
     And user enters employee name "vi"
     Then employee suggestions should be displayed
     When user selects name "Ravi M B"
     Then selected employee name should be "Ravi M B"
     
  Scenario: Verify error msg after invalid name
      Given user is logged in to OrangeHRM
      When user navigates to Assign Leave page
      And user enters employee name "vishwa"
      And user click on assign button
      Then user should be able to see invalid "Invalid" error msg
      
  Scenario: Verify error msg after empty fields
      Given user is logged in to OrangeHRM
      When user navigates to Assign Leave page   
      And user click on assign button 
      Then user should be able to see Required field error message