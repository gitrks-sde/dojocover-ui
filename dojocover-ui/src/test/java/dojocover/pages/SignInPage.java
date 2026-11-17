package dojocover.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignInPage extends BasePage{

	private static final Logger log=LogManager.getLogger(SignInPage.class);
	
	@FindBy(css = "#hero-sign-in" )
	private WebElement signInButton;
	@FindBy(xpath = "//input[@id='login-username']")
	private WebElement usernameField;
	@FindBy(xpath = "//input[@id='login-password']")
	private WebElement passwordField;
	@FindBy(id="login-submit")
	private WebElement confirmSignInButton;
	@FindBy(xpath = "//div[@class='dc-page-title']/h1")
	private WebElement welcomeHeader;
	@FindBy(xpath = "//button[text()='Sign out']")
	private WebElement signOutButton;
	
	//Actions Methods
	public SignInPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSignIn()
	{
		log.info("clicking on sign-in button to navigate signin page");
		signInButton.click();
		
	}
	
	public void fillSignInCredentials(String username, String password)
	{
		log.info("Entering username : "+username);
		usernameField.sendKeys(username);
		log.info("Entering password");
		passwordField.sendKeys(password);
	}
	
	public void submitSignIn()
	{
		log.info("clicking on sign-in to submit");
		confirmSignInButton.click();
	}
	
	public void verifyURL()
	{
		waitForUrlContains("/dashboard");
		String currentURL=getCurrentPageURL();
		log.info(currentURL);
		Assert.assertTrue(currentURL.contains("/dashboard"),"Sign-in failed!");
		
	}
	
	public void verifyWelcomeMeassage(String fullName)
	{
		String welcomeMessage=welcomeHeader.getText();
		log.info("Welcome Message: "+welcomeMessage);
		Assert.assertTrue(welcomeMessage.contains(fullName),"Signed in customer fullname does not match");
	}
	
	public void signOut()
	{
		signOutButton.isEnabled();
		signOutButton.click();
		BasePage base=new BasePage(this.driver);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("/login?signedOut=1"));
		String currentURL=base.getCurrentPageURL();
		log.info(currentURL);
		Assert.assertTrue(currentURL.contains("/login?signedOut=1"),"Sign-out failed!");
	}
}
