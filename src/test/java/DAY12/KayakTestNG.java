package DAY12;

import DAY10.ActionWorkLibrary;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class KayakTestNG {
    //declare Webdriver outside all methodsof all methods of reusable
    WebDriver driver;


    @BeforeSuite
    public void defineDriver() throws IOException,InterruptedException {
        driver = ActionWorkLibrary.setProperty();
    }//end of before suite

    @Test
    public void KayakTestCase() throws InterruptedException {
        driver.navigate().to("https://www.Kayak.com");
        Thread.sleep(2000);
        //verify the title using hard assertion
        //Assert.assertEquals(driver.getTitle(), "Seach Hotel, Cars");
        //using soft assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),"Seach Hotel, Cars");
        //click airport or city
        ReusableLib.ActionWorkLibrary.clickElement(driver,"//*[@data-placeholder='Enter an airport or city']","Search field");
        //enter the airport
        ActionWorkLibrary.userKeys(driver,"//*[@name='pickup']","JFK","Search field");
        //pass assert that way it doesnt skip all your steps
        softAssert.assertAll();

    }//end of test class

    @AfterSuite
    public void closeSession() {
driver.quit();
    }


}//class end
