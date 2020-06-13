package DAY12;



import ReusableLib.ActionWorkLibrary;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class KayakActionWork {
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
//before-new change
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
        driver = ActionWorkLibrary.setProperty();

    }//end of BeforeSuite


    @Test
    public void Test() throws InterruptedException, WriteException {
        //get the total rows that are not empty
        int rows = wSheet.getRows();

        for (int i = 1; i < 3; i++) {
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
            ActionWorkLibrary.clickElement(driver, "//*[@data-placeholder='Enter an airport or city']", "Search Field");
            Thread.sleep(1000);
            //enter the location from the Excel
            ActionWorkLibrary.userKeys(driver, "//*[@name='pickup']", airportName, "Enter airportName: " + airportName);
            Thread.sleep(1000);//wait
            //click on the airport name from the suggested
            ActionWorkLibrary.clickElement(driver, "//*[@class='item-info']", "Selecting the airportName");

            //click on enter endDate
            ActionWorkLibrary.clickElement(driver, "//*[@data-placeholder='Drop-off']", " Click on calender from endDate");
            Thread.sleep(1000);
            //enter the future endDate coming from Excel
            ActionWorkLibrary.userTypeAndHitEnter(driver, "//*[contains(@id,'dropoff-date-input')]", endDate, "Entering End date ");
            Thread.sleep(1000);


            //click on end time
            ActionWorkLibrary.clickElement(driver, "//*[contains(@id,'end-time-select-display') and contains(@class,'_ij- _iad')]", "click on endtime");
            Thread.sleep(1000);
            //enter the drop off time
            ActionWorkLibrary.MouseClickElement(driver, "//*[contains(@id,'end-time-select-option') and contains(@data-title,'" + endTime + "')]", "end time");
            Thread.sleep(1000);

            //click on the start date
            ActionWorkLibrary.clickElement(driver, "//*[@data-placeholder='Pick-up']", "Click on PickUP Date");
            Thread.sleep(1000);
            //enter the pickupdate coming from excel
            ActionWorkLibrary.userTypeAndHitEnter(driver, "//*[contains(@id,'pickup-date-input')]", startDate, "Entering Start date ");
            Thread.sleep(1000);

            //click outside on the screen
            ActionWorkLibrary.clickElement(driver, "//*[@class='title dark']", "Click Outside");
            Thread.sleep(1000);

            //click on start time
            //ActionWorkLibrary.clickElement(driver, "//*[contains(@id,'start-time-select-display') and contains(@class,'_id7 _irc')]", "Click Start Time");
            //Thread.sleep(2000);

            //enter the start time
            ActionWorkLibrary.MouseClickElement(driver, "//*[contains(@id,'start-time-select-option') and contains(@data-title,'"+startTime+"')]", "Start time from Excel");
            Thread.sleep(1000);

            //click on the search icon
            ActionWorkLibrary.clickElement(driver, "//*[@class='v-c-p centre ']", " Search Icon ");

            //select the size
            ActionWorkLibrary.clickElement(driver, "//*[contains(@id,'" + vehicleSize + "') and contains(@class,'_idf _jAd')]", "Select Size");
            Thread.sleep(3000);

            //click on the second index for view detials
            ReusableLib.ActionWorkLibrary.clickByIndex(driver, "//*[contains(text(),'View Deal')]", 1, "View Details for 2 index number");
            Thread.sleep(1000);

            //switching to the new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            Thread.sleep(1000);//waitTime

            //capture the vehicleinfo for arrival and departure info
            String vehicleInfo = ActionWorkLibrary.captureText(driver, "//*[contains(text(),'Pick-up')]", "Captured vehicleInfo");
            System.out.println("Captured Pickup and DropOff info:  " + vehicleInfo);
            Label info = new Label(6, i, vehicleInfo);

            Thread.sleep(1000);//waitTime

            //capturing the total cost
            String TotalPrice = ActionWorkLibrary.captureText(driver, "//*[@class='totalPrice']", "Total Cost");
            Label totalPrice = new Label(7, i, TotalPrice);
            System.out.print("Total Cost: " + TotalPrice);

            //adding back to excel
            wSheet.addCell(info);
            wSheet.addCell(totalPrice);


            Thread.sleep(1000);//waitTime
            driver.close();//close new opened window

            //switch to previous
            driver.switchTo().window(tabs.get(0));

            //delete all cookies
            driver.manage().deleteAllCookies();

        }//end of loop
    }//end of test class

    @AfterSuite
    public void After() throws IOException, WriteException, InterruptedException {

        writableFile.write(); //Write on writable file
        writableFile.close(); //close the writablefile
        readableFile.close(); //close the readable file
        driver.quit(); //close the browser
    }//end aftersuite


}

