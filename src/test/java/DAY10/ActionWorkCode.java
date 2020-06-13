package DAY10;

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

public class ActionWorkCode {
    public static void main(String[] args) throws InterruptedException, IOException, BiffException, WriteException {

        //locate the readable file path
        Workbook readableFile = Workbook.getWorkbook(new File("/Users/kalra/Desktop/SIMRANJEET QA/src/SumonQA/resource/ActionWorkExcel.xls"));

        //locate work worksheet
        Sheet readableSheet = readableFile.getSheet(0);

        //create a writeable workbook
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("/Users/kalra/Desktop/SIMRANJEET QA/src/SumonQA/resource/ActionWorkExcel.Result.xls"), readableFile);
        //create writable sheet
        WritableSheet writableSheet = writableFile.getSheet(0);
        //get the total rows that are not empty
        int rows = writableSheet.getRows();

        //calling the setProperty from the browser
        WebDriver driver = ActionWorkLibrary.setProperty();


        //defining the for loop
        for (int i = 1; i <=3; i++) {

            //storing the column values as a string variable
            String Size = writableSheet.getCell(0, i).getContents();
            String Quantity = writableSheet.getCell(1, i).getContents();
            String firstName = writableSheet.getCell(2, i).getContents();
            String lastName = writableSheet.getCell(3, i).getContents();
            String email = writableSheet.getCell(4, i).getContents();
            String phoneNumber = writableSheet.getCell(5, i).getContents();
            String streetAddress = writableSheet.getCell(6, i).getContents();
            String postalCode = writableSheet.getCell(7, i).getContents();
            String city = writableSheet.getCell(8, i).getContents();
            String state = writableSheet.getCell(9, i).getContents();
            String creditCardNumber = writableSheet.getCell(10, i).getContents();
            String expirationMonth = writableSheet.getCell(11, i).getContents();
            String ExpirationYear = writableSheet.getCell(12, i).getContents();
            String cvvCode = writableSheet.getCell(13, i).getContents();


            //navigate to the Website
            driver.navigate().to("https://www.express.com/");
            Thread.sleep(2000); //wait as page loading take time

            //hover on women tab
            ActionWorkLibrary.hover(driver, "//*[@class='_399XX MegaMenu_primaryNav__label__1s3d1']", "Hover on Women");
            Thread.sleep(1000);

            //click on dresses from hover tab
            ActionWorkLibrary.clickElement(driver, "//*[text()='Dresses']", "Click on Dresses");
            Thread.sleep(1000);

            //click on first dress
            ActionWorkLibrary.clickElement(driver, "//*[@class='_1ddDj _136PD']", "Select the First Dress");

            //click on the size
            ActionWorkLibrary.clickElement(driver, "//*[@value='"+Size+"']", "Select the Size");

            //click on add to cart
            ActionWorkLibrary.clickElement(driver, "//*[@class='btn _9yfmt _194FD _2tFXQ _3yOD6 _1Qp1L _2veMA']", "Click on Add to Cart");
            Thread.sleep(1000);

            //hover of shopping cart
            ActionWorkLibrary.hover(driver, "(//*[contains(@class,'HoverableSlideOutModal_modal_')]) [3]", "Hover on Shopping Cart");
            Thread.sleep(1000);

            //click on viewbag and checkout
            ActionWorkLibrary.clickElement(driver, "//*[@class='btn _9yfmt _194FD _2tFXQ']", "Click on View Bag and Checkout");


            //dropdown and select the quantity
            ActionWorkLibrary.dropdownByText(driver, "//*[@id='qdd-0-quantity']", Quantity, "Select the Quantity");

            //click checkout
            ActionWorkLibrary.clickElement(driver, "//*[@id='continue-to-checkout']", "Click on Checkout");


            //click continue as a guest
            ActionWorkLibrary.clickElement(driver, "//*[text()='Continue as Guest']", "Click on Continue as Guest");
            Thread.sleep(2000);


            //enter first name
            ActionWorkLibrary.userKeys(driver, "//*[@name='firstname']", firstName, "Enter First name");
            //enter Last name
            ActionWorkLibrary.userKeys(driver, "//*[@name='lastname']", lastName, "Enter last name");
            //enter email & confirm email
            ActionWorkLibrary.userKeys(driver, "//*[@name='email']", email, "Enter Email");
            ActionWorkLibrary.userKeys(driver, "//*[@name='confirmEmail']", email, "Confirm Email");
            //enter phone number
            ActionWorkLibrary.userKeys(driver, "//*[@name='phone']", phoneNumber, "Enter Phone Number");
            //click on continue
            ActionWorkLibrary.clickElement(driver, "//*[text()='Continue']", "Click Continue");


            //enter street address
            ActionWorkLibrary.userKeys(driver, "//*[@name='shipping.line1']", streetAddress, "Enter the Street Address");
            //enter the postal code
            ActionWorkLibrary.userKeys(driver, "//*[@name='shipping.postalCode']", postalCode, "Enter the Postal Code");
            //enter valid city
            ActionWorkLibrary.userKeys(driver, "//*[@name='shipping.city']", city, "Enter the City");
            //select state
            ActionWorkLibrary.dropdownByText(driver, "//*[@name='shipping.state']", state, "Select the state");
            //click on continue
            ActionWorkLibrary.clickElement(driver, "//*[text()='Continue']", "Click Continue");

            Thread.sleep(1000);
            //click on continue again
            //click on continue
            ActionWorkLibrary.clickElement(driver, "//*[text()='Continue']", "Click Continue Again");

            //enter card number
            ActionWorkLibrary.userKeys(driver, "//*[@name='creditCardNumber']", creditCardNumber, "Enter Credit Card Number");
            //select exp month
            ActionWorkLibrary.dropdownByText(driver, "//*[@name='expMonth']", expirationMonth, "Select Exp Month");
            //select exp year
            ActionWorkLibrary.dropdownByText(driver, "//*[@name='expYear']", ExpirationYear, "Select Exp Year");
            //enter the 3 digit cvv
            ActionWorkLibrary.userKeys(driver, "//*[@name='cvv']", cvvCode, "Enter the CVV Code");
            //click on Place Order
            ActionWorkLibrary.clickElement(driver, "//*[text()='Place Order']", "Place Order");

            Thread.sleep(2000);
            //capture the Error text
            String Message = ActionWorkLibrary.captureText(driver, "//*[@id='rvn-note-NaN']", "Capture the Message");
            System.out.println("Captured Message is:  " + Message);

            Label label = new Label(14, i, Message);
            //adding back
            writableSheet.addCell(label);

            //delete all cookies
            driver.manage().deleteAllCookies();
        }//end of for loop

        writableFile.write();
        writableFile.close();
        readableFile.close();

        driver.quit();//close the program
    }//main end
}//public class end
