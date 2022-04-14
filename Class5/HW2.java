package com.syntax.Class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
Go to facebook sign up page
Fill out the whole form
Click signup
 */
public class HW2 {
    public static  String url="https://www.facebook.com";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement createaccount = driver.findElement(By.linkText("Create new account"));
        createaccount.click();

        Thread.sleep(2000);

        WebElement firstname=driver.findElement(By.name("firstname"));
        firstname.sendKeys("Alla");
        WebElement lastName=driver.findElement(By.name("lastname"));
        lastName.sendKeys("Olla");
        WebElement email= driver.findElement(By.name("reg_email__")) ;
        email.sendKeys("alle.aaa@gmain.com");
        WebElement confirmEmail=driver.findElement(By.name("reg_email_confirmation__"));
        confirmEmail.sendKeys("alle.aaa@gmain.com");
        WebElement password=driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("123456789");

        WebElement month=driver.findElement(By.id("month"));
        Select selectMonth=new Select(month);
        selectMonth.selectByVisibleText("Jan");

        WebElement day=driver.findElement(By.id("day"));
        Select selectDay=new Select(day);
        selectMonth.selectByIndex(1);

        WebElement year=driver.findElement(By.id("year"));
        Select selectYear=new Select(year);
        selectYear.selectByValue("1995");

     WebElement gender=driver.findElement(By.xpath("//input[@name='sex'][1]"));
     gender.click();
        WebElement submit= driver.findElement(By.name("websubmit"));
        submit.click();

        Thread.sleep(2000);
        driver.quit();



    }
}
