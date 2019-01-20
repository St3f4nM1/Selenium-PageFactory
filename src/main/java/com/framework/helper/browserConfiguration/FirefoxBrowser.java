package com.framework.helper.browserConfiguration;

import com.framework.helper.ResourceHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirefoxBrowser {

    public FirefoxOptions getFirefoxOptions() {

        DesiredCapabilities firefox = DesiredCapabilities.firefox();


        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);
        firefox.setCapability(FirefoxDriver.PROFILE, profile);
        firefox.setCapability("marionette", true);


        FirefoxOptions firefoxOptions = new FirefoxOptions(firefox);

        if (System.getProperty("os.name").contains("Linux")) {
            firefoxOptions.addArguments("--headless", "windows-size=1024,768", "--no-sandbox");
        }
        return firefoxOptions;

    }

    public WebDriver getFirefoxDriver(FirefoxOptions cap) {
        if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/geckodriver"));
            return new FirefoxDriver(cap);
        }
        return null;
    }
}
