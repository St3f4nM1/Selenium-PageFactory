package com.framework.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;


public class DropDownHelper {
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(DropDownHelper.class);

    public DropDownHelper() {
        this.driver = driver;
        log.info("Dropdown helper object created");
    }

    public void selectUsingValue(WebElement element, String value) {
        Select select = new Select(element);
        log.info("selectUsingValue and value is " + value);
        select.selectByValue(value);
    }

    public void selectUsingIndex(WebElement element, int index) {
        Select select = new Select(element);
        log.info("selectUsingIndex and index is " + index);
        select.selectByIndex(index);
    }

    public void deSelectUsingIndex(WebElement element, int index) {
        Select select = new Select(element);
        log.info("deSelectUsingIndex and index is " + index);
        select.deselectByIndex(index);
    }

    public void selectUsingVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        log.info("selectUsingVisibleText and visibleText is " + visibleText);
        select.selectByVisibleText(visibleText);
    }

    public List<String> getAllDropdownData(WebElement element) {
        Select select = new Select(element);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<String>();
        for (WebElement ele : elementList) {
            log.info(ele.getText());
            valueList.add(ele.getText());

        }
        return valueList;
    }

}
