package mytest1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Program1 
{
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Files\\driver\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://staging.paletteu.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	/*
	@Test
	public void verifyTitle()
	{
		String actualTitle = driver.getTitle();
		String expectedTitle = "PaletteEDU";
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	*/
	
	@Test
	public void Login()
	{
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("rosepage@getnada.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Password@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "PaletteEDU";
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterMethod
	public void terminate()
	{
		driver.quit();
		
	}
	

}
