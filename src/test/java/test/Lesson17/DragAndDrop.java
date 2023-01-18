package test.Lesson17;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class DragAndDrop {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver;
        appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            MobileElement navDragBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Drag"));
            navDragBtnElem.click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
