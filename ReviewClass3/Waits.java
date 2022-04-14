package com.syntax.ReviewClass3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Waits {
    public static String url = "https://chercher.tech/practice/implicit-wait-example";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

       //implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

       // Thread.sleep(10000);   <-- do not use this

        WebElement checkBox=driver.findElement(By.xpath("//input[@type= 'checkbox']"));
        checkBox.click();

    }
}
