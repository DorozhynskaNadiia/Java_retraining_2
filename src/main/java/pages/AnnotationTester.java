package pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;


public class AnnotationTester {

    private WebDriver driver;

    public AnnotationTester(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before suite");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("Before groups");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before test");
    }

    @Test
    public void testOne() {
        System.out.println("Test one");
    }

    @Test
    public void testTwo() {
        System.out.println("Test two");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After test");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("After groups");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After suite");
    }
}



//використати всі анотації (@Before, etc) - systemout
// + написати 2 тести

//зробити 2-й клас, аналогічний цьому класу, який наслідує цей клас і в ньому те саме (всі анотації + 2 тести - systemout) - подивитися послідовність виконання

//запустити спочатку тести з 2-го класу, а тоді з першого класу

// почитати про assertj
//reportNG
