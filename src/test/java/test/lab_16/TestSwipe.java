package test.lab_16;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSwipe extends Swipe {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);
        try {
            MobileElement navFormsBtn = driver.findElement(MobileBy.AccessibilityId("Forms"));
            navFormsBtn.click();
            WebDriverWait explicitwait = new WebDriverWait(driver, 10L);

            explicitwait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(
                    "new UiSelector().textContains(\"Form components\")")));

            Dimension windowsize = driver.manage().window().getSize();
            Swipe swipe = new Swipe();
            swipe.swipeUp(windowsize, driver);
            swipe.swipedown(windowsize, driver);
            swipe.swipeUp(windowsize, 15, driver);
            swipe.swipedown(windowsize, 15, driver);

            MobileElement navFormsBtnElem = driver.findElement(MobileBy.AccessibilityId("Swipe"));
            navFormsBtnElem.click();

            explicitwait.until(ExpectedConditions.visibilityOfElementLocated(
                    MobileBy.xpath("//android.widget.TextView[@text=\"Swipe horizontal\"]")));
            swipe.swipeFromRightToLeft(windowsize, driver);
            swipe.swipeFromRightToLeft(windowsize, driver);
            swipe.swipeFromRightToLeft(windowsize, driver);
            swipe.swipeFromLeftToRight(windowsize, driver);
            swipe.swipeFromLeftToRight(windowsize, driver);
            swipe.swipeFromLeftToRight(windowsize, driver);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
