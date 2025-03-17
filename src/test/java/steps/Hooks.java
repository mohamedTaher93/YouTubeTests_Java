package steps;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Helpers;
import utils.DriverInitialization;

import java.io.IOException;
import java.util.Properties;

public class Hooks {
//    private WebDriver driver;

    @Before
    public void setupDriver() throws IOException {
        System.out.println("Before .......");
        Properties properties = Helpers.getConfigData();
        if (DriverInitialization.getDriver() == null || DriverInitialization.getDriver().toString().contains("null")) {
            DriverInitialization.setDriver(properties.getProperty("browser"));
        }
    }
    @AfterStep
    public void takeScreenShot(Scenario scenario)
    {
        if ((scenario.isFailed())) {
            System.out.println("Take screenshot.....");
            final byte[] screenshot = ((TakesScreenshot) DriverInitialization.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        final byte[] screenshot = ((TakesScreenshot) DriverInitialization.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }
    @After
    public void tearDown() {
        DriverInitialization.getDriver().quit();
    }
}