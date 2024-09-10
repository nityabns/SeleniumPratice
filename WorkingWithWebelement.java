package com.SeleniumPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithWebelement {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Working With Web Element");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/register"); // to lunch the application
        driver.manage().window().maximize();
        /*driver.findElement(By.id("gender-male")).click();
        Thread.sleep(2000);
        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Surya");
        Thread.sleep(2000);
        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("B");
        Thread.sleep(2000);
        lastName.clear();
        driver.findElement(By.id("register-button")).submit();
*/
        WebElement element = driver.findElement(By.linkText("Register"));
        String str = element.getText();
        System.out.println("STR::"+str);
        //Thread.sleep(2000);
        WebElement logo = driver.findElement(By.tagName("img"));
        System.out.println("Is Displayed Logo::" +logo.isDisplayed());
        WebElement radioButton = driver.findElement(By.id("gender-male"));
        System.out.println("Is Radio Button Selected::"+ radioButton.isSelected());
        driver.findElement(By.id("gender-male")).click();
        System.out.println("Is Radio Button Selected::"+ radioButton.isSelected());
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.id("register-button"));
        System.out.println("Is Button selected::"+button.isEnabled());
        driver.quit();
    }
}
