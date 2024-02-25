package steps;

import io.cucumber.java.en.And;
import pages.BankScreen;
import utils.DeviceCapabilities;

public class BankSteps extends DeviceCapabilities {

    BankScreen bankScreen = new BankScreen();

    @And("I tap back button")
    public void iTapOnBank(){
        bankScreen.tapBackButton();
    }
}
