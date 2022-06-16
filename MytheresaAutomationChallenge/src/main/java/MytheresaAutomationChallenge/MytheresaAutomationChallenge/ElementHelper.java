package MytheresaAutomationChallenge.MytheresaAutomationChallenge;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelper {
	
	private WebElement element;
	private WebDriver driver; 
	private WebDriverWait wait;
	
	public ElementHelper(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(this.driver,Duration.ofSeconds(20));
	}
	public void clickElement(By by){
		wait.until(ExpectedConditions.elementToBeClickable(by));
		element = driver.findElement(by);
		element.click();
	}
	public void sendKeysElement(By by , String value)
	{
		wait.until(ExpectedConditions.elementToBeClickable(by));
		element = driver.findElement(by);
		element.sendKeys(value);
	}
	public void hoverOnElement(By by)
	{
		WebElement element =wait.until(ExpectedConditions.elementToBeClickable(by));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
	}
	
	public void waitForElementToBeInvisible(By by){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public void assertion (By by , String expected)
	{
		wait.until(ExpectedConditions.elementToBeClickable(by));
		element = driver.findElement(by);
	  assertEquals(element.getText(),expected);
	}
	
	public String getText(By by) {
		
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element.getText();
	}
	
	public void acceptAlertPopUp() {
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
}
