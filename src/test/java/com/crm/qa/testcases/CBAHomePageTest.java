package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CBAHomePage;

public class CBAHomePageTest extends TestBase{

	CBAHomePage cbaHomePage;

   //call constructor in test base which will initialise the property file to upload data from spreadsheet / json etc
	public CBAHomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		cbaHomePage = launchPage(CBAHomePage.class);

	}
	
	@Test(priority=1)
	public void TravelProductTest() throws Exception{
		cbaHomePage.ClickTravelProductLink();
		cbaHomePage.clickOnDiscoverMoreLink();
		Assert.assertTrue(elementDisplayed(cbaHomePage.exchangeRates,"Exchange rate link"));
		Assert.assertTrue(elementDisplayed(cbaHomePage.ratesAndFees,"Exchange rate link"));
	}
	
	@Test(priority=2)
	public void checkNetBankLink() throws Exception{
		cbaHomePage.clickOnNetBankingLink();
		cbaHomePage.clickOnLogOnLink();
		cbaHomePage.switchToLoginFormFrame();
		Assert.assertTrue(elementDisplayed(cbaHomePage.userName,"net banking user name present"));
		Assert.assertTrue(elementDisplayed(cbaHomePage.password,"net banking user name present"));

	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
