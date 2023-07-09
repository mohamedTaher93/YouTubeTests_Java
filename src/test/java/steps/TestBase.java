package steps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class TestBase {

    private static WebDriver driver;

    public void setDriver(String browser) {

        if(browser.equalsIgnoreCase("chrome"))
        {
            System.out.println("Setup driver....");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions());
            driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        }
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public static ChromeOptions chromeOptions()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("no-sandbox");
        options.addArguments("--start-maximized");
        return options;
    }
}
