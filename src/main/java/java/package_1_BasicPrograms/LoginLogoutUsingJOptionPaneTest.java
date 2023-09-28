package package_1_BasicPrograms;


import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import package_2_mainFunctanalities.MainLogin;

public class LoginLogoutUsingJOptionPaneTest {
	  private MainLogin mainLogin = new MainLogin(); 
	  @BeforeTest
	  public void beforeTest() {
		  MainLogin.setUp();
	  }
	  @Test
	  public void runTest() throws InterruptedException {
		  WebDriver driver = mainLogin.getDriver();
		  // using input dialogbox(Joptionpane)
		  String loginname = JOptionPane.showInputDialog("Enter the loginname ");
		  String password = JOptionPane.showInputDialog("Enter the password ");
		  
		  try {
			  driver.findElement(By.cssSelector("ul[id='customer_menu_top'] li a")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.id("loginFrm_loginname")).sendKeys(loginname);
			  Thread.sleep(2000);
			  driver.findElement(By.id("loginFrm_password")).sendKeys(password);
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//button[@title='Login']")).click();
			  Thread.sleep(2000);
	           
	        } catch (Exception e) {
	            // Handle the exception here (e.g., log the error)
	            System.err.println("An error occurred: " + e.getMessage());
	        }
		  driver.navigate().back();
		  driver.findElement(By.xpath("//i[@class='fa fa-unlock']")).click();
	    }
	
		  
		  
		
	  @AfterTest
	  public void close() {
		  MainLogin.close();
	  }
	  
}
