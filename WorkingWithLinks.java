package com.SeleniumPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WorkingWithLinks {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("Webdriver.chrome.driver",".//resourses/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/"); // to lunch the application
        Thread.sleep(2000);
        List< WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("No of Links::"+links.size());
        int cnt=0;
        for(WebElement linktext:links) {
            if(linktext.isDisplayed()) {
                cnt++;
                System.out.println("Link==>"+linktext.getText());
            }
        }
        System.out.println("Displayed Links Count==>"+cnt);
        driver.close();
    }
}
