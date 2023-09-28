package mainPackage;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import package_1_BasicPrograms.LoginLogoutUsingJOptionPaneTest;
import package_1_BasicPrograms.MouseHoverTest;
import package_1_BasicPrograms.RegistrationPageTest;
import package_1_BasicPrograms.WebPageTitleVerificationTest;
import package_1_BasicPrograms.UrlVerificationTest;
import package_2_mainFunctanalities.AccountPageMenuTest;
import package_2_mainFunctanalities.CartPageTest;
import package_2_mainFunctanalities.CheckoutPageTest;
import package_2_mainFunctanalities.CurrencyChooseValidation;
import package_2_mainFunctanalities.HomePage;
import package_2_mainFunctanalities.MainLogin;
import package_2_mainFunctanalities.OrderProductTest;
import package_2_mainFunctanalities.SpecialsPageTest;

public class MainClass {
  @SuppressWarnings("unused")
private MainLogin mainLogin = new MainLogin();

  @BeforeTest
  public void beforeTest() {
        MainLogin.setUp();
    }
  @Test(priority=1)
  public void Test1() throws InterruptedException, IOException {
	   
	  // Run each test class
	   UrlVerificationTest urlVerificationTest = new UrlVerificationTest();
       urlVerificationTest.runTest();
       Thread.sleep(1000);
       System.out.println("Test_Case_01 Passed");
  }
  @Test(priority=2)
  public void Test2() throws InterruptedException, IOException {
      
       WebPageTitleVerificationTest webPageTitleVerificationTest = new WebPageTitleVerificationTest();
       webPageTitleVerificationTest.runTest();
       Thread.sleep(1000);
       System.out.println("Test_Case_02 Passed");
  }
  
  @Test(priority=3)
  public void Test3() throws InterruptedException, IOException {
      
       LoginLogoutUsingJOptionPaneTest loginLogoutTest = new LoginLogoutUsingJOptionPaneTest();
       loginLogoutTest.runTest();
       Thread.sleep(1000);
	   System.out.println("Test_Case_03 Passed");
      
  }
  @Test(priority=4)
  public void Test4() throws InterruptedException, IOException {
       MouseHoverTest mouseHoverTest = new MouseHoverTest();
       mouseHoverTest.runTest();
       Thread.sleep(1000);
       System.out.println("Test_Case_03 Passed");
  }
  @Test(priority=5)
  public void Test5() throws InterruptedException, IOException {
       RegistrationPageTest registrationPageTest = new RegistrationPageTest();
       registrationPageTest.runTest();
       Thread.sleep(1000);
       System.out.println("Test_Case_05 Passed");
  }
  @Test(priority=6)
  public void Test6() throws InterruptedException, IOException {
  	   HomePage homePage = new HomePage();
  	   homePage.runTest();
  	   Thread.sleep(1000);
  	   System.out.println("Test_Case_06 Passed");
  }
  @Test(priority=7)
  public void Test7() throws InterruptedException, IOException {
  	   CurrencyChooseValidation currencyChooseValidation = new CurrencyChooseValidation();
       currencyChooseValidation.runTest();
       Thread.sleep(1000);
       System.out.println("Test_Case_07 Passed");
  }
  @Test(priority=8)
  public void Test8() throws InterruptedException, IOException {
       Thread.sleep(3000);
       OrderProductTest orderProductTest = new OrderProductTest();
  	   orderProductTest.runTest();
  	   Thread.sleep(2000);
  	   System.out.println("Test_Case_08 Passed");
  }
  @Test(priority=9)
  public void Test9() throws InterruptedException, IOException {
       SpecialsPageTest specialsPageTest = new SpecialsPageTest();
  	   specialsPageTest.runTest();
  	   Thread.sleep(1000);
  	   System.out.println("Test_Case_09 Passed");
  }
  
  @Test(priority=10)
  public void Test10() throws InterruptedException, IOException {
	   Thread.sleep(2000);
	   
  	   AccountPageMenuTest accountPageMenuTest = new AccountPageMenuTest();
  	   accountPageMenuTest.runTest();
  	   System.out.println("Test_Case_10 Passed");
  	   Thread.sleep(1000);
  }
  @Test(priority=11)
  public void Test11() throws InterruptedException, IOException {
  	   CartPageTest cartPageTest = new CartPageTest();
       cartPageTest.runTest();
       System.out.println("Test_Case_11 Passed");
       Thread.sleep(2000);
       
  }
  @Test(priority=12)
  public void Test12() throws InterruptedException, IOException {
	   Thread.sleep(5000);
  	   CheckoutPageTest checkoutPageTest = new CheckoutPageTest();
  	   Thread.sleep(2000);
  	   checkoutPageTest.runTest();
  	   
  	   System.out.println("Test_Case_12 Passed");
  }
      
  @AfterTest
  public void close() {
      MainLogin.close();
  }
}
