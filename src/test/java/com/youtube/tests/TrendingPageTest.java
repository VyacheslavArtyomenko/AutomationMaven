package com.youtube.tests;

import com.youtube.pages.TrendingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TrendingPageTest {

    private WebDriver driver;
    private TrendingPage trendingPage;

    @BeforeTest
    public void setUp() {
        String projectLocation = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com/feed/trending");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        trendingPage = new TrendingPage(driver);
    }

    @Test
    public void clickAllTrends() {
        trendingPage.clickMusic();
        trendingPage.wait(3);
        driver.navigate().back();

        trendingPage.clickGaming();
        trendingPage.wait(3);
        driver.navigate().back();

        trendingPage.clickNews();
        trendingPage.wait(3);
        driver.navigate().back();

        trendingPage.clickMovies();
        trendingPage.wait(3);
        driver.navigate().back();

        trendingPage.clickFashion();
        trendingPage.wait(3);
        driver.navigate().back();
    }



}

