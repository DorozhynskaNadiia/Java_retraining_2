//знайти клас який найбільше часу виконується
//посортувати класи по часі виконання

//regular expression щоб витягнути час виконання класів (патерн, що може бути, а що може не бути)

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class JenkinsPageWithTreeNode extends BasePage {

    @FindBy(css = "li.level0")
    WebElement suitItem;

    private WebDriverWait wait;
    private SuiteNode mySuiteNode;

    public JenkinsPageWithTreeNode(WebDriver driver) {
        super(driver, "https://khospodarysko.github.io/training-selenium/9.2.%20jenkins.html");
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
        mySuiteNode = new SuiteNode(suitItem);
    }

    public SuiteNode getSuite() {
        return mySuiteNode;
    }

    public static class SuiteNode extends Node{

        public SuiteNode(WebElement element) {
            super(element);
        }

        public List<ClassNode> getClasses() {
            List<WebElement> classes = wrappedElement.findElements(By.cssSelector("li.level1"));
            return classes.stream().map(webElement -> new ClassNode(webElement)).collect(Collectors.toList());
        }
    }

    public static class ClassNode extends Node{

        public ClassNode(WebElement element) {
            super(element);
        }

        private String getClassNames() {
            String fullClassText = this.getLinkText();
            int parenthesisIndex = fullClassText.indexOf('(');
            if (parenthesisIndex != -1) {
                fullClassText = fullClassText.substring(0, parenthesisIndex);
            }
            int dotIndex = fullClassText.lastIndexOf('.');
            fullClassText = fullClassText.substring(dotIndex + 1);

            return fullClassText;
        }

//        private double timeOfClassRun() {
//            String fullClassText = this.getLinkText();
//            int parenthesisIndex = fullClassText.indexOf(')');
//            if (parenthesisIndex != -1) {
//                fullClassText = fullClassText.substring(0, parenthesisIndex);
//            }
//            int secondParenthesisIndex = fullClassText.lastIndexOf('(');
//            fullClassText = fullClassText.substring(secondParenthesisIndex + 1);
//
//            return fullClassText;
//        }

        public List<MethodNode> getMethods() {
            List<WebElement> methods = wrappedElement.findElements(By.cssSelector("li.level2"));
            return methods.stream().map(webElement -> new MethodNode(webElement)).collect(Collectors.toList());
        }

        public boolean hasFailed() {
            for (MethodNode methods : getMethods()) {
                if (methods.isFailed()) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasSkipped() {
            for (MethodNode methods : getMethods()) {
                if (methods.isSkipped()) {
                    return true;
                }
            }
            return false;
        }

    }

    public static class MethodNode extends Node{

        private WebElement icon;

        public MethodNode(WebElement element) {
            super(element);
        }

        private String getTestName() {
            String fullTestText = this.getLinkText();
            int parenthesisIndex = fullTestText.indexOf('(');
            if (parenthesisIndex != -1) {
                fullTestText = fullTestText.substring(0, parenthesisIndex);
            }
            return fullTestText;
        }

        public boolean isFailed() {
            icon = wrappedElement.findElement(By.cssSelector("span.ico_docu"));
            return icon.getAttribute("style").contains("testerr");
        }

        public boolean isSkipped() {
            icon = wrappedElement.findElement(By.cssSelector("span.ico_docu"));
            return wrappedElement.getAttribute("style").contains("testignored");
        }
    }
}
