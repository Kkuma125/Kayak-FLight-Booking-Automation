package com.qa.kayak.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightsPage {

    private final WebDriver driver;

    private final By fromCLick = By.xpath("(//div[@class='vvTc-item-close'])[1]");
    private final By from = By.xpath("//input[@placeholder='From?']/../input");
    private final By fromtext = By.xpath("(//div[@class='vvTc-item'])[1]/.");
    private final By To = By.xpath("//input[@placeholder='To?']/../input");
    private final By Totext = By.xpath("(//div[@class='vvTc-item'])[2]/.");
    private final By NextButton = By.xpath("//div[@class='sR_k-input sR_k-mod-responsive']");

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
        wait.until(ExpectedConditions.presenceOfElementLocated(from));
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
        wait.until(ExpectedConditions.presenceOfElementLocated(To));
        ele1.sendKeys(Keys.ARROW_DOWN);
        ele1.sendKeys(Keys.ENTER);
        return;
    }

    public String getToText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Totext));
        WebElement toEle = driver.findElement(Totext);
        String text = toEle.getText();
        System.out.println(text);
        return text;

    }
}
