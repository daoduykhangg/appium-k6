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

public class SwipeVeritically {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver;
        driver = DriverFactory.getDriver(Platforms.android);
        try {
            MobileElement navFormBtnElem = driver.findElement(MobileBy.AccessibilityId("Forms"));
            navFormBtnElem.click();
            WebDriverWait explicitWait = new WebDriverWait(driver, 15);
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.TextView[contains(@text,'Form components')]")));

            Dimension windowSize = driver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            int xStartpoint = (50 * screenWidth) / 100;
            int xEndpoint = (50 * screenWidth) / 100;

            int yStartpoint = (50 * screenHeight) / 100;
            int yEndpoint = (10 * screenHeight) / 100;

            PointOption startPoint = new PointOption().withCoordinates(xStartpoint, yStartpoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndpoint, yEndpoint);

            TouchAction ta = new TouchAction(driver);
            ta.longPress(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();

            MobileElement nativeBtnEle = driver.findElement(MobileBy.AccessibilityId("button-Active"));
            nativeBtnEle.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
