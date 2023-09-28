package package_3_POM_TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import package_2_mainFunctanalities.MainLogin;
import package_3_POM_Object.LoginPageObjects;


public class LoginPageTest {
	private MainLogin mainLogin = new MainLogin(); 
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		MainLogin.setUp();
	}
	@Test
	public void LoginTest() throws InterruptedException {
		WebDriver driver = mainLogin.getDriver();
	    LoginPageObjects loginPageObjects = new LoginPageObjects(driver);
	    
	    loginPageObjects.go_to_login().click();
	    loginPageObjects.loginname().sendKeys("RadhaNa");
	    loginPageObjects.password().sendKeys("Admin");
	    loginPageObjects.login_button().click();
	    
	    AccountPageTest accountPageTest = new AccountPageTest(driver);
	    Thread.sleep(2000);
	    try {
	    	
	    	Assert.assertTrue(accountPageTest.AccountPageTest().isDisplayed());
			System.out.println("Account Page is visible");
			MainLogin.takeScreenshot("AccountPage");
		}catch (Exception e) {
		
			System.out.println("Account Page is not visible");
		}
	 }
	 @AfterTest
	  public void close() {
	      MainLogin.close();
	 }
	  
	
}
