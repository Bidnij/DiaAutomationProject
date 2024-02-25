package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LandingScreen;
import utils.DeviceCapabilities;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LandingSteps extends DeviceCapabilities {

    LandingScreen landingScreen = new LandingScreen();

    @Given("I see landing screen")
    public void iSeeLandingScreen(){
        assertTrue(landingScreen.isLanderTitleDisplayed(), "Landing title isn't displayed");
    }

    @When("I tap bankId button")
    public void iTapBankID(){
        landingScreen.tapBankIdButton();
    }

    @And("I turnOff Network connection")
    public void iTurnOffNetwork(){
        landingScreen.turnOffInternetConnection();
    }
    @And("I hide application to background and back")
    public void iHideApp(){
        landingScreen.hideApp();
    }

    @And("^I (.*) device screen")
    public void iLockDeice(String lockStatus){
        landingScreen.lockUnlockDevice(lockStatus);
    }

    @And("^I see device lock status is (.*)")
    public void iSeeDeviceLocked(String lockStatus) {
        if (lockStatus.equals("on")) {
            assertTrue(landingScreen.lockStatus(), "Device isn't lock");
        }
        else {
            assertFalse(landingScreen.lockStatus(), "Device is lock");
        }
    }

    @And("^I rotate screen to landscape")
    public void iRotateScreen() {
        landingScreen.rotateScreenLandscape();
    }
}
