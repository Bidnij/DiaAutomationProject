package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import lombok.Getter;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalTime;
import java.util.Properties;

@Getter
public class DeviceCapabilities {

    public static AppiumDriver driver;
    public static Properties prop;
    public static DesiredCapabilities capabilities;
    public static AppiumDriverLocalService service;

    /**
     * Method to identify the platform
     *
     * @throws Exception
     */
    public void SetCapabilities() throws Exception {
        SetProperty();
        try {
            if (prop.getProperty("PlatformName").equalsIgnoreCase("Android")) {
                driver = initAndroid();
            } else if (prop.getProperty("PlatformName").equalsIgnoreCase("ios")) {
                driver = initIOS();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method is used to set property
     *
     * @throws IOException
     */
    public void SetProperty() throws IOException {
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
    public AppiumDriver initAndroid() throws Exception {
        capabilities = new DesiredCapabilities();
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
            return driver = new AndroidDriver(new URL(prop.getProperty("AppiumUrl")), capabilities);
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
    public IOSDriver initIOS() throws Exception {
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
            return new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } else {
            return null;
        }
    }

}
