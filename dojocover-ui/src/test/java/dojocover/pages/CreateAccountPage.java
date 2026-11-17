package dojocover.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreateAccountPage {
	
	private static final Logger log=LogManager.getLogger(CreateAccountPage.class);
	private final WebDriver driver;
	
	//Locators
	private By createAccountButton=By.cssSelector("#nav-register");
	private By fullnameField=By.cssSelector("#reg-full-name");
	private By usernameField=By.cssSelector("#reg-username");
	private By phoneNumberField=By.cssSelector("#reg-phone");
	private By fieldDOB=By.cssSelector("#reg-dob");
	private By passwordField=By.cssSelector("#reg-password");
	private By confirmCheckBox=By.cssSelector("#reg-terms");
	private By submitButton=By.cssSelector("#reg-submit");
	private By welcomeTitle=By.cssSelector("#done-title");
	private By newUsername=By.cssSelector("#new-username");
	
	public CreateAccountPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Actions Methods
	
	public void clickOnCreateAccount()
	{
		log.info("clicking on create account");
		driver.findElement(createAccountButton).click();
	}
	
	public void fillAccountDetails(String fullName,String userName, long phone,String DOB,String password)
	{
		log.info("Filling the form with mandatory details");
		driver.findElement(fullnameField).sendKeys(fullName);
		driver.findElement(usernameField).sendKeys(userName);
		driver.findElement(phoneNumberField).sendKeys(String.valueOf(phone));
		driver.findElement(fieldDOB).sendKeys(DOB);
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void confirmAndSubmit()
	{
		log.info("Submitting the form");
		driver.findElement(confirmCheckBox).click();
		driver.findElement(submitButton).click();
	}
	
	public void verifyAccountCreatedSuccessfully()
	{
		String welcomeMessasge=driver.findElement(welcomeTitle).getText();
		Assert.assertTrue(welcomeMessasge.contains("Welcome to DojoCover"));
		log.info("Account Created successfully");
		String newUser=driver.findElement(newUsername).getText();
		log.info("New Usernmae: "+newUser);
		
	}

}
