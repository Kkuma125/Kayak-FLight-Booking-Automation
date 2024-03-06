package com.qa.kayak.tests;

import com.qa.kayak.base.BaseTest;
import com.qa.kayak.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FlightsPageTest extends BaseTest {


    @Test
    public void getTitleTest() {
        String title = flightsPage.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, Constants.FLIGHTS_PAGE_TITLE);
    }

    @Test
    public void clickFromLinkTest() {
        flightsPage.clickFromLink();
    }

    @Test
    public void enterFromTest() {
        flightsPage.enterFrom("New Delhi");
    }

    @Test
    public void getFromTextTest() {
        String text = flightsPage.getFromText();
        Assert.assertEquals(text, "New Delhi, National Capital Territory of India, India (DEL)");
    }

    @Test
    public void enterToTest() {
        flightsPage.enterTo("Dubai");
    }

    @Test
    public void getToTextTest() {
        String toText = flightsPage.getToText();
        Assert.assertEquals(toText, "Dubai, United Arab Emirates (DXB)");

    }

    @Test
    public void selectDateTest() {
        flightsPage.selectDate("29", "April", "2024");

    }

    @Test
    public void clickSearchButtonTest() {
        flightsPage.clickSearchButton();
    }
}




