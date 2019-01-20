package com.framework.pageobject;

import com.framework.helper.LoggerHelper;
import com.framework.helper.VerificationHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompanySelectionPage {

    private WebDriver driver;
    private final Logger log = LoggerHelper.getLogger(CompanySelectionPage.class);


    public CompanySelectionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "ul[class=\"day-list ItinerariesContainer__listContainer-3-eCG\"]")
    WebElement flightsTable;

    public void verifyThatTableIsShown(){
        VerificationHelper verificationHelper = new VerificationHelper(driver);
        verificationHelper.isDisplayed(flightsTable);
    }
}
