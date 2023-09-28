package package_2_mainFunctanalities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CartPageTest {
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
	      actions.moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/section[1]/nav[1]/ul[1]/li[5]"))).click().perform();
	      Thread.sleep(3000);
	      actions.moveToElement(driver.findElement(By.xpath("//a[normalize-space()='Women']"))).click().perform();
	      Thread.sleep(3000);
	      JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0, 750);"); 
		  
	      driver.findElement(By.xpath("//div[14]//div[2]//div[3]//a[1]//i[1]")).click();
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//div[11]//div[2]//div[3]//a[1]//i[1]")).click();
	      Thread.sleep(2000);
		  js.executeScript("window.scrollTo(0, 0);"); 
		  driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/ul[1]/li[3]/a[1]/span[1]")).click();
		  Thread.sleep(2000);
		  js.executeScript("window.scrollBy(0, 650);");
		  //To delete the product
		  driver.findElement(By.xpath("//tbody/tr[2]/td[7]/a[1]")).click();
		  Thread.sleep(2000);
		  MainLogin.takeScreenshot("Cart_Page");

	  }
	  
	  @AfterTest
	  public void close() {
		  MainLogin.close();
	  }

}
