package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    private WebDriver driver;
    private String subMenuSelector = "//ul[@id = 'six']//a[normalize-space(text()) = '%s']";
    private String url = "http://ex-fs.net/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage navigate() {
        this.driver.get(url);
        return this;
    }

    private WebElement getTopLevelMenuItem(String menuItem) {
        return driver.findElement(By.xpath(String.format("//ul[@class = 'nav pt pull-left']//a[normalize-space(text()) = '%s']", menuItem)));
    }

    private WebElement getSubMenuItem(String subMenuItem) {

        return driver.findElement(By.xpath(String.format(subMenuSelector, subMenuItem)));
    }

    public void openMovieTypeMenu(String... menus) {
        Actions action = new Actions(driver);
        WebElement firstLevelMenu = getTopLevelMenuItem(menus[0]);

        if (menus.length == 1) {
            action.click(firstLevelMenu).build().perform();
        } else {
            WebElement secondLevel = getSubMenuItem(menus[1]);

            action.moveToElement(firstLevelMenu).click(secondLevel).build().perform();
        }
    }

//    public static void openMovieTypeMenu(String levelOne, String levelTwo) {
//
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("http://ex-fs.net/");
//
//        WebElement firstLevelMenu = driver.findElement(By.xpath("//ul[@class = 'nav pt pull-left']//a[normalize-space(text()) = '"+ levelOne +"']"));
//        WebElement secondLevel = driver.findElement(By.xpath("//ul[@id = 'six']//a[normalize-space(text()) = '" + levelTwo +"']"));
//
//        Actions action = new Actions(driver);
//        action.moveToElement(firstLevelMenu).click(secondLevel).build().perform();
//
//        driver.quit();
//        }
//
//    public static void openMovieTypeMenu(String levelOne) {
//
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("http://ex-fs.net/");
//
//        WebElement firstLevelMenu = driver.findElement(By.xpath("//ul[@class = 'nav pt pull-left']//a[normalize-space(text()) = '"+ levelOne +"']"));
//
//
//        Actions action = new Actions(driver);
//        action.click(firstLevelMenu).build().perform();
//
//        driver.quit();
//    }

}