package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import PageObjects.Add_CustomerPage;
import PageObjects.Login_Page_Objects;
import PageObjects.Search_Customer_Page_Objects;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

//OR

/*import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;*/

//Loggin in
public class Steps extends BaseClass{
	
	@Before
	public void before_browserSetup() throws IOException {
		
		logger=Logger.getLogger("Nop_commerce project");//for adding logs
		PropertyConfigurator.configure("log4j.properties");// for adding logs
		
		prop = new Properties();
		
		FileInputStream fis= new FileInputStream("Config.properties");
		
		prop.load(fis);
		
		String br=prop.getProperty("Browser");
		
		
		if(br.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromePath"));
		driver= new ChromeDriver();
			
		
	}
	
	else if (br.equals("firefox")) {
		
		prop.getProperty("webdriver.gecko.driver",prop.getProperty("FirefoxPath"));	
		
		driver= new FirefoxDriver();
		
	}
		
	else if 
	(br.equals("InternetExplorer")){
		
		
		prop.getProperty("webdriver.ie.driver",prop.getProperty("InternetExplorerPath"));	
		
		driver= new InternetExplorerDriver();
		
	}
		
	}
	
	
	
	@Given("User launches Chrome Browser")
	public void user_launches_chrome_browser() {
		
		logger=Logger.getLogger("Nop_commerce project");//for adding logs
		PropertyConfigurator.configure("log4j.properties");// for adding logs
		
		//System.setProperty("webdriver.chrome.driver","/Users/jayashreehemmige/Documents/drivers/chromedriver");
		//driver= new ChromeDriver();
		
		logger.info("**********************************launching browser*********************************************");
		lpo= new Login_Page_Objects(driver);
		
		System.out.println("PRINTING THIS MSG TO SEE IT THIS SHOWSUP");
	    
	}

	@Given("User opens the URL {string}")
	public void user_opens_the_url(String url) {
		
		logger.info("**********************************Opens URL*********************************************");
	 driver.get(url);
	 
	 
	}

	@When("User enters valid email as {string} and password as {string}")
	public void user_enters_valid_email_as_and_password_as(String emailID, String password) {
	 
		lpo.loginwithemailID(emailID);
		lpo.enterPassword(password);
		
		System.out.println("PRINTING THIS MSG TO SEE IT THIS SHOWSUP123");
	}

	@When("clicks login button")
	public void clicks_login_button() {
	logger.info("**********************************Login Process happening *********************************************");
		lpo.checkRememberme();
		lpo.loginButtonclick();
		
		driver.manage().window().maximize();
	    
	}

	@Then("validate the page title is {string}")
	public void validate_the_page_title_is(String expected_loginpage_title) {
	
	logger.info("**********************************Page Title Validated *********************************************");	
	String log_in_page_title= driver.getTitle();
	Assert.assertEquals(expected_loginpage_title,log_in_page_title);
	
		
	}
	   
	

	@Then("user clicks on Logout button")
	public void user_clicks_on_logout_button() throws InterruptedException {
		logger.info("**********************************Application Logout*********************************************");	
		lpo.logoutButton();
		Thread.sleep(3000);
	    
	}

	@Then("validate page title is {string}")
	public void validate_page_title_is(String actual_homepage_title) {
		
		String expected_home_page_title=driver.getTitle();
		actual_homepage_title="Your store. Login";
		
		Assert.assertEquals(expected_home_page_title, actual_homepage_title);
		/**if (driver.getPageSource().contains("Login was unsuccessful.")) {
		
		driver.close();
		
		Assert.assertTrue(false);
		logger.info("**********************************Login Failed *********************************************");
		
		}
	
		
		else
			
		{
			logger.info("**********************************Login Passed*********************************************");
			
			Assert.assertEquals(expected_home_page_title, actual_homepage_title);
			
		}*/
		
		
		
		
		
	}
	
	@Then("close browser")
	public void close_browser() {
		logger.info("**********************************closed browser*********************************************");
		driver.close();
	   
	}
	
	//****Adding new customer steps------------------------------------
	
	@Then("User able to view Customer Dashboard")
	public void user_able_to_view_customer_dashboard() throws InterruptedException {
		
		addCust= new Add_CustomerPage(driver);
		
	String expected_home_page_title =addCust.getPageTitle();
		
		String actual_homepage_title=driver.getTitle();
		
		Assert.assertEquals(expected_home_page_title, actual_homepage_title);
	   
		Thread.sleep(3000);
	}

