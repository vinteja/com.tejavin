package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.CreateAccount;
import com.ScreenFunctions.ScreenFunctions;

public class Tc_02 extends GenericFunctions
{
	@Test(priority=0)
	public static void verifyCreatAccount()
	{
		launchApplication("firefox");
		CreateAccount ca=PageFactory.initElements(driver,CreateAccount.class);
		ca.createAccount();
	
	}
	
	
}
