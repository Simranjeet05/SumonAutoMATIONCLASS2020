package DAY14;

import ReusableLib.ActionWorkLibrary_Logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TOPIC1_KAYAK_DataDriven_TESTNG_Logger {
    //calling the web driver
    WebDriver driver;
    //readable workBook
    Workbook readableFile;
    //readable workSheet
    Sheet readableSheet;
    //writable workBook
    WritableWorkbook writableFile;
    //Writable workSheet
    WritableSheet wSheet;

    //declare the report
    ExtentReports reports;
    //declare the test/logger
    ExtentTest logger;
    //javascript executor
    JavascriptExecutor js;


    @BeforeSuite
    public void before() throws IOException, InterruptedException, BiffException {
        //define readableFile
        readableFile = Workbook.getWorkbook(new File("/Users/kalra/Desktop/SIMRANJEET QA/Maven_Automation/src/main/resources/DAY12 AcitonWork.xls"));
        //define readableSheet
        readableSheet = readableFile.getSheet(0);
        //define writableFile
        writableFile = Workbook.createWorkbook(new File("/Users/kalra/Desktop/SIMRANJEET QA/Maven_Automation/src/main/resources/DAY12 AcitonWork_Result.xls"), readableFile);
        //define writableSheet
        wSheet = writableFile.getSheet(0);

        //calling the driver for browser page pre-set property ie maximised and incognito browser
        driver = ActionWorkLibrary_Logger.setProperty();

        Thread.sleep(1000);
        //define the report path
        reports = new ExtentReports("/Users/kalra/Desktop/SIMRANJEET QA/Maven_Automation/src/main/java/HTML /Kayak_Report.html", true);

    }//end of BeforeSuite


    @Test
    public void Test() throws InterruptedException, WriteException {
        //get the total rows that are not empty
        int rows = wSheet.getRows();

        //define your logger to start your test
        logger= reports.startTest("Kayak Search Result");

        for (int i = 1; i < 2; i++) {
            //storing the column values as a string variable
            String airportName = wSheet.getCell(0, i).getContents();
            String startDate = wSheet.getCell(1, i).getContents();
            String startTime = wSheet.getCell(2, i).getContents();
            String endDate = wSheet.getCell(3, i).getContents();
            String endTime = wSheet.getCell(4, i).getContents();
            String vehicleSize = wSheet.getCell(5, i).getContents();

            //navigate to the Kayak.com webPage
            driver.navigate().to("https://www.kayak.com");
            Thread.sleep(1000); //wait 1 sec

            //click on the search field
            ActionWorkLibrary_Logger.clickElement(driver, "//*[@data-placeholder='Enter an airport or city']", "Search Field",logger);
            Thread.sleep(1000);
            //enter the location from the Excel
            ActionWorkLibrary_Logger.userKeys(driver, "//*[@name='pickup']", airportName, "Enter airportName: " + airportName,logger);
            Thread.sleep(3000);//wait
            //click on the airport name from the suggested
            ActionWorkLibrary_Logger.clickElement(driver, "//*[@class='item-info']", "Selecting the airportName",logger);

            //click on enter endDate
            ActionWorkLibrary_Logger.clickElement(driver, "//*[@data-placeholder='Drop-off']", " Click on calender from endDate",logger);
            Thread.sleep(1000);
            //enter the future endDate coming from Excel
            ActionWorkLibrary_Logger.userTypeAndHitEnter(driver, "//*[contains(@id,'dropoff-date-input')]", endDate, "Entering End date ",logger);
            Thread.sleep(3000);


            //click on end time
            ActionWorkLibrary_Logger.clickElement(driver, "//*[contains(@id,'end-time-select-display') and contains(@class,'_ij- _iad')]", "click on endtime",logger);
            Thread.sleep(1000);
            //enter the drop off time
            ActionWorkLibrary_Logger.MouseClickElement(driver, "//*[contains(@id,'end-time-select-option') and contains(@data-title,'" + endTime + "')]", "end time",logger);
            Thread.sleep(2000);

            //click on the start date
            ActionWorkLibrary_Logger.clickElement(driver, "//*[@data-placeholder='Pick-up']", "Click on PickUP Date",logger);
            Thread.sleep(1000);
            //enter the pickupdate coming from excel
            ActionWorkLibrary_Logger.userTypeAndHitEnter(driver, "//*[contains(@id,'pickup-date-input')]", startDate, "Entering Start date ",logger);
            Thread.sleep(2000);

            //click outside on the screen
            ActionWorkLibrary_Logger.clickElement(driver, "//*[@class='title dark']", "Click Outside",logger);
            Thread.sleep(2000);

            //click on start time
            //ActionWorkLibrary.clickElement(driver, "//*[contains(@id,'start-time-select-display') and contains(@class,'_id7 _irc')]", "Click Start Time");
            //Thread.sleep(2000);

            //enter the start time
            ActionWorkLibrary_Logger.MouseClickElement(driver, "//*[contains(@id,'start-time-select-option') and contains(@data-title,'" + startTime + "')]", "Start time from Excel",logger);
            Thread.sleep(2000);

            //click on the search icon
            ActionWorkLibrary_Logger.clickElement(driver, "//*[@class='v-c-p centre ']", " Search Icon ",logger);

            //select the size
            ActionWorkLibrary_Logger.clickElement(driver, "//*[contains(@id,'" + vehicleSize + "') and contains(@class,'_idf _jAd')]", "Select Size",logger);
            Thread.sleep(2000);

            //click on the second index for view detials
            ActionWorkLibrary_Logger.clickByIndex(driver, "//*[contains(text(),'View Deal')]", 1, "View Details for 2 index number",logger);
            Thread.sleep(2000);

            //switching to the new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            Thread.sleep(2000);//waitTime

            //capture the vehicleinfo for arrival and departure info
            String vehicleInfo = ActionWorkLibrary_Logger.captureText(driver, "//*[contains(text(),'Pick-up')]", "Captured vehicleInfo",logger);
            System.out.println("Captured Pickup and DropOff info:  " + vehicleInfo);
            Label info = new Label(6, i, vehicleInfo);

            Thread.sleep(2000);//waitTime

            //capturing the total cost
            String TotalPrice = ActionWorkLibrary_Logger.captureText(driver, "//*[@class='totalPrice']", "Total Cost",logger);
            Label totalPrice = new Label(7, i, TotalPrice);
            System.out.print("Total Cost: " + TotalPrice);

            //adding back to excel
            wSheet.addCell(info);
            wSheet.addCell(totalPrice);


            Thread.sleep(2000);//waitTime
            driver.close();//close new opened window

            //switch to previous
            driver.switchTo().window(tabs.get(0));

            //delete all cookies
            driver.manage().deleteAllCookies();

        }//end of loop
        reports.endTest(logger);
    }//end of test class

    @AfterSuite
    public void After() throws IOException, WriteException, InterruptedException {

        writableFile.write(); //Write on writable file
        writableFile.close(); //close the writablefile
        readableFile.close(); //close the readable file
        Thread.sleep(2000);
        //driver.quit(); //close the browser
        reports.flush();
    }//end aftersuite

}