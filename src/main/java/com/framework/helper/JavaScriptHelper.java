package com.framework.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class JavaScriptHelper {

    private WebDriver driver;
    Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);

    public JavaScriptHelper(WebDriver driver) {
        this.driver = driver;
        log.info("Javascript helper has been initialized");
    }

    public Object executeScript(String script) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return executor.executeScript(script);
    }

    public Object executeScript(String script, Object... args) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return executor.executeScript(script, args);
    }

    public void scrollToElement(WebElement element) {
        log.info("scroll to webelement");
        executeScript("window.scrollTo(arguments[0],[arguments[1])", element.getLocation().x, element.getLocation().y);
    }

    public void scrollToElementAndClick(WebElement element) {
        scrollToElement(element);
        element.click();
        log.info("element is clicked " + element.toString());
    }

    public void scrollIntoView(WebElement element) {
        executeScript("arguments[0].scrollIntoView()",element);
    }

    public void scrollIntoViewAndClick(WebElement element) {
        scrollToElement(element);
        element.click();
        log.info("element is clicked " + element.toString());
    }
    public void scrollDownVertically() {
        log.info("scrolling down vertically...");
        executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    public void scrollUpVertically() {
        log.info("scrolling up vertically...");
        executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    public void clickElement(WebElement element) {
        executeScript("arguments[0].click();",element);
    }


}
