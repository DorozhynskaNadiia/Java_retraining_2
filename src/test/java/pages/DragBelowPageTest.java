package pages;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class DragBelowPageTest extends BaseTest {

    private DragBelowPage myDragBelowPage;

    protected DragBelowPageTest() {
        super();
    }

    @BeforeClass
    public void setupClass() {
        super.setupClass();
        myDragBelowPage = new DragBelowPage(driver);
    }

    @BeforeMethod
    public void setup() {
        myDragBelowPage.navigate();
    }

    @Test
    public void scrollSlowly() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        myDragBelowPage.scrollSlowly();
    }

    @Test
    public void testScrollJavascript() {
        myDragBelowPage.scrollPageAndClickOnButtonSelenium();
        Assert.assertEquals("Button 500", myDragBelowPage.getMenuItemText(), "Target button text is not equal to expected one");
    }

    @Test
    public void testScrollSelenium() {
        myDragBelowPage.scrollPageAndClickOnButtonJavascript();
        Assert.assertEquals("Button 50", myDragBelowPage.getMenuItemText());
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
