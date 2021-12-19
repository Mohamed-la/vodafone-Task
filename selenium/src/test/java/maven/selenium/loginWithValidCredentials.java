package maven.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


//System.out.println(System.getProperty("user.dir"));
public class loginWithValidCredentials {

	public static void main(String[] args) 

	{
		

		String chromepath = System.getProperty("user.dir") + "\\chromedriverdir\\chromedriver.exe";		
		System.setProperty("webdriver.chrome.driver", chromepath);		
		ChromeDriver driver = new ChromeDriver();
		driver.navigate ().to("http://automationpractice.com/index.php?controller=authentication");	
		driver.manage().window().maximize();

		WebElement userNameInput = driver.findElement(By.id("email"));
		WebElement passwordInput = driver.findElement(By.id("passwd"));
		WebElement loginBtn = driver.findElement(By.id("SubmitLogin"));

		
		//check with valid email and password
		userNameInput.sendKeys("mohamedabdelqader22@gmail.com"); /*enter valid registered mail*/
		passwordInput.sendKeys("12345");                         /*enter the valid password*/
		loginBtn.click();	 
		WebElement destination = driver.findElement(By.className("info-account"));
		Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.",destination.getText());
         
		//AfterTest
		driver.quit();

	}

}
