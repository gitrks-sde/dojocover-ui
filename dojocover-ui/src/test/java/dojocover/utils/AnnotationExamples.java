package dojocover.utils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationExamples {

	@BeforeMethod
	public void entry()
	{
		System.out.println("Starting");
	}
	
	@AfterMethod
	public void exit()
	{
		System.out.println("Stopped");
	}
	
	
	@Test
	public void testMethod1()
	{
		System.out.println("Method1");
	}
	
	@Test
	public void testMethod2()
	{
		System.out.println("Method2");
	}
}