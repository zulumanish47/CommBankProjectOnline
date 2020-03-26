package com.crm.qa.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Created by p902093d on 22/07/2017.
 */
public class BrowserSafari implements BrowserInterface
{
    public WebDriver setupBrowser(boolean local, boolean fullscreen) throws Exception
    {
        WebDriver driver_;

        if (local)
        {
            try {
                driver_ = new SafariDriver();
                if (fullscreen)
                    driver_.manage().window().maximize();
            } catch(Exception e){
                e.printStackTrace();
                throw e;
            }
        }
        else
        {
            // TODO : no remote Safari in existing code
            driver_ = null;
        }

        return driver_;
    }
}
