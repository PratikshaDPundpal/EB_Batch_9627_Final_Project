package package_2_mainFunctanalities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class MainLogin {
	protected static WebDriver driver;
	public static String loginname = "RadhaNa";
	public static String password = "Admin";
	  @Test
	  public static void setUp() {
		  driver = new ChromeDriver();
		  driver.get("https://automationteststore.com/");
	      driver.manage().window().maximize();
	      driver.manage().deleteAllCookies();
	  }
	  @Test
	  public static void mainLoginpage() throws InterruptedException {
		  driver.findElement(By.cssSelector("ul[id='customer_menu_top'] li a")).click();
		  driver.findElement(By.id("loginFrm_loginname")).sendKeys(loginname);
		  driver.findElement(By.id("loginFrm_password")).sendKeys(password);
		  driver.findElement(By.xpath("//button[@title='Login']")).click();

	  }
	  @AfterTest
	  public static void close() {
		  driver.quit();
	  }
	public WebDriver getDriver() {
				return driver;
	}
	public static void takeScreenshot(String screenshotName) {
	    try {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        File destination = new File(System.getProperty("user.dir") + "/src/test/resources/Screenshots/" + screenshotName + ".png");
	        FileUtils.copyFile(source, destination);
	        System.out.println("Screenshot taken: " + screenshotName);
	    } catch (IOException e) {
	        System.out.println("Exception while taking screenshot: " + e.getMessage());
	    }
	}

	

}
