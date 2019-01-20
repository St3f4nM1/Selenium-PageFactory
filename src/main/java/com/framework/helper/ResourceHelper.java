package com.framework.helper;

public class ResourceHelper {




    public static String getResourcePath(String path) {
        String basepath = System.getProperty("user.dir");
        return basepath + path;
    }


}
