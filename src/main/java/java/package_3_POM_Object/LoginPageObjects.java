package package_3_POM_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
  
	WebDriver driver;
	
	public LoginPageObjects(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//By go_to_login = By.cssSelector("ul[id='customer_menu_top'] li a");  POM 
	@FindBy(css="ul[id='customer_menu_top'] li a")
    WebElement go_to_login;
	
	// By loginname = By.id("loginFrm_loginname");
	@FindBy(id="loginFrm_loginname")
	WebElement loginname;
	
	//By password = By.id("loginFrm_password");
	
	@FindBy(id="loginFrm_password")
	WebElement password;
	
	//By login_button = By.xpath("//button[@title='Login']");
	@FindBy(xpath="//button[@title='Login']")
	WebElement login_button;
	
	public WebElement go_to_login() {
		return go_to_login;
	}
	
	public WebElement loginname() {
		return loginname;
	}
	public WebElement password() {
		return password;
	}
	public WebElement login_button() {
		return login_button;
	}
}
