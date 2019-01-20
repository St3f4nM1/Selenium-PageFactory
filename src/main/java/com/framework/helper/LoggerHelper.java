package com.framework.helper;

import org.apache.log4j.PropertyConfigurator;

import org.apache.log4j.Logger;

public class LoggerHelper {

    private static boolean root = false;

    public static org.apache.log4j.Logger getLogger(Class cls) {
        if (root) {
            return Logger.getLogger(String.valueOf(cls));
        }
        PropertyConfigurator.configure(ResourceHelper.getResourcePath("/src/main/resources/configfile/log4j.properties"));
        root = true;
        return Logger.getLogger(String.valueOf(cls));
    }

}
