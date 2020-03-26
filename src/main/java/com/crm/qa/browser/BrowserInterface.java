package com.crm.qa.browser;

import org.openqa.selenium.WebDriver;

/**
 * Created by p902093d on 22/07/2017.
 */
public interface BrowserInterface
{
    final String EXEC_SELENIUM_GRID = "http://localhost:4444/wd/hub";
    final String downloadPath = "C:\\ccviews\\Results";

    public WebDriver setupBrowser(boolean local, boolean fullscreen) throws Exception;

    default public WebDriver setupBrowser(boolean local) throws Exception
    {
        return setupBrowser(local, true);    
    }
}