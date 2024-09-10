package com.SeleniumPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleiFrames {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
        driver.findElement(By.id("name")).sendKeys("Nitya");
        driver.switchTo().frame("frm1");

        Select courseNameDD = new Select(driver.findElement(By.id("course")));
        courseNameDD.selectByVisibleText("Java");
        Thread.sleep(4000);
        driver.switchTo().defaultContent();//Home page or main doc

        driver.switchTo().frame("frm2");
        driver.findElement(By.id("firstName")).sendKeys("SURYA");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frm1");

        courseNameDD.selectByVisibleText("Python");
        Thread.sleep(3000);

        driver.switchTo().defaultContent();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("Nitya");
        driver.close();

    }
}
