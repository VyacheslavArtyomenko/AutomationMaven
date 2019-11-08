package com.google;

import org.junit.After;
import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;
import pages.GoogleSearchPageObjects;
import pages.YouTubePage;

import java.util.concurrent.TimeUnit;

public class FirstTestClass {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        String projectLocation = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver.exe");
        driver = new ChromeDriver();
    }

//    @Test
//    public void test() {
//        GoogleSearchPageObjects pageObjects = new GoogleSearchPageObjects(driver);
//        driver.get("https://google.com");
//        pageObjects.sendTextInTextbox("TestText");
//        pageObjects.clickEnter();
//        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MILLISECONDS);
//    }

    @Test
    public void testYouTubeSearch() {
        driver.get("https://youtube.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        YouTubePage youTubeMainPage = new YouTubePage(driver);
        youTubeMainPage.sendKeysToSearchBox("try");
        youTubeMainPage.pressSearch();
       // youTubeMainPage.sendKeys(YouTubePage.Locator.id, "search", "video" );
        //youTubeMainPage.pressEnter(YouTubePage.Locator.id, "search-icon-legacy");
    }

    @AfterTest
    public void close() {
        try{
            Thread.sleep(3000);
        } catch (InterruptedException ex){
            System.out.println("Thread is stopped");
        }
        driver.quit();
    }
}
