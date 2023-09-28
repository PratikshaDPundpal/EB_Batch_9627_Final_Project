package package_2_mainFunctanalities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AccountPageMenuTest {
	private MainLogin mainLogin = new MainLogin(); 
	  @BeforeTest
	  public void beforeTest() throws InterruptedException {
			  MainLogin.setUp();
			  MainLogin.mainLoginpage();
		  }

    @Test
    public void runTest() throws InterruptedException {
    	WebDriver driver = mainLogin.getDriver();
        try {
            Thread.sleep(5000);
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/ul[1]/li[2]/a[1]"))).build().perform();
            Thread.sleep(2000);
            
            // Initialize WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(07));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-id='menu_order']")));
            element.click();
            Thread.sleep(2000);
            String title = driver.getTitle();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 650);"); 
            Thread.sleep(3000);

            Assert.assertEquals(title, "My Order History");
  		    System.out.println("You are on "+ title + " page");
  		    MainLogin.takeScreenshot("My_Order_History_Page");
            
        } finally {
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[10]/a[1]")).click();
        }
    }

    @AfterTest
	  public void close() {
		  MainLogin.close();
	  }
}
