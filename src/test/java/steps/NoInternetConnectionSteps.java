package steps;

import io.cucumber.java.en.Then;
import pages.NoInternetConnectionPopup;
import utils.DeviceCapabilities;

import static org.testng.Assert.assertTrue;

public class NoInternetConnectionSteps extends DeviceCapabilities {

    NoInternetConnectionPopup noInternetConnectionPopup = new NoInternetConnectionPopup();

    @Then("I see no internet connection popup")
    public void iSeeNoInternetConnectionPopup(){
        assertTrue(noInternetConnectionPopup.isNoInternetTitleDisplayed(), "No internet title isn't displayed");
        assertTrue(noInternetConnectionPopup.isNoInternetBodyTextDisplayed(), "No internet body text isn't displayed");
        assertTrue(noInternetConnectionPopup.isTryAgainButtonDisplayed(), "Try again button isn't displayed");
    }
}
