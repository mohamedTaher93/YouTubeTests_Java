package utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class DriverInitialization extends Helpers {

    private static WebDriver driver;
    private int defaultWaitTime = Integer.parseInt(getConfigData().getProperty("defaultWait"));

    public void setDriver(String browser) {

        if(browser.equalsIgnoreCase("chrome"))
        {
            System.out.println("Setup driver....");
//            WebDriverManager.chromedriver().driverVersion("108").setup();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions());
        }
        driver.manage().timeouts().implicitlyWait(defaultWaitTime, TimeUnit.SECONDS);
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    private ChromeOptions chromeOptions()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("no-sandbox");
        options.addArguments("--start-maximized");
        return options;
    }
}
