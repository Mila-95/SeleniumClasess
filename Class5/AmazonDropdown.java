package com.syntax.Class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AmazonDropdown {
    public static  String url="https://www.amazon.com";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
       WebElement categories= driver.findElement(By.xpath("//select[@id ='searchDropdownBox']"));
       Select select=new Select(categories);

       List<WebElement> options=select.getOptions();
       for(WebElement option:options){
           String optionText=option.getText();
           System.out.println(optionText);
       }
        select.selectByValue("search-alias=appliances");

    }
}
