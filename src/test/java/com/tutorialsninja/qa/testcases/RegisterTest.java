package com.tutorialsninja.qa.testcases;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.base.Base;
import com.tutorialninja.qa.utils.Utilities;

public class RegisterTest extends Base{
	/*String firstname = "Varsha";
	String lastname = "Kolhe";
	String emailaddress = "khiradevarsha27@gmail.com";
	String telephone = "9855223366";
	String password = "qwer1234";*/
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = initializeBrewserAndOpenApplicationURL();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
	}
	
	@AfterMethod
	public void closure() {
		driver.quit();
	}

	
	@Test(dataProvider="getTestData",dataProviderClass=Provider.class)
	
	public void verifyRegisterTestCase(String firstname, String lastname, String emailaddress, String password, String telephone) throws InterruptedException 
	{
		
		driver.findElement(By.id("input-firstname")).sendKeys(firstname);
		driver.findElement(By.id("input-lastname")).sendKeys(lastname);
		driver.findElement(By.id("input-email")).sendKeys(emailaddress);
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.id("input-confirm")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();	
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		Thread.sleep(2000);
		String actualSuccessHeading = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		Assert.assertEquals(actualSuccessHeading,"Your Account Has Been Created!", "Account Success page is not displayed");
	}
	
	@Test
	
		
		
		public void verifyRegisteringAccountByprovidingAllFields() {
			
		
		driver.findElement(By.id("input-firstname")).sendKeys("qwer");
		driver.findElement(By.id("input-lastname")).sendKeys("tyui");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("9898985656");
		driver.findElement(By.id("input-password")).sendKeys("qwer1234");
		driver.findElement(By.id("input-confirm")).sendKeys("qwer1234");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();	
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		
		driver.quit();
		}
	/*
	@Test
	
	
	public void verifyRegisteringAccountWithExistingEmailAddress() {
		
		WebDriver driver;
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("qwer");
		driver.findElement(By.id("input-lastname")).sendKeys("tyui");
		driver.findElement(By.id("input-email")).sendKeys("tyuiop2121@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("9898985656");
		driver.findElement(By.id("input-password")).sendKeys("qwer1234");
		driver.findElement(By.id("input-confirm")).sendKeys("qwer1234");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();	
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		
		String actualWarning = driver.findElement(By.xpath("/html/body/div[2]/div[1]/text()")).getText();
		Assert.assertTrue(actualWarning.contains("Warning:E-Mail Address is already registered!"), "Warning message  is not displayed");
		
		driver.quit();
	
	}
	*/
	@Test
	
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		String actualPrivacyPolicyWarning = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText();
		Assert.assertTrue(actualPrivacyPolicyWarning.contains("Warning: You must agree to the Privacy Policy!"),"Warning message not displayed");
		
		String actualFirstNameWarning = driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).getText();
		Assert.assertTrue(actualFirstNameWarning.contains("First Name must be between 1 and 32 characters!"),"First Name Warning Message not displayed");
		
		String actualLastNameWarning = driver.findElement(By.xpath("//*[@id=\"account\"]/div[3]/div/div")).getText();
		Assert.assertTrue(actualLastNameWarning.contains("Last Name must be between 1 and 32 characters!"),"Last Name Warning Message not displayed");
		
		String actualEmailWarning = driver.findElement(By.xpath("//*[@id=\"account\"]/div[4]/div/div")).getText();
		Assert.assertTrue(actualEmailWarning.contains("E-Mail Address does not appear to be valid!"),"Email Warning Message not displayed");
		
		String actualTelephoneWarning = driver.findElement(By.xpath("//*[@id=\"account\"]/div[5]/div/div")).getText();
		Assert.assertTrue(actualTelephoneWarning.contains("Telephone must be between 3 and 32 characters!"),"Tele Warning Message not displayed");
		
		String actualPasswordWarning = driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")).getText();
		Assert.assertTrue(actualPasswordWarning.contains("Password must be between 4 and 20 characters!"),"Password Warning Message not displayed");
		
		driver.quit();
	}
	
	
	
	

}
