package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Time {

    private WebDriver driver;
    private String url = "https://khospodarysko.github.io/training-selenium/7.%20time.html";
    private By locatorOfTime = By.cssSelector("#child");

    public Time(WebDriver driver) {
        this.driver = driver;
    }

    public Time navigate() {
        this.driver.get(url);
        return this;
    }

    public void waitUntilLastDigitIsZero(int count) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        for (int i = 0; i < count; i++) {
            WebElement element = wait.until(utils.MyExpectedConditions.lastDigitIsZero(locatorOfTime));
            String text = element.getText();
            System.out.println(text);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

}

