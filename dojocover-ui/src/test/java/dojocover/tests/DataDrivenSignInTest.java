package dojocover.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dojocover.base.BaseTest;
import dojocover.models.SignInUser;
import dojocover.pages.SignInPage;
import dojocover.utils.JsonDataReader;

public class DataDrivenSignInTest extends BaseTest {
	
	//Dataprovider reads the json file for data
	@DataProvider(name="signInJsonData")
	public Object[][] getSignInUsers()
	{
		return JsonDataReader.getJsonData("testdata/signinusers.json");
	}
	
	@Test(dataProvider = "signInJsonData")
	public void signInWithJsonData(SignInUser users)
	{
		SignInPage signin=new SignInPage(getDriver());
		signin.clickOnSignIn();
		signin.fillSignInCredentials(users.getUsername(),users.getPassword());
		signin.submitSignIn();
		signin.verifyURL();
		signin.signOut();
	}

}
