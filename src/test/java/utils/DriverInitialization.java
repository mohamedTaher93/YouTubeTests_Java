package utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class DriverInitialization {

    private static WebDriver driver;
    private static final int defaultWaitTime = Integer.parseInt(Helpers.getConfigData().getProperty("defaultWait"));

    public static void setDriver(String browser) {

        if(browser.equalsIgnoreCase("chrome"))
        {
            System.out.println("Setup driver....");
            String currentChromeVersion = WebDriverManager.chromedriver().getDriverVersions().get(0);
            WebDriverManager.chromedriver().driverVersion(currentChromeVersion).setup();
//            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions());
        }
        driver.manage().timeouts().implicitlyWait(defaultWaitTime, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver()
    {
        return driver;
    }

    private static ChromeOptions chromeOptions()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("no-sandbox");
        options.addArguments("--start-maximized");
        return options;
    }
}


