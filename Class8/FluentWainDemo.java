package com.syntax.Class8;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FluentWainDemo {
    public static String url = " http://syntaxprojects.com/dynamic-data-loading-demo.php";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(5)) //look for an element every 5 seconds
                .ignoring(NoSuchElementException.class);//ignores the exception mentioned in the given time


    }
}
