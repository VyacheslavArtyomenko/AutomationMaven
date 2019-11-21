package com.youtube.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrendingPage {
    private WebDriver driver;

    private By musicTrends = By.linkText("Music");
    private By gamingTrends = By.linkText("Gaming");
    private By newsTrends = By.linkText("News");
    private By moviesTrends = By.linkText("Movies");
    private By fashionTrends = By.linkText("Fashion");

    public TrendingPage(WebDriver driver) {
        this.driver = driver;
    }

    // trendsClickers
    public void clickMusic() {
        driver.findElement(musicTrends).click();
    }

    public void clickGaming() {
        driver.findElement(gamingTrends).click();
    }

    public void clickNews() {
        driver.findElement(newsTrends).click();
    }

    public void clickMovies() {
        driver.findElement(moviesTrends).click();
    }

    public void clickFashion() {
        driver.findElement(fashionTrends).click();
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 3000);
        } catch (InterruptedException ex) {
            System.out.println("Thread is stopped");
        }
    }

}
