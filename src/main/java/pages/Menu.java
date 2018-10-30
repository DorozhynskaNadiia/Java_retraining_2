package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Menu {

    private WebDriver driver;
    private String url = "https://khospodarysko.github.io/training-selenium/5.%20hover-menu.html#";

    public Menu(WebDriver driver) {
        this.driver = driver;

    }

    public Menu navigate() {
        this.driver.get(url);
        return this;
    }

    public void navigateToFinalLevelAndClick() {
        Actions action = new Actions(driver);
        WebElement dropdown = driver.findElement(By.cssSelector("#dLabel"));
        WebElement hoverMeForMoreOptions = driver.findElement(By.xpath("//a[contains(text(),'Hover')]"));
        WebElement evenMore = driver.findElement(By.xpath("//li[@class = 'dropdown-submenu']//child::a[contains(text(),'Even')]"));
        WebElement finalLevel = driver.findElement(By.xpath("//ul[@class = 'dropdown-menu']//child::li//child::a[@onclick]"));

        action
                .click(dropdown)
                .moveToElement(hoverMeForMoreOptions)
                .moveToElement(evenMore)
                .moveToElement(finalLevel)
                .click()
                .build()
                .perform();
    }

    public void getDateAndTimeAndPrintFormatted() {
        WebElement element = driver.findElement(By.cssSelector("#text"));
        String dateAndTime = element.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("K:mm:ss a");
        LocalTime parsed = LocalTime.parse(dateAndTime, formatter);

        LocalDateTime dateTime = LocalDateTime.now();
        dateTime = dateTime.withHour(parsed.getHour()).withMinute(parsed.getMinute()).withSecond(parsed.getSecond());
        String formatDateTime = DateTimeFormatter.ofPattern("d MMMM yyyy, HH:mm:ss").format(dateTime);

        System.out.println(formatDateTime);

    }
}