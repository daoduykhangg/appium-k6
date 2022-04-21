package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapabilityTypeEx {
    public static AppiumDriver<MobileElement> getDriver(Platforms platform) {
        AppiumDriver<MobileElement> appiumDriver = null;
        Exception exception = null;

        if (platform == null) {
            throw new IllegalArgumentException("AppiumDriver can't be null, please provide one of these: " + Arrays.asList(Platforms.values()));
        }
        try {
//            Desired Capabilities
            DesiredCapabilities desiredCaps = new DesiredCapabilities();
            desiredCaps.setCapability(PLATFORM_NAME, "Android");
            desiredCaps.setCapability(AUTOMATION_NAME, "uiautomator2");
            desiredCaps.setCapability(UDID, "emulator-5554");
            desiredCaps.setCapability(APP_PACKAGE, "com.wdiodemoapp");
            desiredCaps.setCapability(APP_ACTIVITY, "com.wdiodemoapp.MainActivity");

            //Init appium session
            URL appiumServer = new URL("http://localhost:4723/wd/hub");
            switch (platform) {
                case android:
                    appiumDriver = new AndroidDriver<MobileElement>(appiumServer, desiredCaps);
                    break;
                case ios:
                    appiumDriver = new IOSDriver<MobileElement>(appiumServer, desiredCaps);
                    break;
            }
        } catch (Exception e) {
            exception = e;
        }

        if (appiumDriver == null) {
            throw new RuntimeException(exception.getMessage());
        }
        appiumDriver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        return appiumDriver;
    }
}
