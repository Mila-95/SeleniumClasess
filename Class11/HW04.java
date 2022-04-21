package com.syntax.Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW04 {
    /*TC 2: HRMS invalid credentials validation
Navigate to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
Enter valid username and wrong password
Click on login button
Verify error message with text "Invalid credentials" is displayed
*/
    public static String url="http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);

        WebElement userName=driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");

        WebElement password=driver.findElement(By.id("txtPassword"));
        password.sendKeys("123456");

        WebElement ligInButton=driver.findElement(By.id("btnLogin"));
        ligInButton.click();

        WebElement text=driver.findElement(By.id("spanMessage"));
        System.out.println(text.getText()+" is displayed");
    }
}
