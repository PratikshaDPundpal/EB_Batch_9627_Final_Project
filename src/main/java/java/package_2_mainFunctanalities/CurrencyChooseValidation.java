package package_2_mainFunctanalities;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CurrencyChooseValidation {
  private MainLogin mainLogin = new MainLogin(); 

  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  MainLogin.setUp();
	  MainLogin.mainLoginpage();	
	  }
  @Test(priority=2)
  public void runTest() throws InterruptedException {
	  WebDriver driver = mainLogin.getDriver();
	  Actions actions = new Actions(driver);
      actions.moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/section[1]/nav[1]/ul[1]/li[3]/a[1]"))).click().perform();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//a[normalize-space()='Face']")).click();
      Thread.sleep(3000);

      
      By EURO = By.xpath("//ul[@class='dropdown-menu currency']//li");
	  By POUND = By.xpath("(//a[@class='dropdown-toggle']/span)[1]");
	  By DOLLAR = By.className("block_6");
	  
	  WebElement currencyDropdown = driver.findElement(By.className("block_6")); 

	  currencyDropdown.click();
	  Thread.sleep(3000);
	  
	  By[] currencyLocators = {EURO, POUND, DOLLAR};

	  
	  Random rand = new Random();
	  int randomIndex = rand.nextInt(currencyLocators.length);

	  
	  By optionLocator = currencyLocators[randomIndex];
	  WebElement optionToSelect = driver.findElement(optionLocator);
	  optionToSelect.click();
	  Thread.sleep(5000);
	  
	  String SelectedCurrency = optionLocator.toString();
	  if(SelectedCurrency == "//ul[@class='dropdown-menu currency']//li"){
			  System.out.println("Selected Currency: € EURO");
			  MainLogin.takeScreenshot("EURO_Currency_selection");
	  }else if(SelectedCurrency == "//a[@class='dropdown-toggle']/span)[1]"){
		  System.out.println("Selected Currency: £ POUND STERLING");
		  MainLogin.takeScreenshot("POUND_Currency_selection");
	  }else {
		  System.out.println("Selected Currency: $ US DOLLAR");
		  MainLogin.takeScreenshot("DOLLAR_Currency_selection");
	  }

	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0, 450);"); 
	  Thread.sleep(3000); 

  }
  @AfterTest
  public void close() {
	  MainLogin.close();
  }
  
}
