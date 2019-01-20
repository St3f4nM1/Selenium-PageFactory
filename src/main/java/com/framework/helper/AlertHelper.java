package com.framework.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertHelper {

    private WebDriver driver;
    private static Logger log = LoggerHelper.getLogger(AlertHelper.class);


    public AlertHelper(WebDriver driver) {
        this.driver = driver;
        log.info("Alert helper object is created");
    }

    public Alert getAlert() {
        log.info("alert test: " + driver.switchTo().alert().getText());
        return driver.switchTo().alert();
    }

    public void acceptAlert() {
        getAlert().accept();
        log.info("accept alert is done");
    }

    public void dismissAlert() {
        getAlert().dismiss();
        log.info("dismis alert is done");
    }

    public String getAlertText() {
        String text = getAlert().getText();
        log.info("alert test: " + text);
        return text;
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            log.info("alert is present");
            return true;
        } catch (NoAlertPresentException e) {
            log.info(e.getCause());
            return false;
        }
    }

    public void acceptAlertIfPresent() {
        if (isAlertPresent()) {
            acceptAlert();
        } else {
            log.info("Allert is not present");
        }
    }

    public void dismissAlertIfPresent() {
        if (isAlertPresent()) {
            dismissAlert();
        } else {
            log.info("Allert is not present");
        }
    }

    public void acceptPrompt(String text) {
        if (isAlertPresent())
            getAlert();
        Alert alert = getAlert();
        alert.sendKeys(text);
        log.info("alert text " + getAlertText());
    }
}
