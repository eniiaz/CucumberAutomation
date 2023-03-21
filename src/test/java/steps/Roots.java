package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Roots {

    //@Before
    public void start(){
        System.out.println("starting the scenario");
    }

    //@After
    public void cleanUp(Scenario scenario){
        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.quitBrowser();
    }
}
