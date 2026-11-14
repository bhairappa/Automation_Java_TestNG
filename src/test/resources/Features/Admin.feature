Feature: Admin employee section
  
@recent
  Scenario: Verify user click on Adminpage
  Given user is logged in to OrangeHRM
  When user clicks on admin button
  Then user should navigate to admin page
  

@recent
  Scenario: Add admin user name
  Given user is logged in to OrangeHRM
  When user enters the user name
  When user click on dropdown and selects admin
  when user click on status drop down and selects enabled
  When user click on search button
  Then user should be able to see admin user name

  