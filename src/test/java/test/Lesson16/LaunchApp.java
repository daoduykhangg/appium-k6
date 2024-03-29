package test.Lesson16;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class LaunchApp {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = null;
        Exception exception = null;
        try {
            DesiredCapabilities desiredCaps = new DesiredCapabilities();
            desiredCaps.setCapability("platformName", "Android");
            desiredCaps.setCapability("automationName", "uiautomator2");
            desiredCaps.setCapability("udid", "emulator-5554");
            desiredCaps.setCapability("appPackage", "com.wdiodemoapp");
            desiredCaps.setCapability("appActivity", ".MainActivity t13");

            URL appiumServer = new URL("http://localhost:4723/wd/hub");

            appiumDriver = new AndroidDriver<MobileElement>(appiumServer, desiredCaps);

            Thread.sleep(3000);
        } catch (Exception e) {
            exception = e;
        }
        if (appiumDriver == null) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}

