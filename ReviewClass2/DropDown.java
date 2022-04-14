package com.syntax.ReviewClass2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown {
    public static String url = "https://www.facebook.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement createaccount=driver.findElement(By.tagName("Create an  Account"));
        createaccount.click();
        Thread.sleep(2000);

        WebElement dayOption=driver.findElement(By.cssSelector("select#day"));
        Select days =new Select(dayOption);
        days.selectByValue("5");
        days.selectByIndex(0);
        days.selectByVisibleText("25");

       // print all the options of the drop down get all the options using select class

        List<WebElement> options=days.getOptions();
        for(WebElement option:options){
            System.out.println(option.getText());
        }






    }
}