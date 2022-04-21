package com.syntax.Class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*Go to https://syntaxprojects.com/javascript-alert-box-demo.php
click on each button and handle the alert accordingly */
public class HW2 {
    public static String url = " https://syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement firstButton=driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        firstButton.click();
        Alert simpleAlert1= driver.switchTo().alert();
        Thread.sleep(2000);
        simpleAlert1.accept();

        WebElement secondButton=driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
        secondButton.click();
        Alert simpleAlert2= driver.switchTo().alert();
        Thread.sleep(2000);
        simpleAlert2.accept();

        WebElement thirdButton=secondButton.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
        thirdButton.click();
        Alert simpleAlert3=driver.switchTo().alert();
        simpleAlert3.sendKeys("Mila");
        Thread.sleep(2000);
        simpleAlert3.accept();
        Thread.sleep(2000);




         driver.quit();
    }
}

