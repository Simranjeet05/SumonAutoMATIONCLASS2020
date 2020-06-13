package DAY8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DAY8_TOPIC1_JSE_SCROLLING {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/kalra/Desktop/SIMRANJEET QA/src/SumonQA/resource/chromedriver");
        ChromeOptions options= new ChromeOptions();
        options.addArguments("incognito");
        WebDriver driver=new ChromeDriver(options);

        //navigate to website
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(2000);

       //declare and define the java script
        JavascriptExecutor jse=(JavascriptExecutor)driver;

/*     XXXXX Example for JSE

        //scrolling all the way down to the bottom of the screen
        jse.executeScript("scroll(0,5000)");
        Thread.sleep(1000);
        //scrolling up to top of the same page again
        jse.executeScript("scroll(0,-5000)");
*/
        //scrolling to an element view for home value
        try{
            WebElement homeValue =driver.findElement(By.xpath("//*[@id='homeval']"));
            jse.executeScript("arguments[0].scrollIntoView(true);",homeValue);
        }catch(Exception e){
            System.out.println("unable to locate the term"+e);
        }
    }
}
