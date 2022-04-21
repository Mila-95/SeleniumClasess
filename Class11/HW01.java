package com.syntax.Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class HW01 {
    /*
    HW
open new browser
open a new tab
navigate to a different URL on a new tab

     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.amazom.com");
        driver.navigate().to("http://google.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();







    }
}
