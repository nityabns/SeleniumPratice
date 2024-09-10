package com.SeleniumPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotCapture {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        //File  screenshots
        /* 3 ways to take screen shots
        1. File
        2. byte[]
        3. BASE64
         */
        File sourceFile = driver.getScreenshotAs(OutputType.FILE);
        /* ChromeDriver and RemoteDriver instances only supports getScreenshotAs(),
        WebDriver instance is not support directly, we should do type cast.
         */
        File destFile = new File("./screenshots/img1.jpg");
        FileUtils.copyFile(sourceFile,destFile);
        driver.close();
        System.out.println("ScreenShot Saved Successfully");
    }
}
