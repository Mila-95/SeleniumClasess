package com.syntax.ReviewClass2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Reviev {
    public static String url = "https://www.syntaxprojects.com/basic-radiobutton-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

       WebElement femaleButton=driver.findElement(By.xpath("//input[@value = 'Female' and @name='optradio']"));
       //check if the  femaleButton radio button is enabeld
        System.out.println(" the female radio button is enabled "+femaleButton.isEnabled());
        //check if the femaleButton radio button is displayed on not
        System.out.println("the female radio button is displayed "+femaleButton.isDisplayed());
        //check if its selected
        System.out.println("the female radio button is selected"+femaleButton.isSelected());

        //checking if the button is not selected and select it
        if(!femaleButton.isSelected()){
            femaleButton.click();
        }
        System.out.println("the female radio btn is selected"+femaleButton.isSelected());

        //get all links in the current webpage and print their text

       List<WebElement> links =driver.findElements(By.tagName("a"));
       for(WebElement link:links){
         String name= link.getText();
         if(!name.isEmpty()){
             System.out.println(name);
         }

       }


    }
}