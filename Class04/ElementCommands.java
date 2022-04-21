package com.syntax.Class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementCommands {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.uitestpractice.com/Students/Form");
        WebElement marriedRadioButton=driver.findElement(By.xpath("(//input[@name = 'optradio']) [1]"));
        boolean isMarryButtonEnabled= marriedRadioButton.isEnabled();
        System.out.println(isMarryButtonEnabled);
        if(!isMarryButtonEnabled){
            System.out.println("Not Enabled");
        }else{
            System.out.println("Enabled");
        }
       boolean iisMarryButtonEnabled= marriedRadioButton.isDisplayed();
        System.out.println(isMarryButtonEnabled);

        //Before cliking
        boolean isMarryButtonEnabledSelected = marriedRadioButton.isSelected();
        System.out.println("Before clicking "+isMarryButtonEnabledSelected);
        marriedRadioButton.click();
        //after cliking
        isMarryButtonEnabledSelected=marriedRadioButton.isSelected();
        System.out.println("After clicking "+isMarryButtonEnabledSelected);

        driver.quit();
    }
}
