package com.crm.qa.base;



import java.io.File;
import java.util.*;
import java.util.concurrent.CancellationException;


public abstract class BasePage
{
//    public BasePage() {}
//
//    private DSLNew _dsl = new DSLNew();
//
//    // Note
//    private Object _lock = new Object();
//
//
//    protected final void setDriver(WebDriver driver)
//    {
//        _dsl.initialise(driver);
//    }
//
//
//
//    protected final <T extends TestBase, U> T launchPage(Class<T> t) throws Exception
//    {
//        return launchPageObject(t, null);
//    }
//
//    protected final <T extends TestBase, U> T launchPageObject(Class<T> t, U... parameters) throws Exception
//    {
//        try
//        {
//            T page = t.newInstance();
//
//////            // NOTE !!!!
////////            page.initialise(_dsl.driver, _dataStore);
//////            ((TestBase) page).launchPageInitialise(_dsl, _dataStore);
//////
//////            _dsl.WaitforPageLoad(); // this should should technically be in the initialise method, but currently working so leave
////
////            if (parameters == null)
////                page.run();
////            else
////                page.run(parameters);
////
////            // remove event listener
//            return page;
//        }
//        catch (CancellationException e)
//        {
////            ReportWriter.writeLogToFile(getSumaryEntityReference(), "** Too many errors - Skipping **" + System.lineSeparator());
////
////            // check if stack trace issue
////            // this is for the main window check
////            // above code - _dsl.monitorNewStrackTraceWindow() will check for child popup stack trace windows
////            ReportWriter.checkStackTrace(getSumaryEntityReference());
//        }
//        return null;
//        // throw all other errors
//    }
//
////    protected final <T extends PageInterface> void launchPage(Class<T> t) throws Exception
////    {
////        try
////        {
////            T page = t.newInstance();
////            page.initialise(_dsl.driver, _dataStore);
////
////            // TODO : add generic wait for page loaded code
////            _dsl.WaitforPageLoad(); // this should should be in the initialise method, but currently working so leave
////
////            page.run();
////        } catch (CancellationException e)
////        {
////            ReportWriter.writeLogToFile(getSumaryEntityReference(), "** Too many errors - Skipping **" + System.lineSeparator());
////        }
////
////        // throw all other errors
////    }
//
//    public final String getClassName()
//    {
//        String className = this.getClass().toString();
//        return className.substring(className.lastIndexOf(".") + 1);
//    }
//
//    protected final String getCurrentUrl()
//    {
//        return _dsl.getCurrentUrl();
//    }
//
//     protected final void sleep(int milliseconds) throws Exception
//    {
//        Thread.currentThread().sleep(milliseconds);
//    }
//
////      protected final void datepicker() throws Exception
////    {
////        //img[contains(@class,'datepicker')]
////        String btn_datepicker ="//img[@class='ui-datepicker-trigger']";
////        String btn_datetoday="//button[text()='Today']";
////
////        clickElementCustomLocator(btn_datepicker,"click on date icon");
////        clickElementCustomLocator(btn_datetoday,"click today");
////
////    }
////
//

}