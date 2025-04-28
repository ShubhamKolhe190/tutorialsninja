package SecondShubhamKolheTrials;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialninja.qa.utils.Utilities;


public class tenantLogin {
	WebDriver driver;
	
	@DataProvider (name="validtenantCredentialsSupplier")
	public Object[][] supplyTenantloginData() {
		
			Object[] [] data =  Utilities.getTestDataofiTouchFromExcel("tenantlogin");
			return data;
		}
	
	
	@Test (dataProvider="validtenantCredentialsSupplier" )
	
	
	public void tenantLogin(String URL, String emailaddress, String password) throws InterruptedException {
		
		
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
			driver.get(URL);
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(emailaddress);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			promptAction.OkayPrompt(driver);
			SecondShubhamKolheTrials.tenantVariables.getotpsusingmailinator(driver);

		}
	
		
		@Test (dataProvider="hospitaldataSupplier")
		
			
			public void hospitalCreation(String hospitalname, String hospitalcode, String hospitalemail, String hospitalphone, String hospitaladdress, 
				String hospitalcity, String hospitalstate, String hospitaldesc, String hospitalpincode, String hospitalcountry,WebDriver driver) 
		{
			
			driver.findElement(By.xpath("//*[contains(text(),\"Manage Hospital\")]")).click();
			driver.findElement(By.xpath("(//*[@type='button'])[4]")).click();
			driver.findElement(By.xpath("//input[@name='name']")).sendKeys(hospitalname);
			driver.findElement(By.xpath("//input[@name='hospitalCode']")).sendKeys(hospitalcode);
			String enteredhospitalcode=driver.findElement(By.xpath("//input[@name='hospitalCode']")).getText();
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(hospitalemail);
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(hospitalphone);
			driver.findElement(By.xpath("//input[@name='street']")).sendKeys(hospitaladdress);
			driver.findElement(By.xpath("//input[@name='city']")).sendKeys(hospitalcity);
			driver.findElement(By.xpath("//input[@name='state']")).sendKeys(hospitalstate);
			driver.findElement(By.xpath("//input[@name='description']")).sendKeys(hospitaldesc);
			driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(hospitalpincode);
			driver.findElement(By.xpath("//input[@name='country']")).sendKeys(hospitalcountry);
			driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();	
			
		}
		@DataProvider (name="hospitaldataSupplier")
		public Object[][] supplyhospitalData() {
			
				Object[][] data =  Utilities.getTestDataofiTouchFromExcel("hospdetails");
				return data;
			}
		
		
}
	
