package DAY13;

import ReusableLib.ActionWorkLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Topic1_ListBoolean {


    //declare driver outside
    WebDriver driver;

    @BeforeSuite
    public void Precondition () throws IOException, InterruptedException {
        driver = ActionWorkLibrary.setProperty();
    }//end of before suite

    @Test
    public void yahoo_verification() throws InterruptedException {
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com");
        //wait time
        Thread.sleep(3000);
        //i want to count all the links in yahoo and print it
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px)')]"));
        //print the total links count
        System.out.println("Total links are "+ linkCount.size());
        //sign in
        ActionWorkLibrary.clickElement(driver,"//*[@id='header-profile-menu']","Sign in");
        //wait time
        Thread.sleep(2000);
        //check if the sign in checkbox is selected using boolean
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //using if else condition
        if(checkboxState == true){
            System.out.println("Checkbox is selected by default ");
        }else {
            System.out.println("Checkbox is not selected by default");
        }//end of is else

        // System.out.println("is element selected? " +checkboxState);


    }//end of test

    @AfterSuite
    public void postCondition() throws InterruptedException {

    }// After Method


}
