package MytheresaAutomationChallenge.MytheresaAutomationChallenge.TestCaseTwo;

import org.testng.annotations.Test;

import MytheresaAutomationChallenge.MytheresaAutomationChallenge.HomePagePOM;
import MytheresaAutomationChallenge.MytheresaAutomationChallenge.TestBase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class VerifyLoginSuccessfullyTest extends TestBase{

	private HomePagePOM homePagePOM;
  @BeforeTest
  public void beforeTest() {
	  homePagePOM = new HomePagePOM(driver);
  }
  
  @Test
  public void VerifyLoginSuccessfully() {
	  homePagePOM.login("Mohamed@maildrop.cc", "12345678");
	  homePagePOM.assertLoggedInUserName("Mohamed Mohamed");
  }
  
  @AfterTest
  public void afterTest() throws Exception {
	  driver.quit();
  }

}
