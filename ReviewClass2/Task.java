package com.syntax.ReviewClass2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {
    public static String url = "https://www.syntaxprojects.com/basic-checkbox-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement age=driver.findElement(By.xpath("//div[@id='txtAge']"));

        System.out.println(age.getText());
        age.click();



    }
}