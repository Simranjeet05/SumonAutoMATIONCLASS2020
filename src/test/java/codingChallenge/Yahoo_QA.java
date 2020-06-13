package codingChallenge;

import ReusableLib.Abstract_class;
import ReusableLib.ReusableLibMain;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class Yahoo_QA extends Abstract_class {

    @Test
    public void Yahoo() throws InterruptedException {
        logger.log(LogStatus.INFO,"navigating to yahoo.com");
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com/");
        //click on search entry field
        ReusableLibMain.click(driver,"//*[@name='p']"," Search Entry Field",logger);
        //enter QA in search bar
        ReusableLibMain.userKeys(driver,"//*[@name='p']","QA","enter the requirement",logger);
        //click on search bar
        ReusableLibMain.click(driver,"//*[@id='header-desktop-search-button']","click search",logger);
        Thread.sleep(4000);
        //click on the wikipedia link
        ReusableLibMain.click(driver,"//*[contains(text(),'assurance - Wikipedia')]","Click on wiki link",logger);
        Thread.sleep(6000);

        //Switch to the new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //Display result
        boolean textDisplayed= driver.findElement(By.xpath("//*[contains(text(),'Middle Ages']")).isDisplayed();
        if(textDisplayed== true)
        {
            System.out.println("Pass");
            logger.log(LogStatus.PASS,"Found and it pass");

        } else
        {
            System.out.println("Fail");
            logger.log(LogStatus.FAIL,"Not found, Failed");
        }
        driver.switchTo().window(tabs.get(0));//switch back

    }//method end
}//public class end
