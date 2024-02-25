package steps;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LandingScreen;
import utils.DeviceCapabilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks extends DeviceCapabilities {

    @Before
    public void setUp() throws Exception {
        SetCapabilities();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        ((AndroidDriver) driver).setConnection(new ConnectionStateBuilder().withWiFiEnabled().withDataEnabled().build());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
        System.out.println("Run ended");
    }
}
