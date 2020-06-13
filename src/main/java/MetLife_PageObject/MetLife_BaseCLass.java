package MetLife_PageObject;

import ReusableLib.Abstract_class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_BaseCLass extends Abstract_class {

    public MetLife_BaseCLass(WebDriver driver) {//constructor
        super();
        PageFactory.initElements(driver, this);
    }//end of constructor

    //create new name for homepage which is going to be object for MetLife_Homepage
    public static MetLife_Homepage metLife_homepage() {
        MetLife_Homepage metLife_homepage = new MetLife_Homepage(driver);
        return metLife_homepage;
    }//end of object

    //object for metlife_homepage
    public static MetLife_SearchResult_Page metLife_searchResult_page() {
        MetLife_SearchResult_Page metLife_searchResult_page = new MetLife_SearchResult_Page(driver);
        return metLife_searchResult_page;
    }//end of object

}
