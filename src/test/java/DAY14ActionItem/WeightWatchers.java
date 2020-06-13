package DAY14ActionItem;

import ReusableLib.Abstract_class;
import ReusableLib.ReusableLibMain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class WeightWatchers extends Abstract_class {

    @Test
    public void WeightWatchers() throws InterruptedException {
        //navigate to Weightwatchers.com
        driver.navigate().to("https://www.weightwatchers.com/us/");

        //verifying the title with the given
        ReusableLibMain.verifyTitle(driver, "Weight Watchers: Weight Loss & Welness Help", logger);

        //string array containing the zipCodes to be searched
        String[] zipCode = new String[]{"11801", "11507", "10004"};
        for (int i = 0; i <= zipCode.length; i++) { //for loop starts

            //click find workshop from menu bar
            ReusableLibMain.click(driver, "//*[contains(text(),'Find a Workshop')]", "Find Workshop", logger);
            Thread.sleep(2000); // wait time

            //typer clicks to search & commands to enter assigned zipcode
            ReusableLibMain.userKeys(driver, "//*[@name='meetingSearch']", zipCode[i], "Enter zipcodes", logger);
            Thread.sleep(2000); //wait time

            //click on search botton
            ReusableLibMain.click(driver, "//*[@class='btn spice-translated']", "Click search Button", logger);
            Thread.sleep(2000); //wait time

            //if: conditional loops starts commanding to open particular index locations for specific zipcodes
            if (i == 0) {
                ReusableLibMain.click(driver, "//*[@id='ml-1180230']", "Click on required", logger);
            }
            if (i == 1) {
                ReusableLibMain.click(driver, "//*[@id='ml-1180170']", "Click on required", logger);
            }
            if (i == 2) {
                ReusableLibMain.click(driver, "//*[@id='ml-1180150']", "Click on required", logger);
            }
            //conditional statements end

            Thread.sleep(2000);
            //capture the location name and address and print on console
            ReusableLibMain.captureText(driver, "//*[@class='location']", "Capturing required", logger);
            Thread.sleep(2000);

            //capture the schedule table and print it on console
            ReusableLibMain.captureText(driver, "//*[@class='meeting-schedule meeting-detail-bottom-section']", "capture Schedule", logger);

        }//for loop end

    }//void end
}//public class end
