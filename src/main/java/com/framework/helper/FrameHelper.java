package com.framework.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.logging.Logger;

public class FrameHelper {

    private WebDriver driver;
    private org.apache.log4j.Logger log = LoggerHelper.getLogger(FrameHelper.class);

    public FrameHelper(WebDriver driver) {
        this.driver = driver;

    }

    public void switchFrame(int frameIndex) {
        driver.switchTo().frame(frameIndex);
        log.info("switched to " + frameIndex +" frame");
    }

    public void switchFrame(String frameName) {
        driver.switchTo().frame(frameName);
        log.info("switched to " + frameName +" frame");
    }

    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
        log.info("switched to frame " + element.toString());
    }

    public void switchToParentFrame( ) {
        driver.switchTo().defaultContent();
        log.info("switched to parent frame ");
    }
}
