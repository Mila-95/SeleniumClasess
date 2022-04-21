package com.syntax.Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW03 {
    /*TC 2: HRMS blank username and password validation
Navigate to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
Leave username and password field empty
Click on login button
Verify error message with text "Username cannot be empty" is displayed
 */
    public static String url="http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);

        WebElement userName=driver.findElement(By.id("txtUsername"));
        userName.sendKeys("");

        WebElement password=driver.findElement(By.id("txtPassword"));
        password.sendKeys("");

        WebElement logInButton=driver.findElement(By.id("btnLogin"));
        logInButton.click();

        WebElement txtMessage=driver.findElement(By.id("spanMessage"));
        System.out.println(txtMessage.getText()+" is displayed ");
    }
}
