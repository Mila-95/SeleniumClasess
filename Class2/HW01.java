package com.syntax.Class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*HW
navigate to https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
fill out the form
click on register
close the browser
*/
public class HW01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(" https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
        driver.findElement(By.id("customer.firstName")).sendKeys("Liudmyla");
        driver.findElement(By.id("customer.lastName")).sendKeys("Kushchak");
        driver.findElement(By.id("customer.address.street")).sendKeys("283 Leonard st");
        driver.findElement(By.id("customer.address.city")).sendKeys("Arizona");
        driver.findElement(By.id("customer.address.state")).sendKeys("AZ");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("12334");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("123-456-7890");
        driver.findElement(By.id("customer.ssn")).sendKeys("123456779");
        driver.findElement(By.id("customer.username")).sendKeys("Kolya123");
        driver.findElement(By.id("customer.password")).sendKeys("123456");
        driver.findElement(By.id("repeatedPassword")).sendKeys("123456");
        driver.findElement(By.className("button")).click();
        driver.quit();
    }
}
