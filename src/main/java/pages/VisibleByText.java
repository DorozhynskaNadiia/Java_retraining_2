package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class VisibleByText implements ExpectedCondition<WebElement> {

    private String text;

    public VisibleByText(String text) {
        this.text = text;
    }

    public WebElement apply(WebDriver driver) {
        try {
            WebElement element = driver.findElement(By.xpath("//*[text() = '" + this.text + "']"));
            if(element.isDisplayed()) {
                return element;
            }
            return null;
        } catch (StaleElementReferenceException e) {
            return null;
        }
    }

    public String toString() {
        return String.format("%s", text);
    }
}
