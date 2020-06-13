package DAY8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class ActionItemDay8 {
    public static void main(String[] args) throws InterruptedException {

        //set the path
        System.setProperty("webdriver.chrome.driver", "/Users/kalra/Desktop/SIMRANJEET QA/src/SumonQA/resource/chromedriver");
        //set the pre-condition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito"); //turing the browser on private mode

        //declare webdriver and define options
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize(); // maximizing the screen

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

            //Verify the title "Insurance & Employee Benefit | Metlife"
            String Title = driver.getTitle();
            if (Title.equals("Insurance & Employee Benefit | Metlife")) {
                System.out.println("TITLE IS CORRECT & MATCHES");
            } else {
                System.out.println("INCORRECT TITLE & THE CORRECT TITLE IS: " + Title);
            }//end of if else condition

            //declare and define actions
            Actions mouse = new Actions(driver);

            //mouse on solutions on menu bar
            try {
                WebElement Solutions = driver.findElement(By.xpath("//*[@class='icon icon-chevron-down']"));
                // call your actions command
                mouse.moveToElement(Solutions).perform();
            } catch (Exception e) {
                System.out.println("Unable to locate SOLUTIONS" + e);
            }//end of SOLUTIONS exception
            Thread.sleep(1000);


            //click on Metlife TakeAlong Dental
            try {
                WebElement MetlifeTakeAlongDental = driver.findElement(By.xpath("//*[text()='MetLife TakeAlong Dental']"));
                // call your actions command to move the elemet and then click
                mouse.moveToElement(MetlifeTakeAlongDental).click().perform();
                //Verify the title "MetLife TakeAlong Dental | MetLife"
                String Title2 = driver.getTitle();
                if (Title2.equals("MetLife TakeAlong Dental | MetLife")) {
                    System.out.println("TITLE IS CORRECT & MATCHES: " + Title2);
                } else {
                    System.out.println("INCORRECT TITLE & THE CORRECT TITLE IS: " + Title2);
                }//end of if else condition
            } catch (Exception e) {
                System.out.println("Unable to locate & click Metlife TakeAlong Dental" + e);
            }//end of Metlife TakeAlong Dental

            Thread.sleep(2000);

            try {
                //click on the enroll now button
                driver.findElement(By.xpath("//a[@id='takealongdental_product_card_tile_1738502282_content-productActionButtonLink']")).click();
                //switch to a new tab
            } catch (Exception e) {
                System.out.println("Unable to locate Enroll now button " + e);
            }//end of enroll now button


            //After click on enroll now Switch to the new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            //declare and define java script(scroller)
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            Thread.sleep(3500);//wait time


            //find zipcode entery bar, clear it and then send zipCode from the array
            try {
                WebElement search = driver.findElement(By.xpath("//*[@name='txtZipCode']"));
                search.clear();
                search.sendKeys(zipCode.get(i));
            } catch (Exception e) {
                System.out.println("Unable to find zipcode input bar and send keys " + e);
            } //end of zipCode entry bar
            Thread.sleep(2000);


            //command to click on search after entering zipCode
            try {
                driver.findElement(By.xpath("//*[@id='txtZipCodetxt']")).click();
            } catch (Exception e) {
                System.out.println("Unable to locate and tap on search button " + e);
            } //end of seach after entering Zipcode

            Thread.sleep(6000);//wait before scrolling


            //scroll to the coverage type element table
            try {
                WebElement coverageType = driver.findElement(By.xpath("//*[text()='Coverage Type - PPO']"));
                jse.executeScript("arguments[0].scrollIntoView(true);", coverageType);
            } catch (Exception e) {
                System.out.print("unable to scroll down to required element " + e);
            }//end of scroll
            Thread.sleep(2000);


            //click in checkbox as per requirement
            try {
                driver.findElement(By.xpath("//*[@class='" + dentalProgram.get(i) + "']")).click();
            } catch (Exception e) {
                System.out.println("Unable to locate the checkbox and send keys " + e);
            }//end of catch box
            Thread.sleep(2000);


            //scroll to the bottom of the screen to enroll now in program now
            try {
                WebElement bottomEnrollNow = driver.findElement(By.xpath("//*[@id='bottomenrolltab']"));
                jse.executeScript("arguments[0].scrollIntoView(true);", bottomEnrollNow);
            } catch (Exception e) {
                System.out.println("Unable to scroll down to enroll in program now " + e);
            }//end of scroll
            Thread.sleep(2000);


            //click on the enroll now in program button
            try {
                driver.findElement(By.xpath("//*[@id='bottomenrolltab']")).click();
            } catch (Exception e) {
                System.out.println("Unable to loacte enroll in program button and send keys " + e);
            }//end of click for enroll now
            Thread.sleep(2000);

            //locate and send referralCode arraylist
            try {
                driver.findElement(By.xpath("//*[@id='txtBxPromocode']")).sendKeys(referralCode.get(i));
            } catch (Exception e) {
                System.out.println("Unable to locate and send referral code array list " + e);
            }//end of promocode
            Thread.sleep(2000);


            //locate and click on GO button
            try {
                driver.findElement(By.xpath("//*[@name='btnEnroll']")).click();
            } catch (Exception e) {
                System.out.println("Unable to locate and click on GO button" + e);
            }//end of locate button
            Thread.sleep(2000);


            //store the message displayed and send it to console
            try {
                WebElement displaymessage = driver.findElement(By.xpath("//*[@id='lblRefCodeError']"));
                System.out.println("Afer PromoCode Entry message Displayed is: " + displaymessage.getText());
            } catch (Exception e) {
                System.out.println("Unable to store display message and display on the console " + e);
            }//end of STORE AND DISPLAY RESULT in console


            Thread.sleep(2000);
            //click on Enroll without a referralCode
            try {
                driver.findElement(By.xpath("//*[@class='btn btn-primaryborder']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on enroll without referralCode " + e);
            }//end of enroll without referral code
            Thread.sleep(5000);


            //capture the statement and match the stored variable with the dental.Program arraylist
            //print the result if matches
            try {
                String PPOtype = driver.findElement(By.xpath("//*[@class='col-sm-8']")).getText();
                if (PPOtype.contains(dentalProgram.get(i))) {
                    System.out.println("Search result contains matching PPOType: " + dentalProgram.get(i));
                } else {
                    System.out.println("Search result Does not contains matching PPOType");
                }//end of if-else condition
            } catch (Exception e) {
                System.out.println("Unable to capture the PPO under Program Application " + e);
            }//end of catch
            Thread.sleep(2000);

            System.out.println(" ");

            //move to old tab back
            driver.close();
            driver.switchTo().window(tabs.get(0));
        }// loop end


        driver.quit();//close the browser

    }//main class end
}//public class end