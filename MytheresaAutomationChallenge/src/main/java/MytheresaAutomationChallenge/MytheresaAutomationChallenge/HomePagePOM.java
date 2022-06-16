package MytheresaAutomationChallenge.MytheresaAutomationChallenge;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePagePOM extends ElementHelper{
	
	public HomePagePOM(WebDriver driver) {
		super(driver);
	}
	
	private By MyAccountPath = By.id("myaccount");
	private By EmailPath = By.id("email");
	private By PasswordPath = By.id("pass");
	private By LoginPath = By.id("send2");
	private By WelcomeMsgPath = By.xpath("//p[@class='welcome-msg']");
	
	public void login(String user, String password)
	{
		hoverOnElement(MyAccountPath);
		sendKeysElement(EmailPath, user);
		sendKeysElement(PasswordPath, password);
		clickElement(LoginPath);
	}
	public void assertLoggedInUserName(String userName)
	{
		assertEquals(getText(WelcomeMsgPath), userName);
	}

}
