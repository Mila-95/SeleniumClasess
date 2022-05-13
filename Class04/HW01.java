package com.syntax.Class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public  class HW01 {
    public static  void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        WebElement username=driver.findElement(By.xpath("//input[@id = 'txtUsername']"));
        username.sendKeys("Admin");
        WebElement password= driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        WebElement login= driver.findElement(By.xpath("//input[@id = 'btnLogin']"));
        login.click();
        WebElement logo=  driver.findElement(By.xpath("//img[contains(@alt , 'OrangeHRM')]"));
        boolean display=logo.isDisplayed();
        if(display){
            System.out.println("Is Displayed");

        }else{
            System.out.println("Is not displayed");
        }
        driver.quit();
    }
}


