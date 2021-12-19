package maven.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


//System.out.println(System.getProperty("user.dir"));
public class loginWithEmptyFields {

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

	    
		//check with empty fields for  email and password
        userNameInput.sendKeys("");
	    passwordInput.sendKeys("");
		loginBtn.click();	
	    WebElement failMessageTwo = driver.findElement(By.className ("navigation_page"));      
	    Assert.assertEquals("Authentication",failMessageTwo.getText());
		
	
		//AfterTest
		driver.quit();



	}

}
