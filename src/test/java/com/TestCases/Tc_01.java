package com.TestCases;

import java.sql.DriverManager;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ScreenFunctions.ScreenFunctions;
import com.ScreenFunctions.SignInPage;



public class Tc_01 extends com.GenericFunctions.GenericFunctions
{
	@Test(priority=1,enabled=false)
	public static void verifySearch()
	{
		launchApplication("firefox");
		ScreenFunctions sf=PageFactory.initElements(driver,ScreenFunctions.class);
		sf.validatesrch();
	}
	@Test(priority=0)
	public static void signin()
	{
		launchApplication("firefox");
		SignInPage sp=PageFactory.initElements(driver,SignInPage.class);
		sp.Signin();
		sp.Createaccount();
		
	}
	
	
	
		
	}

