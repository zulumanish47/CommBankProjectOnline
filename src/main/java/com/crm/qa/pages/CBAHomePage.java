package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CBAHomePage extends TestBase {



   //locators
	private final String travelProductLink="//*[.='Travel products']";
	private final String bankingLink="//a[contains(@title,'Banking')]";
	public final String travelMoneyDiscoverMore="//div[@class='card-container']//a[contains(@title,'Discover more')]";
	public final String exchangeRates="//div[@id='currency']//following::a[contains(@title,'Exchange rates')]";
	public final String ratesAndFees="//a[contains(.,'Rates & fees')]";

	public final String logOnBtn ="//a[@role='button'][@class='log-on-text']";
	public final String loginFrame ="//iframe[@class='netbank-login']";
	public final String userName="txtMyClientNumber_label";//span[.='NetBank client number']";
	public final String password="txtMyPassword$field";


	// Initializing the Page Objects:
	public CBAHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void ClickTravelProductLink() throws Exception{

		javaScriptClick(travelProductLink,"Clicked on travel product link");
	}
	
	public void clickOnDiscoverMoreLink() throws Exception{
		javaScriptClick(travelMoneyDiscoverMore,"Clicked on travel money discover more");
	}

	public void clickOnNetBankingLink() throws Exception{
		clickElement(bankingLink,"Clicked on banking link");
	}
	public void clickOnLogOnLink() throws Exception{
		clickElement(logOnBtn,"Clicked on banking link");
	}

	public void switchToLoginFormFrame() throws Exception{
        switchToFrame(loginFrame,"Switch to login frame");

	}



}
