package com.framework.helper;


import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class WaitHelper {

    private Logger log = LoggerHelper.getLogger(WaitHelper.class);
    private WebDriver driver;


    public WaitHelper(WebDriver driver) {
        log.info("WaitHelper object is created");
        this.driver = driver;
    }

    public void setImplicitWait(int timeout, TimeUnit unit) {
        log.info("Implicit Wait has been set to " + timeout);
        driver.manage().timeouts().implicitlyWait(timeout, unit);
    }

    private WebDriverWait getWait(int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        return wait;

    }

    public void waitForElementVisible(WebElement element, int timeOutInSeconds) {
        log.info("waiting for " + element.toString() + "for" + timeOutInSeconds + " seconds");
        WebDriverWait wait = getWait(timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickable(WebElement element, int timeOutInSeconds) {
        log.info("waiting for " + element.toString() + "for" + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("element is clickable now");
    }

    public boolean waitForElementNotPresent(WebElement element, long timeOutInSeconds) {
        log.info("waiting for " + element.toString() + "for" + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
        log.info("element is invisible now");
        return status;
    }

    public void waitForElementToBeAvailableAndSwitchToIt(WebElement element, long timeOutInSeconds) {
        log.info("waiting for " + element.toString() + "for" + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        log.info("frame is available");
    }

    public Wait getFluentWait(int timeoutInSeconds) {
        Wait<WebDriver> fwait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(timeoutInSeconds));
        return fwait;
    }

    public WebElement waitForElement(WebElement element, int timeOutInSeconds) {
        Wait<WebDriver> fwait = getFluentWait(timeOutInSeconds);
        fwait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void pageLoadTime(long timeout, TimeUnit unit) {
        log.info("waiting for page to load " + unit + "seconds");
        driver.manage().timeouts().pageLoadTimeout(timeout, unit);
        log.info("page is loaded");

    }

    public void waitForUrl(String url, int timeOutInSeconds) {
        log.info("Checking url");
        WebDriverWait wait = getWait(timeOutInSeconds);
        wait.until(ExpectedConditions.urlContains(url));
    }

}
