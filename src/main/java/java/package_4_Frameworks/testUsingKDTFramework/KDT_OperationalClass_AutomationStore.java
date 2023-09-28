package package_4_Frameworks.testUsingKDTFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KDT_OperationalClass_AutomationStore {

	public void url(WebDriver driver)
	{
		driver.get("https://automationteststore.com/");
	}
	
	public void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void clickOnLoginButton(WebDriver driver)
	{
		driver.findElement(By.cssSelector("ul[id='customer_menu_top'] li a")).click(); 
	}
	public void enterLoginName(WebDriver driver,String email) 
	{
		driver.findElement(By.id("loginFrm_loginname")).sendKeys(email); 
	}
	public void enterPassword(WebDriver driver,String pwd) 
	{
		 driver.findElement(By.id("loginFrm_password")).sendKeys(pwd); 
	}
	
	public void clickOnActionButton(WebDriver driver)
	{
		driver.findElement(By.xpath("//button[@title='Login']")).click();
        
	}
			
	public void clickOnLogOutButton(WebDriver driver) 
	{
		driver.findElement(By.xpath("//a[@href='https://automationteststore.com/index.php?rt=account/logout'][normalize-space()='']")).click();
	}
	public void closeBrowser(WebDriver driver)
	{
		driver.close();
	}

	}

