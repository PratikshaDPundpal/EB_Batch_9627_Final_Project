package package_1_BasicPrograms;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import package_2_mainFunctanalities.MainLogin;

public class WebPageTitleVerificationTest {
  private MainLogin mainLogin = new MainLogin();
  @BeforeTest
  public void beforeTest() {
	        MainLogin.setUp();
	    }
  @Test
  public void runTest() throws InterruptedException {
	    WebDriver driver = mainLogin.getDriver();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		driver.manage().window().maximize();
		System.out.println("Actual Title:"+ actualTitle);
		String expectedTitle = "A place to practice your automation skills!";
		try {
			Assert.assertEquals(actualTitle, expectedTitle);
			System.out.println("Title Matched");
			MainLogin.takeScreenshot("Title_Matched");
		}catch (Exception e) {
		
			System.out.println("Title didn't match");
			MainLogin.takeScreenshot("Title_didn't_Matched");
		}
		
		Thread.sleep(2000);
		driver.navigate().to("https://automationteststore.com/");
		
  }
  @AfterTest
  public void close() {
      MainLogin.close();
  }
}
