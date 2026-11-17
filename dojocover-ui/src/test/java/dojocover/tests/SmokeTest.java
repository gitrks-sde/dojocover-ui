package dojocover.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import dojocover.base.BaseTest;

public class SmokeTest extends BaseTest{

	@Test
	public void coverPageOpens()
	{
		Assert.assertTrue(getDriver().getCurrentUrl().contains("testdojo.dev"));
	}
}
