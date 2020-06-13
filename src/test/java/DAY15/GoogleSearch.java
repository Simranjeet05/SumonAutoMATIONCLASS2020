package DAY15;

import ReusableLib.Abstract_class;
import ReusableLib.Abstract_class_Parameter;
import ReusableLib.ReusableLibMain;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class GoogleSearch extends Abstract_class_Parameter {
    @Test
    public void google() throws InterruptedException {
        //Arraylist
        ArrayList<String> city = new ArrayList<>();
        city.add("Queens");
        city.add("Bronx");


        // this is where you will start the loop from navigate up untill before quit
        for (int i = 0; i < city.size(); i++) {

            //opening the browser automatically to go yo google home page
            driver.navigate().to("https://www.google.com");
            //wait  few seconds after navigatingto a apage so browser can load property
            Thread.sleep(2000);

            //locate the search field by inspecting it frst and then end a keyword let say cars
            ReusableLibMain.click(driver,"//*[@name='q']","Click on the search element", logger);
            //enter the details
            ReusableLibMain.userKeys(driver,"//*[@name='q']",city.get(i),"enter the city name",logger);
            //click on google search
            ReusableLibMain.submit(driver,"//*[@name='btnK']","Click on google search", logger);

            Thread.sleep(2000);
            //to capture a text from the website you need to
            ReusableLibMain.captureText(driver,"//*[@id='result-stats']","Capture result",logger);

        }//for loop end

    }// main end
}

