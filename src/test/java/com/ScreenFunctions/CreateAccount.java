/**
 * 
 */
package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

/**
 * @author USER
 *
 */
public class CreateAccount extends GenericFunctions
{
	//Locate Sing-in button
	@FindBy(how=How.XPATH,using="//a[normalize-space(text())='Sign in']")
	public static WebElement Lnk_CreateAccount_Signin;
	
	//Locate Email text-box
	@FindBy(how=How.XPATH,using="//input[@id='email_create']")
	public static WebElement Txt_CreateAccount_Email;
	
	//Locate Create account Button
	@FindBy(how=How.XPATH,using="//button[@id='SubmitCreate']")
	public static WebElement Btn_CreateAccount_CreateAccount;
	
	/*Locate Radio button
	@FindBy(how=How.XPATH,using="//input[@id='id_gender1']")
	public static WebElement Rdo_CreateAccount_Mr;
	
	//Locate FirstName Text box
	@FindBy(how=How.XPATH,using="//input[@id='customer_firstname']")
	public static WebElement Txt_CreateAccount_FirstName;
	
	//Locate lastName Text box
	@FindBy(how=How.XPATH,using="//input[@id='customer_lastname']")
	public static WebElement Txt_CreateAccount_LastName;
	
	//Locate Email Text box
	@FindBy(how=How.XPATH,using="//input[@id='email']")
	public static WebElement Txt_CreateAccount_mailID;
	
	//Locate Password Text box
	@FindBy(how=How.XPATH,using="//input[@id='passwd']")
	public static WebElement Txt_CreateAccount_Psswd;
	
	//Locate Date drop down
	@FindBy(how=How.XPATH,using="//select[@id='days']")
	public static WebElement Txt_CreateAccount_Date;
	
	//Locate Month drop down
	@FindBy(how=How.XPATH,using="//select[@id='months']")
	public static WebElement Txt_CreateAccount_Month;
	
	//Locate Year drop down
	@FindBy(how=How.XPATH,using="//select[@id='years']")
	public static WebElement Txt_CreateAccount_Year;
	
	//Locate Sign up
	@FindBy(how=How.XPATH,using="//input[@id='newsletter']")
	public static WebElement Chk_CreateAccount_Signup;
	
	//Locate FName Text box
	@FindBy(how=How.XPATH,using="//input[@id='firstname']")
	public static WebElement Txt_CreateAccount_FName;
	
	//Locate LName Text box
	@FindBy(how=How.XPATH,using="//input[@id='lastname']")
	public static WebElement Txt_CreateAccount_LName;
	
	//Locate Address Text box
	@FindBy(how=How.XPATH,using="//input[@id='company']")
	public static WebElement Txt_CreateAccount_Address;
	
	//Locate Adderss1 Text box
	@FindBy(how=How.XPATH,using="//input[@id='address1']")
	public static WebElement Txt_CreateAccount_Address1;*/
	
	public static boolean createAccount()
	{
		boolean status=true;
		
		Lnk_CreateAccount_Signin.click();
		if(status)
		{
			logEvent("Pass","Sign-in operation is performed Successfully");
		}
		else
		{
			logEvent("Fail","Sign-in operation is not performed Successfully");
		}
		waitForElement(Txt_CreateAccount_Email);
		try
		{
		String useremail=getdata("createAccount","user-email",1);
		status=setText(Txt_CreateAccount_Email, useremail);
		if(status)
		{
			logEvent("Pass","email is entered successfully");
		}
		else
		{
			logEvent("Fail","email is not entered successfully");
		}
		}
		catch(Exception email)
		{
			email.printStackTrace();
		}
		waitForElement(Btn_CreateAccount_CreateAccount);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return status;
}
	
	
	
	
	
	
	
	
	
	
}
