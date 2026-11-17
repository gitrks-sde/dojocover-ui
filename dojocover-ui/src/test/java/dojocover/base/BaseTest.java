package dojocover.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	private String URL="https://testdojo.dev/cover/QA-T633S/";
	private static final ThreadLocal<WebDriver> DRIVER=new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver()
	{
		return DRIVER.get();
	}
	
	@BeforeClass
	public void initializeConnection()
	{
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		DRIVER.set(driver);
		driver.get(URL);
	}
	
	@AfterClass
	public void closeConnection() throws InterruptedException
	{
		if(getDriver() !=null)
		{
		Thread.sleep(5000);
		getDriver().quit();
		}
	}
}
