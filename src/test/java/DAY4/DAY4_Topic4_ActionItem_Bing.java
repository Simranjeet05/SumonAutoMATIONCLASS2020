package DAY4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Action Item.......................................................................................................................
Go to bing.com
Using dynamic array variable with at least 5 values, you can create the values for any of the following  variable such as
country, state, location, sports, places

By using for or while loop create following scenarios as followed
1. Go to bing.com
2. Enter a keyword on a search field
3. Click on Search button
4. Capture the search message
5. Split and print out only the search number for each values within the category
6. Outside of the loop quit the driver
 */

public class DAY4_Topic4_ActionItem_Bing {
    public static void main(String[] args) throws InterruptedException {

        //set the system chrome driver path
        System.setProperty("webdriver.chrome.driver", "/Users/kalra/Desktop/SIMRANJEET QA/src/SumonQA/resource/chromedriver");

        //declare and define the web driver
        WebDriver driver = new ChromeDriver();

        //create a dynamic array and define it
        String[] sports = new String[5];
        sports[0] = "Cricket";
        sports[1] = "Baseball";
        sports[2] = "Golf";
        sports[3] = "Ice Hockey";
        sports[4] = "Tennis";

        //for-loop starts: same search criteria for defined array
        for (int i = 0; i < sports.length; i++) {

            //opening the browser and commanding to open Bing.com
            driver.navigate().to("https://www.bing.com/?FORM=UNKSBD");
            Thread.sleep(1000);//wait time

            //locates search key and types in the searching item
            driver.findElement(By.name("q")).sendKeys((sports[i]));

            //automatically clicks the search btn for the searching item
            driver.findElement(By.name("search")).submit();


            //capturing the required text
            String message = driver.findElement(By.id("b_tween")).getText();
            Thread.sleep(1000);//wait time

            // splitting message above by array var.
            String[] searchRequired = message.split(" ");
            System.out.println("Searched Sport is " + sports[i] + " & Total available searching numbers are : " + searchRequired[0]);
        }//for-loop end

        Thread.sleep(1000);//wait time before browser closes

        //exit the browser after search is complete
        driver.quit();

    }//main class end
}//public class end

