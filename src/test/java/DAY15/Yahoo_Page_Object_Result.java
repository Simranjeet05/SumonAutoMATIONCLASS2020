package DAY15;

import ReusableLib.Abstract_class;
import Yahoo_Page_Object.Yahoo_Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Yahoo_Page_Object_Result extends Abstract_class {
    @Test
    public void Yahoo_Search_Result() throws InterruptedException {

        logger.log(LogStatus.INFO,"navigating to Yahoo Home Page");
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2500);
        Yahoo_Base_Class.yahoo_homepage().searchField("Cars");
        Thread.sleep(2500);
        //click on the search Icon
        Yahoo_Base_Class.yahoo_homepage().searchIcon();
        Thread.sleep(2500);
        //scroll to botton of the pAGE
        Yahoo_Base_Class.yahoo_search_result_page().scrollToBottom();
        //getting search number
        Yahoo_Base_Class.yahoo_search_result_page().searchNumber();




    }
}
