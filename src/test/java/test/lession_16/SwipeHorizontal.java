package test.lession_16;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwipeHorizontal {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            MobileElement navFormsBtnElem = driver.findElement(MobileBy.AccessibilityId("Swipe"));
            navFormsBtnElem.click();

            WebDriverWait explicitwait = new WebDriverWait(driver, 10L);
            explicitwait.until(ExpectedConditions.visibilityOfElementLocated(
                    MobileBy.xpath("//android.widget.TextView[@text=\"Swipe horizontal\"]")));

            Dimension windowSize = driver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            int xStartPoint = 70 * screenWidth / 100;
            int xEndPoint = 5 * screenWidth / 100;

            int yStartPoint = 70 * screenHeight / 100;
            int yEndPoint = 70 * screenHeight / 100;

            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            TouchAction touchAction = new TouchAction(driver);

            //Using touchAction to swipe from right to left 5 times
            for (int i = 0; i < 5; i++) {
                touchAction
                        .longPress(startPoint)
                        .moveTo(endPoint)
                        .release()
                        .perform();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
