package package_4_Frameworks;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import package_4_Frameworks.testUsingKDTFramework.KDT_OperationalClass_AutomationStore;


public class LoginUsingDDTandPOI {
	 public static WebDriver driver;
	
	 public static void main(String[] args) throws Exception{
	
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		FileInputStream file = new FileInputStream("./POI_AutomationTestStore.xlsx");
		// JVM will reach to Excel File
		@SuppressWarnings("resource")
		XSSFWorkbook w = new XSSFWorkbook(file);
		System.out.println("File opened successfully.");
		
		// Decide unique Excel Sheet
		XSSFSheet s = w.getSheet("DDT");
		
		// To Store Total Number of Row
		int rowSize= s. getLastRowNum();
		System.out.println("No of Rows: "+rowSize);
		
		// Create object of POM class >> repository
		KDT_OperationalClass_AutomationStore obj = new KDT_OperationalClass_AutomationStore();
		
			for(int i=1; i<rowSize; i++) // DataDriven>> Multiple Credentials
			{
				String loginname = s.getRow(i).getCell(0).getStringCellValue();
				String password = s.getRow(i).getCell(1).getStringCellValue();
				System.out.println(loginname +"\t\t"+ password);
					try
					{
						obj.url(driver);
					    obj.maximizeBrowser(driver);
						//obj.deleteCookies(driver);
						
						Thread.sleep(2000);
						obj.clickOnLoginButton(driver);
						
						obj.enterLoginName(driver, loginname);
						Thread.sleep(2000);
						
						obj.enterPassword(driver, password);
						Thread.sleep(2000);
						
						obj.clickOnActionButton(driver);
						Thread.sleep(2000);
								
						obj.clickOnLogOutButton(driver);
						Thread.sleep(2000);
						
						//Update TestResult
						System.out.println("Valid Credential.");
						System.out.println("");
						s.getRow(i).createCell(2).setCellValue("Valid Credential");
						
					}
					
				catch (Exception e)
				{
					System.out.println("Invalid Credential.");
					System.out.println("");
					s.getRow(i).createCell(2).setCellValue("Invalid Credential.");
					
				}				
			}
		FileOutputStream out = new FileOutputStream("./POI_AutomationTestStore.xlsx");
		w.write(out);
		
		obj.closeBrowser(driver);
			}
	 }
