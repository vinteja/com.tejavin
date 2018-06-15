package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class ScreenFunctions extends com.GenericFunctions.GenericFunctions
{
	//*******************Verify Empty and Keyword giver Text box**************************
	@FindBy(how=How.XPATH,using="//input[@id='search_query_top']")
	public static WebElement Txt_homepage_textbox;
	
	@FindBy(how=How.XPATH,using="//button[@name='submit_search']")
	public static WebElement Btn_homepage_search;
	
	@FindBy(how=How.XPATH,using="//p[normalize-space(text())='Please enter a search keyword']")
	public static WebElement Txt_homepage_entersearch;
	
	@FindBy(how=How.XPATH,using="//h5[@itemprop='name']//a[normalize-space(text())='Faded Short Sleeve T-shirts']")
	public static WebElement Txt_homepage_searchedItem;
	
	
	public static boolean validatesrch()
	{
		boolean status=true;
		{
			try
			{
				Btn_homepage_search.click();
				if(Txt_homepage_entersearch.isDisplayed())
					{
					String color=Txt_homepage_entersearch.getCssValue("color");
					logEvent("Pass","Test passed for empty click on search button::" +color);
					String font=Txt_homepage_entersearch.getCssValue("font-size");
					logEvent("Pass","Text font-size is::" +font);
					}
				else
				{
					logEvent("Fail","Test failed to get colour and font of Text");
				}
			
				Thread.sleep(3000);
				Txt_homepage_textbox.sendKeys("t-shirts");
				Btn_homepage_search.click();
				Thread.sleep(3000);
				if(Txt_homepage_textbox.isDisplayed())
				{
					logEvent("Pass","searched item is displayed");
				}
				else 
				{
					logEvent("Fail","searched item is not displayed");
				}
			}
				catch(Exception e)
				{
					status=false;
				}
			}
		return status;
	}
	
}

