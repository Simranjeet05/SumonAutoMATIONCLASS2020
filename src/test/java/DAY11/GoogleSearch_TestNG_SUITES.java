package DAY11;

import ReusableLib.ActionWorkLibrary;
import ReusableLib.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class GoogleSearch_TestNG_SUITES {

    WebDriver driver;

    String getUrl;

    @Test(priority = 1)
    public void googleSearch() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
        //enter keywork car in search field
        ActionWorkLibrary.userKeys(driver, "//*[@name='q']", "Cars", "Search Field");
        //click submit
        ActionWorkLibrary.submit(driver, "//*[@name='btnK']", "Google Search Button");
        Thread.sleep(2000);
        //capture the current url
        getUrl = driver.getCurrentUrl();
    }//end of test priority 1
    //when you use dependsOnMethods in your @Test that means your second test is dependent
    //on your first tst if first test fails second test will be skipped
    //if all test has properties they might or might not be dependent on each other

    @Test(dependsOnMethods = "searchIngoogle")
    //@Test(priority = 2)
    public void captureTheResult() throws InterruptedException{
        driver.navigate().to(getUrl);
        Thread.sleep(2000);
        //capture tex and print out the search number
        String searchResult = ActionWorkLibrary.captureText(driver, "//*[@id='result-stats']", "Search Result");
        //split the text and print the number
        String[] arraySearch = searchResult.split(" ");
        System.out.println("My Search number is " + arraySearch[1]);
    }//end of  capture Result


    @BeforeSuite
    public void callDriver() {
        WebDriver driver = ActionWorkLibrary.setProperty();
    }//end of before method

    @AfterSuite
    public void quitDriver() {
        driver.quit();
    }//end of after method

}//class end
