package com.syntax.Class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");//for Windows users .exe at the end

        WebDriver driver=new ChromeDriver(); //launch the browser
        driver.get("https://www.google.com/"); //
        String url= driver.getCurrentUrl();
        System.out.println(url);
        String title=  driver.getTitle();
        System.out.println(title);
        driver.quit();//close browser

    }


}
