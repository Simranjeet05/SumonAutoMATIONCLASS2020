package DAY5; //25April

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DAY5_Topic1_Xpath_withAmazon {
    public static void main(String[] args) throws InterruptedException {

        //line below store your search field xpath as a string variable
        String searchPath = "//*[@name='field-keywords']";
        //line below store your search icon xpath as a string variable
        String searchIconPath = "//*[@value='Go']";
        //line below store your Image Icon xpath as a string variable
        String searchImgPath = "//img[contains(@class,'s-image')]";


        //define the property
        System.setProperty("webdriver.chrome.driver", "/Users/kalra/Desktop/SIMRANJEET QA/src/SumonQA/resource/chromedriver");
        //define the driver
        WebDriver driver = new ChromeDriver();

        //navigate to website
        driver.navigate().to("https://www.amazon.com");

        //maximize your window
        driver.manage().window().maximize();

        //wait few seconds
        Thread.sleep(2000);

        //enter a keyword on amazon search using X path with operator
        driver.findElement(By.xpath(searchPath)).sendKeys("Televisions");
/*
        if you are not sure about unique property then use operators and/or
        When use and or operator--2unique properties and you not 100% sure
         we cannot use|| / && because these are for conditions statements
         (*) ignoring the fact and it just focus on the requirement
        @ is to assign and do not leave space after this as it will not work

        //driver.findElement(By.xpath("//*[@ value name='field-keywords' or id ='twotabsearchtextbox']")).sendKeys("Laptops");
  */
        //search using same element
        //driver.findElement(By.xpath("//*[@name='field-keywords']")).submit();
        //search using unique property

        Thread.sleep(2000);
        driver.findElement(By.xpath(searchIconPath)).click();

        Thread.sleep(3000);
        //finding by Elements ("//*[@class='s-image']") if not defined in string
        //driver.findElements(By.xpath("//img[contains(@class,'s-image')]")).get(4).click(); //incase they have diff class name
        driver.findElements(By.xpath(searchImgPath)).get(7).click();
        //driver.findElements(By.xpath("//*[@class='s-image']")).get(4).click();

        //wait time
        Thread.sleep(3000);
        //quit the browser
        // driver.quit();
    }//main end
}//class end
