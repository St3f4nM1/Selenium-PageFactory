package com.framework.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class VerificationHelper {

    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(VerificationHelper.class);

    public VerificationHelper(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            log.info("element is displayed " + element);
            return true;
        } catch (Exception e) {
            log.error("element is not present" + e.getCause());
        }
        return false;
    }

    public boolean isNotDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            log.info("element is displayed " + element);
            return false;
        } catch (Exception e) {
            log.error("element is not present" + e.getCause());
        }
        return true;
    }

    public String getText(WebElement element) {
        if (element == null) {
            log.info("Webelement is null");
            return null;
        }
        boolean status = isDisplayed(element);
        if (status) {
            log.info("element text  is  displayed");
            return element.getText();
        }else
        return null;
    }

}
