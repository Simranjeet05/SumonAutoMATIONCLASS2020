package Yahoo_Page_Object;

import ReusableLib.Abstract_class;
import ReusableLib.ReusableLibMain;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Search_Result_Page extends Abstract_class {
    ExtentTest logger;

    //we need to cretae a constructor method that defines
    //driver and logger to be reuse locally to this page class
    //contructor inherits same name as your java class
    public Yahoo_Search_Result_Page(WebDriver driver) {//no void method coz its a constructor
        super();
        PageFactory.initElements(driver, this);
        //local page logger gets set to abstract class logger when you use it in
        //page object concept
        this.logger = super.logger;
    }//end of the constructor

    public Yahoo_Search_Result_Page scrollToBottom(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        logger.log(LogStatus.INFO,"Scrolling to the bottom");
        jse.executeScript("scroll(0,10000)");
        return new Yahoo_Search_Result_Page(driver);
    }

    //method to capture the search number
    public Yahoo_Search_Result_Page searchNumber() {
        String searchResult = ReusableLibMain.captureText(driver, "//*[@class='compPagination']", "searchField", logger);
        String[] searchNumber = searchResult.split("Next");
        logger.log(LogStatus.INFO, "My searchNumber is " + searchNumber[1]);
        return new Yahoo_Search_Result_Page(driver);
    }

}
