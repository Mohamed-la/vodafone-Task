package maven.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class cartCheckout {

	public static void main(String[] args)
	{
		String chromepath = System.getProperty("user.dir") + "\\chromedriverdir\\chromedriver.exe";		
		System.setProperty("webdriver.chrome.driver", chromepath);		
		ChromeDriver driver = new ChromeDriver();
		driver.navigate ().to("http://automationpractice.com/index.php?controller=authentication");	
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.linkText("http://automationpractice.com/index.php?controller=order")).getText());	

	}

}
