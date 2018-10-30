package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected String url;
    protected JavascriptExecutor executor;

    protected BasePage(WebDriver driver, String url) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) driver;
        this.url = url;
    }

    public BasePage navigate() {
        this.driver.get(url);
        return this;
    }
}


