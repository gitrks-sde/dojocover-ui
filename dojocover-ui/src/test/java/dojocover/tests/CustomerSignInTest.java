package dojocover.tests;

import org.testng.annotations.Test;

import dojocover.base.BaseTest;
import dojocover.models.SignInUser;
import dojocover.pages.SignInPage;
import dojocover.utils.JsonDataReader;
public class CustomerSignInTest extends BaseTest{

	@Test
	public void validateCustomerSignIn()
	{
		String path=System.getProperty("user.dir")+"/src/test/resources/testdata/signinusers.json";
		SignInPage signin=new SignInPage(getDriver());
		SignInUser user=JsonDataReader.getUserByName(path, "user2");
		signin.clickOnSignIn();
		signin.fillSignInCredentials(user.getUsername(),user.getPassword());
		signin.submitSignIn();
	}
	
	@Test(dependsOnMethods = "validateCustomerSignIn")
	public void validateSignInSuccessfull()
	{
		SignInPage signin=new SignInPage(getDriver());
		signin.verifyURL();
		signin.verifyWelcomeMeassage("TestUser");
		signin.signOut();
	}
	
	
}
