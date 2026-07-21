package org.example.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.utils.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class hooks{

    DriverManager test;
    private SoftAssert softAssert;
    public hooks(DriverManager test) {
        this.test = test;
    }

    @Before
    public void setUp() throws Exception {
        softAssert = new SoftAssert();
        test.setupSoftAssert(softAssert);
    }

    @After
    public void tearDown(Scenario scenario) {
     WebDriver driver = test.driver; // Replace with your WebDriver instance
     if (scenario.isFailed()) {
         final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
     }
    }


}