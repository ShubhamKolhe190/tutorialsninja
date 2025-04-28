package SecondShubhamKolheTrials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuItem {
	public static void navigateToMenuItem(WebDriver driver, String menuitem ) {
		    driver.findElement(By.xpath("//div[contains(text(),'"+menuitem+"')]")).click();
		}
}

