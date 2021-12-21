package maven.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


//System.out.println(System.getProperty("user.dir"));
public class loginWithInvalidCredentials {

	public static void main(String[] args) 

	{
		//BeforeTest


		String chromepath = System.getProperty("user.dir") + "\\chromedriverdir\\chromedriver.exe";		
		System.setProperty("webdriver.chrome.driver", chromepath);		
		ChromeDriver driver = new ChromeDriver();
		driver.navigate ().to("http://automationpractice.com/index.php?controller=authentication");	
		driver.manage().window().maximize();

		WebElement userNameInput = driver.findElement(By.id("email"));
		WebElement passwordInput = driver.findElement(By.id("passwd"));
		WebElement loginBtn = driver.findElement(By.id("SubmitLogin"));


		//check with invalid email and password
		userNameInput.sendKeys("wrongemail@gmail.com");
		passwordInput.sendKeys("1234");
		loginBtn.click();	
		WebElement failMessageOne = driver.findElement(By.className ("navigation_page"));      
		Assert.assertEquals("Authentication",failMessageOne.getText()); 
		
		
		if (failMessageOne.getText().equals("Welcome to your account. Here you can manage all of your personal information and orders."))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed (inavalid mail)");
		}

		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);  // waiting until page reload
		//AfterTest
		driver.quit();



	}

}
