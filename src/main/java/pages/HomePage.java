package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    private String videoName;
    private WebElement video;
    public HomePage (WebDriver driver)

    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@id='search']")
    WebElement searchBox;

    @FindBy(id = "search-icon-legacy")
    WebElement searchIcon;

    @FindBy(xpath = "//a[@id='video-title']")
    List<WebElement> videosTitles;
    public void searchForVideo(String videoTitle)
    {
        videoName = videoTitle;
        enterText(searchBox, videoTitle);
        pressEnter(searchBox);
    }

    public Boolean videoDisplayed ()
    {
        String actualTitle;
        explicitWaitForAllElements(videosTitles);
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

    public WebElement openVideo()
    {
        clickElement(video);
        return video;
    }

}