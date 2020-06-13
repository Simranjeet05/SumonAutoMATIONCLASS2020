package DAY10;

import Day9.Reusable_Library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class DAY10_topic1_Excel_googleSearch {
    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {

        //Step1
        //locate the readable file path
        Workbook readableFile = Workbook.getWorkbook(new File("/Users/kalra/Desktop/SIMRANJEET QA/src/SumonQA/resource/Google_Search.xls"));

        //Step 2
        //locate the work workssheet
        Sheet readableSheet = readableFile.getSheet(0);

        //Step 3
        //we need to create a writeable workbook to minic readable file because we shouldny be writing on readable fime
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("/Users/kalra/Desktop/SIMRANJEET QA/src/SumonQA/resource/Google_Search_Result.xls"), readableFile);
        //create writable sheet
        WritableSheet writableSheet = writableFile.getSheet(0);
        //get the total rows that are not empty
        int rows = writableSheet.getRows();


        //calling the set property from the reusable lib(day9)
        WebDriver driver = Reusable_Library.setDriver();

        //maximizing the screen
        driver.manage().window().maximize();

        //defining the for loop
        for (int i = 1; i < rows; i++) {

            //step 4 :
            //store the cars column values as a string variable
            //columns are always hard coded whwereas the rows are dynamic based on your i
            String cars = writableSheet.getCell(0, i).getContents();

            //navigating to the website
            driver.navigate().to("https://www.google.com");

            Thread.sleep(2500);

            //reusable library to enter car values in search field
            Reusable_Library.userKeys(driver, "//*[@name='q']", cars, "Search Field");

            //reusable library to click on google search
            Reusable_Library.submit(driver, "//*[@name='btnK']", "Google Search");

            //timeout
            Thread.sleep(2000);

            String result = Reusable_Library.captureText(driver, "//*[@id='result-stats']", "Search Result");
            String[] resultArray = result.split(" ");
            System.out.println("My Search number is " + resultArray[1] +" "+resultArray[3]+" "+resultArray[4]);

            //step 5
            Label label = new Label(1, i, resultArray[1]);
            //adding back
            writableSheet.addCell(label);


        }//for loop end

        //outside of the loop we need to write and close the excel
        writableFile.write();
        writableFile.close();
        readableFile.close();

        //close browser
        driver.quit();


    }//end of main
}//end of class
