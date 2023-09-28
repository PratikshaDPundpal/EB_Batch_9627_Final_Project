package package_4_Frameworks.testUsingKDTFramework;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class KDT_ReadExcel_AutomationStore {

    public void readExcel(WebDriver driver) {
        try {
            FileInputStream file = new FileInputStream("./POI_AutomationTestStore.xlsx");
            XSSFWorkbook w = new XSSFWorkbook(file);
            XSSFSheet s = w.getSheet("KDT");

            int rowsize = s.getLastRowNum();
            System.out.println("No of Keywords :" + rowsize);
            KDT_OperationalClass_AutomationStore obj = new KDT_OperationalClass_AutomationStore();

            for (int i = 0; i <= rowsize; i++) {
                XSSFRow row = s.getRow(i);
                if (row != null) {
                    XSSFCell cell = row.getCell(0);
                    if (cell != null) {
                        String key = cell.getStringCellValue();
                        System.out.println(key);
                        switch (key) {
                            case "OpenURL":
                                obj.url(driver);
                                break;
                            case "MaximizeBrowser":
                                obj.maximizeBrowser(driver);
                                break;
                            case "ClickOnLoginButton":
                                obj.clickOnLoginButton(driver);
                                break;
                            case "EnterLoginName":
                                obj.enterLoginName(driver, "RadhaNa");
                                break;
                            case "EnterPassword":
                                obj.enterPassword(driver, "Admin");
                                break;
                            case "ClickOnActionButton":
                                obj.clickOnActionButton(driver);
                                break;
                            case "ClickOnLogOutButton":
                                obj.clickOnLogOutButton(driver);
                                break;
                            case "CloseBrowser":
                                obj.closeBrowser(driver);
                                break;
                            default:
                                System.out.println("Unknown keyword: " + key);
                                break;
                        }
                    }
                    
                        else {
                            System.out.println("Cell is null at row " + i); // Debug statement
                        }
                    } else {
                        System.out.println("Row is null at index " + i); // Debug statement
                    }
                    }
              
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
