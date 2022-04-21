package com.syntax.Class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {
    public static  String url="http://www.uitestpractice.com/Students/Switchto";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement simpleAlertButton=driver.findElement(By.id("alert"));
        simpleAlertButton.click();

        //switch the focus to alert
       Alert simpleAlert= driver.switchTo().alert();
       Thread.sleep(2000);
       simpleAlert.accept();

       WebElement confirmAlertButton=driver.findElement(By.id("confirm"));
       confirmAlertButton.click();
       Thread.sleep(2000);

       //switch the focus to alert
       Alert confirmAlert=driver.switchTo().alert();
       String alertText= confirmAlert.getText();
        System.out.println(alertText);
        confirmAlert.dismiss();

        WebElement promptAlertButton=driver.findElement(By.cssSelector("button#prompt"));
        promptAlertButton.click();
        Thread.sleep(2000);
       Alert pronmAlert=driver.switchTo().alert();
       pronmAlert.sendKeys("Batch 12 is the best");
       pronmAlert.accept();






    }
}
