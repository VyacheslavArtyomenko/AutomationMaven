package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
    WebDriver driver;

    public GoogleSearchPageObjects(WebDriver driver){
        this.driver = driver;
    }

    private By searchTextbox = By.name("q");
    private By searchButton = By.name("btnK");

    public void sendTextInTextbox(String text) {
        driver.findElement(searchTextbox).sendKeys(text);
    }

    public void clickEnter() {
        driver.findElement(searchButton).sendKeys(Keys.ENTER);
    }
}
