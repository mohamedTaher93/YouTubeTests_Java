package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VideoPage extends BasePage {

    public VideoPage(WebDriver driver)
    {
//        this.driver = driver;
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@title = 'Pause (k)']")
    WebElement pauseIcon;
    @FindBy(xpath = "//ytd-watch-metadata//ytd-channel-name[@id = 'channel-name']//a")
    WebElement videoChannelName;
    @FindBy(xpath = "//ytd-watch-metadata//button[@aria-label = 'Share']")
    WebElement shareVideoButton;
    @FindBy(xpath = "//ytd-watch-metadata//button[@aria-label = 'Download']")
    WebElement downloadButton;
    By downloadPopup = By.xpath("//ytd-download-quality-selector-renderer");
    By downloadUnavailableAlert = By.xpath("//yt-formatted-string[text() = 'Download unavailable']");
    By videoPlayer = By.id("player");
    By sharePopUp = By.xpath("//ytd-unified-share-panel-renderer");
    By pauseIconBy = By.xpath("//button[@title = 'Pause (k)']");

    public Boolean videoPageOpened()
    {
//        waitForElement(videoPlayer);
//        return elementDisplayed(videoPlayer);
        waitForElement(videoPlayer);
        return elementDisplayed(videoPlayer);
    }

    public Boolean videoStartedPlaying()
    {
//        return elementDisplayed(pauseIconBy);
        return elementDisplayed(pauseIconBy);
    }

    public void pauseVideo ()
    {
//        clickElement(pauseIcon);
        clickElement(pauseIcon);
    }

    public Boolean videoPaused()
    {
//        waitForInvisibilityOfElement(pauseIcon);
        waitForInvisibilityOfElement(pauseIcon);
        return true;
    }

    public Boolean channelNameDisplayed(String channelName)
    {
//        String actualChannelName = getText(videoChannelName);
        String actualChannelName = getText(videoChannelName);
        if(channelName.equalsIgnoreCase(actualChannelName))
        {
            return true;
        }
        return false;
    }
    public void clickShareVideo()
    {
//        clickElement(shareVideoButton);
        clickElement(shareVideoButton);
    }
    public Boolean shareVideoPopUpDisplayed()
    {
//        return elementDisplayed(sharePopUp);
        return elementDisplayed(sharePopUp);
    }
    public void clickDownloadVideo()
    {
//        clickElement(downloadButton);
        clickElement(downloadButton);
    }
    public Boolean downloadUnavailableAlertDisplayed()
    {
        System.out.println("Download Alert checker......");
//        return elementDisplayed(downloadUnavailableAlert);
        return elementDisplayed(downloadUnavailableAlert);
    }
    public Boolean downloadPopUpDisplayed()
    {
        System.out.println("Download popup checker.......");
//        return elementDisplayed(downloadPopup);
        return elementDisplayed(downloadPopup);
    }

}
