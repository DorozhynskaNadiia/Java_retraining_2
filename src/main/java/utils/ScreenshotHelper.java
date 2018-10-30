package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotHelper {

    public static void takeScreenshots(WebDriver driver) {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss-SSS");
        String formatDateTime = now.format(formatter);

        try {
            FileUtils.copyFile(scrFile, new File("screenshots\\" + "Screenshot " + formatDateTime + ".png"));
        } catch (IOException e) {
            System.out.println("Couldn't copy screenshot in folder");
        }
    }
}
