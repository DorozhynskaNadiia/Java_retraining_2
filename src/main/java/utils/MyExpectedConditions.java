package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import javax.annotation.Nullable;
import java.util.List;

public class MyExpectedConditions {

    public static ExpectedCondition<WebElement> visibilityOfElementLocatedByAndText(final By locator, final String text) {
        return new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {
                    WebElement element = driver.findElement(locator);
                    String elementText = element.getText();
                    if (element.isDisplayed() && text.equals(elementText)) {
                        return element;
                    }
                    return null;
                } catch (
                        StaleElementReferenceException e) {
                    return null;
                }
            }

        };
    }

    public static ExpectedCondition<WebElement> visibilityOfElementByText(final String text) {
        return new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {
                    WebElement element = driver.findElement(By.xpath("//*[text() = '" + text + "']"));
                    if (element.isDisplayed()) {
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

        };

    }

    public static ExpectedCondition<Boolean> textToBePresentInElementLocated(final By locator, final String text) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    String elementText = driver.findElement(locator).getText();
                    return elementText.contains(text);
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            }

            public String toString() {
                return String.format("text ('%s') to be present in element found by %s", text, locator);
            }
        };
    }

    public static ExpectedCondition<Boolean> listsIsEmpty(List<WebElement> smallSpinners, List<WebElement> largeSpinners, List<WebElement> extraSpinners) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return smallSpinners.size() == 0 && largeSpinners.size() == 0 && extraSpinners.size() == 0;
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            }
        };
    }

    public static ExpectedCondition<Boolean> onlyOneExtraSpinnerLeft(List<WebElement> smallSpinners, List<WebElement> largeSpinners, List<WebElement> extraSpinners) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return smallSpinners.size() == 0 && largeSpinners.size() == 0 && extraSpinners.size() == 1;
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            }
        };
    }

    public static ExpectedCondition<Boolean> textInAllRowsDisplays(By locator) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    List<WebElement> list = driver.findElements(locator);
                    for (int i = 0; i < list.size(); i++) {
                        WebElement element = list.get(i);
                        String text = element.getText();
                        if (!text.contains("test")) {
                            return false;
                        }
                    }
                    return list.size() == 10;
                } catch (StaleElementReferenceException e) {
                    return false;
                }
            }
        };
    }

    public static ExpectedCondition<Boolean> elementTextNotEmpty(By locator) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                String text = element.getText();

                return !text.isEmpty();
            }
        };
    }

    public static ExpectedCondition<WebElement> lastDigitIsZero(By locator) {
        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                String time = element.getText();
//                time.matches("\\d{1,2}:\\d+:\\d0");
                char lastDigit = time.charAt(time.length() - 4);
                if (lastDigit == '0') {
                    return element;
                }
                return null;
            }
        };
    }

    public static ExpectedCondition<Boolean> heightToBeStable(By locator, int millis) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                int height = element.getSize().height;
                int newHeight;
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) {
                }
                newHeight = element.getSize().height;
                return height == newHeight;
            }
        };
    }
}

