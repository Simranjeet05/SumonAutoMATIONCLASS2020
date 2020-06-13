package DAY4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DAY4_Topic2_GoogleTest {

        public static void main(String[] args) throws InterruptedException {
            //set the system chrome driver path ayleast once in one of your main method
            //webdriver.chrome.driver needs to be in lower case followed by your driver path

            System.setProperty("webdriver.chrome.driver","/Users/kalra/Desktop/SIMRANJEET QA/src/SumonQA/resource/chromedriver");
//for mac we have to copy chrome driver from resources folder


            //you declare and define the web driver
            WebDriver driver = new ChromeDriver();

                //opening the browser automatically to go yo google home page
                driver.navigate().to("https://www.google.com");

                //wait  few seconds after navigatingto a apage so browser can load property
                Thread.sleep(2000);

                //locate the search field by inspecting it frst and then end a keyword let say cars
                driver.findElement(By.name("q")).sendKeys("Cars");

                //maximize your browser
                driver.manage().window().maximize();

                //click on google search
                driver.findElement(By.name("btnK")).click();

                //to capture a text from the website you need to
                String message = driver.findElement(By.id("result-stats")).getText();
                // using array variable to split above message
                String[] arrayResult = message.split(" ");
                System.out.println("My search number is " + arrayResult[1]);


            //close vs quit the session
            //quit will kill the driver from your task memory
            //close will only close the driverbut not from your memory

            //i(sumon) prefer to use quit
            driver.quit();
        }// main end

    }
