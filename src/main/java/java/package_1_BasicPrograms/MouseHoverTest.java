package package_1_BasicPrograms;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import package_2_mainFunctanalities.MainLogin;

public class MouseHoverTest {
    private MainLogin mainLogin = new MainLogin();

    @BeforeTest
    public void beforeTest() {
        MainLogin.setUp();
    }

    @Test
    public void runTest() throws InterruptedException {
        WebDriver driver = mainLogin.getDriver();
        Actions a = new Actions(driver);
        
        
        try {
            List<WebElement> ls = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/section[1]/nav[1]/ul/li"));
            int size = ls.size();
            System.out.println("No of elements: " + size);

            for (int i = 1; i <= size; i++) {
                Thread.sleep(2000);
                String el = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/section[1]/nav[1]/ul/li[" + i + "]")).getText();
                System.out.println(el);
                a.moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/section[1]/nav[1]/ul/li[" + i + "]"))).click().perform();
                MainLogin.takeScreenshot(el);
                Thread.sleep(2000);

            }

            
            Thread.sleep(1000);
        } catch (Exception e) {
            
            System.err.println("An error occurred: " + e.getMessage());
        }
        //driver.navigate().to("https://automationteststore.com/");
        
    }

    @AfterTest
    public void close() {
        MainLogin.close();
    }
}
