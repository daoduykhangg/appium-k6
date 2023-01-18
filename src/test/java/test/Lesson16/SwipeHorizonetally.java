package test.Lesson16;

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

public class SwipeHorizonetally {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver;
        driver = DriverFactory.getDriver(Platforms.android);
        try {
            MobileElement navFormBtnElem = driver.findElement(MobileBy.AccessibilityId("Swipe"));
            navFormBtnElem.click();
            WebDriverWait explicitWait = new WebDriverWait(driver, 15);
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.TextView[contains(@text,'Swipe horizontal')]")));

            Dimension windowSize = driver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenwidth = windowSize.getWidth();

            int xStartPoint = (70 * screenwidth) / 100;
            int xEndPoint = (10 * screenwidth) / 100;

            int yStartPoint = (70 * screenHeight) / 100;
            int yEndPoint = (70 * screenHeight) / 100;
            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            TouchAction ta = new TouchAction(driver);
            for (int i = 0; i < 5; i++) {
                ta.longPress(startPoint)
                        .moveTo(endPoint)
                        .release()
                        .perform();
            }
            for (int i = 0; i < 5; i++) {
                ta.longPress(endPoint)
                        .moveTo(startPoint)
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
