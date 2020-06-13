package Day9;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Statefarm_Test {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= Reusable_Library.setDriver();

        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("11219");

        ArrayList<String> productType = new ArrayList<>();
        productType.add("Homeowners");
        productType.add("Auto");


        for (int i=0; i<zipCode.size(); i++) {

            //navigate to mortgage calculator home page
            driver.navigate().to("https://www.statefarm.com");

            Thread.sleep(2500);

            //call my reusable method to compare title
            Reusable_Library.verifyTitle(driver, "Auto, Life Insurance");
            //call my reusable method to select product drop down
            Reusable_Library.dropdownByText(driver, "//*[@id='popDropdown']",productType.get(i), "Product Dropdown");
            //call my reusable method to enter a zipcode
            Reusable_Library.userKeys(driver, "//*[@id='quote-main-zip-code-input']",zipCode.get(i), "Zipcode");
            //call my reusable method to click on quote
            Reusable_Library.click(driver, "//*[text()='Start Quote')]", "Start Quote");

            //capture the result
            if(productType.get(i).equals("Homeowner")) {
                String textResult = Reusable_Library.captureText(driver, "//h1[conatins(text(),'Quote')]", "Quote");
                String[] testArray = textResult.split(" ");
                System.out.println("My captured Text is: " + testArray[0]);
            } else if (productType.get(i).equals("Auto")){
                String textResult = Reusable_Library.captureText(driver, "//*[@id='btnExisting']", "Car Auto Text");
            }
        }//end of for loop
    }//end of main



}//end of java class
