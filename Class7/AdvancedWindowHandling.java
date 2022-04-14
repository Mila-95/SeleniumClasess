package com.syntax.Class7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class AdvancedWindowHandling {
    /*
    clicks on buttons and open new tab

     */


    public static String url = "http://www.uitestpractice.com/Students/Contact";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        String mainPageHandle=driver.getWindowHandle();
        WebElement igButton=driver.findElement(By.linkText("Follow On Instagram"));
        WebElement fbButton=driver.findElement(By.linkText("Like us On Facebook"));
        WebElement igAndFbButton=driver.findElement(By.linkText("Follow Instagram & Facebook"));

        igButton.click();
        fbButton.click();
        igAndFbButton.click();

       Set< String> allWindowsHendle=driver.getWindowHandles();
        System.out.println(allWindowsHendle.size());

       Iterator<String> it= allWindowsHendle.iterator();
       while(it.hasNext()){   //start iterating through the handles
           String handle=it.next();     //getting the next handle
           if(!mainPageHandle.equals(handle)) {  //set a condition
               driver.switchTo().window(handle);//switch to a window which is not equal to mai9n page handle
               //driver.manage().window().maximize();
               // driver.switchTo().window(handle);
               String title = driver.getTitle();
               System.out.println(title);
               driver.close();

           }
       }
       driver.switchTo().window(mainPageHandle);//switching back to parent handle
       igButton.click();
    }

    }
