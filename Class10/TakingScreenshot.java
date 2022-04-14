package com.syntax.Class10;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakingScreenshot {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

        WebElement username= driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password=driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton= driver.findElement(By.className("button"));
        loginButton.click();

        TakesScreenshot ts=(TakesScreenshot) driver;
         File scrFile=ts.getScreenshotAs(OutputType.FILE);//screenshoot is taken ont his step
        try {
            FileUtils.copyFile(scrFile,new File("screenshots/SmartBear/adminLogin.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
