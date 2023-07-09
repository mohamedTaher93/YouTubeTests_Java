package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BasePage {
    private WebDriverWait wait ;
    private WebDriver driver;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void launchApp(String appUrl)
    {
        driver.navigate().to(appUrl);

    }

    public void explicitWaitForAllElements(List<WebElement> elements)
    {
       wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void clickElement (WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void clearBox (WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
    }

    public void enterText (WebElement element, String text)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(text);
    }

    public void pressEnter (WebElement element)
    {
        element.sendKeys(Keys.ENTER);
    }

    public String getText(WebElement element)
    {
        String elementText;
        wait.until(ExpectedConditions.visibilityOf(element));
        elementText = element.getText();
        return elementText;
    }

    public Boolean elementDisplayed (WebElement element)
    {

        try
        {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch (Error e)
        {
            System.out.println("element not displayed");

        }
        return false;
    }
}