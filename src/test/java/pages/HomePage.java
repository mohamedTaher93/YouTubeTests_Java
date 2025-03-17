package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    private String videoName;
    private WebElement video;
    public HomePage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//input[@id='search']")
    WebElement searchBox;
    @FindBy(xpath = "//a[@id='video-title']")
    List<WebElement> videosTitles;
    By youtubeLogo = By.xpath("//yt-formatted-string[text() = 'Home']");

    public Boolean homePageLoaded()
    {
        return elementDisplayed(youtubeLogo);
    }

    public void searchForVideo(String videoTitle)
    {
        videoName = videoTitle;
        enterText(searchBox, videoTitle);
        pressEnter(searchBox);
    }
    public Boolean videoDisplayed ()
    {
        String actualTitle;
//        explicitWaitForAllElements(videosTitles);

        for(int i = 0; i < videosTitles.size(); i++)
        {
            video = videosTitles.get(i);
            actualTitle = videosTitles.get(i).getAttribute("title");
            if(videoName.equalsIgnoreCase(actualTitle))
            {
                return true;
            }
        }
        return false;
    }
    public void openVideo()
    {
        clickElement(video);
//        return video;
    }
}