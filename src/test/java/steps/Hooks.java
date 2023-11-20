package steps;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.Helpers;
import utils.DriverInitialization;

import java.io.IOException;
import java.util.Properties;

public class Hooks extends DriverInitialization {
    private WebDriver driver;
    private Properties properties;
    Helpers helpers = new Helpers();

    @Before
    public void setupDriver() throws IOException {
        System.out.println("Before .......");
        properties = helpers.getConfigData();
        driver = getDriver();
        if (driver == null || driver.toString().contains("(null)")) {
            setDriver(properties.getProperty("browser"));
            driver = getDriver();
        }
    }
    @AfterStep
    public void takeScreenShot(Scenario scenario)
    {
        if ((scenario.isFailed())) {
            System.out.println("Take screenshot.....");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}