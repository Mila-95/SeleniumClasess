package com.syntax.Class9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandlingPaginations {
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement username=driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");

        WebElement password=driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");

        WebElement loginButton=driver.findElement(By.id("btnLogin"));
        loginButton.click();

        WebElement pimButton=driver.findElement(By.id("menu_pim_viewPimModule"));
        pimButton.click();

        WebElement addEmployeeButton=driver.findElement(By.id("menu_pim_addEmployee"));
        addEmployeeButton.click();

        WebElement firstname=driver.findElement(By.id("firstName"));
        firstname.sendKeys("Diego");
        WebElement lasName=driver.findElement(By.id("lastName"));
        lasName.sendKeys("Asghar");

        WebElement empIdField=driver.findElement(By.id("employeeId"));
        String empId= empIdField.getAttribute("value");

        WebElement saveButton=driver.findElement(By.id("btnSave"));
        saveButton.click();

        WebElement employeListButton=driver.findElement(By.id("menu_pim_viewEmployeeList"));
        employeListButton.click();

        boolean flag=true;
        while (flag) {
            List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
            for (int i = 0; i < tableRows.size(); i++) {
                String rowText = tableRows.get(i).getText();
                if (rowText.contains(empId)) {
                    flag = false;
                    WebElement checkbox = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[1]"));
                    checkbox.click();
                    WebElement delateButton = driver.findElement(By.id("btnDelete"));
                    delateButton.click();
                    WebElement confirmDelete = delateButton.findElement(By.id("dialogDeleteBtn"));
                    confirmDelete.click();
                    break;
                }
            }
            if (flag) {
                WebElement nextButton = driver.findElement(By.linkText("Next"));
                nextButton.click();
            }
        }
    }
}
