package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitHelper;

import java.util.List;

public class Spinners {
    private WebDriver driver;
    private String url = "https://khospodarysko.github.io/training-selenium/3.%20spinners.html";
    private WaitHelper myWaitHelper;

    @FindBy(css = ".spinner-small")
    private List<WebElement> smallSpinners;

    @FindBy(css = ".spinner-large")
    private List<WebElement> largeSpinners;

    @FindBy(css = ".spinner-extra")
    private List<WebElement> extraSpinners;

    public Spinners(WebDriver driver) {
        this.driver = driver;
        myWaitHelper = new WaitHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public Spinners navigate() {
        this.driver.get(url);
        return this;
    }

    public int countSmallSpinners() {
        return smallSpinners.size();
    }

    public int countLargeSpinners() {
        return largeSpinners.size();
    }

    public int countExtraSpinners() {
        return extraSpinners.size();
    }

    public void waitUntilOneSpinnerLeft() {
        myWaitHelper.waitUntilOnlyExtraSpinnerLeft(smallSpinners, largeSpinners, extraSpinners);
    }

    public void waitUntilListIsEmpty() {
        myWaitHelper.waitUntilListIsEmpty(smallSpinners, largeSpinners, extraSpinners);
    }
}


