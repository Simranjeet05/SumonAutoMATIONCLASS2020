package DAY8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DAY8_topic2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/kalra/Desktop/SIMRANJEET QA/src/SumonQA/resource/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.usps.com");
        Thread.sleep(2000);

        //declare and defineActions
        Actions mouse = new Actions(driver);

        //hover to Mail & Ship tab
        try {
            WebElement mailAndShip = driver.findElement(By.xpath("//*[text()='Mail & Ship']"));
            // call your actions command to move the elemet
            mouse.moveToElement(mailAndShip).perform();

        } catch (Exception e) {
            System.out.println("Unable to locate mail and ship" + e);
        }//end of mail and ship exception
        Thread.sleep(2000);
        //click on click and ship using actions
        try {
            WebElement clickAndShip = driver.findElement(By.xpath("//*[@class='tool-cns']/following::a[text()='Click-N-Ship']"));
            // WebElement clickAndShip = driver.findElement(By.xpath("//*[@class='tool-cns']/a[text()='Click-N-Ship']"));
            // call your actions command to move the elemet and then click
            mouse.moveToElement(clickAndShip).click().perform();
            //clickAndShip.submit();
            //this is to submit using mouse actions
            //mouse.moveToElement(clickAndShip).sendKeys(Keys.ENTER).perform();


        } catch (Exception e) {
            System.out.println("Unable to locate click-n-ship" + e);
        }//end of Click-n-ship exception
    }
}
