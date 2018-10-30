package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.Test;

import java.util.List;

public class Methods extends Test {

    public static void getFilmTitlesInCarusel() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ex-fs.net/");
        List<WebElement> list = driver.findElements(By.cssSelector(".owl-item img[title]"));

        for (int i = 0; i < list.size(); i++) {
            String title = list.get(i).getAttribute("title");

            String cutFirstPart = title.substring(10);
            String cutSecondPart = cutFirstPart.replace("» онлайн", " ");

            System.out.println(cutSecondPart);
        }
        driver.quit();
    }

    public static void getFilmsViaParent() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ex-fs.net/");

        WebElement films = driver.findElement(By.xpath("//ul[@class=\"nav pt pull-left\"]//child::a[@href=\"/films/\"]"));

        String title = films.getText();
        System.out.println(title);

        driver.quit();
    }

    public static void getFilmsViaChild() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ex-fs.net/");

        WebElement films = driver.findElement(By.xpath("//span[@class=\"glyphicon glyphicon-chevron-down icosm\"]/parent::a[@href=\"/films/\"]"));

        String title = films.getText();
        System.out.println(title);

        driver.quit();
    }

    public static void getListOfCategoriesInFilms() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ex-fs.net/");

        WebElement menu = driver.findElement(By.xpath("//a[@href = \"/films/\"]"));
        Actions action = new Actions(driver);
        action.moveToElement(menu).build().perform();

        List<WebElement> list = driver.findElements(By.xpath("//a[@href = \"/films/\"]//following-sibling::ul//a"));

        for (int i = 0; i < list.size(); i++) {
            String title = list.get(i).getText();
            System.out.println(title);
        }
        driver.quit();
    }

    public static void getTitlesOfSerials() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ex-fs.net/");

        WebElement serials = driver.findElement(By.xpath("//a[@href='/series/']"));
        WebElement ukrainian = driver.findElement(By.xpath("//a[@href='/genre/на_украинском/']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(serials).moveToElement(ukrainian).click(ukrainian).build().perform();

        List<WebElement> list = driver.findElements(By.xpath("//div[@class = \"MiniPostName\"]//child::a[@title]"));

        for (int i = 0; i < list.size(); i++) {
            String title = list.get(i).getText();
            System.out.println(title);
        }
        driver.quit();
    }

    public static void getTitleYearCountryOfSerials() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ex-fs.net/");

        WebElement serials = driver.findElement(By.xpath("//a[@href='/series/']"));
        WebElement ukrainian = driver.findElement(By.xpath("//a[@href='/genre/на_украинском/']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(serials).moveToElement(ukrainian).click(ukrainian).build().perform();

        List<WebElement> movieContainer = driver.findElements(By.cssSelector(".MiniPostAllForm"));

        for (WebElement movie : movieContainer) {
            String title = movie.findElement(By.cssSelector(".MiniPostName a")).getText();
            String country = movie.findElement(By.cssSelector(".MiniPostInfo a:nth-child(2)")).getText();
            String year = movie.findElement(By.cssSelector(".MiniPostInfo a[href*=year]")).getText();

            System.out.format("%s %s %s\n", title, country, year);
        }
        driver.quit();
    }
}
