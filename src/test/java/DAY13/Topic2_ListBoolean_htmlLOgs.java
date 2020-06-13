package DAY13;

import ReusableLib.ActionWorkLibrary;
import ReusableLib.ActionWorkLibrary_Logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Topic2_ListBoolean_htmlLOgs {
    //declare driver outside
    WebDriver driver;
    //declare the report variable outside
    ExtentReports reports;
    //declare the logger(extent test)
    ExtentTest logger;

    @BeforeSuite
    public void Precondition () throws IOException, InterruptedException {
        driver = ActionWorkLibrary_Logger.setProperty();
        //define the report path here as a before suite
        reports = new ExtentReports("src/main/java/HTML/AutomationReport.html", true);
    }//end of before suite

    @Test
    public void yahoo_verification() throws InterruptedException {
        //define and start the test
        logger = reports.startTest("Yahoo verification");
        //navigate to yahoo.com
        logger.log(LogStatus.INFO,"navigating to yahoo.com");
        driver.navigate().to("https://www.yahoo.com");
        //wait time
        Thread.sleep(3000);
        //i want to count all the links in yahoo and print it
        logger.log(LogStatus.INFO,"Getting the list for all links");
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px)')]"));
        //print the total links count
        System.out.println("Total links are "+ linkCount.size());
        //sign in
        ActionWorkLibrary.clickElement(driver,"//*[@id='header-profile-menu']","Sign in");
        //wait time
        Thread.sleep(2000);
        //check if the sign in checkbox is selected using boolean
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //using if else condition
        if(checkboxState == true){
            System.out.println("Checkbox is selected by default ");
            logger.log(LogStatus.PASS,"checkbox is selected");
        }else {
            System.out.println("Checkbox is not selected by default");
            logger.log(LogStatus.FAIL, "Checkbox is not selected ");
        }//end of if else

        // System.out.println("is element selected? " +checkboxState);

        //end the test for specific @Test
        reports.endTest(logger);
    }//end of test method

    @AfterSuite
    public void postCondition() throws InterruptedException {
        //writing the logs back to automation reports that you defined
        reports.flush();

    }// After Method



}
