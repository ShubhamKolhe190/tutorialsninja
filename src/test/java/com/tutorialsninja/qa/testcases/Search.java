package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialninja.qa.base.*;

public class Search extends Base{
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		driver = initializeBrewserAndOpenApplicationURL ();
		
	}
	
	@AfterMethod
	public void closure() {
		driver.quit();
	}
	
	@Test
	public void verifySearchWithValidProductName() {
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("HP");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		
		String actualProductMeetingMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).getText();
		Assert.assertEquals(actualProductMeetingMessage,"Products meeting the search criteria","No message is displayed");
	}

	@Test
	
	public void verifySearchWithInvalidProductName() {
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("qwer");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		
		String actualProductNotMeetingMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).getText();
		Assert.assertEquals(actualProductNotMeetingMessage,"There is no product that matches the search criteria.","No message is displayed");
	}
	
@Test
	
	public void verifySearchWithoutProductName() {
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("qwer");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		
		String actualNoProductMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).getText();
		Assert.assertEquals(actualNoProductMessage,"There is no product that matches the search criteria.","No message is displayed");
	}
}
