package pages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JenkinsPageTest extends BaseTest {

    private JenkinsPage myJenkinsPage;

    protected JenkinsPageTest() {
        super();
    }

    @BeforeClass
    public void setupClass() {
        super.setupClass();
        myJenkinsPage = new JenkinsPage(driver);
    }

    @BeforeMethod
    public void setup() {
        myJenkinsPage.navigate();
        myJenkinsPage.expandSuite();
    }

    @Test
    public void testExpandAllJavascript() {
        myJenkinsPage.expandAllJavascript();
        myJenkinsPage.getFailedSkippedTests();
    }

    @Test
    public void testExpandAllActions() {
        myJenkinsPage.expandAllActions();
    }

    @Test
    public void testExpandAllSelenium() {
        myJenkinsPage.expandAllSelenium();
    }

    @Test
    public void testExpandAllSeleniumReverse() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        myJenkinsPage.expandAllSeleniumReverse();
        myJenkinsPage.getFailedSkippedTests();

    }

    @Test
    public void getClosed() {
        myJenkinsPage.expandAllActions();
        myJenkinsPage.getClosed();
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }

}