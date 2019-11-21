package com.youtube.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By popUpDismissButton = By.xpath("/html/body/ytd-app/ytd-popup-container/paper-dialog/ytd-mealbar-promo-renderer/div/div[2]/ytd-button-renderer[1]/a/paper-button");
    private By searchBox = By.id("search");
    private By searchButton = By.id("search-icon-legacy");
    private By firstVideoTitle = By.id("video-title");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeysToSearchBox(String value) {
        driver.findElement(searchBox).sendKeys(value);
    }

    public boolean popUpIsDisplayed() {
        return driver.findElement(popUpDismissButton).isDisplayed();
    }

    public void closePopUp() {
        driver.findElement(popUpDismissButton).click();
        System.out.println("Pop up was closed");
    }

    public void pressSearch() {
        driver.findElement(searchButton).sendKeys(Keys.ENTER);
    }

    public void chooseFirstVideo() {
       driver.findElement(firstVideoTitle).click();
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            System.out.println("Thread is stopped");
        }
    }

    public enum Locator {id, name, linkText, className, cssSelector, XPath}

    //old version
    public void sendKeys(Locator locator, String fieldName, String value) {
        switch (locator) {
            case id:
                driver.findElement(By.id(fieldName)).sendKeys(value);
                break;

            case name:
                driver.findElement(By.name(fieldName)).sendKeys(value);
                break;

        }
    }

    // old version
    public void pressEnter(Locator locator, String fieldName) {
        switch (locator) {
            case id:
                driver.findElement(By.id(fieldName)).sendKeys(Keys.ENTER);
                break;
            case className:
                driver.findElement(By.className(fieldName)).sendKeys(Keys.ENTER);
                break;
        }
    }
}
