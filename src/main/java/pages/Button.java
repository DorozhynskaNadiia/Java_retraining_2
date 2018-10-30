package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button extends Test {

    public static void clickButtonFiveTimes() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///C:/Users/ndorozhynska/button.html");

        WebDriverWait wait = new WebDriverWait(driver, 20);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class = \"hide\"]")));
//        wait.until(new VisibleByLocatorAndTextCondition(By.cssSelector("button"), "Delayed Button"));
//        wait.until(new VisibleByText("Delayed Button"));
//        wait.until(utils.MyExpectedConditions.visibilityOfElementLocatedByAndText((By.xpath("//button[@class = \"hide\"]")), "Delayed Button"));
//        wait.until(utils.MyExpectedConditions.visibilityOfElementByText("Delayed Button"));
//        wait.until(utils.MyExpectedConditions.textToBePresentInElementLocated((By.xpath("//button[@class = \"hide\"]")), "Delayed Button"));

        WebElement button = driver.findElement(By.className("hide"));
        for (int i = 0; i < 5; i++) {
            button.click();
        }

        String text = button.getText();
        if (text.equals("Clicked 5")) {
            System.out.println("Clicked 5 times");
        }

        driver.quit();
    }
}