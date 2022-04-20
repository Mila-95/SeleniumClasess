package com.syntax.Class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*avigate to fb.com
click on create new account
fill up all the textboxes
click on sign up button
close the pop up
close the browser

 */
public class HW02 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.linkText("Create new account")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys("Ale");
        driver.findElement(By.name("lastname")).sendKeys("Azov");
        driver.findElement(By.name("reg_email__")).sendKeys("Alle@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("Alle@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("password123");
        Thread.sleep(2000);
        driver.findElement(By.name("websubmit")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("._8ien ._8idr")).click();
        driver.quit();



    }
}
