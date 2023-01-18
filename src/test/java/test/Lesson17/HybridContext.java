package test.Lesson17;

import Context.Context;
import Context.WaitContextMoreThanOne;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HybridContext implements Context {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver;
        appiumDriver = DriverFactory.getDriver(Platforms.android);
        try {
            MobileElement navWebViewBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Webview"));
            navWebViewBtnElem.click();

            WebDriverWait explicitWait = new WebDriverWait(appiumDriver, 15);
            explicitWait.until(new WaitContextMoreThanOne(appiumDriver));
            appiumDriver.context(WEB_VIEW);

            WebElement subtitleElem = appiumDriver.findElement(By.cssSelector(".hero__subtitle"));
            System.out.println(subtitleElem.getText());

            appiumDriver.context(NATIVE_APP);

            MobileElement navLoginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();

            List<MobileElement> credInputFields = appiumDriver.findElements(MobileBy.xpath("//android.widget.EditText"));
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            credInputFields.get(0).sendKeys("teo@sth.com");
            credInputFields.get(1).sendKeys("123456789");

            MobileElement loginInstructionElem = appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"When the device\")"));
            System.out.println(loginInstructionElem.getText());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }

    }
}
