package MytheresaAutomationChallenge.MytheresaAutomationChallenge.TestCaseOne;

import org.testng.annotations.Test;

import MytheresaAutomationChallenge.MytheresaAutomationChallenge.TestBase;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterTest;

public class VerifyNoJsErrorsTest extends TestBase{



	
  @BeforeTest
  public void beforeTest() {
  }
  
  @Test
  public void VerifyNoJsErrors() {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);  
		List<LogEntry> lg =logEntries.getAll();
		assertEquals(lg.size(),0 );
  }
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
