package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
//import org.testng.Assert;
import pages.BasePage;
import pages.HomePage;
import pages.VideoPage;
import utils.Helpers;

public class OpenVideo extends TestBase {

    BasePage basePage = new BasePage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    VideoPage videoPage = new VideoPage(getDriver());
    WebElement video;
    @Given("I navigate to youtube")
    public void navigateToYoutube(){
        basePage.launchApp(Helpers.properties.getProperty("appUrl"));
    }

    @When("I search for {string} video")
    public void searchForVideo(String videoTitle)
    {
        homePage.searchForVideo(videoTitle);
    }

    @When("I press on the video")
    public void pressOnVideo()
    {
        video = homePage.openVideo();
    }

    @When("I pause the video")
    public void pauseVideo ()
    {
        videoPage.pauseVideo();
    }

    @Then("Verify the video displayed in the search page")
    public void verifyVideoDisplayed()
    {
        Assert.assertTrue("video is not displayed", homePage.videoDisplayed());
    }

    @Then("Verify the video page opened")
    public void verifyVideoPageOpened()
    {
        Assert.assertTrue("video page not opened", videoPage.videoPageOpened());
    }

    @Then("Verify the video has started playing")
    public void verifyVideoStartedPlaying()
    {
        Assert.assertTrue("video didn't started", videoPage.videoStartedPlaying());
    }

    @Then("Verify the video paused successfully")
    public void verifyVideoPaused()
    {
        Assert.assertTrue("Pause video not working", videoPage.videoPaused());
    }

    @Then("Verify {string} displayed")
    public void verifyChannelNameDisplayed(String channelName)
    {
        Assert.assertTrue("Channel name is incorrect", videoPage.channelNameDisplayed(channelName));
    }
}
