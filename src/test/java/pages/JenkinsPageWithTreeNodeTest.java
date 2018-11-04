package pages;

import org.testng.annotations.*;
import org.testng.annotations.Test;

public class JenkinsPageWithTreeNodeTest extends BaseTest{

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
    public void  openSuitesByTreeNode() {
        myJenkinsPageWithTreeNode.openSuitesByTreeNode();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }


}
