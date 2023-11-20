package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Helpers;
import java.time.Duration;
import java.util.List;
import static java.lang.Integer.parseInt;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Helpers helpers = new Helpers();
    public int defaultWaitSeconds= parseInt(helpers.getConfigData().getProperty("defaultWait"));

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWaitSeconds));
        PageFactory.initElements(driver, this);
    }
    public void launchApp(String appUrl)
    {
        driver.navigate().to(appUrl);
    }

    //    public static void explicitWaitForAllElements(WebDriver driver, List<WebElement> elements)
//    {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWaitSeconds));
//        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
//    }
    public void clickElement (WebElement element)
    {
//        setWait(driver);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWaitSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public void enterText (WebElement element, String text)
    {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWaitSeconds));
//        setWait(driver);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    public void pressEnter (WebElement element)
    {
        element.sendKeys(Keys.ENTER);
    }
    public String getText(WebElement element)
    {
        String elementText;
//        wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWaitSeconds));
//        setWait(driver);
        wait.until(ExpectedConditions.visibilityOf(element));
        elementText = element.getText();
        return elementText;
    }
    public void waitForInvisibilityOfElement (WebElement element)
    {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWaitSeconds));
//        setWait(driver);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public Boolean elementDisplayed (By by)
    {
        List<WebElement> elements = driver.findElements(by);
        if(elements.isEmpty())
        {
            return false;
        }
        return true;
    }
    public void waitForElement (By by)
    {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWaitSeconds));
//        setWait(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}