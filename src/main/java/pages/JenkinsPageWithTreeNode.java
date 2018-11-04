package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class JenkinsPageWithTreeNode extends BasePage {

    @FindBy(css = "li.level0")
    WebElement suitItem;

    private WebDriverWait wait;

    public JenkinsPageWithTreeNode(WebDriver driver) {
        super(driver, "https://khospodarysko.github.io/training-selenium/9.2.%20jenkins.html");
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openSuitesByTreeNode() {
        TreeNode myTreeNode = new TreeNode(suitItem);
        System.out.println(myTreeNode.isClosed());
        myTreeNode.toggle();
        System.out.println(myTreeNode.isOpened());
        System.out.println(myTreeNode.getLinkText());

        for (TreeNode childNode : myTreeNode.getChildNodes()) {
            System.out.println(childNode.getLinkText());
            childNode.toggle();
            for( TreeNode childChildNode: childNode.getChildNodes()) {
                System.out.println("\t"+childChildNode.getLinkText());
            }
        }
    }
}

class TreeNode {
    private WebElement element;
    private By iconElementLocator = By.cssSelector("span");
    private By linkLocator = By.cssSelector("a");
    private By childrenNodeContainerLocator = By.cssSelector("ul");

    public TreeNode(WebElement element) {
        this.element = element;
    }

    private WebElement getIconElement() {
        return element.findElement(iconElementLocator);
    }

    private WebElement getLinkElement() {
        return element.findElement(linkLocator);
    }

    public boolean isOpened() {
        return getIconElement().getAttribute("class").contains("root_open");
    }

    public boolean isClosed() {
        return getIconElement().getAttribute("class").contains("root_close");
    }

    public void toggle() {
        this.getIconElement().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    public String getLinkText() {
        return getLinkElement().getText();
    }

    public List<TreeNode> getChildNodes() {
        List<WebElement> children = element.findElement(childrenNodeContainerLocator).findElements(By.xpath("li"));
        List<TreeNode> childNodes = new ArrayList<TreeNode>();
        for (WebElement element : children) {
            TreeNode myTreeNode = new TreeNode(element);
            childNodes.add(myTreeNode);
        }
        return childNodes;
    }
}