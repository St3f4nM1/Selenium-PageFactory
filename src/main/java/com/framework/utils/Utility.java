package com.framework.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utility {

    public static void captureScreenShot(WebDriver driver,String screenShotName) {

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("src/main/resources/screenshots/" + screenShotName + ".png"));
        } catch (IOException e) {
            System.out.println("Screenshots while taking screenshots" + e.getMessage());
        }
    }
}
