package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class DynamicList {

    private WebDriver driver;
    private String url = "https://khospodarysko.github.io/training-selenium/4.%20dynamic-list.html";
    private By locator = By.cssSelector(".list-group-item span");
    private WaitHelper myWaitHelper;

    public DynamicList(WebDriver driver) {
        this.driver = driver;
        myWaitHelper = new WaitHelper(driver);
    }

    public DynamicList navigate() {
        this.driver.get(url);
        return this;
    }

    public void waitForVisibilityOfTextInAllRows() {
        myWaitHelper.waitUntilTextDisplaysInAllRows(locator);
    }

}
