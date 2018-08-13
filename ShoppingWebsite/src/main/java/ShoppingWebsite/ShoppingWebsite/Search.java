package ShoppingWebsite.ShoppingWebsite;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {
	
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
	public void search() {
		myDriver.get("http://automationpractice.com/index.php");
		WebElement searchBox = myDriver.findElement(By.id("search_query_top"));
		WebElement searchButton = myDriver.findElement(By.name("submit_search")); 
		searchBox.sendKeys("dress");
		searchButton.click();
		
		WebElement foundElement = myDriver.findElement(By.className("heading-counter"));		
		assertEquals("Output not expected", "7 results have been found.", foundElement.getText());
	}
	
	@After
	public void close() {
		myDriver.close();
	}

}
