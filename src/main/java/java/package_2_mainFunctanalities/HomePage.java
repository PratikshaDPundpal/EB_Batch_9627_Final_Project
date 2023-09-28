package package_2_mainFunctanalities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePage {
   private MainLogin mainLogin = new MainLogin(); 
   
   @BeforeTest
   public void beforeTest() throws InterruptedException {
			  MainLogin.setUp();
			  MainLogin.mainLoginpage();
		  }
  
	
  @Test(priority = 1)
  public void runTest() throws InterruptedException {
	  WebDriver driver = mainLogin.getDriver();
	  Actions a = new Actions(driver);
      List<WebElement>ls = driver.findElements(By.xpath("//ul[@id='main_menu_top']//li"));
      int size = ls.size();
      
      System.out.println("No of elements: "+size);
    
      for(int i=1; i<=size; i++)
      {
    	if(i==5)
    		break;
      	Thread.sleep(2000);
      	String menuItems = driver.findElement(By.xpath("//ul[@id='main_menu_top']//li["+i+"]")).getText();
      	System.out.println(menuItems);
      	a.moveToElement(driver.findElement(By.xpath("//ul[@id='main_menu_top']//li["+i+"]"))).click().build().perform();
      	
      	MainLogin.takeScreenshot(menuItems);
		Thread.sleep(2000); 
      }
      
     
  }
  @Test(priority =2)
  public void searchProduct() {
	  WebDriver driver = mainLogin.getDriver();
	  driver.findElement(By.id("filter_keyword")).sendKeys("Lipstick");
	  driver.findElement(By.className("button-in-search")).click();
	  String title =driver.getTitle(); 
	  System.out.println(title);
	  MainLogin.takeScreenshot("After_Searching_product");
  }
  

  @AfterTest
  public void close() {
	  MainLogin.close();
  }
}
