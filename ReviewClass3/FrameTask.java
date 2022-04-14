package com.syntax.ReviewClass3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FrameTask {
    public static String url = "https://chercher.tech/practice/frames";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);


//I did in class
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        WebElement checkBox=driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();
        Thread.sleep(2000);


        //Second way to do this task
        driver.switchTo().frame("frame3");
        WebElement checkBox2=driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox2.click();
        Thread.sleep(2000);


        //Third way to do that
        WebElement frame1=driver.findElement(By.xpath("//iframe[@id = 'frame1']"));
        driver.switchTo().frame(frame1);

        // we did it with instructor
        driver.switchTo().frame(0);
        WebElement topic=driver.findElement(By.xpath("//b[@id = 'topic']"));
        System.out.println(topic.getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);

       WebElement dropdown= driver.findElement(By.tagName("select"));
       Select select=new Select(dropdown);
       select.selectByIndex(2);

       driver.switchTo().defaultContent();
       driver.switchTo().frame(0);
       driver.switchTo().frame(0);
        WebElement checkBox1=driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox1.click();
        Thread.sleep(2000);
        driver.quit();

    }
    }
