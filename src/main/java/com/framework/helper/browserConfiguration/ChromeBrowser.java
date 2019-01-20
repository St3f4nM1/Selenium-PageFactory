package com.framework.helper.browserConfiguration;

import com.framework.helper.ResourceHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeBrowser {

    public ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
     //   options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--test-type");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("window-size=1920,1080");
        options.setCapability(ChromeOptions.CAPABILITY, options);
        if (System.getProperty("os.name").contains("Linux")) {
            options.addArguments("--headless", "window-size=1920,1080", "--no-sandbox");
        }
        return options;
    }

    public WebDriver getChromeDriver(ChromeOptions cap) {
        if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver"));
            return new ChromeDriver(cap);
        } else if (System.getProperty("os.name").contains("Window")) {
            System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver"));
            return new ChromeDriver(cap);
        } else if (System.getProperty("os.name").contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver"));
            return new ChromeDriver(cap);
        }
        return null;
    }
}
