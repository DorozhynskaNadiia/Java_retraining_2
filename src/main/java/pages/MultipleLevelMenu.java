package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.WaitHelper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MultipleLevelMenu {

    private WebDriver driver;
    private String url = "https://khospodarysko.github.io/training-selenium/6.%20multilevel-menu.html";
    private By locatorDate = By.cssSelector("#time");
    private WaitHelper wait;

    public MultipleLevelMenu(WebDriver driver) {
        this.driver = driver;
        wait = new WaitHelper(driver);
    }

    public MultipleLevelMenu navigate() {
        this.driver.get(url);
        return this;
    }

    public void navigateAndClickTime() {
        Actions action = new Actions(driver);
        WebElement menu = driver.findElement(By.cssSelector("#css-menu"));
        WebElement languages = driver.findElement(By.cssSelector("label[class = right]"));
        WebElement time = driver.findElement(By.cssSelector("a[onclick]"));

        action.click(menu).click(languages).click(time).build().perform();
    }

    public void getTimeAndPrintFormatted() {
        wait.waitUntilTextIsDisplayed(locatorDate);
        WebElement element = driver.findElement(locatorDate);
        String dateTimeText = element.getText();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy, HH:mm:ss");
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTimeText, formatter);

        System.out.println(parsedDateTime);
    }
}