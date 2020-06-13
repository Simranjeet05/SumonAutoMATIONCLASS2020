package FInalActionItem;

import MetLife_PageObject.MetLife_BaseCLass;
import MetLife_PageObject.MetLife_SearchResult_Page;
import ReusableLib.Abstract_class;
import ReusableLib.ReusableLibMain;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.ArrayList;

public class MetLife_PageObject_MainCLass extends Abstract_class {

    @Test
    public void MetLife_Main() throws InterruptedException {

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

        logger.log(LogStatus.INFO, "navigating to Yahoo Home Page");


        //Command to navigate the Website
        driver.navigate().to("http://www.metlife.com/");
        Thread.sleep(5000);//wait 3 seconds

        //introducing for loop zipCodes
        for (int i = 0; i < 1; i++) {

            MetLife_BaseCLass.metLife_searchResult_page().VerifyTitle0();
            Thread.sleep(3000);
            MetLife_BaseCLass.metLife_homepage().hover();
            Thread.sleep(1000);
            MetLife_BaseCLass.metLife_homepage().click();
            MetLife_BaseCLass.metLife_searchResult_page().VerifyTitle();
            Thread.sleep(2000);
            MetLife_BaseCLass.metLife_homepage().enroll();

            //After click on enroll now Switch to the new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            MetLife_BaseCLass.metLife_homepage().clickZipcode();
            MetLife_BaseCLass.metLife_searchResult_page().EnterZipCode(zipCode.get(i));
            Thread.sleep(2000);
            MetLife_BaseCLass.metLife_homepage().zipCodeSearchClick();
            Thread.sleep(6000);//wait before scrolling
            MetLife_BaseCLass.metLife_searchResult_page().ScrollToElement();
            Thread.sleep(2000);
            MetLife_BaseCLass.metLife_searchResult_page().ClickPPOcheckbox(dentalProgram.get(i));
            MetLife_BaseCLass.metLife_searchResult_page().ScrollLocatorEnroll();
            Thread.sleep(2000);
            MetLife_BaseCLass.metLife_homepage().Enrollclick();
            Thread.sleep(2000);
            MetLife_BaseCLass.metLife_searchResult_page().ReferralCodeInput(referralCode.get(i));
            Thread.sleep(2000);
            MetLife_BaseCLass.metLife_homepage().ReferralGoButton();
            ReusableLibMain.getScreenShot(driver,logger,"CaptureMessage");
            MetLife_BaseCLass.metLife_searchResult_page().CaptureMessage();
            Thread.sleep(2000);
            MetLife_BaseCLass.metLife_homepage().WithoutReferralCode();
            Thread.sleep(5000);
            MetLife_BaseCLass.metLife_searchResult_page().CaptureErrorMessage(dentalProgram.get(i));
            Thread.sleep(2000);
            System.out.println(" ");

            //move to old tab back
            driver.close();
            driver.switchTo().window(tabs.get(0));

        }//for loop ends
    }//void class ends
}//public class end
