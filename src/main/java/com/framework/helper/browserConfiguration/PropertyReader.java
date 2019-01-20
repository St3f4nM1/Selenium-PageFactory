package com.framework.helper.browserConfiguration;

import com.framework.helper.ResourceHelper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader implements ConfigReader {

    private static FileInputStream file;
    public static Properties OR;


    static {
        try {
            String filePath = ResourceHelper.getResourcePath("/src/main/resources/configfile/config.properties");
            file = new FileInputStream(new File(filePath));
            OR = new Properties();
            OR.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public int getImplictWait() {
        return Integer.parseInt(OR.getProperty("implicitwait"));
    }

    @Override
    public int getExplicitWait() {
        return Integer.parseInt(OR.getProperty("explicitwait"));
    }

    @Override
    public int getPageLoadTime() {
        return Integer.parseInt(OR.getProperty("pageloadtime"));
    }

    @Override
    public BrowserType getBrowserType() {
        return BrowserType.valueOf(OR.getProperty("browsertype"));
    }

    @Override
    public String getUrl() {
        return OR.getProperty("applicationUrl");
    }



}
