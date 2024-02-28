package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class BaseAction {

    private final AppiumDriver<?> driver;

    public BaseAction(AppiumDriver<?> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected AppiumDriver<?> getDriver() {
        return driver;
    }

    protected AndroidDriver<?> getAndroidDriver() {
        return (AndroidDriver<?>) driver;
    }

    private WebDriverWait driverWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(20)); // Native default to wait 20s
    }

    protected WebElement waitUntilClickable(WebElement element) {
        return driverWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUntilVisible(WebElement element) {
        driverWait().until(ExpectedConditions.visibilityOf(element));

    }
     boolean isElementDisplayedLazy(WebElement element) {

        try {
            waitUntilVisible(element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void hideApp() {
        ((AndroidDriver<?>)driver).runAppInBackground(Duration.ofSeconds(20));
    }

    @SneakyThrows
    public void lockUnlockDevice(String lockStatus) {
        if(lockStatus.equals("lock")) {
            ((AndroidDriver<?>) driver).lockDevice();
            Thread.sleep(10000);
        }
        else {
            ((AndroidDriver<?>) driver).unlockDevice();
            Thread.sleep(10000);
        }
    }

    public boolean lockStatus() {
        return ((AndroidDriver<?>) driver).isDeviceLocked();
    }

    public void rotateScreenLandscape() {
        ((AndroidDriver<?>) driver).rotate(ScreenOrientation.LANDSCAPE);
        }

    public void turnOffInternetConnection() {
        ((AndroidDriver<?>) driver).setConnection(new ConnectionStateBuilder().withWiFiDisabled().withDataDisabled().build());
    }

    public boolean isElementPresent(WebElement element) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        boolean flag = false;
        try {
            if (element.isDisplayed()) {
                flag = true;
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public void scrollAndClick(String visibleText) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollForward(3).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))")).click();
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollForward(3).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))")).click();
    }
}
