package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;

public class Login_Page_Objects {
	
	public WebDriver ldriver;
	WaitHelper wait;
	
	
	//creating constructor
	public Login_Page_Objects (WebDriver rdriver) {
		
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
		
		wait= new WaitHelper(ldriver);
			
	}
	
	// page elements 
	@FindBy(xpath="//input[@id='Email']")
	WebElement EmailID;
	
	@FindBy (xpath="//input[@id='Password']")
	WebElement Password;
	
	@FindBy (xpath="//input[@id='RememberMe']")
	WebElement Rememberme;
	
	@FindBy (xpath="//button[contains(text(),'Log in')]")
	WebElement Buttonlogin;
	
	@FindBy(linkText="Logout" )
	
	WebElement logoutBtn;
	
	
	
	
//creating actionable methods for the elements
	
	//takes emailID as parameter
	
	public void loginwithemailID(String emailID) {
		
		EmailID.clear();
		
		EmailID.sendKeys(emailID);
		
		
	}
	
	//takes password as parameter
	public void enterPassword(String password) {
		
		Password.clear();
		
		Password.sendKeys(password);
		
	
	}
	
	
	public void checkRememberme() {
		
		Rememberme.click();
		
		
	}
	
	
	public void loginButtonclick() {
	
		Buttonlogin.click();
		//wait.waitforElement(logoutBtn, 30);
		
		
		
	
	}
	
	
	public void logoutButton() {
	
	
	logoutBtn.click();
	
}
	
	
	
	
	
	

}
