package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Add_CustomerPage {
	
	WebDriver ldriver;
	

public Add_CustomerPage(WebDriver rdriver) {
		
		ldriver=rdriver;
	
		PageFactory.initElements(rdriver, this);
		
	}
	
	By lnkCustomers_menu=By.xpath("//body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]/p[1]");
	By lnkCustomers_menuitem=By.xpath("//body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]/p[1]");
	
	By btnAddnew=By.xpath("//body/div[3]/div[1]/form[1]/div[1]/div[1]/a[1]/i[1]"); //Add new
		
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassword=By.xpath("//input[@id='Password']");
	
	
			
			//By.id("SelectedNewsletterSubscriptionStoreIds");
	
			
	
			//("//*[@class='k-widget k-multiselect k-multiselect-clearable'][1]/select/option[2]");
			
	By txtnewsLetter=By.xpath("//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[9]/div[2]/div[1]/div[1]/div[1]/div[1]");
	By txtcustomerRole= By.xpath("//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]");
	
	By chkbxtaxexempt =By.id("IsTaxExempt");
	
	By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
	By lstitemforummderator= By.xpath("//li[contains(text(),'Forum Moderators')]");
	
	By choosestorename= By.xpath("//li[contains(text(),'Your store name')]");
	By choosestorename1= By.xpath("//li[contains(text(),'Test store 2')]");
	
	By drpmgrOfVendor=By.xpath("//*[@id='VendorId']");
	By rdMaleGender=By.id("Gender_Male");
	By rdFeMaleGender=By.id("Gender_Female");
	
	By txtFirstName=By.xpath("//input[@id='FirstName']");
	By txtLastName=By.xpath("//input[@id='LastName']");
	
	By txtDob=By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompanyName=By.xpath("//input[@id='Company']");
		
	By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
	
	By btnSave=By.xpath("//button[@name='save']");
	
	/*@FindBy (xpath=("//button[@name='save']"))
	WebElement buttonsaving;*/
	//Action Methods
	
	public String getPageTitle() {
		
		String expected_page_title =ldriver.getTitle();
		
		return expected_page_title;
	
	}
	
	public void customers_menu() {
		
		ldriver.findElement(lnkCustomers_menu).click();
		
	}
	
	public void customer_menu_Item() {
		
	ldriver.findElement(lnkCustomers_menuitem).click();
	}
	
public void addnewcustomerbtn() {
	
	
	 ldriver.findElement(btnAddnew).click();
}

public void enterEmail(String email) {
	
	ldriver.findElement(txtEmail).sendKeys(email);
}

public void enterPassword(String password) {
	
	
	ldriver.findElement(txtPassword).sendKeys(password);
}

public void setFirstName(String fname)
{
	ldriver.findElement(txtFirstName).sendKeys(fname);

}
public void setlastName(String lname)
{
	ldriver.findElement(txtLastName).sendKeys(lname);
	

}


//setting gender
public void setGender(String gender) {
	
	if (gender.equals("Male")) {
		
		ldriver.findElement(rdMaleGender).click();
	}
	
	else if (gender.equals("Female")) {
		
		ldriver.findElement(rdFeMaleGender).click();
		
	}
	
	else {
		
		ldriver.findElement(rdMaleGender).click(); //default option
	}
	
	
}

public void setDateobirth(String dateob) {
	
	ldriver.findElement(txtDob).sendKeys(dateob);
	
}
public void setCompName(String companyName) {
	
	ldriver.findElement(txtCompanyName).sendKeys(companyName);
}


//setting customer role
public void setcustomerrole(String role) throws InterruptedException {
	
	ldriver.findElement(txtcustomerRole).click();
	
	Thread.sleep(3000);
	
	if (role.contains("Administrators")) {
		
		ldriver.findElement(lstitemAdministrators).click();
	}
	else if (role.contains("Forum Moderators")) {
		
		
		ldriver.findElement(lstitemforummderator).click();
	}
	
	else if (role.contains("Vendors")) {
		
		ldriver.findElement(lstitemVendors).click();
		
	}
	else if (role.contains("Registered")) {
		
		ldriver.findElement(lstitemRegistered).click();
		
	}
	
	else {
		
		ldriver.findElement(lstitemGuests).click();
		
	}
	
}

public void settaxExempt() {
	ldriver.findElement(chkbxtaxexempt).click();
		
}

public void setNewsLetter(String value) throws InterruptedException {
	
ldriver.findElement(txtnewsLetter).click();


Thread.sleep(3000);

/*Actions a = new Actions(ldriver);

WebElement drp= ldriver.findElement(By.xpath("//li[contains(text(),'Test store 2')"));

a.moveToElement(drp).click().build().perform();*/


if(value.contains("Your store name")) {
	
	ldriver.findElement(By.xpath("//*[@id='SelectedNewsletterSubscriptionStoreIds_listbox']/li[1]")).click();
	
}

else if (value.contains("Test store 2"))
	
{
	ldriver.findElement(By.xpath("//*[@id='SelectedNewsletterSubscriptionStoreIds_listbox']/li[2]")).click();
	
}


//Select drp = new Select (ldriver.findElement(txtnewsLetter));
//Thread.sleep(2000);

//drp.selectByValue(value);
	
	
}

public void setManagerOfVendor(String vendorvalue) {
	
	WebElement managerofvendor= ldriver.findElement(drpmgrOfVendor);
	
	Select drpdn =new Select(managerofvendor);
	
	drpdn.selectByValue(vendorvalue);
	
}

public void setAdmincomment(String comment) {
	
	ldriver.findElement(txtAdminContent).sendKeys(comment);
	
}

public void clickBtnSave() {
	
	
	ldriver.findElement(btnSave).click();
}

}
