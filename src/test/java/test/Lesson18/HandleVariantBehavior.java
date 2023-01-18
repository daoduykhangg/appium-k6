package test.Lesson18;

import driver.DriverFactory;
import driver.MobileCapabilityTypeEx;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.internal.CapabilityHelpers;
import org.openqa.selenium.Capabilities;

public class HandleVariantBehavior {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver;
        appiumDriver = DriverFactory.getDriver(Platforms.android);
        try {
            Capabilities caps = appiumDriver.getCapabilities();
            String platformName = CapabilityHelpers.getCapability(caps, MobileCapabilityTypeEx.PLATFORM_NAME, String.class);
            System.out.println(platformName);
            String appPackage = CapabilityHelpers.getCapability(caps, MobileCapabilityTypeEx.APP_PACKAGE, String.class);
            System.out.println(appPackage);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
