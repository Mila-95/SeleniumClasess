package com.syntax.Class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaximizedWindow {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver =new ChromeDriver();
        driver.navigate().to("https://amazon.com/");
        driver.manage().window().maximize(); //makes winndow bigger 99%WILL be uset on job
        driver.manage().window().fullscreen();//on full screen WE CANNOT GO BACK,NO CONTROL PANNEL
    }
}
