package com.framework.helper.browserConfiguration;

public interface ConfigReader {

    public int getImplictWait();

    public int getExplicitWait();

    public int getPageLoadTime();

    public BrowserType getBrowserType();

    public String getUrl();



}
