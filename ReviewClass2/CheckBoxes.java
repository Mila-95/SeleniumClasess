package com.syntax.ReviewClass2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {
    public static String url = "https://www.syntaxprojects.com/basic-checkbox-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get(url);
WebElement checkbox1=driver.findElement(By.cssSelector("input#isAgeSelected"));
        System.out.println("the checkbox is selected "+checkbox1.isSelected());
        //select checkbox
        Thread.sleep(2000);
        checkbox1.click();
        //diselect checkbox
        checkbox1.click();
        //get all the avaliable options
        List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@class ='cb1-element']"));

        //select all
        for(WebElement checkbox:checkboxes){
           checkbox.click();
}
             //unselect
             Thread.sleep(2000);
           for(WebElement checkbox:checkboxes){
                 checkbox.click();
}

    }
}