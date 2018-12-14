package pages;

import org.testng.annotations.*;
import org.testng.annotations.Test;


public class AnnotationTester {

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

    @Test(groups = {"testOne"})
    public void testOne1() {
        System.out.println("Test one");
    }

    @Test(groups = {"testTwo"})
    public void testTwo1() {
        System.out.println("Test two");
    }

    @Test (groups = {"testThree"})
    public void testThree() {
        System.out.println("Test three");
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


// почитати про assertj
//reportNG

//написати xml яка буде запускати 2 з 3-х тестів в 1 класі (include exclude)

//maven surefire plugin + testng, прочитати як запускати custom testng xml через maven surefire з command line  - через mvn clean test

//testng listener, виводити стрічку, коли тест стартує і закінчується (start test and end test). зробити 2 різні тести, 1 пасд, один сфейлити. в форматі
// повний шлях до класу + ім'я метода
