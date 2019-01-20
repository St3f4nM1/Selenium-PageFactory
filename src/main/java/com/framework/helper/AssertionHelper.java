package com.framework.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AssertionHelper {


    private WebDriver driver;
    private  static Logger log = LoggerHelper.getLogger(Assert.class);

    public AssertionHelper(WebDriver driver) {
        this.driver = driver;
    }

    public static void verifyText(String s1, String s2) {
        log.info("verifying test: " + s1 + "with" + s2);
        Assert.assertEquals(s1, s2);

    }

    public static void verifyTrue() {
        log.info("script passed");
        Assert.assertTrue(true);
    }

    public static void verifyTrue(String msg) {
        Assert.assertTrue(true, msg);
    }

    public static void verifyFalse(String msg) {
        log.info("script fails");
        Assert.assertTrue(false, msg);
    }

    public static void verifyTrue(boolean status) {
        Assert.assertTrue(status);
    }


}
