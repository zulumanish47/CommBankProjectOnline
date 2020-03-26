package com.crm.qa.browser;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by p902093d on 22/07/2017.
 */
public class BrowserChrome implements BrowserInterface
{
    public WebDriver setupBrowser(boolean local, boolean fullscreen) throws Exception
    {
        WebDriver driver_;

        // setup prefs
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", downloadPath);

        ChromeOptions options = new ChromeOptions();
       // options.setPageLoadStrategy(PageLoadStrategy.NONE);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("disable-infobars");


        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);

        // test
        cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        // test

        if (local)
        {
            try
            {
                System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\ChromeDriver\\chromedriver.exe");
                driver_= new ChromeDriver(cap);

                if (fullscreen)
                    driver_.manage().window().maximize();
            }
            catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }
        else
        {
            try
            {
                System.setProperty("webdriver.chrome.driver", "C:\\Resource\\ChromeDriver\\chromedriver.exe");
                driver_ = new RemoteWebDriver(new URL(EXEC_SELENIUM_GRID), cap);

                if (fullscreen)
                    driver_.manage().window().maximize();
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
                throw e;
            }
        }

        return driver_;
    }
}