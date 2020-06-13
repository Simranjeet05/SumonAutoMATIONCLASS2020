package ReusableLib;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class ActionWorkLibrary_Logger {


        static int time = 20;

        //setting the property for the browser:opens chrome(incoginto mode) and maximize the screen
        public static WebDriver setProperty() {
            System.setProperty("webdriver.chrome.driver", "/Users/kalra/Desktop/SIMRANJEET QA/Maven_Automation/src/main/resources/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("incognito");
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            return driver;
        }//end of set property

        //method to enter user input on send keys
        public static void userTypeAndHitEnter(WebDriver driver,String locator, String userInput, String elementName, ExtentTest logger){
            WebDriverWait wait = new WebDriverWait(driver,time);
            try{
                System.out.println("Entering a value on element " + elementName);
                logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                element.clear();
                element.sendKeys(userInput);
                element.sendKeys(Keys.ENTER);
            } catch (Exception e) {
                System.out.println("Unable to enter element " + elementName + " " + e);
                logger.log(LogStatus.FAIL, "Unable to hover on  element "+elementName+" "+e);

            }
        }//end of userTypeAndHitEnter method

        //reusable method for hover tab
        public static void hover(WebDriver driver, String locator, String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, time);
            //declare and defineActions
            Actions mouse = new Actions(driver);
            try {
                System.out.println("hover on element " + elementName);
                logger.log(LogStatus.INFO,"hover on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                mouse.moveToElement(element).perform();
            } catch (Exception e) {
                System.out.println("Unable to hover on tab: " + elementName + " " + e);
                logger.log(LogStatus.FAIL, "Unable to hover on  element "+elementName+" "+e);

            }//end of catch
        }//end of hover

        //click on click and ship using actions
        public static void MouseClickElement(WebDriver driver, String locator, String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, time);
            Actions mouse = new Actions(driver);

            try {
                logger.log(LogStatus.INFO,"Mouse cLick on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                // WebElement clickAndShip = driver.findElement(By.xpath("//*[@class='tool-cns']/a[text()='Click-N-Ship']"));
                // call your actions command to move the elemet and then click
                mouse.moveToElement(element).click().perform();
                //clickAndShip.submit();
                //this is to submit using mouse actions
                //mouse.moveToElement(clickAndShip).sendKeys(Keys.ENTER).perform();
            } catch (Exception e) {
                System.out.println("Unable to mouse click on " + elementName + " " + e);
                logger.log(LogStatus.FAIL, "Unable to MouseClick element "+elementName+" "+e);

            }//end of Click-n-ship exception
        }
        //reusable method for click
        public static void clickElement(WebDriver driver, String locator, String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, time);
            try {
                System.out.println("click on element " + elementName);
                logger.log(LogStatus.INFO,"click on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                element.click();
            } catch (Exception e) {
                System.out.println("Unable to click " + elementName + " " + e);
                logger.log(LogStatus.FAIL, "Unable to click element "+elementName+" "+e);
            }//end of catch
        } //end for click method

        //method to select a drop down value by visible text
        public static void dropdownByText(WebDriver driver, String locator, String userInput, String elementName,ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, time);
            try {
                System.out.println("Selecting a value on element " + elementName);
                logger.log(LogStatus.INFO,"Selecting a value on element " + elementName);

                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                Select dDown = new Select(element);
                dDown.selectByVisibleText(userInput);
            } catch (Exception e) {
                System.out.println("Unable to select element " + elementName + " " + e);
                logger.log(LogStatus.FAIL, "Unable to Select element "+elementName+" "+e);
            }
        }//end of drop down by text method


        //method to enter user input on send keys
        public static void userKeys(WebDriver driver, String locator, String userInput, String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, time);
            try {
                System.out.println("Entering a value on element " + elementName);
                logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                element.clear();
                element.sendKeys(userInput);
            } catch (Exception e) {
                System.out.println("Unable to enter element " + elementName + " " + e);
                logger.log(LogStatus.FAIL, "Unable to enter element "+elementName+" "+e);

            }
        }

        //method to return text from an element
        public static String captureText(WebDriver driver, String locator, String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, time);
            String result = null;
            try {
                System.out.println("Capturing a text from element " + elementName);
                logger.log(LogStatus.INFO,"Capturing a text from element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                result = element.getText();
                System.out.println("My Required Text is: " + result);
            } catch (Exception e) {
                System.out.println("Unable to Capture element " + elementName + " " + e);
                logger.log(LogStatus.FAIL, "Unable to Capture element "+elementName+" "+e);

            }
            return result;
        }//end of click method

    //method to click by index on an element
    public static void clickByIndex(WebDriver driver,String locator,int index, String elementName, ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver,time);
        try{
            System.out.println("Clicking a value by index " + index + " on element " + elementName);
            logger.log(LogStatus.INFO," Clicking a value by index " + index + "on element" +elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click by index " + index +  " on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to Click by index "+elementName+" "+e);

        }
    }//end of click method



    }

