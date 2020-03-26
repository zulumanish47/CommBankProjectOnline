package com.crm.qa.browser;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by p902093d on 22/07/2017.
 */
public class BrowserInternetExplorer implements BrowserInterface
{
    public WebDriver setupBrowser(boolean local, boolean fullscreen) throws Exception
    {
        WebDriver driver_;

        // Cannot set download path in IE.
        // workaround is to set this per browser settings
        // Ctrl+J and then download options, etc

        // TODO - this doesn't work
        // we can navigate to the site, but it fails wiht locator, etc
        // not sure if this was the case before the proxy issue

        DesiredCapabilities cap = DesiredCapabilities.internetExplorer();

        // use config proxy if present
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
                System.setProperty("webdriver.ie.driver", "C:\\Resource\\IEDriverServer\\IEDriverServer.exe");
                driver_ = new InternetExplorerDriver(cap); //cap);

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
                System.setProperty("webdriver.ie.driver", "C:\\Resource\\IEDriverServer\\IEDriverServer.exe");
                DesiredCapabilities p_ieCapabilities = DesiredCapabilities.internetExplorer();

                driver_ = new RemoteWebDriver(new URL(EXEC_SELENIUM_GRID), p_ieCapabilities);

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