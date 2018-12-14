package pages;

import org.testng.annotations.*;
import org.testng.annotations.Test;

public class AnnotationTesterChild extends AnnotationTester {

    @BeforeSuite
    public void beforeSuiteChild() {
        System.out.println("Before suite inherited");
    }

    @BeforeGroups
    public void beforeGroupsChild() {
        System.out.println("Before groups inherited");
    }

    @BeforeClass
    public void beforeClassChild() {
        System.out.println("Before class inherited");
    }

    @BeforeMethod
    public void beforeMethodChild() {
        System.out.println("Before method inherited");
    }

    @BeforeTest
    public void beforeTestChild() {
        System.out.println("Before test inherited");
    }

    @Test
    public void testOneChild() {
        System.out.println("Test one inherited");
    }

    @Test
    public void testTwoChild() {
        System.out.println("Test two inherited");
    }

    @Test
    public void testThreeChild() {
        System.out.println("Test three inherited");
    }

    @AfterTest
    public void afterTestChild() {
        System.out.println("After test inherited");
    }

    @AfterMethod
    public void afterMethodChild() {
        System.out.println("After method inherited");
    }

    @AfterClass
    public void afterClassChild() {
        System.out.println("After class inherited");
    }

    @AfterGroups
    public void afterGroupsChild() {
        System.out.println("After groups inherited");
    }

    @AfterSuite
    public void afterSuiteChild() {
        System.out.println("After suite inherited");
    }
}
