package package_4_Frameworks.testUsingHybridFrameworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HybridMainClass_AutomationStore {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\webdriver\\\\\\\\ChromeDriver\\\\\\\\chromedriver-win64\\\\\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		HybridReadExcel ob = new HybridReadExcel();
		ob.readExcel(driver);

	}

}
