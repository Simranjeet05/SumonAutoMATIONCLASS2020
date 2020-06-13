package DAY14ActionItem;

import ReusableLib.Abstract_class;
import ReusableLib.ReusableLibMain;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class MetLife_Abstract extends Abstract_class {

        @Test
        public void metlife() throws InterruptedException {


        //set array list for zipCodes
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("10007");
        zipCode.add("10025");
        zipCode.add("10016");

        //set array list for referralCodes
        ArrayList<String> referralCode = new ArrayList<>();
        referralCode.add("Promo1");
        referralCode.add("Promo2");
        referralCode.add("Promo3");

        //set array list for dentalPrograms
        ArrayList<String> dentalProgram = new ArrayList<>();
        dentalProgram.add("PPO-LOW");
        dentalProgram.add("PPO-MEDIUM");
        dentalProgram.add("PPO-HIGH");

        //Command to navigate the Website
        driver.navigate().to("http://www.metlife.com/");
        Thread.sleep(3000);//wait 3 seconds

        //introducing for loop zipCodes
        for (int i = 0; i < zipCode.size(); i++) {
            //verify the title
            ReusableLibMain.verifyTitle(driver,"Insurance & Employee Benefit | Metlife",logger);
            //hover on solutions
            ReusableLibMain.mouseHover(driver,"//*[@class='icon icon-chevron-down']", "hover on solutions",logger);
            Thread.sleep(1000);
            //click on the required
            ReusableLibMain.click(driver,"//*[text()='MetLife TakeAlong Dental']", "click on the required",logger );
            //verify page title
            ReusableLibMain.verifyTitle(driver,"MetLife TakeAlong Dental | MetLife",logger);
            Thread.sleep(2000);
            //click on enroll now
            ReusableLibMain.click(driver,"//a[@id='takealongdental_product_card_tile_1738502282_content-productActionButtonLink']","click on enroll now",logger);

            //After click on enroll now Switch to the new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            //declare and define java script(scroller)
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            Thread.sleep(3500);//wait time

            //find zipcode entery bar, clear it and then send zipCode from the array
            ReusableLibMain.click(driver,"//*[@name='txtZipCode']","click on search",logger);
            ReusableLibMain.userKeys(driver,"//*[@name='txtZipCode']",zipCode.get(i),"enter zipcode",logger);
            Thread.sleep(2000);

            //command to click on search after entering zipCode
            ReusableLibMain.click(driver,"//*[@id='txtZipCodetxt']","click search",logger);
            Thread.sleep(6000);//wait before scrolling

            //scroll to the coverage type element table
            ReusableLibMain.scroll(driver,"//*[text()='Coverage Type - PPO']","scroll",logger);
            Thread.sleep(2000);

            //click in checkbox as per requirement
            ReusableLibMain.click(driver,"//*[@class='" + dentalProgram.get(i) + "']", "dentalProgramType",logger);

            //scroll to the bottom of the screen to enroll now in program now
            ReusableLibMain.scroll(driver,"//*[@id='bottomenrolltab']","scroll",logger);

            //click on the enroll now in program button
            ReusableLibMain.click(driver,"//*[@id='bottomenrolltab']","click",logger);
            Thread.sleep(2000);

            //locate and send referralCode arraylist
            ReusableLibMain.userKeys(driver,"//*[@id='txtBxPromocode']",referralCode.get(i),"referralCode",logger);
            Thread.sleep(2000);

            //locate and click on GO button
            ReusableLibMain.click(driver,"//*[@name='btnEnroll']","click on go button",logger);

            //store the message displayed and send it to console
            ReusableLibMain.captureText(driver,"//*[@id='lblRefCodeError']","PPO-Type store",logger);
            Thread.sleep(2000);

            //click on Enroll without a referralCode
            ReusableLibMain.click(driver,"//*[@class='btn btn-primaryborder']","click on enroll",logger);
            Thread.sleep(5000);

            //capture the statement and match the stored variable with the dental.Program arraylist
            //print the result if matches
            String PPOtype= ReusableLibMain.captureText(driver,"//*[@class='col-sm-8']","capture Text",logger);
                if (PPOtype.contains(dentalProgram.get(i))) {
                    System.out.println("Search result contains matching PPOType: " + dentalProgram.get(i));
                } else {
                    System.out.println("Search result Does not contains matching PPOType");
                }//end of if-else condition

            Thread.sleep(2000);

            System.out.println(" ");

            //move to old tab back
            driver.close();
            driver.switchTo().window(tabs.get(0));
        }// loop end



}//main class end
}//public class end
