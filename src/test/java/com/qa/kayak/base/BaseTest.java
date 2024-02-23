package com.qa.kayak.base;

import com.qa.kayak.factory.DriverFactory;
import com.qa.kayak.pages.FlightsPage;
import com.qa.kayak.pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;


public class BaseTest {

    DriverFactory df;
    public Properties prop;
    WebDriver driver;
    public FlightsPage flightsPage;
    public SearchResultsPage searchResultsPage;


    @Parameters({"Browser", "version"})
    @BeforeTest
    public void setUp(String browserName, String browserVersion) {
        df = new DriverFactory();
        prop = df.init_prop();
        String browser = prop.getProperty("Browser");

        if (browserName!=null) {
            browser = browserName;
        }

        driver = df.init_driver(browser, browserVersion);
        driver.get(prop.getProperty("url"));
        flightsPage = new FlightsPage(driver);

    }

    @AfterTest
    public void tearDown() {
        if (driver!=null) {
            driver.quit();
        }
    }


}
