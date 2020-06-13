package DAY6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class actionWork {
    public static void main(String[] args) throws InterruptedException{

        //set the path
        System.setProperty("webdriver.chrome.driver","/Users/kalra/Desktop/SIMRANJEET QA/src/SumonQA/resource/chromedriver");

        //set the pre-condition
        ChromeOptions options = new ChromeOptions();
        //set an argument for this driver
        options.addArguments("incognito");

        //define the chrome driver and call options
        WebDriver driver = new ChromeDriver(options);

        //navigate to Weightwatchers.com
        driver.navigate().to("https://www.weightwatchers.com/us/");

        Thread.sleep(1500); //wait 1.5sec before maximizing screen
        //maximize the screen-could not do by option(Mac doesn't support)
        driver.manage().window().maximize();

        //verifying the title with the given
        String actualTitle =driver.getTitle();
        if (actualTitle.equals("Weight Watchers: Weight Loss & Welness Help")) {
            System.out.println("TITLE matches with expected"); //print if the title matches
        }
        else{ //else condition if given title doesn't match
            System.out.println("Title does not match but the correct Title is: "+actualTitle);//print the correct title
        }//end of if else condition

        //string array containing the zipCodes to be searched
        String[] zipCode = new String[] {"11801", "11507", "10004"};


        for (int i=0; i<=zipCode.length; i++){ //while loop starts

            driver.findElement(By.xpath("//*[@class='find-a-meeting']")).click(); //click find workshop from menu bar
            Thread.sleep(2000); // wait time
            driver.findElement(By.xpath("//*[@name='meetingSearch']")).sendKeys((zipCode[i])); //typer clicks to search & commands to enter assigned zipcode
            Thread.sleep(2000); //wait time
            driver.findElement(By.xpath("//*[@class='btn spice-translated']")).click(); //click on search botton
            Thread.sleep(2000); //wait time

            //if: conditional loops starts commanding to open particular index locations for specific zipcodes
            if(i==0){
                driver.findElements(By.xpath("//*[@id='ml-1180230']")).get(0).click();
            }
            if(i==1){
                driver.findElements(By.xpath("//*[@id='ml-1180170']")).get(0).click();
            }
           if(i==2){
                driver.findElements(By.xpath("//*[@id='ml-1180150']")).get(0).click();
            }
            //conditional statements end*/

            Thread.sleep(2000);
            //capture the location name and address and print on console
            String location= driver.findElement(By.xpath("//*[@class='location']")).getText();
            System.out.println("Location: " +location);
            Thread.sleep(2000);

            //capture the schedule table and print it on console
            String schedule= driver.findElement(By.xpath("//*[@class='meeting-schedule meeting-detail-bottom-section']")).getText();
            System.out.println("Schedule: " +schedule);

        }//while loop end

        Thread.sleep(2000);
        driver.quit(); //quit the program


    }//main end
}//public class end
