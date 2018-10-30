package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilmsPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class = \"MiniPostName\"]//child::a[@title]")
    List<WebElement> list;

    public FilmsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void printFilmsTitle() {
        for (int i = 0; i < list.size(); i++) {
            String title = list.get(i).getText();
            System.out.println(title);
        }
    }
}