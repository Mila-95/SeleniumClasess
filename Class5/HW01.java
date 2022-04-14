package com.syntax.Class5;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
/*
TC 1: Facebook dropdown verification
Open chrome browser
Go to "https://www.facebook.com"
click on create new account
Verify:
month dd has 12 month options
day dd has 31 day options
year dd has 115 year options
Select your date of birth
Quit browser
 */
public class HW01 {
    public static  String url="https://www.facebook.com";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement createaccount = driver.findElement(By.linkText("Create new account"));
        createaccount.click();

        Thread.sleep(2000);
        WebElement months = driver.findElement(By.id("month"));
        Select selectMonths = new Select(months);
        List<WebElement> allOptions = selectMonths.getOptions();

        if (allOptions.size() == 12) {
            System.out.println("There is  12 months ");
        } else {
            System.out.println("Do not have 12 months It has " + allOptions.size() + " months option");
        }

        WebElement has31day = driver.findElement(By.xpath("//select[@name='birthday_day']"));
        Select selectDays = new Select(has31day);
        List<WebElement> allDays = selectDays.getOptions();

        if (allDays.size() == 31) {
            System.out.println("There is 31 days ");
        } else {
            System.out.println("Do not have 31 days There is " + allDays.size() + " days");
        }

        WebElement year = driver.findElement(By.id("year"));
        Select selectYear = new Select(year);
        List<WebElement> allYears = selectYear.getOptions();

        if (allYears.size() == 115) {
            System.out.println("There is 115 days");
        } else {
            System.out.println("Do not have 115 days it has " + allYears.size());
        }

        for(WebElement allOption:allOptions){
            String value=allOption.getText();
            if(value.equals("Jan")){
                allOption.click();
                break;
            }

        }
        for(WebElement allDay:allDays){
            String num=allDay.getText();
            if(num.equals("1")){
                allDay.click();
                break;
            }

        }

        for(WebElement allYear:allYears){
            String years=allYear.getText();
            if(years.equals("1995")){
                allYear.click();
                break;

            }
        }

        Thread.sleep(2000);
        driver.quit();

    }
}
