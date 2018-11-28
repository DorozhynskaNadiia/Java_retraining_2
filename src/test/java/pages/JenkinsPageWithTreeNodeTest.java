package pages;

import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.List;

public class JenkinsPageWithTreeNodeTest extends BaseTest {

    private JenkinsPageWithTreeNode myJenkinsPageWithTreeNode;

    protected JenkinsPageWithTreeNodeTest() {
        super();
    }

    @BeforeClass
    public void setupClass() {
        super.setupClass();
        myJenkinsPageWithTreeNode = new JenkinsPageWithTreeNode(driver);
    }

    @BeforeMethod
    public void navigate() {
        myJenkinsPageWithTreeNode.navigate();
    }

    @Test
    public void getSuite() {
        JenkinsPageWithTreeNode.SuiteNode mySuite = myJenkinsPageWithTreeNode.getSuite();
        mySuite.open();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getFailedClasses() {
        myJenkinsPageWithTreeNode.getSuite().open();
            List<JenkinsPageWithTreeNode.ClassNode> myClasses = myJenkinsPageWithTreeNode.getSuite().getClasses();
            for (JenkinsPageWithTreeNode.ClassNode classes : myClasses) {
                classes.open();
                System.out.println("Failed: " + classes.hasFailed());
        }
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }


}
