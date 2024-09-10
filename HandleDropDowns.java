package com.SeleniumPratice;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleDropDowns {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String selectedTxt = singleElementDropdownSelected(driver);
        System.out.println("Selected Text::=>"+selectedTxt);
        multiElementDropdownSelected(driver);
        //Thread.sleep(3000);
        driver.close();
    }

    private static void multiElementDropdownSelected(WebDriver driver) throws InterruptedException {
        WebElement ideElmnt = driver.findElement(By.id("ide"));
        Select ideDrpdwnOptions = new Select(ideElmnt);
        List<WebElement> options = ideDrpdwnOptions.getOptions();
        System.out.println("List of all Elements from Multi DropDown Menu");
        displayOptions(options);
        ideDrpdwnOptions.selectByIndex(0); // Eclipse
        Thread.sleep(2000);
        ideDrpdwnOptions.selectByValue("ij"); // Intelij IDEA
        Thread.sleep(2000);
        ideDrpdwnOptions.selectByVisibleText("NetBeans"); // Netbeans
        Thread.sleep(2000);
        ideDrpdwnOptions.deselectByIndex(1);
        List<WebElement> selectedOptions = ideDrpdwnOptions.getAllSelectedOptions();
        System.out.println("Selected Items from Multi Drop Down List");
        displayOptions(selectedOptions);
    }

    private static String singleElementDropdownSelected(WebDriver driver) throws InterruptedException {
        WebElement crsElmnt = driver.findElement(By.id("course"));
        Select crsDrpdwnOptions = new Select(crsElmnt);
        List<WebElement> options = crsDrpdwnOptions.getOptions();
        System.out.println("List of all Elements from Single DropDown Menu");
        displayOptions(options);
        crsDrpdwnOptions.selectByIndex(1); // JAVA
        Thread.sleep(2000);
        crsDrpdwnOptions.selectByValue("net"); // Dot net
        Thread.sleep(2000);
        crsDrpdwnOptions.selectByVisibleText("Python"); // Python
        return crsDrpdwnOptions.getFirstSelectedOption().getText();
    }

    private static void displayOptions(List<WebElement> options) {
        for (WebElement webelmt: options){
            System.out.println(webelmt.getText());
        }
        System.out.println();
    }
}
