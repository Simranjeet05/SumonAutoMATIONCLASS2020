package DAY6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DAY6_Topic1_chromeOptions {

    public static void main(String[] args) throws InterruptedException {

        //set the chrome path
        System.setProperty("webdriver.chrome.driver", "/Users/kalra/Desktop/SIMRANJEET QA/src/SumonQA/resource/chromedriver");

        //SET some preconditions using chromeoptions
        ChromeOptions options= new ChromeOptions();
        //set the argument you want for this driver
        options.addArguments("start-maximized","incognito"); //start-maximized does not work with mac

        //now simply define the chrome driver
        WebDriver driver = new ChromeDriver(options);

        //navigate to the website mlcalc.com
        driver.navigate().to("https://www.mlcalc.com");

        //since we were not able to use start-maximized therefore we will manually call it
        driver.manage().window().maximize();
        Thread.sleep(2000); //wait time

        //i want to camputre the title
        //System.out.println("my title name is: "+driver.getTitle());
        //store your actual title on a variable and then compare with your expected
        String actualTitle =driver.getTitle();
        if (actualTitle.equals("Mortgage Calculator & Loan Calculator")) {
            System.out.println("TITLE matches with expected" );
        }
        else{
            System.out.println("Title does not match"+ actualTitle);
        }//end of if else condition

        //if the same locator used more than once then store it as a web element variable to reuse it
        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));

        //clear the field first
        pPrice.clear();

        //enter your new data
        pPrice.sendKeys("400000");

        //store your start month in WebElement variable and call it on your select command
        WebElement sMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        // call my select command and  it only works when the downdrop locator is under select tag
        Select sMonthList = new Select(sMonth);
        //select the drop down value by visible variable
        //sMonthList.selectByIndex(0);
        //sMonthList.selectByValue("1");
        sMonthList.selectByVisibleText("May");

        //whenever the dropdown is not under select tag then we must click on dropdown and
        //then click on the value of the dropdown
        /*
            driver.findElement(By.xpath("//*[@name='sy']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[text()=2025]")).click();
         */

        //lets verify some of the start year to make sure its matching
        String[] yearArray = new String[] {"2005","2015","2035"};
        for (int i=0; i<yearArray.length; i++) {
            driver.findElement(By.xpath("//*[@name='sy']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[text()='"+yearArray[i]+"']")).click();

        }//loop end
    }// main end
}//class end
