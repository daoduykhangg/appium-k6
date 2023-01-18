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

public class Lap16 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver;
        driver = DriverFactory.getDriver(Platforms.android);
        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Forms")));
            MobileElement navFormsBtnElem = driver.findElement(MobileBy.AccessibilityId("Forms"));
            navFormsBtnElem.click();

            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("text-input")));
            MobileElement inputfieldElem = driver.findElement(MobileBy.AccessibilityId("text-input"));
            inputfieldElem.sendKeys("Somethings");

            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("input-text-result")));
            MobileElement youHavefieldElem = driver.findElement(MobileBy.AccessibilityId("input-text-result"));
            System.out.println(youHavefieldElem.getText());

            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("switch")));
            MobileElement switchToggledElem = driver.findElement(MobileBy.AccessibilityId("switch"));
            switchToggledElem.click();

            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("switch-text")));
            MobileElement switchTextdElem = driver.findElement(MobileBy.AccessibilityId("switch-text"));
            System.out.println(switchTextdElem.getText());

            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Dropdown")));
            MobileElement dropdownListdElem = driver.findElement(MobileBy.AccessibilityId("Dropdown"));
            dropdownListdElem.click();

            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Appium is awesome\")")));
            MobileElement appiumOptiopdElem = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Appium is awesome\")"));
            appiumOptiopdElem.click();

            Dimension windowScreen = driver.manage().window().getSize();

            int screenHeight = windowScreen.getHeight();
            int screenWidth = windowScreen.getWidth();

            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;

            int yStartPoint = 50 * screenHeight / 100;
            int yEndPoint = 20 * screenHeight / 100;

            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            TouchAction tc = new TouchAction(driver);
            tc.longPress(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();

            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("button-Active")));
            MobileElement activeBtndElem = driver.findElement(MobileBy.AccessibilityId("button-Active"));
            activeBtndElem.click();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
