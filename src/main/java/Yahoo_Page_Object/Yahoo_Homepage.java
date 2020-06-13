package Yahoo_Page_Object;

import ReusableLib.Abstract_class;
import ReusableLib.Abstract_class_Parameter;
import ReusableLib.ReusableLibMain;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Homepage extends Abstract_class {
    ExtentTest logger;
    //we need to cretae a constructor method that defines
    //driver and logger to be reuse locally to this page class
    //contructor inherits same name as your java class
    public Yahoo_Homepage(WebDriver driver){//no void method coz its a constructor
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object concept
        this.logger= super.logger;
    }//end of the constructor

    //method for searchField
    public Yahoo_Homepage searchField(String userValue){
        ReusableLibMain.userKeys(driver,"//*[@id='header-search-input']",userValue,"SearchField",logger);
        return new Yahoo_Homepage(driver);
        //the driver that i used is returning you the same
        //yahoo_homepage
    }
    //method for seachIcon
    public Yahoo_Homepage searchIcon(){
        ReusableLibMain.click(driver,"//*[@id='header-desktop-search-button']","click search",logger);
        return  new Yahoo_Homepage(driver);
    }//end of seach icon method

}
