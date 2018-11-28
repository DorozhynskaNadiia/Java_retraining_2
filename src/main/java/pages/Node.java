package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Node {

    protected WebDriver driver;
    protected WebElement wrappedElement;
    protected By iconElementLocator = By.cssSelector("span");
    protected By linkLocator = By.cssSelector("a");

    protected Node(WebElement element) {
        this.wrappedElement = element;

    }

    public WebElement getIconElement() {
        return wrappedElement.findElement(iconElementLocator);
    }

    public WebElement getLinkElement() {
        return wrappedElement.findElement(linkLocator);
    }

    public boolean isOpened() {
        String classAttribute = getIconElement().getAttribute("class");
        return classAttribute.contains("center_open") || classAttribute.contains("root_open");
    }

    public boolean isClosed() {
        String classAttribute = getIconElement().getAttribute("class");
        return classAttribute.contains("center_close") || classAttribute.contains("root_close");
    }

    public String getLinkText() {
        return getLinkElement().getText();
    }

    public void open() {
        if (isClosed()) {
            this.getIconElement().click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void close() {
        if (isOpened()) {
            this.getIconElement().click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }
}



//винести всі спільн методи сюди з ClassNode + SuiteNode