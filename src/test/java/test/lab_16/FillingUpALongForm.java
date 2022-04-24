package test.lab_16;

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

public class FillingUpALongForm {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);
        try {
            WebDriverWait explicitwait = new WebDriverWait(driver, 5L);

            MobileElement navFormsBtn = driver.findElement(MobileBy.AccessibilityId("Forms"));
            navFormsBtn.click();

            explicitwait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(
                    "new UiSelector().textContains(\"Form components\")")));

            MobileElement inputfieldTextbox = driver.findElement(MobileBy.AccessibilityId("text-input"));
            inputfieldTextbox.sendKeys("email");

            MobileElement uHaveTypeTextbox = driver.findElement(MobileBy.AccessibilityId("input-text-result"));
            System.out.println("You have typed: " + uHaveTypeTextbox.getText());

            driver.findElement(MobileBy.AccessibilityId("switch")).click();

            driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Select an item...\")")).click();

            explicitwait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(
                    "new UiSelector().textContains(\"webdriver.io is awesome\")")));

            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiSelector().textContains(\"webdriver.io is awesome\")")).click();

            Dimension windowsize = driver.manage().window().getSize();
            int screenHeight = windowsize.getHeight();
            int screenWidth = windowsize.getWidth();

            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;

            int yStartPoint = 50 * screenHeight / 100;
            int yEndPoint = 35 * screenHeight / 100;

            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            TouchAction touchAction = new TouchAction(driver);
            touchAction
                    .longPress(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();

            driver.findElement(MobileBy.AccessibilityId("button-Active")).click();
            driver.findElement(MobileBy.id("android:id/button1")).click();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
