package DAY4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DAY4_Topic3_GoogleTest_withLoop {
    public static void main(String[] args) throws InterruptedException {
        //set the system chrome driver path ayleast once in one of your main method
        //webdriver.chrome.driver needs to be in lower case followed by your driver path

        System.setProperty("webdriver.chrome.driver", "/Users/kalra/Desktop/SIMRANJEET QA/src/SumonQA/resource/chromedriver");
//for mac we have to copy chrome driver from resources folder
        //you declare and define the web driver
        WebDriver driver = new ChromeDriver();

        //create a dynamic array
        String[] city = new String[4];
        city[0] = "Queens";
        city[1] = "Bronx";
        city[2] = "Brooklyn";
        city[3] = "Manhattan";

        // this is where you will start the loop from navigate up untill before quit
        for (int i = 0; i < city.length; i++) {

            //opening the browser automatically to go yo google home page
            driver.navigate().to("https://www.google.com");
            //maximize your browser
            driver.manage().window().maximize();

            //wait  few seconds after navigatingto a apage so browser can load property
            Thread.sleep(2000);

            //locate the search field by inspecting it frst and then end a keyword let say cars
            driver.findElement(By.name("q")).sendKeys((city[i]));
            //click on google search
            driver.findElement(By.name("btnK")).submit();

            Thread.sleep(2000);
            //to capture a text from the website you need to
            String message = driver.findElement(By.id("result-stats")).getText();
            // using array variable to split above message
            String[] arrayResult = message.split(" ");
            System.out.println("My city is " + city[i] + " and search number is " + arrayResult[1]);
        }//for loop end

        Thread.sleep(2000);
        //close vs quit the session
        //quit will kill the driver from your task memory
        //close will only close the driverbut not from your memory
        //i(sumon) prefer to use quit
        driver.quit();

    }// main end

}//public class end
