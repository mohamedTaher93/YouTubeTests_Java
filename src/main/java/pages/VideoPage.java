package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VideoPage extends BasePage {

    public VideoPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ytd-video-owner-renderer//ytd-channel-name[@id = \'channel-name\']//yt-formatted-string")
    WebElement videoOwner;

    @FindBy(id = "player")
    WebElement videoPlayer;

    @FindBy(xpath = "//button[@title = 'Pause (k)']")
    WebElement pauseIcon;

    @FindBy(xpath = "//button[@title = 'Play (k)']")
    WebElement playIcon;
    @FindBy(xpath = "//ytd-video-owner-renderer//ytd-channel-name[@id = 'channel-name']//a")
    WebElement videoChannelName;

    public Boolean videoPageOpened()
    {
        return elementDisplayed(videoPlayer);
    }

    public Boolean videoStartedPlaying()
    {
        return elementDisplayed(pauseIcon);
    }

    public void pauseVideo ()
    {
        clickElement(pauseIcon);
    }

    public Boolean videoPaused()
    {
        return elementDisplayed(playIcon);
    }

    public Boolean channelNameDisplayed(String channelName)
    {
        String actualChannelName = videoChannelName.getText();
        if(channelName.equalsIgnoreCase(actualChannelName))
        {
            return true;
        }
        return false;
    }

}
