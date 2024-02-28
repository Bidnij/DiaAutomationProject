package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Getter
public class DeviceCapabilities {

    private static final ThreadLocal <AppiumDriver<?>> appiumDriver = new ThreadLocal<>();
    private static final ThreadLocal <AndroidDriver<?>> androidDriver = new ThreadLocal<>();
    private static final ThreadLocal <IOSDriver<?>> iOSDriver = new ThreadLocal<>();
    public static Properties prop;
    public static DesiredCapabilities capabilities;
    public static AppiumDriverLocalService service;

    public static AppiumDriver<?> getAppiumDriver() {
        return appiumDriver.get();
    }

    public static void setAppiumDriver(AppiumDriver<?> driver) {
        appiumDriver.set(driver);
    }
    /**
     * Method to identify the platform
     *
     * @throws Exception
     */
    @SneakyThrows
    public static AppiumDriver<?> getAppSession() {
        SetProperty();
        AppiumDriver<?> appiumMobileDriver;
        AppiumDriver<?> appiumDriver;
            if (prop.getProperty("PlatformName").equalsIgnoreCase("Android")) {
                appiumMobileDriver = new AndroidDriver<AndroidElement>(new URL(prop.getProperty("AppiumUrl")), setAndroidCap());
                setAppiumDriver(appiumMobileDriver);
            } else if (prop.getProperty("PlatformName").equalsIgnoreCase("ios")) {
                appiumMobileDriver = new IOSDriver<IOSElement>(new URL(prop.getProperty("AppiumUrl")), setIOSCap());
                setAppiumDriver(appiumMobileDriver);
            }
            else appiumMobileDriver = null;
        return appiumMobileDriver;
    }

    public void runTestWithConfig() {
        getAppSession();
        getAppiumDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        ((AndroidDriver<?>) getAppiumDriver()).setConnection(new ConnectionStateBuilder().withWiFiEnabled().withDataEnabled().build());
        getAppiumDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    /**
     * Method is used to set property
     *
     * @throws IOException
     */
    public static void SetProperty() throws IOException {
        FileInputStream fis =
                new FileInputStream(
                        System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
        prop = new Properties();
        prop.load(fis);
    }


    /**
     * Capabilities for android device
     *
     * @return
     * @throws Exception
     */
    private static DesiredCapabilities setAndroidCap() throws Exception {
            DesiredCapabilities capabilities = new DesiredCapabilities();
         if (prop.getProperty("Platform").equalsIgnoreCase("local")) {
            System.out.println("Opening App");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("PlatformVersion"));
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("PlatformName"));
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("RealDeviceName"));
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability("adbExecTimeout", 20000);
            capabilities.setCapability(AndroidMobileCapabilityType.AVD, prop.getProperty("AVD"));
            capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + prop.getProperty("App"));
//            capabilities.setCapability(AndroidMobileCapabilityType.ANDROID_NATURAL_ORIENTATION, "LANDSCAPE");
            capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
            capabilities.setCapability("noReset", "false");
            capabilities.setCapability("autoGrantPermissions", true);
            capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, false);
            capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, false);
            return capabilities;
        } else {
            return null;
        }
    }

    /**
     * Capabilities for IOS device
     *
     * @return
     * @throws Exception
     */
     private static DesiredCapabilities setIOSCap() throws Exception {
        capabilities = new DesiredCapabilities();
        if (prop.getProperty("Platform").equalsIgnoreCase("local")) {
            capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("IosRealDevicePlatformVersion"));
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("IosRealDeviceName"));
            capabilities.setCapability("udid", prop.getProperty("IosRealDeviceUdid"));
            capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + prop.getProperty("IosApp"));
            capabilities.setCapability("appPackage", prop.getProperty("AppPackage"));
            capabilities.setCapability("appActivity", prop.getProperty("AppActivity"));
            capabilities.setCapability("noReset", "false");
            capabilities.setCapability("autoGrantPermissions", true);
            return capabilities;
        } else {
            return null;
        }
    }

    public static void destroyDriver() {
        System.out.println("Quiting Driver");
        appiumDriver.get().quit();
        appiumDriver.remove();
    }
}
