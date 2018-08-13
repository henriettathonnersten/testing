package com.qa.quickstart;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;


public class TheDemoSite {

	static WebDriver myDriver;
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
	}
	
	@Before
	public void setup()	{
		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
	}
	
	@Test 
	public void createUser() {
		myDriver.get("http://thedemosite.co.uk/savedata.php");
		WebElement userBox = myDriver.findElement(By.name("username"));
		WebElement passwBox = myDriver.findElement(By.name("password"));
		WebElement saveButton = myDriver.findElement(By.name("FormsButton2"));
		userBox.sendKeys(Keys.chord("AAAA"));
		passwBox.sendKeys(Keys.chord("1111"));
		saveButton.submit();
		checkUser();
		
	}
	
	//@Test 
	public void checkUser() {
		myDriver.get("http://thedemosite.co.uk/login.php");
		WebElement userBox = myDriver.findElement(By.name("username"));
		WebElement passwBox = myDriver.findElement(By.name("password"));
		WebElement saveButton = myDriver.findElement(By.name("FormsButton2"));
		userBox.sendKeys(Keys.chord("AAAA"));
		passwBox.sendKeys(Keys.chord("1111"));
		saveButton.submit();
		WebElement output = myDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));
		assertEquals("Output is not what is expected", "**Successful Login**", output.getText());
	}
	
	@After
	public void close() {
		myDriver.close();
	}
}
