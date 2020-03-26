package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;

import com.crm.qa.browser.BrowserFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static DSLNew _dsl;
	
	public TestBase(){
		try {
			prop = new Properties();
			_dsl = new DSLNew();
			_dsl.initialise(driver);
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		try
		{
			driver = BrowserFactory.getBrowser(browserName,true);
		}
		catch (Exception e)
		{
           System.out.println("browser driver not initialised");

		}

		e_driver = new EventFiringWebDriver(driver);

		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}

	protected final <T extends TestBase, U> T launchPage(Class<T> t) throws Exception
	{
		return launchPageObject(t, null);
	}

	protected final <T extends TestBase, U> T launchPageObject(Class<T> t, U... parameters) throws Exception
	{
		try
		{
			T page = t.newInstance();
			return page;
		}
		catch (Exception e)
		{
			throw new Exception ("Cannot launch class"+t.toString());
		}

	}

	//all wrappers for actual selenium calls


	protected final void enterValue(String locator,String textToBeEntered , String message) throws Exception
	{
		_dsl.enterValue(locator ,textToBeEntered ,message);
	}
	protected final void clickElement(String locator, String message) throws Exception
	{
 		_dsl.clickElement(locator, message);
	}

	protected final void javaScriptClick(String locator , String message) throws Exception
	{
		_dsl.javascriptClick(locator, message);
	}

	protected final boolean elementDisplayed(String locator, String elementName) throws Exception
	{
		return _dsl.elementDisplayed(locator, elementName);
	}

	protected final void switchToFrame(String locator , String message) throws Exception {

		 _dsl.SwitchToFrame(locator ,message);
	}
	protected final void swithToDefaultContent() throws Exception {

		_dsl.SwitchTodefaultContent();
	}

}
