package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.Test;

public class Slider extends Test {

    public static void moveSlider() {
        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/ndorozhynska/slider.html");

        WebElement slider = driver.findElement(By.cssSelector("input[class = \"slider\"]"));

        WebElement target = driver.findElement(By.cssSelector("span[id = \"demo\"]"));
        String targetPoint = target.getText();

        Actions action = new Actions(driver);
        action.clickAndHold(slider).build().perform();

        while (!targetPoint.equals("20")) {
            System.out.println(targetPoint);
            action.moveByOffset(-5, 0).build().perform();
            targetPoint = target.getText();
        }

        action.release().build().perform();
        System.out.println("Value: " + targetPoint);

        driver.quit();
    }
}
