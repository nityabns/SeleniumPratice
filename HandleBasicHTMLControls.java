package com.SeleniumPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBasicHTMLControls {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
		driver.findElement(By.id("femalerb")).click();
		Thread.sleep(2000);
		WebElement engchkbox = driver.findElement(By.id("englishchbx"));
		engchkbox.click();
		Thread.sleep(2000);
		if(engchkbox.isSelected()){
			engchkbox.click();
		}
		Thread.sleep(2000);
		driver.findElement(By.id("hindichbx")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("registerbtn")).click();
		System.out.println(driver.findElement(By.id("msg")));
		Thread.sleep(2000);
	}

}
