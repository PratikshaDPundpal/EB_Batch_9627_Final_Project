package package_4_Frameworks.testUsingHybridFrameworks;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import package_4_Frameworks.testUsingKDTFramework.KDT_OperationalClass_AutomationStore;

public class HybridReadExcel {

		public void readExcel(WebDriver driver) throws Exception
		{
			//Excel
			FileInputStream file = new FileInputStream("./POI_AutomationTestStore.xlsx");
			@SuppressWarnings("resource")
			XSSFWorkbook w = new XSSFWorkbook(file);
			XSSFSheet s = w. getSheet("HDT");
			
			int rowSize= s. getLastRowNum();
			System.out.println("No of Rows: "+rowSize);
			
			// Create object of POM class >> repository
			KDT_OperationalClass_AutomationStore o = new KDT_OperationalClass_AutomationStore();
			
			for(int i=1; i<=rowSize; i++) // DataDriven>> Multiple Credentials
			{
				String email = s.getRow(i).getCell(1).getStringCellValue();
				String password = s.getRow(i).getCell(2).getStringCellValue();
				System.out.println(email +"\t\t"+ password);
				
				try
				{
					for(int j =1; j<=rowSize; j++)// KeyWordDriven >> Keys: As per keys will perform actions
					{
						String key = s.getRow(j).getCell(0).getStringCellValue();
						
						if(key.equals("OpenURL"))
						{
							o.url(driver);
							System.out.println(key);
							Thread.sleep(2000);
						}
						
						else if(key.equals("MaximizeBrowser"))
						{
							o.maximizeBrowser(driver);
							System.out.println(key);
							Thread.sleep(2000);
						}
						else if(key.equals("ClickOnLoginButton"))
						{
							o.clickOnLoginButton(driver);
							System.out.println(key);
							Thread.sleep(2000);
						}
						else if(key.equals("EnterLoginName"))
						{
							o.enterLoginName(driver, email);
							System.out.println(key);
							Thread.sleep(2000);
						}
						else if(key.equals("EnterPassword"))
						{
							o.enterPassword(driver, password);
							System.out.println(key);
							Thread.sleep(2000);
						}
						else if(key.equals("ClickOnActionButton"))
						{
							o.clickOnActionButton(driver);
							System.out.println(key);
							Thread.sleep(2000);
						}
						else if(key.equals("ClickOnLogOutButton"))
						{
							o.clickOnLogOutButton(driver);
							System.out.println(key);
							Thread.sleep(2000);
						}						
						
					}
					System.out.println("Valid Credential.");
					System.out.println("");
					s.getRow(i).createCell(3).setCellValue("Valid Credential.");
					
				}
				catch (Exception e)
				{
					System.out.println("Invalid Credential.");
					System.out.println("");
					s.getRow(i).createCell(3).setCellValue("Invalid Credential.");
					
				}
			}
			
			FileOutputStream out = new FileOutputStream("./POI_AutomationTestStore.xlsx");
			w.write(out);
			
			o.closeBrowser(driver);
			
			
			
		}



}
