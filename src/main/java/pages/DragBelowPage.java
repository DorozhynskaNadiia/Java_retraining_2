package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragBelowPage extends BasePage{
    private By locatorOfButtonFifty = By.cssSelector("#id-50");
    private By menuLocator = By.cssSelector("#menu");
    private By menuItemLocator = By.cssSelector("#clicked");

    public DragBelowPage(WebDriver driver) {
        super(driver,"https://khospodarysko.github.io/training-selenium/8.%20drag-below.html");
    }

    public void scrollPageAndClickOnButtonJavascript() {

        executor.executeScript("" +
                "var offsetTop = document.getElementById('id-50').offsetTop;\n" +
                "var menuHeight = document.getElementById('menu').clientHeight;\n" +
                "window.scrollBy(0, offsetTop - menuHeight);");

        WebElement button = driver.findElement(locatorOfButtonFifty);
        executor.executeScript("arguments[0].click();", button);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }

    public void scrollSlowly() {
        WebElement button = driver.findElement(locatorOfButtonFifty);
        int menuHeight = driver.findElement(menuLocator).getSize().height;
        int targetScrollPosition = button.getLocation().y - menuHeight;

        int step = 100;
        int currentScrollPosition = 0;
        int interval = 200;

        while (currentScrollPosition < targetScrollPosition) {
            if((targetScrollPosition - currentScrollPosition) < step) {
                executor.executeScript("" +
                        "window.scrollBy(0," + (targetScrollPosition - currentScrollPosition) + ");");
            } else {

                executor.executeScript("" +
                        "window.scrollBy(0," + step + ");");
            }
            currentScrollPosition = currentScrollPosition + step;

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }

    public void scrollPageAndClickOnButtonSelenium() {

        WebElement button = driver.findElement(locatorOfButtonFifty);
        int menuHeight = driver.findElement(menuLocator).getSize().height;
        int y = button.getLocation().y - menuHeight;

        executor.executeScript("" +
                "window.scrollBy(0," + y + ");");

        executor.executeScript("arguments[0].click();", button);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }

    public String getMenuItemText() {
        WebElement buttonInMenu = driver.findElement(menuItemLocator);
        return buttonInMenu.getText();
    }
}
