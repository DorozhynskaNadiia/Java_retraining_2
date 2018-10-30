package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        DragBelowPage myDragBelowPage = new DragBelowPage(driver);

        myDragBelowPage.navigate();
        myDragBelowPage.scrollSlowly();
//        myDragBelowPage.scrollPageAndClickOnButtonJavascript();
//        myDragBelowPage.scrollPageAndClickOnButtonSelenium();

        driver.quit();






//        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//        Time myTime = new Time(driver);
//
//        myTime.navigate();
//        myTime.waitUntilLastDigitIsZero(5);
//
//        driver.quit();





//        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//        MultipleLevelMenu myMultipleMenu = new MultipleLevelMenu(driver);
//
//        myMultipleMenu.navigate();
//        myMultipleMenu.navigateAndClickTime();
//        myMultipleMenu.getTimeAndPrintFormatted();
//
//
//        driver.quit();




//        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
////        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
////        WebDriver driver = new FirefoxDriver();
//
//        Menu myMenu = new Menu(driver);
//
//        myMenu.navigate();
//        myMenu.navigateToFinalLevelAndClick();
//        myMenu.getDateAndTimeAndPrintFormatted();
//
//        driver.quit();




//        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//        DynamicList myDynamicList = new DynamicList(driver);
//
//        myDynamicList.navigate();
//
//        myDynamicList.waitForVisibilityOfTextInAllRows();
//
//        driver.quit();




//        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
//
//        Spinners mySpinners = new Spinners(driver);
//
//        mySpinners.navigate();
//
//        mySpinners.countSmallSpinners();
//        mySpinners.countLargeSpinners();
//        mySpinners.countExtraSpinners();
//
//        mySpinners.waitUntilOneSpinnerLeft();
//        ScreenshotHelper.takeScreenshots(driver);
//
//        mySpinners.waitUntilListIsEmpty();
//
//        driver.quit();




//        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

//        pages.Methods.getFilmTitlesInCarusel();
//        pages.Methods.getFilmsViaParent();
//        pages.Methods.getFilmsViaChild();
//        pages.Methods.getListOfCategoriesInFilms();
//        pages.Methods.getTitlesOfSerials();
//        pages.Methods.getTitleYearCountryOfSerials();
//        pages.Button.clickButtonFiveTimes();
//        pages.HomePage.openMovieTypeMenu("Передачи и шоу");
//        pages.Slider.moveSlider();

//        WebDriver driver = new ChromeDriver();
//        driver
//            .manage()
//            .window()
//            .maximize();
//
//        HomePage myHomePage = new HomePage(driver);
//        FilmsPage myFilmsPage = new FilmsPage(driver);
//
//        myHomePage.navigate();
//        myHomePage.openMovieTypeMenu("Категории", "Немецкие");
//        myFilmsPage.printFilmsTitle();
//
//        driver.quit();
    }
}
