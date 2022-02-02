package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.Add_CustomerPage;
import PageObjects.Login_Page_Objects;
import PageObjects.Search_Customer_Page_Objects;

public class BaseClass {

	public WebDriver driver;
	public Login_Page_Objects lpo;
	public Add_CustomerPage addCust;
	public Search_Customer_Page_Objects spo;
	// public String random1Email;
	public static Logger logger;
	public static Properties prop;

	// this method helps in creating random strings
	/*
	 * public static String getGtrandomstring(String randomEmail) {
	 * 
	 * String randomEmail1 = "why??"; //RandomStringUtils.//randomAlphabetic(6);
	 * 
	 * return randomEmail; }
	 */

	public static String getRandomEmail() {

		String randomEmail = RandomStringUtils.randomAlphabetic(6);

		return randomEmail;

	}

}
