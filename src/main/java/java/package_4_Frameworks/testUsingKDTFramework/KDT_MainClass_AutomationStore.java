package package_4_Frameworks.testUsingKDTFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class KDT_MainClass_AutomationStore {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\\\webdriver\\\\ChromeDriver\\\\chromedriver-win64\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		KDT_ReadExcel_AutomationStore ob = new KDT_ReadExcel_AutomationStore();
		ob.readExcel(driver);
		Thread.sleep(2000);
	}

}