	@Then("User clicks on Customers menu on left navigation panel")
	public void user_clicks_on_customers_menu_on_left_navigation_panel() {
		addCust.customers_menu();
		
	}

	@Then("User clicks on Customers menu item on the dropdown")
	public void user_clicks_on_customers_menu_item_on_the_dropdown() throws InterruptedException {
		addCust.customer_menu_Item();
		Thread.sleep(3000);
	}

	@Then("click on Add New button")
	public void click_on_add_new_button() throws InterruptedException {
		addCust.addnewcustomerbtn();
		Thread.sleep(2000);
	}

	@Then("User able to see Add new customer page")
	public void user_able_to_see_add_new_customer_page() {
		
		logger.info("**********************************Adding new customer*********************************************");
	String pgTitle=   driver.getTitle();
	String expectedTitle= "Add a new customer / nopCommerce administration";
	
	Assert.assertEquals(expectedTitle, pgTitle);
		
		
	}

	@When("User enters customer information")
	public void user_enters_customer_information() throws InterruptedException {
		
		logger.info("**********************************providing customer detailsL*********************************************");
		addCust.enterEmail(getRandomEmail()+ "@gmail.com");
		addCust.enterPassword("asdf123$");
		addCust.setFirstName("John");
		addCust.setlastName("Revolta");
		addCust.setGender("Female");
		addCust.setDateobirth("12/01/1950");
		addCust.setCompName("SmartSoftSolutions");
		addCust.settaxExempt();
		Thread.sleep(2000);
		addCust.setNewsLetter("Test store 2");
		addCust.setcustomerrole("Vendors");
		Thread.sleep(2000);
		addCust.setManagerOfVendor("2");
		addCust.setAdmincomment("what's up yo!");
	    
	}

	@When("User clicks on Save button")
	public void user_clicks_on_save_button() throws InterruptedException {
		
		addCust.clickBtnSave();
		Thread.sleep(3000);
	    
	}

	@Then("User is able to see validation message {string}")
	public void user_is_able_to_see_validation_message(String Actualmsg) {
		
		String expectedmsg1 = "The Customer has been added successfully";
		
		
		Assert.assertEquals(expectedmsg1, expectedmsg1);
	    
	}
	//searching the customers
	@When("user clicks on EmailID field and passes a valid {string}")
	public void user_clicks_on_email_id_field_and_passes_a_valid(String string) {
		
		//random1Email=getRandomEmail()+ "@gmail.com";
	    
		spo = new Search_Customer_Page_Objects(driver);
		
		spo.setEmail("arthur_holmes@nopCommerce.com");
		
	}

	@When("clicks on Search button")
	public void clicks_on_search_button() {
	   spo.clickSearchBtn();
	}

	@Then("User should be able to see the email in the search results")
	public void user_should_be_able_to_see_the_email_in_the_search_results() {
		logger.info("**********************************Searching Customer with email*********************************************");
	    
	boolean validemail=	spo.emailValidation("arthur_holmes@nopCommerce.com");
		
		//String expected_email ="arthur_holmes@nopCommerce.com";
		//String actual_email ="arthur_holmes@nopCommerce.com";
		
		//Assert.assertEquals(expected_email, actual_email);
		
		Assert.assertEquals(true, validemail);
		
	}
	//search using first name and lastname
		@When("user clicks on firstname field  and passes a first name")
		public void user_clicks_on_firstname_field_and_passes_a_first_name() {
			logger.info("**********************************Inserted first name *********************************************");
			
			spo= new Search_Customer_Page_Objects(driver);
		   
			spo.setFirstName("Arthur");
		}

		@When("user clicks on lastname field and passes a last name")
		public void user_clicks_on_lastname_field_and_passes_a_last_name() {
			logger.info("**********************************Inserted last name *********************************************");
		    spo.setLastName("Holmes");
		}
		
		@Then("User should be able to see the name in the search results")
		public void user_should_be_able_to_see_the_name_in_the_search_results() {
		  
		Boolean nameVal=spo.nameValidation("Arthur Holmes");//this is the name that'll be returned on SearchCustomerpageObject

		Assert.assertEquals(true, nameVal);
			
			
			
		}

		
	


}
