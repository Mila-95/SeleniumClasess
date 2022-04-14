package com.syntax.Class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxDemo {
   public static  String url="https://www.syntaxprojects.com/basic-checkbox-demo.php";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        //locating checkbox and storing them into a list
        List<WebElement> optionCheckBox=driver.findElements(By.xpath("//input[@class = 'cb1-element']"));
        int size=optionCheckBox.size();
        System.out.println(size);
        //looping through each item from the list in the line 19
        for(WebElement option:optionCheckBox){
            String checkBoxvalue=option.getAttribute("value");
            if(checkBoxvalue.equals("Option-2")){
                option.click();
                break;
            }
        }
        //if we want to select more options
        /*
        for (WebElement option:optionCheckBoxes){
         String checkBoxValue = option.getAttribute("value");
        if (checkBoxValue.equals("Option-1")){
        option.click();
       } else if (checkBoxValue.equals("Option-2")){
        option.click();
        } else if (checkBoxValue.equals("Option-4")){
        option.click();
        break;
    }
}
         */

    }
}
