package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverInitialization;
import utils.Helpers;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.parseInt;

public class BasePage {
//    private WebDriver driver;
    WebDriverWait wait;
    public int defaultWaitSeconds= parseInt(Helpers.getConfigData().getProperty("defaultWait"));

    public BasePage(WebDriver driver)
    {
//        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWaitSeconds));
    }
    public static void launchApp(String appUrl)
    {
        DriverInitialization.getDriver().navigate().to(appUrl);
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
        List<WebElement> elements = DriverInitialization.getDriver().findElements(by);
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
    public void selectOptionFromDropdown(By dropDownBy, String option){
        Select dropdown = new Select(DriverInitialization.getDriver().findElement(dropDownBy));
        dropdown.selectByVisibleText(option);
    }
    public void draft(){
        WebDriver driver = DriverInitialization.getDriver();
        driver.switchTo().frame("x");
        driver.switchTo().alert().accept();
        String mainWindow = driver.getWindowHandle();
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        String x = windows.get(2);
        driver.switchTo().window(windows.get(2));
        driver.switchTo().window(mainWindow);

        driver.switchTo().window(windows.iterator().next());
        driver.manage().window().maximize();


    }
}