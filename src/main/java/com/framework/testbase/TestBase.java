package com.framework.testbase;

import com.framework.helper.LoggerHelper;
import com.framework.helper.ResourceHelper;
import com.framework.helper.WaitHelper;
import com.framework.helper.browserConfiguration.*;
import com.framework.utils.Utility;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    private Logger log = LoggerHelper.getLogger(TestBase.class);
    public static File reportDirectory;

    @BeforeSuite
    public void beforeSuite() {
    }

    @BeforeTest
    public void beforeTest() {

    }

    @BeforeClass
    public void beforeClass() {
        ObjectReader.reader = new PropertyReader();
        reportDirectory = new File(ResourceHelper.getResourcePath("/src/main/resources/screenshots"));
        setUpDriver(ObjectReader.reader.getBrowserType());


    }

    @BeforeMethod
    public void beforeMethod(Method method) {
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Utility.captureScreenShot(driver, result.getName());

        }
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    public WebDriver getBrowserObject(BrowserType btype) {
        try {
            switch (btype) {
                case Chrome:
                    ChromeBrowser chrome = ChromeBrowser.class.newInstance();
                    ChromeOptions option = chrome.getChromeOptions();
                    return chrome.getChromeDriver(option);


                case Firefox:
                    FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
                    FirefoxOptions options = firefox.getFirefoxOptions();
                    return firefox.getFirefoxDriver(options);


                default:
                    throw new Exception("Driver not found " + btype.name());
            }


        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return null;
    }

    public void setUpDriver(BrowserType btype) {
        driver = getBrowserObject(btype);
        log.info("Initialize Web driver " + driver.hashCode());
        WaitHelper wait = new WaitHelper(driver);
        wait.setImplicitWait(ObjectReader.reader.getImplictWait(), TimeUnit.SECONDS);
        wait.pageLoadTime(ObjectReader.reader.getPageLoadTime(), TimeUnit.SECONDS);
    }

    public void getApplicationUrl() {
        log.info("Getting the url .....");
        driver.get(ObjectReader.reader.getUrl());
    }

}
