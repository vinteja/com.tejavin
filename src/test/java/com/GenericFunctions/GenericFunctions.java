package com.GenericFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

public class GenericFunctions extends TestNGListeners 
{
	public static  WebDriver driver;

	/*************************************************
	Function Name:launchApplication
	
	Purpose:-This Function is used to launch the HRM Application when ever the user is required
	
	Input Parameters:-User must send in which browser does the application need to be launch
	
	Output Parameters:-This method will return a boolean value stating wheter the user logged into in the system
	
	Author:-Veera Prathap Malepati
	
	Creation date:-12/30/2017
	**************************************************/
	public static boolean launchApplication(String browser) 
	{
		
		boolean status=true;
		switch (browser.toLowerCase()) 
		{
		case "ie":
			
			break;

		case "firefox":
			
			driver= new FirefoxDriver();
			
			String url=getCommontestdata("Url");
			
			System.out.println(url);
			
			driver.get(url);
			
			driver.manage().window().maximize();
			
			//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			
			break;
			
		case "chrome":
			System. setProperty("webdriver.chrome.driver", "C:\\Users\\tm\\Downloads\\chromedriver.exe");		
			
			driver =new ChromeDriver();
			String url1=getCommontestdata("Url");
			System.out.println(url1);
			driver.manage().window().maximize();

			break;
			
			
			
		default:
			break;
		}
		
	return status;	
		
	}
	

	/*************************************************
	
	Function Name:GetCommonTestdata 
	
	Purpose:-This Function is used to get the common test data which can be accessed commonly for each testcase such as Environment,Url,Username,Password
	
	Input Parameters:-User must send an argument stating what data that is required
	
	Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
	
	Author:-Veera Prathap Malepati
	
	Creationn date:-12/31/2017
	
	
	**************************************************/
		
	public static String getCommontestdata(String data)
	{
		
		String strQuery="Select "+ data+" from CommonTestdata";
		
		System.out.println(strQuery);
		
		Recordset recordset;
		
		String fetcheddata="";
		
		
		try {
			
			recordset = TestNGListeners.connection.executeQuery(strQuery);
			
			while(recordset.next()){
				
				System.out.println("Data is found and the data is " +recordset.getField(data));
				
				fetcheddata=recordset.getField(data);
				break;
				
				
				}
				 
				recordset.close();
			
			
		} catch (FilloException e) {
			
			System.out.println("No Records Found");
		}
		 
		return fetcheddata;
		
		
	}
	
	
	public static String getdata(String sheetname,String userdata,int itr)
	{
		
		String strQuery="Select "+ userdata+" from "+sheetname+ " where Tc_Name='"+crntclass+"' and Iteration="+itr;
		System.out.println(strQuery);
		
		Recordset recordset;
		
		String fetcheddata="";
		
		
		try {
			
			recordset = TestNGListeners.connection.executeQuery(strQuery);
			
			while(recordset.next()){
				
				System.out.println("Data is found and the data is " +recordset.getField(userdata));
				
				fetcheddata=recordset.getField(userdata);
				break;
				
				
				}
				 
				recordset.close();
			
			
		} catch (FilloException e) {
			
			System.out.println("No Records Found");
		}
		 
		return fetcheddata;
		
		
	}
	public static int getLastIterationNumber(String sheetname) {

		String strQuery = "Select Iteration from " + sheetname + " where Tc_Name='" + crntclass + "'";
		System.out.println(strQuery);

		Recordset recordset;

		int iteration = 0;

		try {

			recordset = TestNGListeners.connection.executeQuery(strQuery);

			while (recordset.next()) {

				System.out.println("Data is found and the data is " + recordset.getField("Iteration"));

				iteration++;

			}

			recordset.close();

		} catch (FilloException e) {

			System.out.println("No Records Found");
		}

		return iteration;

	}

	
	public static void waitForElement(WebElement element)
	{
	
		for(int i=1;i<=10;i++)
		{
		try
		{
			System.out.println("Wait is executing");
			Actions acc=new Actions(driver);
			acc.moveToElement(element).build().perform();
			
			System.out.println("Element Found");
			break;
			
		}
		catch(Exception e)
		{
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
			
		}
		}	
		
	}
	
	
	public static boolean hoverAndClick(WebElement element)
	{
	boolean status=true;
		
		try
		{
			waitForElement(element);
			Actions acc=new Actions(driver);
			acc.moveToElement(element).click().build().perform();
		
		
			
			
		}
		catch(Exception e)
		{
			
			status=false;
		
		}	
		
	
	
	return status;
	}	
	
	public static void forceClick(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", element);
		
	}
	public static boolean setText(WebElement element,String value)
	{
		boolean status=true;
		try
		{
			element.clear();
			element.click();
			element.sendKeys(value);
		}
		catch(Exception e)
		{
			status=false;
		}
		return status;
	}
	
	public static boolean selectDropDown(WebElement element,String value)
	{
		boolean status=true;
		try
		{
			element.click();
			Select option=new Select(element);
			option.selectByValue(value);
		}
		catch(Exception e)
		{
			//status=false;
			e.printStackTrace();
		}
		return status;
	}
	

}
