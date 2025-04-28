package SecondShubhamKolheTrials;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class promptAction {


	
	
	public static void  OkayPrompt(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();

}
}
