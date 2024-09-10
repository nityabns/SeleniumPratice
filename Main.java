package com.SeleniumPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello world!");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/"); // to lunch the application
        Thread.sleep(2000);
        driver.navigate().to("https://www.fb.com");// to lunch the application with history
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println("The title of the page ="+title);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("URL = "+currentUrl);
        String src = driver.getPageSource();
        System.out.println("SRC="+src);
        driver.manage().window().maximize(); //How can we maximize the window size

        driver.switchTo().newWindow(WindowType.TAB); // How to switch one tab to another
        driver.switchTo().newWindow(WindowType.WINDOW); // How to switch one window to another

        String win1 = driver.getWindowHandle();
        System.out.println(win1);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.instagram.com");
        String win2 = driver.getWindowHandle();
        System.out.println(win2);
        Set<String> wins = driver.getWindowHandles();
        System.out.println("No of Windows:: "+wins.size());

        Thread.sleep(2000);
        Thread.sleep(2000);
        //driver.close();
        driver.quit();
    }
}