package Day9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Google_With_Reusable_Methods {

    public static void main(String[] args) {
        //set the chrome path
        System.setProperty("webdriver.chrome.driver", "/Users/kalra/Desktop/SIMRANJEET QA/src/SumonQA/resource/chromedriver");
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        //navigate to mortgage calculator home page
        driver.navigate().to("https://www.google.com");

        //call my reusable method to compare title
        Reusable_Library.verifyTitle(driver,"Google");
        //call my reusable method to enter a Search Field
        Reusable_Library.userKeys(driver,"//*[@name='q']","Cars","Search Field");
        //call my reusable method to submit on google search
        Reusable_Library.submit(driver,"//*[@name='btnK']","Google Search");


    }




}
