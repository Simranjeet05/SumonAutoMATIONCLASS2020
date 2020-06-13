package DAY11;

import ReusableLib.ActionWorkLibrary;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;

public class GoogleSearch_TestNG {

    WebDriver driver;
    ArrayList<String> cars= new ArrayList();

    @Test
    public void googleSearch() throws InterruptedException {
        for (int i=0; i<cars.size(); i++){
            driver.navigate().to("https://www.google.com");
            Thread.sleep(2000);
            //enter keywork car in search field
            ActionWorkLibrary.userKeys(driver, "//*[@name='q']", cars.get(i), "Search Field" +cars.get(1));
            //click submit
            ActionWorkLibrary.submit(driver, "//*[@name='btnK']", "Google Search Button");
            Thread.sleep(2000);
            //capture tex and print out the search number
            String searchResult = ActionWorkLibrary.captureText(driver, "//*[@id='result-stats']", "Search Result");
            //split the text and print the number
            String[] arraySearch = searchResult.split(" ");
            Reporter.log("My seach number for car is: " +arraySearch[1]);//report to html
            System.out.println("My Search number is " + arraySearch[1]);
        }//for loop end
    }//end of googleSearch


    @BeforeSuite
    public void callDriver() throws IOException, InterruptedException {
        driver = ActionWorkLibrary.setProperty();
        cars.add("BMW");
        cars.add("Mercedes");
        cars.add("Audi");
    }//end of before method

    @AfterSuite
    public void quitDriver() {

        driver.quit();
    }//end of after method

}
