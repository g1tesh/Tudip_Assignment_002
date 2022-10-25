package Apply_Jop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Java_Developer_Application {
	
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tudip.com/");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@title= 'Careers']"))).build().perform();
		
		driver.findElement(By.xpath("//a[text() = 'Apply Online']")).click();
		driver.findElement(By.id("catapultCookie")).click();
	
		WebElement jobid = driver.findElement(By.xpath("//div[@id = 'job-post-title']//h3[text() ='Designer Executive']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(jobid)).click();
		
		WebElement apply = driver.findElement(By.xpath("//input[@type = 'button']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", apply);
		
		System.out.println("Quiting driver");
		driver.quit();
		
	}
}
