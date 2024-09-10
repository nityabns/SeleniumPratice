package com.SeleniumPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.findElement(By.id("APjFqb")).sendKeys("Nitya");
        driver.findElement(By.id("APjFqb")).submit();
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
        driver.close();
    }
}
