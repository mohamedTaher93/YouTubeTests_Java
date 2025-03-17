package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.HomePage;
import pages.VideoPage;
import utils.Helpers;
import utils.DriverInitialization;

public class OpenVideo {
//    BasePage basePage = new BasePage(getDriver());
    HomePage homePage = new HomePage(DriverInitialization.getDriver());
    VideoPage videoPage = new VideoPage(DriverInitialization.getDriver());
//    WebElement video;

    @Given("I navigate to youtube")
    public void navigateToYoutube(){
        BasePage.launchApp(Helpers.properties.getProperty("appUrl"));
    }

    @When("I search for {string} video")
    public void searchForVideo(String videoTitle)
    {
        homePage.searchForVideo(videoTitle);
    }

    @When("I press on the video")
    public void pressOnVideo()
    {
        homePage.openVideo();
    }

    @When("I pause the video")
    public void pauseVideo ()
    {
        videoPage.pauseVideo();
    }

    @When("I select share option")
    public void selectShareOption()
    {
        videoPage.clickShareVideo();
    }
    @When("I select download option")
    public void selectDownloadOption()
    {
        videoPage.clickDownloadVideo();
    }

    @Then("Verify home page loaded")
    public void verifyHomePageLoaded()
    {
        Assert.assertTrue("Home page not loaded", homePage.homePageLoaded());
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
    @Then("Verify share popup displayed")
    public void verifySharePopupDisplayed()
    {
        Assert.assertTrue("Share video doesn't work correctly", videoPage.shareVideoPopUpDisplayed());
    }
    @Then("Verify download disabled")
    public void verifyDownloadDisabled()
    {
        Assert.assertTrue("Download unavailable alert not displayed", videoPage.downloadUnavailableAlertDisplayed());
        Assert.assertFalse("Download video doesn't work correctly", videoPage.downloadPopUpDisplayed());
    }
}
