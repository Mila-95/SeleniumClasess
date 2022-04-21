package com.syntax.Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW02 {
    /*HW: TestNG and use assertions
TC 1: HRMS blank password validation
Navigate to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
Enter valid username and leave password field empty
Click on login button
Verify error message with text "Password cannot be empty" is displayed   */
      public static String url="http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);

        WebElement username=driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");

        WebElement password=driver.findElement(By.id("txtPassword"));
        password.sendKeys("");

        WebElement logInButton=driver.findElement(By.id("btnLogin"));
        logInButton.click();

        WebElement txt=driver.findElement(By.id("spanMessage"));
        System.out.println(txt.getText()+"  is displayed");













    }
}
