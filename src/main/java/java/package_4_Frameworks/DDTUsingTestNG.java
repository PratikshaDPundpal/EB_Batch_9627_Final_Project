package package_4_Frameworks;


import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import package_3_POM_Object.LoginPageObjects;




public class DDTUsingTestNG {
	public static WebDriver driver;
	
	@Test(dataProvider = "dp")
	 public void VerifyLogin(String lname, String pass) throws IOException{
	
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.get("https://automationteststore.com/");
			
			 LoginPageObjects loginPageObjects = new LoginPageObjects(driver);
			 loginPageObjects.go_to_login().click();
			 loginPageObjects.loginname().sendKeys(lname);
			 loginPageObjects.password().sendKeys(pass);
			 loginPageObjects.login_button().click();
			
		    String actualTitle="My Account"; 
		    String expectedTitle= driver.getTitle();
		    if(expectedTitle.contains(actualTitle))
		    {
		    	System.out.println("User logged in successfully");
		    }else {
		    	System.out.println("User failed to login");
		    }
		    


}
	@DataProvider
	public Object [][] dp() {
		Object [] [] data = {{"RadhaNay", "Admin6"},
							{"RadhaNa","Admin"},
							{"RadhaNay", "Admin6"}
		};
		return data;
		
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
