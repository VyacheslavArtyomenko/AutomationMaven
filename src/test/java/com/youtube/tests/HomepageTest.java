package com.youtube.tests;

import com.youtube.DataProviderClass;
import com.youtube.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

public class HomepageTest {
    private WebDriver driver;
    private HomePage youTubeMainPage;

    @BeforeMethod
    public void setUp() {
        String projectLocation = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://youtube.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        youTubeMainPage = new HomePage(driver);
        driver.manage().window().maximize();

        if (youTubeMainPage.popUpIsDisplayed()){
            youTubeMainPage.closePopUp();
        } else {
            System.out.println("Haven`t seen a pop up");
        }
    }

    @Test
    public void testYouTubeSearch() {
        youTubeMainPage.sendKeysToSearchBox("test");
        youTubeMainPage.pressSearch();

        youTubeMainPage.wait(3);
    }

    // with DataProvider
    @Test (dataProvider = "set1", dataProviderClass = DataProviderClass.class)
    public void testYouTubeSearchWithDataProvider(String s) {
        youTubeMainPage.sendKeysToSearchBox(s);
        youTubeMainPage.pressSearch();

        youTubeMainPage.wait(3);
    }

    @Test
    public void backToStartingPageFromVideo() {
        youTubeMainPage.chooseFirstVideo();
        youTubeMainPage.wait(3);
        driver.navigate().back();
        youTubeMainPage.wait(3);
    }

    @Test
    public void scrollDownALot() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < 100; i++) {
            jse.executeScript("window.scrollBy(0,5000)", "");
        }
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
