package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelp2 {
	
	
	public void WaitforElement(WebDriver driver,WebElement element,Long TimeInSeconds) {
		
		
	
	WebDriverWait wait = new WebDriverWait(driver, TimeInSeconds );	
		
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
