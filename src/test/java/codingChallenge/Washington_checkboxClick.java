package codingChallenge;

import ReusableLib.Abstract_class;
import ReusableLib.ReusableLibMain;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Washington_checkboxClick extends Abstract_class {

    @Test
    public void CheckboxClick(){
        logger.log(LogStatus.INFO,"navigating to washington.edu");
        //navigate to website
        driver.navigate().to("https://faculty.washington.edu/chudler/java/boxes.html");

         int i=0;//initialize
         while(i<=100)//limit
         {
            ReusableLibMain.clickByIndex(driver, "//*[@type='checkbox']",i, "clicked on ChecboxNumber "+i,logger);
        i=i+1;
        }//while loop end
        //capture the result
        ReusableLibMain.getScreenShot(driver,logger,"Screenshot");
        }//checkboxclick method end
}//public class end
