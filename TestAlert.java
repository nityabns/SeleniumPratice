package com.SeleniumPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
        //Alert Box
        System.out.println(driver.findElement(By.id("output")).getText());
        driver.findElement(By.id("alertBox")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.id("output")).getText());
        Thread.sleep(3000);
        //Confirm Box
        System.out.println(driver.findElement(By.id("output")).getText());
        driver.findElement(By.id("confirmBox")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.id("output")).getText());
        Thread.sleep(3000);
        driver.findElement(By.id("confirmBox")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        System.out.println(driver.findElement(By.id("output")).getText());
        Thread.sleep(3000);
        //Prompt Box
        System.out.println(driver.findElement(By.id("output")).getText());
        driver.findElement(By.id("promptBox")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("SURYA");
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.id("output")).getText());
        Thread.sleep(3000);
        driver.findElement(By.id("promptBox")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        System.out.println(driver.findElement(By.id("output")).getText());
        driver.close();
    }
}
