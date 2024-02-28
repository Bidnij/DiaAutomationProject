package steps;

import io.cucumber.java.en.And;
import pages.BankScreen;
import pages.BankSelectScreen;
import utils.DeviceCapabilities;

public class BankSteps extends DeviceCapabilities {

    private final BankScreen bankScreen;

    public BankSteps() {
        bankScreen = new BankScreen(getAppiumDriver());
    }

    @And("I tap back button")
    public void iTapOnBank(){
        bankScreen.tapBackButton();
    }
}
