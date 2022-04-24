package test.lab_16;

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

public class NarrowDownSearchScope {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);
        try {
            Dimension windowsize = driver.manage().window().getSize();
            int screenHeight = windowsize.getHeight();
            int screenWidth = windowsize.getWidth();

            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;

            int yStartPoint = 0 * screenHeight / 100;
            int yEndPoint = 50 * screenHeight / 100;

            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            TouchAction touchAction = new TouchAction(driver);
            //Swipe down
            touchAction
                    .longPress(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();

            Map<String, String> notifications = new HashMap<String, String>();

            List<MobileElement> notificationsElems = driver.findElements(MobileBy.id("android:id/notification_headerless_view_column"));
            for (MobileElement notificationsElem : notificationsElems) {
                MobileElement titleElem = notificationsElem.findElement(MobileBy.id("android:id/title"));
                String title = titleElem.getText();

                MobileElement contextElem = notificationsElem.findElement(MobileBy.id("android:id/text"));
                String context = contextElem.getText();
                notifications.put(title, context);
            }
            if (notifications.keySet().isEmpty()) {
                throw new RuntimeException("[ERR] There is no notification to test");
            } else {
                for (String title : notifications.keySet()) {
                    System.out.println("Title = " + title);
                    System.out.println("Context = " + notifications.get(title));
                }
            }

            //Swipe up
            touchAction
                    .longPress(endPoint)
                    .moveTo(startPoint)
                    .release()
                    .perform();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
