package com.syntax.Class7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SimpleWindowHandle {
    /*
    click on Help link
    switch between tabs
     */
    public static String url = "http://accounts.google.com/signup";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

       String mainPageHandle= driver.getWindowHandle();//get window handle foe main page
        System.out.println(mainPageHandle);

        WebElement helpLink=driver.findElement(By.linkText("Help"));
        helpLink.click();

       Set<String> allWindowsHandles= driver.getWindowHandles();//store all the handles in a set
        System.out.println(allWindowsHandles.size());

        Iterator<String> it=allWindowsHandles.iterator();//have an iterator inj order ti interest through the handles
        mainPageHandle= it.next();  // step to using the main handle
        String childHandle=  it.next();  // take the second  step and have a child handled
        System.out.println(childHandle);

        driver.switchTo().window(mainPageHandle);//switch back to main page
        Thread.sleep(3000);
        driver.close();

        driver.switchTo().window(mainPageHandle);
        helpLink.click();



    }

}
