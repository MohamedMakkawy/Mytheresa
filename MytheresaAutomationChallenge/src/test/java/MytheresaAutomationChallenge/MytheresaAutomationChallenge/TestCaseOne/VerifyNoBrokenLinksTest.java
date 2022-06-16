package MytheresaAutomationChallenge.MytheresaAutomationChallenge.TestCaseOne;
import org.testng.annotations.Test;

import MytheresaAutomationChallenge.MytheresaAutomationChallenge.TestBase;

import org.testng.annotations.BeforeTest;

import java.util.List;

import static org.testng.Assert.assertEquals;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class VerifyNoBrokenLinksTest extends TestBase{

	String url = "";
    HttpURLConnection huc = null;
    int respCode = 200;
  @BeforeTest
  public void beforeTest() {
	  
  }
  
  @Test
  public void VerifyNoBrokenLinks() {
	  int brokenLinksCount = 0;
	  List<WebElement> links = driver.findElements(By.tagName("a"));
      
      Iterator<WebElement> it = links.iterator();
      
      while(it.hasNext()){
          
          url = it.next().getAttribute("href");
          try {
              huc = (HttpURLConnection)(new URL(url).openConnection());
              
              huc.setRequestMethod("HEAD");
              
              huc.connect();
              
              respCode = huc.getResponseCode();
              
              if(url == null || url.isEmpty()){
            	  System.out.println(url+" is either not configured for anchor tag or it is empty");
            	  brokenLinksCount++;
            	                  continue;
            	 }
              if(respCode == 200 || respCode>= 300){
            	  if(respCode < 400)
            		  continue;
              }
            	  else if(respCode >= 400){
            		  brokenLinksCount++;
                  System.out.println(url+" is a broken link");
                  continue;
              }
                  
          } 
          catch (Exception e) {
              e.printStackTrace();
          }    
          assertEquals(brokenLinksCount, 0);
      }
  }
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
