Feature: Login_nop_ecommerce


@SanityTest
  Scenario: Succesful Login with Valid Credentials
    Given User launches Chrome Browser
    And User opens the URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    When User enters valid email as "admin@yourstore.com" and password as "admin"
    And clicks login button
    Then validate the page title is "Dashboard / nopCommerce administration"
    And user clicks on Logout button
    Then validate page title is "Your store. Login"
    And close browser

    @Regression @prod
  	Scenario Outline: Succesful Login with Valid Credentials multiple data through Datadriven
    Given User launches Chrome Browser
    And User opens the URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    When User enters valid email as "<emailID>" and password as "<password>"
    And clicks login button
    Then validate the page title is "Dashboard / nopCommerce administration"
    And user clicks on Logout button
    Then validate page title is "Your store. Login"
    And close browser
    
    
    Examples:
    |emailID							|password	|
    |admin@yourstore.com	|admin		|
    |admin@yourstore.com	|admin123	|