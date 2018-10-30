package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JenkinsPage extends BasePage {
    @FindBy(css = "li.level0 > span")
    WebElement suiteIconLocator;  ////span[@class = \"button level1 switch center_close\"]

    @FindBy(css = "li.level1")
    List<WebElement> levelOneLocator;

    @FindBy(css = "li.level1 > span")
    List<WebElement> classesPlusLocator;

    @FindBy(css = "li.level1 > a")
    List<WebElement> classesTextLocator;  ////li[@class = 'level1']//span[@class = 'node_name']

    @FindBy(xpath = "//span[contains(@class,'center_close')]//parent::li")
    List<WebElement> closedListLocator;

    ////span[contains(@style,'testerr')]//ancestor::li[@class='level1']
    ////li[@class='level1'][descendant::*[contains(@style,'testerr')]]
    ////li[@class='level1'][.//*[contains(@style,'testerr')]]
    ////li[@class='level1'][.//*[contains(@style,'testerr')] or .//*[contains(@style,'testignored')]]

    private WebDriverWait wait;

    public JenkinsPage(WebDriver driver) {
        super(driver, "https://khospodarysko.github.io/training-selenium/9.2.%20jenkins.html");
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void expandSuite() {
        WebElement suiteIcon = suiteIconLocator;
        suiteIcon.click();
        wait.until(utils.MyExpectedConditions.heightToBeStable(By.cssSelector("li#tree-1_1"), 500));
    }

    public void expandAllJavascript() {
        List<WebElement> list = classesPlusLocator;
        executor.executeScript("arguments[0].forEach(function(i){i.click();})", list);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void expandAllActions() {
        Actions action = new Actions(driver);
        List<WebElement> list = classesTextLocator;
        for (WebElement element : list) {
            action.doubleClick(element).build().perform();
        }
    }

    public List<String> getClosed() {
        List<WebElement> closedList = closedListLocator;
        List<String> closedListText = new ArrayList<>();
        String classText;
        for (WebElement levelOneElement : closedList) {
            classText = levelOneElement.findElement(By.cssSelector("a")).getText();
            System.out.println(getClassName(classText));
        }
        return closedListText;
    }

    private String getClassName(String fullClassText) {
        int parenthesisIndex = fullClassText.indexOf('(');
        if (parenthesisIndex != -1) {
            fullClassText = fullClassText.substring(0, parenthesisIndex);
        }
        int dotIndex = fullClassText.lastIndexOf('.');
        fullClassText = fullClassText.substring(dotIndex + 1);

        return fullClassText;
    }

    private String getTestName(String fullTestText) {
        int parenthesisIndex = fullTestText.indexOf('(');
        if (parenthesisIndex != -1) {
            fullTestText = fullTestText.substring(0, parenthesisIndex);
        }
        return fullTestText;
    }

    public void expandAllSelenium() {
        List<WebElement> levelOneElements = levelOneLocator;
        for (WebElement levelOneElement : levelOneElements) {
            WebElement icon = levelOneElement.findElement(By.cssSelector("span.switch"));
            icon.click();
            WebElement testListElement = levelOneElement.findElement(By.cssSelector("ul"));
            while (true) {
                String styleAttr = testListElement.getAttribute("style");
                if (!styleAttr.contains("height") && !styleAttr.contains("display: none")) {
                    break;
                }
            }
        }
    }

    public void expandAllSeleniumReverse() {
        List<WebElement> levelOneElements = levelOneLocator;
        Collections.reverse(levelOneElements);
        for (WebElement levelOneElement : levelOneElements) {
            WebElement icon = levelOneElement.findElement(By.cssSelector("span.switch"));
            icon.click();
//        for (int i = levelOneElements.size() - 1; i >= 0; i--) {
//            WebElement icon = levelOneElements.get(i).findElement(By.cssSelector("span.switch"));
//            icon.click();
        }
    }

    public void getFailedSkippedTests() {
        List<WebElement> levelOneElements = levelOneLocator;
        String testText;
        for (WebElement levelOneElement : levelOneElements) {
            WebElement classNameElement = levelOneElement.findElement(By.cssSelector("a"));
            String className = classNameElement.getText();

            List<WebElement> levelTwoElements = levelOneElement.findElements(By.cssSelector(("li")));
            List<String> failed = new ArrayList<>();
            List<String> skipped = new ArrayList<>();
            int failedIndex = 0;
            int skippedIndex = 0;
            for (WebElement levelTwoElement : levelTwoElements) {
                WebElement icon = levelTwoElement.findElement(By.cssSelector("span.ico_docu"));
                String styleAttr = icon.getAttribute("style");
                testText = levelTwoElement.findElement(By.cssSelector(".node_name")).getText();
                String methodName = getTestName(testText);
                if (styleAttr.contains("testerr")) {
                    failed.add(getTestName(methodName));
                    failedIndex = failedIndex + 1;
                } else if (styleAttr.contains("testignored")) {
                    skipped.add(getTestName(methodName));
                    skippedIndex = skippedIndex + 1;
                }
            }
            if(failed.size() > 0 || skipped.size()> 0) {
                System.out.println(getClassName(className));
            }

            if (failed.size() > 0) {
                for (String failedName : failed) {
                    System.out.println("\t" + "failed - " + failedName);
                }
            }

            if (skipped.size() > 0) {
                for (String skippedName : skipped) {
                    System.out.println("\t" + "skipped - " + skippedName);
                }
            }
        }
    }
}