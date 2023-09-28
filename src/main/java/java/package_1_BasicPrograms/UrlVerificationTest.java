package package_1_BasicPrograms;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import package_2_mainFunctanalities.MainLogin;

public class UrlVerificationTest {
  private MainLogin mainLogin = new MainLogin();
  @BeforeTest
  public void beforeTest() {
        MainLogin.setUp();
    }
  @Test
  public void runTest() throws InterruptedException {
	    WebDriver driver = mainLogin.getDriver();
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		driver.manage().window().maximize();
		String expectedUrl = "https://automationteststore.com/";
		try {
			Assert.assertEquals(URL, expectedUrl);
			System.out.println("URL verified");
			MainLogin.takeScreenshot("UrlVerification");
		}catch (Exception e) {
		
			System.out.println("URL didn't match");
		}
		
		Thread.sleep(2000);
		

	}
  @AfterTest
  public void close() {
      MainLogin.close();
  }
  
}
