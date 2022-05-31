package com.SDET_Review.StepDefs;

import com.SDET_Review.utilities.Browser_Utils;
import com.SDET_Review.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @Before
    public void setUpScenario(){
        System.out.println("------Setting up browser with further details...");
    }


    @After
    public void tearDownScenario(Scenario scenario){
        //if my scenario failed
        // go and take screen shot
        if (scenario.isFailed()) {
            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", scenario.getName());
        }
        Browser_Utils.wait(1);
      //  Driver.closeDriver();
    }
}
