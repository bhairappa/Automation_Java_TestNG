Feature: Admin employee section
  
@recent
  Scenario: Verify user click on Adminpage
  Given user is logged in to OrangeHRM
  When user clicks on admin button
  Then user should navigate to admin page
  
  