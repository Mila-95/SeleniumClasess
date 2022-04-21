package com.syntax.Class11;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HW05 {
    /*TC:4 --> do on selenium project
Go to http://www.uitestpractice.com/
interact with drag and drop, iframe, double click
click on home
delete one user from the table
go to the next link
click on the ajax link and wait for the text
verify that the text is displayed
go to Form
and fill out everything
go to widgets
upload any file and verify it is uploaded
go to actions and perform all the necessary actions
go to SwitchTo
work with alerts and frames
go to select
perform actions on all dropdowns
 */

    public static String url = "http://www.uitestpractice.com/";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(droppable).release().build().perform();

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text() ='Double Click ME !']"));
        actions.doubleClick(doubleClickButton).build().perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.switchTo().frame("iframe_a");
        WebElement iframe = driver.findElement(By.id("name"));
        iframe.sendKeys("Hello");

        driver.switchTo().defaultContent();

        WebElement homeButton = driver.findElement(By.xpath("//a[text() ='Home']"));
        homeButton.click();

        List<WebElement> allElements = driver.findElements(By.xpath("//table[@class ='table']/tbody/tr"));
        WebElement nextBtn = driver.findElement(By.xpath("//a[@rel ='next']"));

        boolean flag = true;
        while (flag) {
            for (WebElement allElement : allElements) {
                String allElementText = allElement.getText();
                if (allElementText.contains("11111111")) {
                    flag = false;
                    break;

                }
            }
            if(flag){
                nextBtn.click();
            }
        }
        WebElement deletButton = driver.findElement(By.xpath("//button[text() ='DELETE'][1]"));
        deletButton.click();
    }
}
