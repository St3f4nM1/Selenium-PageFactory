package com.framework.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowHelper {

    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(WindowHelper.class);

    public WindowHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToParentWindow() {
        log.info("switching to parent window");
        driver.switchTo().defaultContent();
    }

    public void switchToWindow(int index) {
        log.info("switching to parent window");
        Set<String> windows = driver.getWindowHandles();
        int i = 1;
        for (String window : windows) {
            if (i == index) {
                driver.switchTo().window(window);
            } else {
                i++;
            }
        }
    }

    public void closeAllTabsAndSwitchToMainWindow() {
        Set<String> windows = driver.getWindowHandles();
        String mainWindow = driver.getWindowHandle();
        for (String window : windows) {
            if (!window.equalsIgnoreCase(mainWindow)) {
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }


}
