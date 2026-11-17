package dojocover.tests.regression;

import org.testng.annotations.Test;

import dojocover.base.BaseTest;
import dojocover.pages.GetQuotes;

public class MotorQuote extends BaseTest {

	@Test
	public void verifyMotorPageLoaded()
	{
		GetQuotes getQuotes=new GetQuotes(getDriver());
		getQuotes.navigateToGetaQuote();
		getQuotes.verifyMotorQuotePage();
	}
}
