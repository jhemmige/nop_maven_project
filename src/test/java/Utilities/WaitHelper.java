package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	
	WebDriver driver;
	
	public WaitHelper(WebDriver driver) {
	
	this.driver= driver;	
	
		
	}
	
	
	public void waitforElement(WebElement element, long TimeOutInSeconds) {
	
	WebDriverWait wait = new WebDriverWait(driver,TimeOutInSeconds);
	
	wait.until(ExpectedConditions.visibilityOf(element));

}
}