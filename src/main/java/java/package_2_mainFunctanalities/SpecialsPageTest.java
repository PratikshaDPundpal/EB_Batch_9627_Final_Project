package package_2_mainFunctanalities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SpecialsPageTest {
	  private MainLogin mainLogin = new MainLogin(); 
	  @BeforeTest
	  public void beforeTest() throws InterruptedException {
			  MainLogin.setUp();
			  MainLogin.mainLoginpage();
		  }
	  @Test
	  public void runTest() throws InterruptedException {
		  WebDriver driver = mainLogin.getDriver();
		  Actions actions = new Actions(driver);
	      actions.moveToElement(driver.findElement(By.xpath("//li[@data-id='menu_specials']"))).click().perform();
	      Thread.sleep(3000);
	      String title = driver.getTitle();
	      JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0, 550);"); 
	      Thread.sleep(3000);
	      driver.findElement(By.xpath("//div[@class='thumbnails grid row list-inline']//div[2]//div[2]//div[3]//a[1]//i[1]")).click();
		  Thread.sleep(2000);
		  Assert.assertEquals(title, "Special Offers");
		  System.out.println("You are on "+ title + " page");
		  MainLogin.takeScreenshot("Specials_Page");
		  
	  }
	  
	  @AfterTest
	  public void close() {
		  MainLogin.close();
	  }

}
