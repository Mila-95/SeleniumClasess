package com.syntax.Class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HW1 {
    /*  Go to https://demoqa.com/browser-windows
click on New Tab and print the text from new tab in the console
click on New Window and print the text from new window in the console
click on New Window Message and print the text from new window in the console
Verify (compare) the titles for each page
Print out the title of the all pages     */
    public static String url = "https://demoqa.com/browser-windows";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String mainPageHandle=driver.getWindowHandle();

        WebElement newTab=driver.findElement(By.id("tabButton"));
        WebElement newWindow=driver.findElement(By.id("windowButton"));
        WebElement newWindowMassage=driver.findElement(By.id("messageWindowButton"));

        newTab.click();
        newWindow.click();
        newWindowMassage.click();


         Set<String> allWindowsHandle=driver.getWindowHandles();
        System.out.println(allWindowsHandle.size());

         Iterator<String> iterator= allWindowsHandle.iterator();
        while(iterator.hasNext()) {
            String handle = iterator.next();
            if (!mainPageHandle.equals(handle)) {
                driver.switchTo().window(handle);
                WebElement console = driver.findElement(By.cssSelector("body"));
                String getText = console.getText();
                System.out.println("Get Text: " +getText);

            }
            String title = driver.getTitle();
            System.out.println("Title: " + title);
        }


    }
}
