package SecondShubhamKolheTrials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialninja.qa.utils.Utilities;

public class hospitalCreation {
	WebDriver driver;
	@DataProvider (name="hospitaldataSupplier")
	public Object[][] supplyhospitalData() {
		
			Object[] [] data =  Utilities.getTestDataofiTouchFromExcel("hospitaldetails");
			return data;
		}
	@Test (dataProvider="hospitaldataSupplier")
	
		
		public void hospitalCreation(String hospitalname, String hospitalcode, String hospitalemail, String hospitalphone, String hospitaladdress, 
			String hospitalcity, String hospitalstate, String hospitaldesc, String hospitalpincode, String hospitalcountry) 
	{
		MenuItem.navigateToMenuItem(driver, "Manage Hospital");
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
}
