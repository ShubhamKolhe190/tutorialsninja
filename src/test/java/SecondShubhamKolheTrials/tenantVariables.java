package SecondShubhamKolheTrials;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class tenantVariables {
		
		
		public static void getotpsusingmailinator(WebDriver driver) throws InterruptedException  {
			Thread.sleep(5000);
			WebDriver driver2;
			driver2=new ChromeDriver();
			driver2.manage().window().maximize();
			driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			String otp="";
			
			driver2.get("https://www.mailinator.com/");
			driver2.findElement(By.xpath("//span[contains(text(),\"LOGIN\")]")).click();
			driver2.findElement(By.xpath("//input[@placeholder=\"Email\"]")).sendKeys("qatester@iorbit-tech.com");
			driver2.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("qatester@1234");
			driver2.findElement(By.xpath("/html/body/main/div/div/div/section/form/div[4]/a[1]")).click();
			driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver2.findElement(By.xpath("(//*[@class='ng-binding'])[1]")).click();
			
			try {
				WebElement iframeElement = driver2.findElement(By.xpath("html/body/div/main/div/div/div[3]/div/div[2]/iframe"));
				driver2.switchTo().frame(iframeElement);
				WebElement otpElement = driver2.findElement(By.xpath("//body[contains(text(), 'OTP')]"));
				String otpText = otpElement.getText();

	           
	            Pattern pattern = Pattern.compile("\\d{6}");
	            Matcher matcher = pattern.matcher(otpText);

	            if (matcher.find()) {
	                 otp = matcher.group(0);
	                System.out.println("Extracted OTP: " + otp);
	            } else {
	                System.out.println("OTP not found in the email.");
	            }

	        }  catch (NoSuchElementException n) {
	            System.out.println("Email containing OTP not found.");
	        } 
			System.out.println("Stored OTP: " + otp);
			  driver2.quit();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@name='otpCode']")).sendKeys(otp);
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			
			
		}

}

