package com.syntax.Class11;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HW05 {
    /*TC:4 --> do on selenium project
Go to http://www.uitestpractice.com/
interact with drag and drop, iframe, double-click on home
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

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        //interact with drag and drop
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(droppable).release().build().perform();
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text() ='Double Click ME !']"));
        actions.doubleClick(doubleClickButton).build().perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();
             //iframe
        driver.switchTo().frame("iframe_a");
        WebElement iframe = driver.findElement(By.id("name"));
        iframe.sendKeys("Hello");

        driver.switchTo().defaultContent();

        //double-click on home
        WebElement homeButton = driver.findElement(By.xpath("//a[text() ='Home']"));
        homeButton.click();

        //delete one user from the table
        List<WebElement> allElements = driver.findElements(By.xpath("//table[@class ='table']/tbody/tr"));
        boolean a=true;
        while(a){
        allElements = driver.findElements(By.xpath("//table[@class ='table']/tbody/tr"));
        for (WebElement allElement : allElements) {
        String allElementText = allElement.getText();
        if (allElementText.contains("Stoleru")) {
            a=false;
            System.out.println(allElementText);
           WebElement deletButton = driver.findElement(By.xpath("//button[text() ='DELETE'][1]"));
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("arguments[0].click()",deletButton);
            WebElement deleteBtn2=driver.findElement(By.xpath("//input[@type = 'submit']"));
            deleteBtn2.click();
            break;
        }
    }
         if (a) {
        WebElement nextButn =driver.findElement(By.xpath("//a[@rel= 'next']"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",nextButn);

         }
       }
        //click on the ajax link and wait for the text
        //verify that the text is displayed
        WebElement ajaxCallBtn=driver.findElement(By.linkText("AjaxCall"));
        ajaxCallBtn.click();
        WebElement ajaxLink=driver.findElement(By.linkText("This is a Ajax link"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",ajaxLink);
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ContactUs']")));
        WebElement text=driver.findElement(By.xpath("//div[@class='ContactUs']"));
        System.out.println(text.getText());
        System.out.println(text.isDisplayed());

        //go to Form
        //and fill out everything
        WebElement formBtn=driver.findElement(By.linkText("Form"));
        formBtn.click();
        WebElement firstName=driver.findElement(By.id("firstname"));
        firstName.sendKeys("Mila");
        WebElement lastName=driver.findElement(By.id("lastname"));
        lastName.sendKeys("Milos");
        WebElement mariedBtn=driver.findElement(By.xpath("//input[@name= 'optradio'][1]"));
        mariedBtn.click();
        WebElement dancingBtn=driver.findElement(By.xpath("//input[@value= 'dance']"));
        dancingBtn.click();
        WebElement country=driver.findElement(By.id("sel1"));
        Select allCountry=new Select(country);
        allCountry.selectByVisibleText("Egypt");
        WebElement calendarClick=driver.findElement(By.id("datepicker"));
        calendarClick.click();
        WebElement months=driver.findElement(By.xpath("//select[@data-handler= 'selectMonth']"));
        Select Allmonths=new Select(months);
        Allmonths.selectByVisibleText("Jan");
        WebElement years=driver.findElement(By.xpath("//select[@data-handler= 'selectYear']"));
        Select allYears=new Select(years);
        allYears.selectByVisibleText("2022");
        List<WebElement> allDates=driver.findElements(By.xpath("//table[@class= 'ui-datepicker-calendar']/tbody/tr/td/a"));
        for(WebElement allDate:allDates) {
            String allDateText = allDate.getText();
            if (allDateText.contains("1")) {
                allDate.click();
                break;
            }
        }
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

            WebElement phoneNumber=driver.findElement(By.id("phonenumber"));
            phoneNumber.sendKeys("123-456-7890");
            WebElement userName=driver.findElement(By.id("username"));
            userName.sendKeys("mila.mila");
            WebElement email=driver.findElement(By.id("email"));
            email.sendKeys("mila.mila@gmain.com");
            WebElement comment=driver.findElement(By.id("comment"));
            comment.sendKeys(" Don't mess with Ukraine");
            WebElement pass=driver.findElement(By.id("pwd"));
            pass.sendKeys("1234567890");
            WebElement submitBtm=driver.findElement(By.xpath("//button[@type= 'submit']"));
            submitBtm.click();

            WebElement widgets=driver.findElement(By.linkText("Widgets"));
            widgets.click();
            WebElement chooseFileBtn=driver.findElement(By.id("image_file"));
            chooseFileBtn.sendKeys("/Users/liudmylakushchak/Documents/Batch12/Book1.xlsx");

            WebElement uploadBtn=driver.findElement(By.xpath("//input[@type ='button']"));
            uploadBtn.click();
            WebDriverWait wait2=new WebDriverWait(driver,20);
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='ContactUs']")));
            WebElement uploadText=driver.findElement(By.xpath("//div[@class ='ContactUs']"));
            System.out.println(uploadText.getText());

            WebElement actionsButton=driver.findElement(By.linkText("Actions"));
            actionsButton.click();
            WebElement clickButton=driver.findElement(By.name("click"));
            clickButton.click();
            alert.accept();
            WebElement dblClick=driver.findElement(By.name("dblClick"));
            actions.doubleClick(dblClick).build().perform();
            alert.accept();
            WebElement draggable2=driver.findElement(By.id("draggable"));
            WebElement droppable2=driver.findElement(By.id("droppable"));
            Actions actions1=new Actions(driver);
            actions1.clickAndHold(draggable2).moveToElement(droppable2).release().build().perform();
            WebElement blueGreen=driver.findElement(By.id("div2"));
            actions.moveToElement(blueGreen).release().perform();

            WebElement switchTo=driver.findElement(By.linkText("Switch to"));
            switchTo.click();
            WebElement alertButton=driver.findElement(By.id("alert"));
            alertButton.click();
            alert.accept();
            WebElement confirmBtn=driver.findElement(By.id("confirm"));
            confirmBtn.click();
            alert.accept();
            WebElement promptBtn=driver.findElement(By.id("prompt"));
            promptBtn.click();
            alert.accept();
            WebElement launchModalBtn=driver.findElement(By.xpath("//button[@data-toggle='modal']"));
            launchModalBtn.click();
            launchModalBtn.sendKeys("Hello");
            WebElement windowOkBtn=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
            windowOkBtn.click();
            WebElement basicAuthenticationButton=driver.findElement(By.id("basicAuthentication"));
            System.out.println(basicAuthenticationButton.isEnabled());
             driver.switchTo().frame("iframe_a");
             WebElement iframeEnterName=driver.findElement(By.id("name"));
             iframeEnterName.sendKeys("Mila");
             driver.switchTo().defaultContent();

             WebElement selectBtn= driver.findElement(By.linkText("Select"));
             selectBtn.click();
             WebElement dropdown1=driver.findElement(By.id("countriesSingle"));
             dropdown1.click();
            Select drp1=new Select(dropdown1);
            drp1.selectByVisibleText("United states of America");
            WebElement dropdown2=driver.findElement(By.id("countriesMultiple"));
            Select drp2=new Select(dropdown2);
            drp2.selectByVisibleText("United states of America");
            WebElement dropdown3=driver.findElement(By.id("dropdownMenu1"));
            dropdown3.click();
            List<WebElement> dropdown3Options=driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li/a"));
             Iterator<WebElement> dropdownListIterator=dropdown3Options.iterator();
             while (dropdownListIterator.hasNext()){
                 WebElement nextdropDown3=dropdownListIterator.next();
                 String nextText=nextdropDown3.getText();
                 if(nextText.contains("United states of America")){
                     nextdropDown3.click();
                     break;
                 }
             }

            driver.quit();

    }
}


