package DAY16;

import ReusableLib.Abstract_class;
import Yahoo_Page_Object.Yahoo_Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Yahoo_Page_Object_Search_Result extends Abstract_class {
    @Test
    public void Yahoo_Search_Result() throws InterruptedException {
        //using  array list to define the array test data
        ArrayList<String> cars = new ArrayList<>();
        cars.add("Mercedes");
        cars.add("BMW");
        cars.add("Audi");

        /** We are using reference name for page class which is
         * defined on yahoo base class
         */
for(int i=0; i<cars.size(); i++) {
    logger.log(LogStatus.INFO, "navigating to Yahoo Home Page");
    driver.navigate().to("https://www.yahoo.com");
    Thread.sleep(2500);
    //calling search field method from yahoo home page
    Yahoo_Base_Class.yahoo_homepage().searchField(cars.get(i));
    Thread.sleep(2500);
    //calling on the search Icon method from yahoo search result page
    Yahoo_Base_Class.yahoo_homepage().searchIcon();
    Thread.sleep(2500);
    //calling scroll to botton from yahoo search result page
    Yahoo_Base_Class.yahoo_search_result_page().scrollToBottom();
    //calling search number method from yahoo search result page
    Yahoo_Base_Class.yahoo_search_result_page().searchNumber();
}



    }
}
