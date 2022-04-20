package com.syntax.Class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HW1 {
  /*  Go to aa.com/homePage.do
    select depart date
    select return date
    select destination
    click on search
    quit the browser*/
  public static String url = "https://www.aa.com/homePage.do";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);


driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
WebElement calendar=driver.findElement(By.className("ui-datepicker-trigger"));
calendar.click();
WebElement dMonth = driver.findElement(By.className("ui-datepicker-month"));
        String dMonthText= dMonth.getText();
        while (!dMonthText.equals("November"))  {
            WebElement nextBttn = driver.findElement(By.xpath("//a[@aria-label='Next Month']"));
            nextBttn.click();
            dMonth = driver.findElement(By.className("ui-datepicker-month"));
            dMonthText= dMonth.getText();
        }
List<WebElement> toDates=driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
for(WebElement toDate:toDates){
    if(toDate.getText().equals("22")){
        toDate.click();
        break;
    }
}
        WebElement returnDate = driver.findElement(By.xpath("//*[@id=\"reservationFlightSearchForm\"]/div[4]/div[2]/div/button"));
        returnDate.click();
        WebElement returnMonth = driver.findElement(By.className("ui-datepicker-month"));
        String returnMonthText = returnMonth.getText();
        while(!returnMonthText.equals("February")){
            WebElement nextBttn = driver.findElement(By.xpath("//a[@aria-label='Next Month']"));
            nextBttn.click();
            returnMonth = driver.findElement(By.className("ui-datepicker-month"));
            returnMonthText= returnMonth.getText();

       }
        List<WebElement> alls=driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement all:alls ){
            if(all.getText().equals("15")){
                all.click();
                break;
            }
        }
       WebElement destination=driver.findElement(By.id("reservationFlightSearchForm.destinationAirport"));
        destination.sendKeys("MIA");

        WebElement search=driver.findElement(By.id("flightSearchForm.button.reSubmit"));
        search.click();
        driver.quit();
    }
}
