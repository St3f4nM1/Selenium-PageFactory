package com.framework.pageobject;

import com.framework.helper.DropDownHelper;
import com.framework.helper.LoggerHelper;
import com.framework.helper.VerificationHelper;
import com.framework.helper.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class SearchFlightsPage {

    private WebDriver driver;
    private final Logger log = LoggerHelper.getLogger(SearchFlightsPage.class);
    private String today;

    public SearchFlightsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "identity")
    WebElement skyScannerLogo;


    @FindBy(id = "fsc-origin-search")
    WebElement origin;

    @FindBy(css = "input[id=\"fsc-destination-search\"]")
    WebElement destination;

    @FindBy(css = "ul[role=\"listbox\"]")
    WebElement dropDownList;

    @FindBy(id = "depart-fsc-datepicker-button")
    WebElement startDate;

    @FindBy(id = "return-fsc-datepicker-button")
    WebElement returnDate;

    @FindBy(xpath = "//table[@class=\"BpkCalendarGrid_bpk-calendar-grid__sak14 FlightDatepicker_fsc-datepicker__list-size__1UX2a\"]//tbody")
    WebElement dates;

    @FindBy(id = "CabinClassTravellersSelector_fsc-class-travellers-trigger__1qSiF")
    WebElement cabinClassAndTravellers;

    @FindBy(id = "search-controls-cabin-class-dropdown")
    WebElement cabinClass;

    @FindBy(id = "react-autowhatever-fsc-destination-search")
    WebElement destDropDown;

    @FindBy(css = "button[title=\"Increase number of children\"]")
    WebElement increaseNoChilds;

    @FindBy(id = "children-age-dropdown-0")
    WebElement childrenAgeDropDown;

    @FindBy(css = "button[class=\"BpkLink_bpk-link__1Wmr3\"]")
    WebElement doneBtn;

    @FindBy(css = "button[aria-label=\"Search flights\"]")
    WebElement searcFlightsBtn;

    @FindBy(css = "input[type=\"checkbox\"]")
    private List<WebElement> checkBoxes;


    public void enterOriginLocation(String originLocation) {
        WaitHelper waitHelper = new WaitHelper(driver);
        origin.click();
        origin.clear();
        origin.sendKeys(originLocation);
        waitHelper.waitForElementVisible(dropDownList, 30);
        destination.sendKeys(Keys.DOWN);
        destination.sendKeys(Keys.ENTER);
    }

    public void enterDestinationLocation(String destinationLocation) throws InterruptedException {
        WaitHelper waitHelper = new WaitHelper(driver);
        destination.clear();
        Thread.sleep(2000);
        destination.sendKeys(destinationLocation);
        waitHelper.waitForElementVisible(destDropDown, 50);
        Thread.sleep(2000);
        destination.sendKeys(Keys.DOWN);
        destination.sendKeys(Keys.ENTER);

    }

    public void landingPageAssertion() {
        VerificationHelper verificationHelper = new VerificationHelper(driver);
        verificationHelper.isDisplayed(skyScannerLogo);
    }

    public void clickOnDatePicker() {
        WaitHelper waitHelper = new WaitHelper(driver);
        waitHelper.waitForElementVisible(startDate, 30);
        startDate.click();
    }

    public void clickReturnDatePicker() {
        WaitHelper waitHelper = new WaitHelper(driver);
        waitHelper.waitForElementVisible(returnDate, 30);
        returnDate.click();
    }

    // select today's date
    public void pickDepartingDate() {
        today = getCurrentDay();
        List<WebElement> columns = dates.findElements(By.tagName("td"));
        columns.stream()
                .filter(ele -> ele.getText().equalsIgnoreCase(today))
                .findFirst()
                .ifPresent(element -> element.click());
    }

    public void pickReturnDate(String date) {
        List<WebElement> columns = dates.findElements(By.tagName("td"));
        System.out.println(columns.size());
        for (WebElement cell : columns) {
            if (cell.getText().equalsIgnoreCase(date)) {
                cell.click();
                break;
            }
        }
    }

    public void clickOnCabinclassAndTravellers(String cabinClassLevel) {
        DropDownHelper dropDownHelper = new DropDownHelper();
        cabinClassAndTravellers.click();
        dropDownHelper.selectUsingVisibleText(cabinClass, cabinClassLevel);


    }

    public void increaseNoOfChilds(String noOfChilds) {
        increaseNoChilds.click();
        DropDownHelper dropDownHelper = new DropDownHelper();
        dropDownHelper.selectUsingVisibleText(childrenAgeDropDown, noOfChilds);
        doneBtn.click();
    }

    private String getCurrentDay() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        String todayStr = Integer.toString(todayInt);
        return todayStr;
    }

    public void clickCheckBoxes() {
        for (WebElement option : checkBoxes) {
            if (!option.isSelected()) {
                option.click();
            }
        }
    }

    public void clickSearcFlightButton() {
        searcFlightsBtn.click();
    }

}





