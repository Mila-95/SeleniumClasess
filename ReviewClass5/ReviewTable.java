package com.syntax.ReviewClass5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReviewTable {
    public static String url = "https://www.techlistic.com/p/demo-selenium-practice.html";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        WebElement whole_Table=driver.findElement(By.xpath("//table[@id ='customers']"));
//        System.out.println(whole_Table.getText());

        //accusing the row of row table
//        List<WebElement> rows=driver.findElements(By.xpath("//table[@id ='customers']/tbody/tr"));
//        for(WebElement row:rows) {
//            String text = row.getText();
//            if (text.contains("Germany")) {
//                System.out.println(text);
//            }
//        }

        //Print all the companies are located in UK

        List<WebElement> countries=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td[3]"));
        int i=1;
        for (WebElement country:countries){
            String countryName= country.getText();
            if (countryName.equals("UK")){
                WebElement company=  driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+(i+1)+"]/td[1]"));
                System.out.println("The Company name in UK is "+company.getText());
            }
            i=i+1;

        }
        //if column locating may change
        //get the header -->then find location of column  that has country---> from there he will
        //// get the index
        ////that should be place in front of td




    }
}
