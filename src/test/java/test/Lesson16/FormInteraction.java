package test.Lesson16;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormInteraction {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver;
        driver = DriverFactory.getDriver(Platforms.android);
        try {
            MobileElement navLoginBtnElem = driver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();

            MobileElement usernameElem = driver.findElement(MobileBy.AccessibilityId("input-email"));
            usernameElem.sendKeys("abc@gmail.com");

            MobileElement passwordElem = driver.findElement(MobileBy.AccessibilityId("input-password"));
            passwordElem.sendKeys("12345678");

            MobileElement loginBtnElem = driver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            loginBtnElem.click();
            WebDriverWait explicitWait = new WebDriverWait(driver, 10);
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/alertTitle")));
            MobileElement loginDialogTitleElem = driver.findElement(MobileBy.id("android:id/alertTitle"));
            System.out.println(loginDialogTitleElem.getText());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
