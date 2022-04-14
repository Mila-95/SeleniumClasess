package com.syntax.Class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownHanding {
    public static  String url="https://www.syntaxprojects.com/basic-select-dropdown-demo.php";
    public static <list> void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
         driver.get(url);

        WebElement daysDD=driver.findElement(By.id("select-demo"));
        Select select=new Select(daysDD);

        select.selectByIndex(3); //index starts from 0

        Thread.sleep(2000);
        select.selectByVisibleText("Thursday");

        Thread.sleep(2000);
        select.selectByValue("Sunday");

        List<WebElement> alloptions=select.getOptions();
        int size=alloptions.size();
        System.out.println(size);

         for( int i=0; i<size; i++){
             alloptions.get(i);
             String option=alloptions.get(i).getText(); //get text for each element
             System.out.println(option);
             select.selectByIndex(i);
             Thread.sleep(2000);
         }


    }
}
