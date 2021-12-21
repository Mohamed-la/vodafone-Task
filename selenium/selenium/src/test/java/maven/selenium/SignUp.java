package maven.selenium;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class SignUp 
{

	public static void main(String[] args) 
	
	{
		String chromepath = System.getProperty("user.dir") + "\\chromedriverdir\\chromedriver.exe";		
		System.setProperty("webdriver.chrome.driver", chromepath);
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/index.php?controller=authentication");
		driver.manage().window().maximize();
		
		WebElement userNameInput = driver.findElement(By.id("email_create"));			
		userNameInput.sendKeys("eslam.sayed@gmail.com");
		userNameInput.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);  // waiting until page reload

	
		driver.findElement(By.id("customer_firstname")).sendKeys("Mohamed");
		driver.findElement(By.id("customer_lastname")).sendKeys("Abdelqader");		
		driver.findElement(By.id("passwd")).sendKeys("test1234");
		driver.findElement(By.className("form-group")).click();
		driver.findElement(By.id("company")).sendKeys("el sewedy electrometer");
		driver.findElement(By.id("address1")).sendKeys("6 october-Giza");
		driver.findElement(By.id("city")).sendKeys("october");
		driver.findElement(By.id("postcode")).sendKeys("00000");
		driver.findElement(By.id("phone_mobile")).sendKeys("01117757815");
		Select drpCountry = new Select(driver.findElement(By.xpath("//*[@id='id_state']")));	
		drpCountry.selectByIndex(3);
		driver.findElement(By.id("phone_mobile")).sendKeys(Keys.ENTER);
		
		WebElement destination = driver.findElement(By.className("info-account"));
		if (destination.getText().equals("Welcome to your account. Here you can manage all of your personal information and orders."))
		{
			System.out.println("registeration succeded");
		}
		else
		{
			System.out.println("registeration Failed");
		}
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);  // waiting until page reload
		driver.quit();
		
	}

}
