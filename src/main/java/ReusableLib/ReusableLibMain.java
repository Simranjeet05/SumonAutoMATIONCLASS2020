package ReusableLib;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ReusableLibMain {

        static int timeout = 20;


        //method to re use chrome driver and chrome options
        public static WebDriver setDriver() {
//set the chrome path
            System.setProperty("webdriver.chrome.driver", "/Users/kalra/Desktop/SIMRANJEET QA/Maven_Automation/src/main/resources/chromedriver");
//set some pre conditions using ChromeOptions
// ChromeOptions options = new ChromeOptions();
// //set the arguments you want for the driver
// options.addArguments("incognito");
//
// //now simply define your chrome driver
// WebDriver driver = new ChromeDriver(options);
            ChromeOptions options = new ChromeOptions();
            Map prefs = new HashMap();
            prefs.put("profile.default_content_settings.cookies", 2);
            options.setExperimentalOption("prefs", prefs);
            WebDriver driver = new ChromeDriver(options);
            driver = new ChromeDriver(options);
//maximize your window
//driver.manage().window().maximize();
            return driver;
        }

        //method to compare expected with actual title
        public static void verifyTitle(WebDriver driver, String expectedTitle, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try{
            String actualTitle = driver.getTitle();

            if (actualTitle.equals(expectedTitle)) {
                logger.log(LogStatus.INFO, "VerifyTitle");

                System.out.println("Expected title matches with Actual " + expectedTitle);
            } else {
                System.out.println("Expected doesn't match actual title. Actual title is " + actualTitle);
                logger.log(LogStatus.FAIL, "Unable to Verify");
                getScreenShot(driver,logger,"Error Verify Title");
            }
        }catch(Exception e){
                System.out.println("Unable to verify" + e);

    }}
        //end of verify title method


        //method to select a drop down value by visible text
        public static void dropdownByText(WebDriver driver, String locator, String userInput, String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                logger.log(LogStatus.INFO, "Selecting from drop down by text, The text is " + elementName);
                System.out.println("Selecting from drop down by text, The text is " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                Select dDown = new Select(element);
                dDown.selectByVisibleText(userInput);
            } catch (Exception e) {
                System.out.println("Unable to select " + elementName + " " + e);
                logger.log(LogStatus.FAIL, "Unable to select " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }
        }//end of drop down by text method

        //method to select a drop down value by visible text
        public static void dropdownByValue(WebDriver driver, String locator, String userInput, String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                logger.log(LogStatus.INFO,"Selecting element " + elementName);
                System.out.println("Selecting element " + elementName);
//WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                WebElement element = driver.findElement(By.xpath(locator));
                Select dDown = new Select(element);
                dDown.selectByValue(userInput);
            } catch (Exception e) {
                System.out.println("Unable to select element " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to select element " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }
        }//end of drop down by text method

        //method to enter user input on send keys
        public static void userKeys(WebDriver driver, String locator, String userInput, String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                logger.log(LogStatus.INFO, "Entering a value on element " + elementName);
                System.out.println("Entering a value on element " + elementName);
                Reporter.log("Entering a value on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                element.clear();
                Thread.sleep(2000);
                element.sendKeys(userInput);
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to enter element " + elementName + " " + e);
                Reporter.log("Unable to enter element " + elementName + " " + e);
                logger.log(LogStatus.FAIL, "Unable to enter element " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }//end of the try-catch condition
        }//end of sendKeys method

        //method to click on an element
        public static void click(WebDriver driver, String locator, String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                System.out.println("Click on " + elementName);
                logger.log(LogStatus.INFO, "Click on " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                element.click();
            } catch (Exception e) {
                System.out.println("Unable to click " + elementName + " " + e);
                logger.log(LogStatus.FAIL, "Unable to click " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }
        }//end of click method

        //method to submit on an element
        public static void submit(WebDriver driver, String locator, String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                logger.log(LogStatus.INFO, "Submitting a value on element " + elementName);
                System.out.println("Submitting a value on element " + elementName);
                Reporter.log("Submitting a value on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                element.submit();
            } catch (Exception e) {
                System.out.println("Unable to submit element " + elementName + " " + e);
                Reporter.log("Unable to submit element " + elementName + " " + e);
                logger.log(LogStatus.FAIL, "Unable to submit element " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }
        }//end of click method

        //method to return text from an element
        public static String captureText(WebDriver driver, String locator, String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            String result = null;
            try {
                logger.log(LogStatus.INFO, "Capturing a text from element " + elementName);
                System.out.println("Capturing a text from element " + elementName);
                Reporter.log("Capturing a text from element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                result = element.getText();
                System.out.println("The Text result is " + result);
            } catch (Exception e) {
                System.out.println("Unable to capture text on element " + elementName + " " + e);
                Reporter.log("Unable to capture text on element " + elementName + " " + e);
                logger.log(LogStatus.FAIL, "Unable to capture text on element " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }

            return result;
        }//end of click method

        public static String captureTextWithoutPrinting(WebDriver driver, String locator, String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            String result = null;
            try {
                logger.log(LogStatus.INFO, "Capturing a text from element " + elementName);
                System.out.println("Capturing a text from element " + elementName);
                Reporter.log("Capturing a text from element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                result = element.getText();
            } catch (Exception e) {
                System.out.println("Unable to capture text on element " + elementName + " " + e);
                Reporter.log("Unable to capture text on element " + elementName + " " + e);
                logger.log(LogStatus.FAIL, "Unable to capture text on element " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }

            return result;
        }//end of click method

        //-------------------------
//method to submit on an element
        public static void mouseHover(WebDriver driver, String locator, String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            Actions mouse = new Actions(driver);
            try {
                logger.log(LogStatus.INFO, "Hovering the mouse " + elementName);
                System.out.println("Hovering the mouse " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                mouse.moveToElement(element).perform();
            } catch (Exception e) {
                System.out.println("Unable to " + elementName + " " + e);
                logger.log(LogStatus.FAIL, "Unable to " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }
        }//end of click method

        public static void KeyDownAndEnter(WebDriver driver, String locator, String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);

            try {
                logger.log(LogStatus.INFO, "Keyboard operation:down and enter " + elementName);
                System.out.println("Keyboard operation:down and enter " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                element.sendKeys(Keys.ARROW_DOWN);
                element.sendKeys(Keys.ENTER);
            } catch (Exception e) {
                System.out.println("Unable to " + elementName + " " + e);
                logger.log(LogStatus.FAIL, "Unable to " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }

        }//end of keyboard method

        public static void KeyEnter(WebDriver driver, String locator, String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);

            try {
                logger.log(LogStatus.INFO, "Keyboard operation:down and enter " + elementName);
                System.out.println("Keyboard operation:down and enter " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                element.sendKeys(Keys.ENTER);
            } catch (Exception e) {
                System.out.println("Unable to " + elementName + " " + e);
                logger.log(LogStatus.FAIL, "Unable to " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }

        }//end of keyboard method

        public static void scrollDown(WebDriver driver, String locator, int xOffset, int yOffset, String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            Actions mouse = new Actions(driver);
            try {
                logger.log(LogStatus.INFO, "Keyboard operation:down and enter " + elementName);
                System.out.println("Keyboard operation:down and enter " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                mouse.dragAndDropBy(element, xOffset, yOffset).perform();
            } catch (Exception e) {
                System.out.println("Unable to " + elementName + " " + e);
                logger.log(LogStatus.FAIL, "Unable to " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }

        }//end of keyboard method

        //method to click by index on an element
        public static void clickByIndex(WebDriver driver, String locator, int index, String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                logger.log(LogStatus.INFO, "Clicking a value by index " + index + " on element " + elementName);
                System.out.println("Clicking a value by index " + index + " on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
                element.click();
            } catch (Exception e) {
                System.out.println("Unable to click by index " + index + " on element " + elementName + " " + e);
                logger.log(LogStatus.FAIL, "Unable to click by index " + index + " on element " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }
        }//end of click method

        //method to enter user input on send keys
        public static void userTypeAndHitEnter(WebDriver driver, String locator, String userInput, String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                logger.log(LogStatus.INFO, "Entering a value on element " + elementName);
                System.out.println("Entering a value on element " + elementName);
                Reporter.log("Entering a value on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                element.clear();
                element.sendKeys(userInput);
                element.sendKeys(Keys.ENTER);
            } catch (Exception e) {
                System.out.println("Unable to enter element " + elementName + " " + e);
                Reporter.log("Unable to enter element " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }
        }//end of userTypeAndHitEnter method

        public static void mouseClick(WebDriver driver, String locator, String elementName, ExtentTest logger) {
            Actions mouse = new Actions(driver);
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                logger.log(LogStatus.INFO, "Tne name of element is :" + elementName);
                System.out.println("The name of element is :" + elementName);
                WebElement clickMouse = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                mouse.moveToElement(clickMouse).click().perform();
            } catch (Exception e) {
                System.out.println("Unable to click the mouse click on element " + e);
                logger.log(LogStatus.FAIL, "Unable to click the mouse click on element " + e);
                getScreenShot(driver,logger,elementName);
            }//end of click mouse exception

        }//end of mouse click method

        public static void getScreenShot(WebDriver wDriver,ExtentTest logger,String imageName) {
            try {
                String fileName = imageName + ".png";
                String directory ="src/main/java/HTML_Report/Screenshots/";
                File sourceFile = ((TakesScreenshot) wDriver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(sourceFile, new File(directory + fileName));
//String imgPath = directory + fileName;
                String image = logger.addScreenCapture("Screenshots//" + fileName);
                logger.log(LogStatus.INFO, "ScreenShot", image);
            } catch (Exception e) {
                logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
                e.printStackTrace();
            }//end of if else condition
        }//end of screenshot method

        public static void ClickByIndex(WebDriver driver, String locator, int index, String elementName, ExtentTest logger) {

            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                logger.log(LogStatus.INFO, "Tne name of element is :" + elementName);
                System.out.println("The name of element is :" + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
                element.click();
            } catch (Exception e) {
                System.out.println("Unable to click the click by index on element " + e);
                logger.log(LogStatus.FAIL, "Unable to click the click by index on element " + e);
                getScreenShot(driver,logger,elementName);
            }//end of click mouse exception

        }//end of mouse click method

        public static void scroll(WebDriver driver, String locator, String elementName, ExtentTest logger) {

            JavascriptExecutor jsc = (JavascriptExecutor) driver;
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                logger.log(LogStatus.INFO, "Action Scroll" + elementName);
                System.out.println("Action Scroll" + elementName);
                WebElement Element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                jsc.executeScript("arguments[0].scrollIntoView(true);", Element);
            } catch (Exception e) {
                System.out.println("Unable to scroll " + e);
                logger.log(LogStatus.FAIL, "Unable to scroll" + e);
                getScreenShot(driver,logger,elementName);
            }//end of scroll

        }//end of mouse click method

    }
