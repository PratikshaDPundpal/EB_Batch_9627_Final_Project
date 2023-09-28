package package_3_POM_TestCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPageTest {
	
  WebDriver driver;
  public AccountPageTest(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
  
  
  @FindBy(xpath="//ul[@class='breadcrumb']//a[normalize-space()='Account']")
  WebElement AccountPageTest;
 
  public WebElement AccountPageTest() {
	  return AccountPageTest;
  }
}
