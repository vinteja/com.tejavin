package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class SignInPage extends com.GenericFunctions.GenericFunctions
{
	//**********************Click on SignIn******************************
	@FindBy(how=How.XPATH,using="//a[normalize-space(text())='Sign in']")
	public static WebElement Btn_Register_Signin;
	
	public static void Signin()
	{
		Btn_Register_Signin.click();
	}
	//*******************************************************************
	
	//*******************Validate Create an account**********************
	//click on CREATE AN ACCOUNT with empty text box and validate the error message 
	//enter unregistered email-address******should navigate to registration page
	//Enter already registered address "Message should be displayed"
	
	
	@FindBy(how=How.XPATH,using="//button[@id='SubmitCreate']/child::span")
	public static WebElement Btn_Register_createanAccount;
	
	@FindBy(how=How.XPATH,using="//div[@class='alert alert-danger']//ol//li")
	public static WebElement Txt_Register_ErrorMessage;
		
	public static boolean Createaccount()
	{
		boolean status=true;
		status=hoverAndClick(Btn_Register_createanAccount);
		try
		{
			if(Txt_Register_ErrorMessage.isDisplayed())
			{
				String color=Txt_Register_ErrorMessage.getCssValue("color");
				logEvent("Pass","Colour of error Msg for clicking on empty txt box is ::"+color);	
			}
			else
			{
				logEvent("Fail","Colour of error Msg for clicking on empty txt box is not displayed");
			}
		}
			catch(Exception e)
			{
				status=false;
			}
			
		return status;
	}

	
	
	
	
}
