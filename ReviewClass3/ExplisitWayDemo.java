package com.syntax.ReviewClass3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplisitWayDemo {
    public static String url = "https://syntaxprojects.com/dynamic-elements-loading.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        //we cannot use implicit wait here
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebDriverWait wait=new WebDriverWait(driver,20);
        WebElement btn=driver.findElement(By.id("startButton"));
        btn.click();
        //explicit wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Welcome Syntax' )]")));
        WebElement WelcomeMSG=driver.findElement(By.xpath("//*[contains(text(), 'Welcome Syntax' )]"));
        System.out.println(WelcomeMSG.getText());

    }
}
