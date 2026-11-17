package dojocover.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import dojocover.base.BaseTest;


public class TestListener implements ITestListener {

	private static final Logger log=LogManager.getLogger(TestListener.class);
	private static final DateTimeFormatter timmeStamp=DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		log.info("PASSED: {}"+result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		this.takeScreenshot();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
	public void takeScreenshot()
	{
		BaseTest base=new BaseTest();
		File srcFile=((TakesScreenshot)base.getDriver()).getScreenshotAs(OutputType.FILE);
		String desinationPath=System.getProperty("user.dir")+"/screenshots/"+LocalDateTime.now().format(timmeStamp)+"screenshot.png";
		try
		{
			Files.createDirectories(Paths.get(System.getProperty("user.dir")+"/screenshots/"));
			Files.copy(srcFile.toPath(), Paths.get(desinationPath));
			System.out.println("saved successfully");
			
		}catch(IOException e)
		{
			System.out.println("Failed to save screenshot");
		}
	}
	
}
