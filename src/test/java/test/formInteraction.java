package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class formInteraction {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);
        try {
            MobileElement navLoginBtnElem = driver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();

            MobileElement emailTextboxElem = driver.findElement(MobileBy.AccessibilityId("input-email"));
            emailTextboxElem.clear();
            emailTextboxElem.sendKeys("khang@sth.com");

            MobileElement passwordTextboxElem = driver.findElement(MobileBy.AccessibilityId("input-password"));
            passwordTextboxElem.clear();
            passwordTextboxElem.sendKeys("12345678");

            MobileElement loginButtonElem = driver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            loginButtonElem.click();

            WebDriverWait explicitwait = new WebDriverWait(driver, 5L);

            explicitwait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/alertTitle")));
            MobileElement titleLoginDialogElem = driver.findElement(MobileBy.id("android:id/alertTitle"));
            System.out.println(titleLoginDialogElem.getText());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
