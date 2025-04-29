package com.tutorialsninja.qa.testcases;
import java.util.Date;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import java.util.Properties;
import com.tutorialninja.qa.base.Base;
import com.tutorialninja.qa.utils.Utilities;


public class LoginTest extends Base{
	
	public LoginTest() {
		super();
	}
	
//	String validemailaddress = "shubhamkolhe190@gmail.com";
//	String validpassword = "alliswell11";
//	String invalidemailaddress = "xyz@hmail.com";
//	String invalidpassword = "qwer1234";
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		
		driver = initializeBrewserAndOpenApplicationURL();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.linkText("Login")).click();
	}
	@AfterMethod
	public void closure() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	@Test (priority=1,dataProvider="validCredentialsSupplier")
	
	public void verifyLoginWithValidCredentials(String emailaddress, String password) {
	
		
		driver.findElement(By.id("input-email")).sendKeys(emailaddress);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"Edit your account information is not displayed");
		

	}
	@DataProvider (name="validCredentialsSupplier")
public Object[][] supplyTestData() {
	
		Object[] [] data =  Utilities.getTestDataFromExcel("login");
		return data;
	}
	
	@Test
	
	public void verifyLoginWithInvalidCredentials() throws InterruptedException {
		
		
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage =dataProp.getProperty("expectedWarningMessage");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is dsiplayed");
	    
		

	}
	@Test
		
		public void verifyLoginWithInvalidPassword() throws InterruptedException
		{
		
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validemailaddress"));
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is dsiplayed");
	    
		
		}
		
	@Test
		
		public void verifyLoginWithInvalidemailaddress() throws InterruptedException
		{
		
		driver.findElement(By.id("input-email")).sendKeys(dataProp.getProperty("invalidemail"));
		Thread.sleep(5000);
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validpassword"));
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is dsiplayed");
	    
		
		}
		
	@Test
		
		public void verifyLoginWithoutEmailAndPassword()
		{
		
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage = "Warning: No match for E-Mail and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is dsiplayed");
	    
	
	}
		
}
	  
		

