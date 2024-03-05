package com.qa.kayak.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightsPage {

    private final WebDriver driver;

    private final By fromCLick = By.xpath("(//div[@class='vvTc-item-close'])[1]");
    private final By from = By.xpath(" //input[@placeholder='From?']");
    private final By fromtext = By.xpath("(//div[@role='list'])[1]");
    private final By To = By.xpath(" //input[@placeholder='To?']");
    private final By Totext = By.xpath("(//div[@role='list'])[2]");
    private final By startdate = By.xpath("//span[@aria-label='Start date calendar input']");
    private final By monthyearValue = By.xpath("(//div[@class='wHSr-monthName'])[1]");
    private final By nextButton = By.xpath("(//*[local-name()='span' and @class='tUEz-icon'])[2]");
    private final By backButton = By.xpath("(//*[local-name()='span' and @class='tUEz-icon'])[1]");

    private final By monthyearValueText = By.xpath("(//div[@class='wHSr-monthName'])[1]");
    //private final By selectdate = By.xpath("(//div[text()='15'])[1]");


    public FlightsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickFromLink() {
        driver.findElement(fromCLick).click();
    }

    public void enterFrom(String FromText) {
        WebElement ele = driver.findElement(from);
        ele.sendKeys(FromText);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementValue(from, FromText));
        ele.sendKeys(Keys.ARROW_DOWN);
        ele.sendKeys(Keys.ENTER);
        return;
    }

    public String getFromText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fromtext));
        WebElement ele = driver.findElement(fromtext);
        String Fromtext = ele.getText();
        System.out.println(Fromtext);
        return Fromtext;
    }

    public void enterTo(String ToText) {
        WebElement ele1 = driver.findElement(To);
        ele1.sendKeys(ToText);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementValue(To, ToText));
        ele1.sendKeys(Keys.ARROW_DOWN);
        ele1.sendKeys(Keys.ENTER);
        return;
    }

    public String getToText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(Totext));
        WebElement toEle = driver.findElement(Totext);
        String text = toEle.getText();
        System.out.println(text);
        return text;

    }

    public static String[] getMonthYear(String monthyearValue) {
        return monthyearValue.split(" ");

    }


    public void selectDate(String Expdate, String ExpMonth, String ExpYear) {

        driver.findElement(startdate).click();

        if (ExpMonth.equals("February") && Integer.parseInt(Expdate) > 29) {
            System.out.println("Wrong Date Selected :"+ExpMonth+" : "+Expdate);
            return;

        }

        String text = driver.findElement(monthyearValue).getText();
        System.out.println(text);
        while (!(getMonthYear(text)[0].trim().equals(ExpMonth) && getMonthYear(text)[1].trim().equals(ExpYear))) {
//            driver.findElement(backButton).click();
            driver.findElement(nextButton).click();
            text = driver.findElement(monthyearValue).getText();
            System.out.println(text);
            WebElement date = driver.findElement(By.xpath("(//div[text()='"+Expdate+"'])[1]"));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(date));
            date = driver.findElement(By.xpath("(//div[text()='"+Expdate+"'])[1]"));


            Actions act = new Actions(driver);
            act.moveToElement(date).click().perform();


        }


    }

}
