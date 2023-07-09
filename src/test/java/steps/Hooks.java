package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import steps.TestBase;
import utils.Helpers;

import java.io.IOException;
import java.util.Properties;

public class Hooks extends TestBase {

    private WebDriver driver;
    private Properties properties;
    Helpers helpers = new Helpers();

    @Before
    public void setupDriver() throws IOException {
        System.out.println("Before .......");
        properties = helpers.getConfigData();
        driver = getDriver();
        if(driver == null || driver. toString(). contains("(null)"))
        {
            setDriver(properties.getProperty("browser"));
            driver = getDriver();
        }
    }
    @After
    public void tearDown(Scenario scenario)
    {
        System.out.println("Take screenshot.....");
//        if ((scenario.isFailed())) {
//            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", scenario.getName());
//        }
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());

        driver.quit();

    }
}
