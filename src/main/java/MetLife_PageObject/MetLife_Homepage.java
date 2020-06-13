package MetLife_PageObject;

import ReusableLib.Abstract_class;
import ReusableLib.ReusableLibMain;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Homepage extends Abstract_class {
    ExtentTest logger;

    public MetLife_Homepage(WebDriver driver) {//constructor
        super();
        PageFactory.initElements(driver, this);
        this.logger = super.logger;
    }//end of the constructor

    public MetLife_Homepage hover() {
        //hover on solutions
        ReusableLibMain.mouseHover(driver, "//*[@class='icon icon-chevron-down']", "Hover on Solutions", logger);
        return new MetLife_Homepage(driver);
    }//hover end

    public MetLife_Homepage click() {
        //click on the required field
        ReusableLibMain.click(driver, "//*[text()='MetLife TakeAlong Dental']", "MetLife TakeAlong Dental click", logger);
        return new MetLife_Homepage(driver);
    }//click end

    public MetLife_Homepage enroll() {
        //click on enroll now
        ReusableLibMain.click(driver, "//a[contains(@id,'content-productActionButtonLink')]", "Enroll now", logger);
        return new MetLife_Homepage(driver);
    }//enroll end

    public MetLife_Homepage clickZipcode() {
        //find zipcode entery bar and click
        ReusableLibMain.click(driver, "//*[@name='txtZipCode']", "Zipcode Entry Bar", logger);
        return new MetLife_Homepage(driver);
    }//clickZipCode end

    public MetLife_Homepage zipCodeSearchClick() {
        //command to click on search after entering zipCode
        ReusableLibMain.click(driver, "//*[@id='txtZipCodetxt']", "Zipcode Search Button", logger);
        return new MetLife_Homepage(driver);
    }//zipCodeSearchClick end

    public MetLife_Homepage Enrollclick() {
        //click on the enroll now in program button
        ReusableLibMain.click(driver, "//*[@id='bottomenrolltab']", "Enroll Button", logger);
        return new MetLife_Homepage(driver);
    }//EnrollClick End

    public MetLife_Homepage ReferralGoButton() {
        //locate and click on GO button
        ReusableLibMain.click(driver, "//*[@name='btnEnroll']", "Go button", logger);
        return new MetLife_Homepage(driver);
    }//ReferralGoButton end

    public MetLife_Homepage WithoutReferralCode() {
        //click on Enroll without a referralCode
        ReusableLibMain.click(driver, "//*[@class='btn btn-primaryborder']", "Enroll Without Referral", logger);
        return new MetLife_Homepage(driver);
    }//WithoutReferralCode

}//public class end
