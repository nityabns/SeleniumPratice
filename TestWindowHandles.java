package com.SeleniumPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class TestWindowHandles {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        String parentWindowHandel = driver.getWindowHandle();
        singleWindowHandler(driver,parentWindowHandel);
        driver.switchTo().window(parentWindowHandel);
        driver.findElement(By.id("name")).sendKeys("Jai Hanumaa");
        Thread.sleep(2000);
        singleTabHandler(driver,parentWindowHandel);
        driver.switchTo().window(parentWindowHandel);
        driver.findElement(By.id("name")).sendKeys("Jai Jai Jai");
        Thread.sleep(2000);
        driver.quit();
    }

    private static void singleTabHandler(WebDriver driver, String parentWindowHandel) {
        driver.findElement(By.id("newTabBtn")).click();
        Set<String> tabHandels = driver.getWindowHandles();
        for(String tabHanel: tabHandels) {
            if(!tabHanel.equals(parentWindowHandel)) {
                driver.switchTo().window(tabHanel);
                System.out.println(driver.findElement(By.id("output")).getText());
                driver.findElement(By.id("confirmBox")).click();
                System.out.println(driver.switchTo().alert().getText());
                driver.switchTo().alert().accept();
                System.out.println(driver.findElement(By.id("output")).getText());
                //Thread.sleep(3000);
                driver.close();
            }
        }
    }

    private static void singleWindowHandler(WebDriver driver, String parentWindowHandel) throws Exception{
        driver.findElement(By.id("newWindowBtn")).click();
        Set<String> windowHandels = driver.getWindowHandles();
        for(String windowHanel: windowHandels) {
            if(!windowHanel.equals(parentWindowHandel)) {
                driver.switchTo().window(windowHanel);
                driver.manage().window().maximize();
                driver.findElement(By.id("firstName")).sendKeys("Jai Sri Ram");
                Thread.sleep(3000);
                driver.close();
            }
        }

    }
}
