package com.syntax.Class8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW01 {
    /*
       go to https://the-internet.herokuapp.com/dynamic_controls
      click on checkbox and click on remove
      verify the text
      click on enable verify the textbox is enabled
      enter text and click disable
      verify the textbox is disabled
     */
    public static String url = " https://the-internet.herokuapp.com/dynamic_controls";
        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get(url);

            WebElement checkButton=driver.findElement(By.xpath("//input[@type= 'checkbox']"));
            checkButton.click();
            WebElement removeButton=driver.findElement(By.xpath("//button[@onclick= 'swapCheckbox()']"));
            removeButton.click();
            WebDriverWait wait=new WebDriverWait(driver,20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
            WebElement text1=driver.findElement(By.id("message"));
            String getText1=text1.getText();
            System.out.println(getText1);

            WebElement enableButton=driver.findElement(By.xpath("//button[@onclick= 'swapInput()']"));
            enableButton.click();
           WebDriverWait wait2=new WebDriverWait(driver,20);
           wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
           WebElement text2=driver.findElement(By.id("message"));
           String getTextEnabledBytton=text2.getText();
            System.out.println(getTextEnabledBytton);

            WebElement typeWord=driver.findElement(By.xpath("//input[@type= 'text']"));
            typeWord.sendKeys("Mila");
            WebElement enableButtonClickagain=driver.findElement(By.xpath("//button[@onclick= 'swapInput()']"));
            enableButtonClickagain.click();
            WebDriverWait wait3=new WebDriverWait(driver,20);
            wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
            WebElement text3=driver.findElement(By.id("message"));
            String getText=text3.getText();
            System.out.println(getText);


    }
}
