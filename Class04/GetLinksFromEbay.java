package com.syntax.Class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;



public class GetLinksFromEbay {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ebay.com/");
        driver.findElement(By.tagName("a"));
        List<WebElement> allinks = driver.findElements(By.tagName("a"));
        System.out.println("Number of links " + allinks.size());
        for (WebElement link : allinks) {
            String linkText = link.getText();
            String fullink=link.getAttribute("href");
            if (!linkText.isEmpty()) {
                System.out.println(linkText+ " "+fullink);
            }
        }
    }
}