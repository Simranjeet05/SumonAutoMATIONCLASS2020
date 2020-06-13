package codingChallenge;

import ReusableLib.Abstract_class;
import ReusableLib.ReusableLibMain;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Washington_skip5Multiple_checkbox extends Abstract_class {

    @Test
    public void CheckboxClick(){
        logger.log(LogStatus.INFO,"navigating to washington.edu");
        driver.navigate().to("https://faculty.washington.edu/chudler/java/boxes.html");

        int i=0;//initialize
        while(i<=100)//set the limit
        {
                if(i%5!=0) {
                    ReusableLibMain.clickByIndex(driver, "//*[@type='checkbox']", i, "clicked on ChecboxNumber " + i, logger);
                }
                i = i + 1;
            }//while loop ends

        //capture the result
        ReusableLibMain.getScreenShot(driver,logger,"Skip5Multiple");

    }//test method end
    }//public class end
