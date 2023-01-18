package test.Lesson16;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NarrowDownSearchingScope {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver;
        driver = DriverFactory.getDriver(Platforms.android);
        try {

            Dimension windowSize = driver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            int xStartpoint = (50 * screenWidth) / 100;
            int xEndpoint = (50 * screenWidth) / 100;

            int yStartpoint = (0 * screenHeight) / 100;
            int yEndpoint = (100 * screenHeight) / 100;

            PointOption startPoint = new PointOption().withCoordinates(xStartpoint, yStartpoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndpoint, yEndpoint);

            TouchAction ta = new TouchAction(driver);
            //Swipe down
            ta.press(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();

            int aStartpoint = (50 * screenWidth) / 100;
            int aEndpoint = (50 * screenWidth) / 100;

            int bStartpoint = (70 * screenHeight) / 100;
            int bEndpoint = (65 * screenHeight) / 100;

            PointOption sstartPoint = new PointOption().withCoordinates(aStartpoint, bStartpoint);
            PointOption eendPoint = new PointOption().withCoordinates(aEndpoint, bEndpoint);

            ta.longPress(sstartPoint)
                    .moveTo(eendPoint)
                    .release()
                    .perform();

            Map<String, String> notifications = new HashMap<String, String>();
            List<MobileElement> notificationElems = driver.findElements(MobileBy.id("android:id/notification_main_column"));
            for (MobileElement notificationElem : notificationElems) {
                String titleText = null;
                String contentText = null;
                List<MobileElement> titleElems = notificationElem.findElements(MobileBy.id("android:id/title"));
                if (!titleElems.isEmpty()) {
                    for (MobileElement titleElem : titleElems) {
                        titleText = titleElem.getText();
                    }
                }
                List<MobileElement> contentElems = notificationElem.findElements(MobileBy.id("android:id/text"));
                if (!contentElems.isEmpty()) {
                    for (MobileElement contentElem : contentElems) {
                        contentText = contentElem.getText();
                    }
                }
                if (titleText != null && contentText != null) {
                    notifications.put(titleText, contentText);
                }
            }

            if (notifications.keySet().isEmpty()) {
                throw new RuntimeException("there is no notification!");
            } else {
                for (String title : notifications.keySet()) {
                    System.out.println("Title: " + title);
                    System.out.println("Content: " + notifications.get(title));
                }
            }
            //Swipe up
            ta.longPress(endPoint)
                    .moveTo(startPoint)
                    .release()
                    .perform();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
