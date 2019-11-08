package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class YouTubePage {
    WebDriver driver;

    private By searchBox = By.id("search");
    private By searchButton = By.name("search-icon-legacy");

    public YouTubePage(WebDriver driver) {
        this.driver = driver;
    }

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

    public void sendKeysToSearchBox(String value) {
        driver.findElement(searchBox).sendKeys(value);
    }

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

    public void pressSearch() {
        driver.findElement(searchButton).sendKeys(Keys.ENTER);
    }

    public enum Locator {id, name, linkText, className, cssSelector, XPath}

}
