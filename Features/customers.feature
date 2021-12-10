Feature: Adding Customer

Background:
	Given User launches Chrome Browser
  And User opens the URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
  When User enters valid email as "admin@yourstore.com" and password as "admin"
  And clicks login button
  Then User able to view Customer Dashboard

  
  Scenario: Successful creation of new customer

  And User clicks on Customers menu on left navigation panel
  And User clicks on Customers menu item on the dropdown
  And click on Add New button
  Then User able to see Add new customer page
  When User enters customer information
  And User clicks on Save button
  Then User is able to see validation message "The Customer has been added successfully"
  And close browser
     
 
  Scenario: Searching for customer -Validating if search functionality works
  
    And User clicks on Customers menu on left navigation panel
    And User clicks on Customers menu item on the dropdown
    When user clicks on EmailID field and passes a valid "<email>"
    And clicks on Search button
    Then User should be able to see the email in the search results
    And close browser
    
   Scenario: Searching for customer using FistName and LastName -Validating if search functionality works
   
    And User clicks on Customers menu on left navigation panel
    And User clicks on Customers menu item on the dropdown
    When user clicks on firstname field  and passes a first name
    And user clicks on lastname field and passes a last name
    And clicks on Search button
    Then User should be able to see the name in the search results
    And close browser