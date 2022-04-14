package com.syntax.Class6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
    public static  String url="http://www.uitestpractice.com/Students/Switchto";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.switchTo().frame(0);
        WebElement textbox=driver.findElement(By.id("name"));
        textbox.sendKeys("Batch 12 forever!!!");

        //we need to switch back from frame to get  alert manually if we dont switch cod won't work
        driver.switchTo().defaultContent();

        WebElement alertButton=driver.findElement(By.id("alert"));
        alertButton.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        alert.accept();
        driver.switchTo().frame("iframe_a");
        textbox.click();
        textbox.sendKeys("We are back to frame");

        driver.switchTo().defaultContent();
     WebElement frameElement=driver.findElement(By.xpath("//iframe[@src='/Demo.html']"));
     driver.switchTo().frame(frameElement);
     textbox.clear();
     textbox.sendKeys("Hold your horses");



    }
}
