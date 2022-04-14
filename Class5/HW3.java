package com.syntax.Class5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Go to ebay.com
get all the categories and print them in the console
select Computers/Tables & Networking
click on search
verify the header
 */
public class HW3 {
    public static  String url="https://www.ebay.com";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);


    }

}
