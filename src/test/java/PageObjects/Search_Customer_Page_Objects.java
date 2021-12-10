package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;
import stepDefinitions.BaseClass;

public class Search_Customer_Page_Objects extends BaseClass{
	
	WebDriver ldriver;
	WaitHelper wait;
	
	public Search_Customer_Page_Objects(WebDriver rdriver) {
		
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
		
		 wait = new WaitHelper(ldriver);
	}
	
	@FindBy(id="SearchEmail")
	WebElement emailIDinput;
	
	
	@FindBy(id="SearchFirstName")
	WebElement firstNameinput;
	
	@FindBy(id="SearchLastName")
	WebElement lastNameinput;
	
	@FindBy (name="SearchMonthOfBirth")
	WebElement DOBMonthselectoption;
	
	@FindBy (name="SearchDayOfBirth")
	WebElement DOBDayselectoption;
	
	@FindBy(id="SearchCompany")
	WebElement companyInput;
	
	@FindBy(id="SearchIpAddress")
	WebElement IPaddressInput;
	
	@FindBy(xpath="//div[@class='k-widget k-multiselect k-multiselect-clearable']/div/ul/li/span[2]")
	WebElement CustomerRoledelete;
	
	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap']")
	WebElement CustomerRoleInput;
	
	@FindBy(xpath="//div[@class='dataTables_wrapper dt-bootstrap4 no-footer']")
	WebElement customerTable;
	
	@FindBy(xpath="//div[@class='dataTables_scrollBody']/table/tbody/tr/td[2]")
	List<WebElement> EmailReturn;
	
	
	@FindBy(xpath="//div[@id='customers-grid_wrapper']/div/div/div/div/div/table/thead/tr/th[2]") //email xpath
	WebElement EmailHeaderTable;
	
	@FindBy(xpath="//th[contains(text(),'Name')]")
	WebElement nameheader;
	
	@FindBy(xpath="//div[@class='dataTables_scrollBody']/table/tbody/tr/td[3]")
	List<WebElement> nameReturn;
	
	@FindBy(id="search-customers")
	
	WebElement clickSearch;
	
	
	public void setEmail(String email) {
		
		emailIDinput.clear();
		emailIDinput.click();
		emailIDinput.sendKeys(email);
		
	}
	
	
	
	public void setDateOfBirth() {
		
		
	}
	
	
	public void setCompany() {
		
		
		
	}
	
	
	public void setIPaddress() {
		
		
		
	}
	
	public void setCustomerRole() {
		
		
		
	}
	
	public void clickSearchBtn() {
		
		
		clickSearch.click();
		
		wait.waitforElement(customerTable,30);
		
	}
	
	
	public void setFirstName(String firstName) {
		
		wait.waitforElement(firstNameinput, 20);
		firstNameinput.clear();
		firstNameinput.sendKeys(firstName);
		
		
	}
	
public void setLastName(String lastName) {
	
	wait.waitforElement(lastNameinput, 20);
		
	lastNameinput.clear();
	lastNameinput.sendKeys(lastName);
		
		
	}
	
	
	public boolean emailValidation(String email) {
		
		
		
	//List <WebElement> webele = EmailReturn;
	
	boolean flag= false;
	
	for(WebElement emailID:EmailReturn) {
		
	String emailObtained=emailID.getText();
	
	if (emailObtained.equals(email)) {
		
		
	flag= true;
		
		
	}
	
	}
	
	return flag;
	
		
	}
	
	
	Boolean flag=false;
	
	public Boolean nameValidation(String name) {
		
		
		List<WebElement> Webele= nameReturn;
		
		
		for (WebElement ele:Webele) {
			
		String returnEdName= ele.getText();
			
			if (returnEdName.equals(name)) {
				
				
				flag=true;
			}
			
		}
		
		return flag;
		
	}
	
	
	
	
	

}
