package com.syntax.Class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingElement {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("http://fb.com");
        driver.findElement(By.id("email")).sendKeys("symtax@ad.com");
        driver.findElement(By.id("pass")).sendKeys("watewer");
        driver.findElement(By.name("login")).click();
        Thread.sleep(2000);
       // driver.findElement(By.linkText("Forgot password?")).click(); whole link text
        driver.findElement(By.partialLinkText("Forgot")).click();
        driver.quit();

    }
}
