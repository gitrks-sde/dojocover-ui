package dojocover.tests;

import org.testng.annotations.Test;

import dojocover.base.BaseTest;
import dojocover.pages.CreateAccountPage;

public class CreateAccountTest extends BaseTest {
	
	@Test(testName = "Creating New Account for User")
	public void createNewAccount()
	{
		CreateAccountPage createPage=new CreateAccountPage(getDriver());
		createPage.clickOnCreateAccount();
		createPage.fillAccountDetails("TestUser", "coveruser428", 8870056512l, "2000-02-01", "User@123321");
		createPage.confirmAndSubmit();
		createPage.verifyAccountCreatedSuccessfully();
	}

}
