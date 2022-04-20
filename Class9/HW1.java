package com.syntax.Class9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HW1 {
    /*Go to http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
click on leave
click on leave list
choose from "From calendar"
choose from "To calendar"
click only on cancelled and rejected checkboxes
uncheck Pending Approval
select IT support from DD
click search
quit the browser     */

    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);


        WebElement userName=driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");

        WebElement password=driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");

        WebElement loginButton=driver.findElement(By.id("btnLogin"));
        loginButton.click();

        WebElement leveList=driver.findElement(By.id("menu_leave_viewLeaveModule"));
        leveList.click();

        WebElement fromCalendar=driver.findElement(By.id("calFromDate"));
        fromCalendar.click();

        WebElement months=driver.findElement(By.className("ui-datepicker-month"));
        Select select=new Select(months);
        select.selectByVisibleText("Jan");
        List<WebElement> fromDates=driver.findElements(By.xpath("//table[@class= 'ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement fromDate:fromDates){
         String dateText=fromDate.getText();
         if(dateText.equals("29")){
             fromDate.click();
             break;
         }
}
         WebElement toCalendar=driver.findElement(By.id("calToDate"));
        toCalendar.click();
        WebElement toMonths=driver.findElement(By.className("ui-datepicker-month"));
        Select select1=new Select(toMonths);
        select1.selectByVisibleText("Dec");
        List<WebElement> toDates=driver.findElements(By.xpath("//table[@class= 'ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement toDate:toDates){
            String dateText2=toDate.getText();
            if(dateText2.equals("10")){
                toDate.click();
                break;
            }
        }
         WebElement rejectButton=driver.findElement(By.id("leaveList_chkSearchFilter_-1"));
        rejectButton.click();

        WebElement cancelButton=driver.findElement(By.id("leaveList_chkSearchFilter_0"));
        cancelButton.click();

        WebElement pendingAproval=driver.findElement(By.id("leaveList_chkSearchFilter_1"));
        pendingAproval.click();

        WebElement dropDown=driver.findElement(By.id("leaveList_cmbSubunit"));
        Select select2=new Select(dropDown);
       select2.selectByVisibleText("IT Support");


        WebElement serchButton=dropDown.findElement(By.xpath("//input[@id='btnSearch']"));
        serchButton.click();
        driver.quit();


    }
}
