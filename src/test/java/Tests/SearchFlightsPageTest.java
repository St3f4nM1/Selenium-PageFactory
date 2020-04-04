package Tests;

import com.framework.pageobject.CompanySelectionPage;
import com.framework.pageobject.SearchFlightsPage;
import com.framework.testbase.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchFlightsPageTest extends TestBase {

    private SearchFlightsPage searchFlightsPage;
    private CompanySelectionPage companySelectionPage;

    @BeforeClass
    public void setUp() {
        searchFlightsPage = new SearchFlightsPage(driver);
        getApplicationUrl();
    }

    @Test
    public void userShouldBeAbleToSearchForFlight() throws InterruptedException {
        //Thread.sleep(90000);
        searchFlightsPage.landingPageAssertion();
        searchFlightsPage.enterOriginLocation("London Luton");
        searchFlightsPage.enterDestinationLocation("Berlin");
        searchFlightsPage.clickOnDatePicker();
        searchFlightsPage.pickDepartingDate();
        searchFlightsPage.clickReturnDatePicker();
        searchFlightsPage.pickReturnDate("29");
        searchFlightsPage.clickOnCabinclassAndTravellers("Premium Economy");
        searchFlightsPage.increaseNoOfChilds("1");
        searchFlightsPage.clickCheckBoxes();
        Thread.sleep(5000);
        searchFlightsPage.clickSearcFlightButton();
        companySelectionPage.verifyThatTableIsShown();

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

}
