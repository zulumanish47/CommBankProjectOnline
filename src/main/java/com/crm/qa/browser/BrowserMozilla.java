package com.crm.qa.browser;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by p902093d on 22/07/2017.
 */
public class BrowserMozilla implements BrowserInterface
{
    public WebDriver setupBrowser(boolean local, boolean fullscreen) throws Exception
    {
        WebDriver driver_;

        // setup prefs
        // these are all in Mozilla config
        // type in taskbar
        //      about:config
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.dir", downloadPath);
        profile.setPreference("browser.helperApps.neverAsk.openFile","application/msword, application/csv, application/ris, text/csv, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream, application/PDF");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword, application/csv, application/ris, text/csv, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream, application/PDF");
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
        profile.setPreference("browser.download.manager.closeWhenDone", false);
        profile.setPreference("pdfjs.disabled", true); // disables firefox from previewing PDFs snce PDF.js has been integrated into firefox to provide built in ability to display PDFs inside the browser
        profile.setPreference("extensions.shield-recipe-client.enabled", false);
        profile.setPreference("browser.urlbar.timesBeforeHidingSuggestionsHint", 0);

//        profile.setPreference("network.negotiate-auth.allow-proxies", true);
        profile.setPreference("keyword.enabled", false);

        DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setCapability(FirefoxDriver.PROFILE, profile);
        cap.setCapability("marionette", false);

//        // use config proxy if present
//        String proxyString = Config.getValue(Config.KEY.PROXY);
//        if (proxyString != null)
//        {
//            Proxy proxy = new Proxy();
//            proxy.setAutodetect(false);
//            proxy.setHttpProxy(proxyString);
//            proxy.setFtpProxy(proxyString);
//            proxy.setSslProxy(proxyString);
//            cap.setCapability(CapabilityType.PROXY, proxy);
//        }

        if (local)
        {
            try
            {
                System.setProperty("webdriver.firefox.marionette", "C:\\Resource\\geckodriver.exe");
                driver_ = new FirefoxDriver(cap);

                if (fullscreen)
                    driver_.manage().window().maximize();
            }
            catch (Exception e)
            {
                e.printStackTrace();
                throw e;
            }
        }
        else
        {
            try
            {
                // selenium and or driver version conflict?
                // does not work remotely

                System.setProperty("webdriver.gecko.driver", "C:\\Resource\\geckodriver.exe");
                driver_ = new RemoteWebDriver(new URL(EXEC_SELENIUM_GRID), cap);

                if (fullscreen)
                    driver_.manage().window().maximize();
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
                throw e;
            }
        }

        return driver_;
    }
}