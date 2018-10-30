package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WaitHelper {

    public WebDriver driver;
    private int timeout = 15;
    WebDriverWait wait;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeout);
    }

    public void waitUntilListIsEmpty(List<WebElement> smallSpinners, List<WebElement> largeSpinners, List<WebElement> extraSpinners) {
        wait.until(utils.MyExpectedConditions.listsIsEmpty(smallSpinners, largeSpinners, extraSpinners));
    }

    public void waitUntilOnlyExtraSpinnerLeft(List<WebElement> smallSpinners, List<WebElement> largeSpinners, List<WebElement> extraSpinners) {
        wait.until(utils.MyExpectedConditions.onlyOneExtraSpinnerLeft(smallSpinners, largeSpinners, extraSpinners));
    }

    public void waitUntilTextDisplaysInAllRows(By locator){
        wait.until(utils.MyExpectedConditions.textInAllRowsDisplays(locator));
    }

    public void waitUntilTextIsDisplayed(By locator) {
        wait.until(utils.MyExpectedConditions.elementTextNotEmpty(locator));
    }

}
