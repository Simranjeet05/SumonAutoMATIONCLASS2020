package DAY8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class ActionWorkaetna {
    public static void main(String[] args) throws InterruptedException {

        //set the path
        System.setProperty("webdriver.chrome.driver","/Users/kalra/Desktop/SIMRANJEET QA/src/SumonQA/resource/chromedriver");

        //set pre-property to incognito
        ChromeOptions options= new ChromeOptions();
        options.addArguments("incognito");

        //declare driver and define options
        WebDriver driver= new ChromeDriver(options);
        driver.manage().window().maximize();//maximize screen

        //Set string array list for zipCode
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("10007");
        zipCode.add("10016");
        zipCode.add("10025");

        //Set Integer array list for MileRange
        ArrayList<Integer> milesRange = new ArrayList<>();
        milesRange.add(20);
        milesRange.add(30);
        milesRange.add(40);


        //navigate to the website and wait 2 sec
        driver.navigate().to("https://www.aetna.com/");
        Thread.sleep(3000);


        //Verify the Title of the page
        //if the title matches Print it matches with Title
        //if does not match then print it does not match with the correct title
        String Title = driver.getTitle();
        if(Title.equals("Health Insurance Plans | Aetna")){
            System.out.println("Title Matches- " +Title);
        } else{
            System.out.println("Title does not match and correct title is: "+Title);
        }//end of if else condition

//declare and defineActions
        Actions mouse = new Actions(driver);
       for (int i = 0; i < zipCode.size() ; i++) {


            //locate and click on shop for a plan
            try {
                driver.findElement(By.xpath("//*[@class='megamenu__primary--item--btn']")).click();
            } catch (Exception e) {
                System.out.println("Unable to locate on shop for a plan " + e);
            }//end of the catch statement-shop for a plan

            Thread.sleep(1000);//wait 1 sec

            //locate medicare and click on it
            try {
                driver.findElement(By.xpath("//*[text()='Medicare']")).click();
            } catch (Exception e) {
                System.out.println("Unable to locate medicare and click on it " + e);
            }//end of catch-locate and click medicare

            Thread.sleep(1000); // wait 1 sec


            //locate and click on find a doctor
            try {
            driver.findElement(By.xpath("//*[contains(text(),'Find a doctor ')]")).click();
            } catch (Exception e) {
                System.out.println("Unable to locate -Find a doctor " + e);
            }//end of catch- find a doctor

            Thread.sleep(2000);//wait 2 sec

            //locate and click 2020 Medicare plans you purchase yourself
            try {
                driver.findElement(By.xpath("//*[@class='primaryPurple BtnWidth mgbutton w400']")).click();
            } catch (Exception e) {
                System.out.println("Unable to locate and click on 2020 Medicare plans you purchase yourself " + e);
            }//end of catch 2020 Medicare plans you purchase yourself

        Thread.sleep(2000); //wait 2 sec

            //locate zipcode entry bar + clear it and then send zipcode array list
            try{
                WebElement zipcode=driver.findElement(By.xpath("//*[@id='medZip']"));
                zipcode.clear();
                zipcode.sendKeys(zipCode.get(i));

            }catch(Exception e){
                System.out.println("Unable to find and send zipCode array list " + e);
            } //end of catch for zipcode entry

           //captur the text from scroll down

        }//for loop end
    }//main end
}//class end
