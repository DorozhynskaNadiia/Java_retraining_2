package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class VisibleByLocatorAndTextCondition implements ExpectedCondition<WebElement> {

    private By locator;
    private String text;

    public VisibleByLocatorAndTextCondition(By locator, String text) {
        this.locator = locator;
        this.text = text;
    }

    public WebElement apply(WebDriver driver) {
        try {
            WebElement element = driver.findElement(locator);
            String elementText = element.getText();
            if(element.isDisplayed() && this.text.equals(elementText)) {
                return element;
            }
            return null;
        } catch (StaleElementReferenceException e) {
            return null;
        }
    }
}
