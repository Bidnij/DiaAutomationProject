package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BankSelectScreen;
import utils.DeviceCapabilities;

import static org.testng.Assert.assertTrue;

public class BankSelectSteps extends DeviceCapabilities {

    private final BankSelectScreen bankSelectScreen;

    public BankSelectSteps() {
        bankSelectScreen = new BankSelectScreen(getAppiumDriver());
    }

    @Then("I see bank select screen")
    public void iSeeLandingScreen(){
        assertTrue(bankSelectScreen.isSelectBankScreen(), "Bank select title isn't displayed");
    }

    @And("^I tap on bank with name (.*)")
    public void iTapOnBank(String bankName){
        bankSelectScreen.tapOnBankName(bankName);
    }

}
