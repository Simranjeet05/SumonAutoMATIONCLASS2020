package DAY7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class DAY7_Topic1_tryCatch_arrayList {

    public static void main(String[] args) throws InterruptedException {
        //set the system chrome driver path ayleast once in one of your main method
        //webdriver.chrome.driver needs to be in lower case followed by your driver path

        System.setProperty("webdriver.chrome.driver", "/Users/kalra/Desktop/SIMRANJEET QA/src/SumonQA/resource/chromedriver");
        //for mac we have to copy chrome driver from resources folder
        //you declare and define the web driver
        WebDriver driver = new ChromeDriver();

        //set the array list for the cars
        //dont need to define the size or the length
        ArrayList<String> cars=new ArrayList<>();
        cars.add("Lexus");
        cars.add("Toyota");
        cars.add("BMW");

        for(int i=0; i<cars.size(); i++) {


            //opening the browser automatically to go yo google home page
            driver.navigate().to("https://www.google.com");
            //maximize your browser
            driver.manage().window().maximize();

            //wait  few seconds after navigatingto a apage so browser can load property
            Thread.sleep(2000);
            try {
                //locate the search field by inspecting it frst and then end a keyword let say cars
                WebElement search = driver.findElement(By.xpath("//*[@name='q']"));
                search.sendKeys(cars.get(i));

            } catch (Exception e) {
                System.out.println("Unable to enter data on Search field" + e);
            }//end of search field exception
            try {
                //click on google search
                driver.findElement(By.xpath("//*[@name='btnK']")).submit();
            } catch (Exception e) {
                System.out.println("unable to submit on search icon" + e);
            }//end of search icon exception


            Thread.sleep(2000);
            try {
                //to capture a text from the website you need to
                String message = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();//XXXXXXXXX error we put here
                // using array variable to split above message
                String[] arrayResult = message.split(" ");
                System.out.println("My search number is " + arrayResult[1]);
            } catch (Exception e) {
                System.out.println("Unable to capture on search Result" + e);
            }
            Thread.sleep(2000);
        }
        //close vs quit the session
        //quit will kill the driver from your task memory
        //close will only close the driverbut not from your memory
        //i(sumon) prefer to use quit
        driver.quit();

        //when you inspect an element and most of the time  it takes  yout to lowest tag and property within it
        //but i can still usethe tags before and the properties of it as long as it highlights the same element in the page

    }// main end
}//class end
