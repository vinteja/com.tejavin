package com.ScreenFunctions;



import java.security.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class ApplyLeave extends GenericFunctions {
	
	//**************************** Apply Leave *************************
	
		@FindBy(how=How.XPATH,using="//option[text()='Personal Leave']")
		
		public static WebElement Option_PersonalLeave;
		
		@FindBy(how=How.XPATH,using="//option[text()='Annual Leave']")
		
		public static WebElement Option_AnnualLeave;
		
		@FindBy(how=How.XPATH,using="//*[@id='applyleave_txtFromDate']")
		
		public static WebElement Text_Fromdate;
		
		@FindBy(how=How.XPATH,using="//*[@id='applyleave_txtToDate']")
		
		public static WebElement Text_Todate;
		
		@FindBy(how=How.XPATH,using="//*[@id='applyleave_txtComment']")
		
		public static WebElement Text_Comment;
		
		
		@FindBy(how=How.ID,using="//input[@id='applyBtn']")
		
		public static WebElement Button_Apply;
		
		public static boolean ApplyLeave_Validation()
		{
			
			boolean status=true;
			//Select Leave Type
			try {
				
				String leavetype=getdata("ApplyLeave","Leave_Type", 1);
				
				waitForElement(driver.findElement(By.xpath("//option[text()='"+leavetype.trim()+"']")));
				
				driver.findElement(By.xpath("//option[text()='"+leavetype+"']")).click();
			
				System.out.println("Leave type "+leavetype+ " is selected Sucessfully");
				
			}
			catch(Exception e)
			{
				status=false;
				
			}
			
			//Based on the Leave type status
			
			if(status)
			{
				
				try {
					
					String fromdate=getdata("ApplyLeave","From_Date", 1);
					waitForElement(Text_Fromdate);
					
					hoverAndClick(Text_Fromdate);
					
					Text_Fromdate.clear();
					
					Text_Fromdate.sendKeys(fromdate);
					
					System.out.println("From date is enter sucessfully");
				}
				catch(Exception e)
				{
					status=false;
					
				}
				
				
				try {
					
					String todate=getdata("ApplyLeave","To_Date", 1);
					waitForElement(Text_Todate);
					hoverAndClick(Text_Todate);
					Text_Todate.clear();
					Text_Todate.sendKeys(todate);
					Text_Todate.sendKeys(Keys.TAB);
					System.out.println("To date is enter sucessfully");
				}
				catch(Exception e)
				{
					status=false;
					
				}
				
				
				try {
					
					String comment=getdata("ApplyLeave","Comment", 1);
					waitForElement(Text_Comment);
					
					Text_Comment.sendKeys(comment);
					System.out.println("Comment is enter sucessfully");
				}
				catch(Exception e)
				{
					status=false;
					
				}
				
				try {
					
//					waitForElement(Button_Apply);
//					
//					hoverAndClick(Button_Apply);
					
					driver.findElement(By.xpath("//input[@id='applyBtn']")).click();
					
					//forceClick(Button_Apply);
					System.out.println("Apply button is clicked sucessfully");
				}
				catch(Exception e)
				{
					status=false;
					
				}
				
				
				
			}
			
			
			
			return status;
		}
	

}
