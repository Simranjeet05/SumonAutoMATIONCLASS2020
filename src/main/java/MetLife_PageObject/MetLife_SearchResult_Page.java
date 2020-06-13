package MetLife_PageObject;

import ReusableLib.Abstract_class;
import ReusableLib.ReusableLibMain;
import com.google.common.base.Verify;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_SearchResult_Page extends Abstract_class {
    ExtentTest logger;

    public MetLife_SearchResult_Page(WebDriver driver) {//no void method coz its a constructor
        super();
        PageFactory.initElements(driver, this);
        this.logger = super.logger;
    }//end of the constructor

    public MetLife_SearchResult_Page VerifyTitle0() {
        //verify the title
        ReusableLibMain.verifyTitle(driver, "Insurance & Employee Benefit | Metlife", logger);
        return new MetLife_SearchResult_Page(driver);
    }//VerifyTitle0 end

    public MetLife_SearchResult_Page VerifyTitle() {
        //verify page title
        ReusableLibMain.verifyTitle(driver, "MetLife TakeAlong Dental | MetLife", logger);
        return new MetLife_SearchResult_Page(driver);
    }//VerifyTitle end

    public MetLife_SearchResult_Page EnterZipCode(String UserValue) {
        //find zipcode entery bar, clear it and then send zipCode from the array
        ReusableLibMain.userKeys(driver, "//*[@name='txtZipCode']", UserValue, "enter zipcode", logger);
        return new MetLife_SearchResult_Page(driver);
    }//EnterZipCode end

    public MetLife_SearchResult_Page ScrollToElement() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        ReusableLibMain.scroll(driver, "//*[text()='Coverage Type - PPO']", "scroll", logger);
        return new MetLife_SearchResult_Page(driver);
    }//ScrollToElement end

    public MetLife_SearchResult_Page ScrollLocatorEnroll() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll to the bottom of the screen to enroll now in program now
        ReusableLibMain.scroll(driver, "//*[@id='bottomenrolltab']", "scroll", logger);
        return new MetLife_SearchResult_Page(driver);
    }//ScrollLocatorEnroll end

    public MetLife_SearchResult_Page ClickPPOcheckbox(String UserValue) {
        //click on the PPO box for assigned
        ReusableLibMain.click(driver, "//*[@class='" + UserValue + "']", "dentalProgramType", logger);
        return new MetLife_SearchResult_Page(driver);
    }//ClickPPOcheckbox end

    public MetLife_SearchResult_Page ReferralCodeInput(String UserInput) {
        //locate and send referralCode arraylist
        ReusableLibMain.userKeys(driver, "//*[@id='txtBxPromocode']", UserInput, "referralCode", logger);
        return new MetLife_SearchResult_Page(driver);
    }//ReferralCodeInput end

    public MetLife_SearchResult_Page CaptureMessage() {
        //store the message displayed and send it to console
        ReusableLibMain.captureText(driver, "//*[@id='lblRefCodeError']", "PPO-Type store", logger);
        return new MetLife_SearchResult_Page(driver);
    }//CaptureMessage end

    public MetLife_SearchResult_Page CaptureErrorMessage(String UserInput) {
        //capture the statement and match the stored variable with the dental.Program arraylist
        //print the result if matches
        String PPOtype = ReusableLibMain.captureText(driver, "//*[@class='col-sm-8']", "capture Text", logger);
        if (PPOtype.contains(UserInput)) {
            System.out.println("Search result contains matching PPOType: " + UserInput);
        } else {
            System.out.println("Search result Does not contains matching PPOType");
        }//end of if-else condition
        return new MetLife_SearchResult_Page(driver);
    }//CaptureErrorMessage end

}//public class end
