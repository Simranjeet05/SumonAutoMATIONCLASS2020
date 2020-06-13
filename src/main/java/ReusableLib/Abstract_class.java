package ReusableLib;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class Abstract_class {
    // you need to set the global variable as public static in order
    //to be used on your @test classes
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    //define before suite to set a static driver
    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
        driver = ReusableLibMain.setDriver()  ;

        //define the report path
       // reports = new ExtentReports("src//main//java//HTML//TestReport.html",true);
        reports= new ExtentReports("/Users/kalra/Desktop/SIMRANJEET QA/Maven_Automation/src/main/java/HTML/TestReport.html",true);
    }//end of before suite

    //before method will be used to capture a unique @test name that you gave on your test classes
    @BeforeMethod
    public void getMethodName(Method testName){
        //start the logger here to capture the method name
        logger = reports.startTest(testName.getName());
    }//end of before method

    //after method will end each test
    @AfterMethod
    public void endTest(){
        reports.endTest(logger);
    }//end of after method

    //After suite will quit and flush to your report
    @AfterSuite
    public void PostCondition (){
        driver.quit();
        reports.flush();
    }//end of after suite



}//end of java class

