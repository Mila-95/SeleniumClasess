package com.syntax.Class6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Navigate to https://syntaxprojects.com/bootstrap-iframe.php
verify the header text AUTOMATION TESTING PLATFORM BY SYNTAX is displayed
verify enroll today button is enabled
 */
public class HW1 {
    public static String url = "https://syntaxprojects.com/bootstrap-iframe.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement syntax=driver.findElement(By.id("hide"));
        if(syntax.isDisplayed()){
            System.out.println(" SYNTAX is displayed");
        }else{
            System.out.println("Error");
        }
        Thread.sleep(2000);

driver.switchTo().frame("FrameTwo");
WebElement enrollButton=driver.findElement(By.className("text-block-2"));
     if(enrollButton.isEnabled()){
        System.out.println("Button is unable");
    }else{
         System.out.println("button is displayed");
     }
Thread.sleep(2000);
driver.quit();

    }
}
