package package_1_BasicPrograms;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import mainPackage.RandomDataGeneration;
import package_2_mainFunctanalities.MainLogin;


public class RegistrationPageTest {
  private MainLogin mainLogin = new MainLogin(); 
 
  @BeforeTest
  public void beforeTest() {
		  MainLogin.setUp();
	
	  }
  @Test
  public void runTest() throws InterruptedException, IOException {
	  WebDriver driver = mainLogin.getDriver();
	  Properties prop =new Properties();
	  FileInputStream ip= new FileInputStream("./config.properties");

	  prop.load(ip);
	  
	  String pass = RandomDataGeneration.generateRandomPassword(); 
	  driver.findElement(By.cssSelector("ul[id='customer_menu_top'] li a")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[@title='Continue']")).click();
	  driver.findElement(By.id("AccountFrm_firstname")).sendKeys("Admin1");
	  driver.findElement(By.id("AccountFrm_lastname")).sendKeys("Admin1");
	  driver.findElement(By.id("AccountFrm_email")).sendKeys(RandomDataGeneration.generateRandomEmail());
	  driver.findElement(By.id("AccountFrm_address_1")).sendKeys("Nehru nagar Kurla");
	  driver.findElement(By.id("AccountFrm_city")).sendKeys("Mumbai");
	  Select country = new Select(driver.findElement(By.id("AccountFrm_country_id")));
	  country.selectByVisibleText("India");
	  Thread.sleep(2000);
	  Select zone = new Select(driver.findElement(By.id("AccountFrm_zone_id")));
	  zone.selectByVisibleText("Maharashtra");
	  driver.findElement(By.id("AccountFrm_zone_id")).sendKeys("X");
	  driver.findElement(By.id("AccountFrm_postcode")).sendKeys("400022");
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0, 850);"); 
	  driver.findElement(By.id("AccountFrm_loginname")).sendKeys(RandomDataGeneration.generateRandomName());
	  driver.findElement(By.id("AccountFrm_password")).sendKeys(pass);
	  driver.findElement(By.id("AccountFrm_confirm")).sendKeys(pass);
	  Thread.sleep(3000);
	  driver.findElement(By.id("AccountFrm_newsletter1")).click();
	  driver.findElement(By.id("AccountFrm_newsletter0")).click();
	  driver.findElement(By.id("AccountFrm_agree")).click();
	  driver.findElement(By.xpath("//button[@title='Continue']")).click();
	  Thread.sleep(10000);
	  String title = driver.getTitle();
      Assert.assertEquals(title, "Your Account Has Been Created!");
	  System.out.println("You are on "+ title + " page");
	  MainLogin.takeScreenshot("Account_has_been_created");
  }
  @AfterTest
  public void close() {
	  MainLogin.close();
  }  
}
