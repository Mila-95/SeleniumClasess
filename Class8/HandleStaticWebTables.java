package com.syntax.Class8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class HandleStaticWebTables {
    public static String url = "https://syntaxprojects.com/table-search-filter-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

       List<WebElement> rowData= driver.findElements(By.xpath("//table[@id ='task-table']/tbody/tr"));
        System.out.println(rowData.size());

        Iterator<WebElement>it= rowData.iterator();
        while(it.hasNext()){
           WebElement row= it.next();
           String rowText=row.getText();
            System.out.println(rowText);
        }
        System.out.println("______________________");

        //print header data ( column data)

     List<WebElement> coloumnsData=driver.findElements(By.xpath("//table[@id ='task-table']/thead/tr/th"));
        System.out.println(coloumnsData.size());

        for(WebElement colData:coloumnsData){
            String colText=colData.getText();
            System.out.println(colText);
        }
    }
}
