package package_2_mainFunctanalities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class OrderProductTest {
  private MainLogin mainLogin = new MainLogin(); 
  @BeforeTest
  public void beforeTest() throws InterruptedException {
		  MainLogin.setUp();
		  MainLogin.mainLoginpage();
	  }
  
  @Test
  public void runTest() throws InterruptedException {
	  WebDriver driver = mainLogin.getDriver();
	  driver.navigate().to("https://automationteststore.com/");
	  Actions actions = new Actions(driver);
      actions.moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/section[1]/nav[1]/ul/li[2]"))).click().perform();
	  driver.findElement(By.xpath("//a[normalize-space()='Shoes']")).click();
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,350)", "");
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//a[@title='Womens high heel point toe stiletto sandals ankle strap court shoes']")).click();
	  js.executeScript("window.scrollBy(0,450)", "");
	  
	//li[6]//a[1]//img[1]
	  driver.findElement(By.id("option347763")).click();
	  WebElement qty = driver.findElement(By.id("product_quantity"));
	  qty.clear();
	  qty.sendKeys("2");

	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//a[@class='cart']")).click();
	  Thread.sleep(2000); 
	  js.executeScript("window.scrollBy(0,750)", "");
	  driver.findElement(By.id("cart_checkout1")).click();

	  Thread.sleep(2000);

	  js.executeScript("window.scrollBy(0,750)", "");

	  System.out.println(driver.getCurrentUrl());
	  MainLogin.takeScreenshot("Order_Product");
	  
  }
  @AfterTest
  public void close() {
	  MainLogin.close();
  }
  

}
