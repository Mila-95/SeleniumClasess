package com.syntax.Class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandlingMultipleSelectedDD {
    public static  String url="https://syntaxprojects.com/basic-select-dropdown-demo.php";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement states=driver.findElement(By.name("States"));
        Select select=new Select(states);

         boolean multiple=select.isMultiple();
        System.out.println(multiple);
        if(multiple){
         List<WebElement> option= select.getOptions();
         for(WebElement options:option){
             String optionText=options.getText();
             select.selectByValue(optionText);
             Thread.sleep(1000);
         }

        }
        //deselecting multiple dropdown
        select.selectByIndex(5);
        //deselect all ot them
        select.deselectAll();


    }
}
