package test.Lesson17;

import Context.Context;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class TakingScreenShot implements Context {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver;
        appiumDriver = DriverFactory.getDriver(Platforms.android);
        try {
            WebDriverWait explicitWait = new WebDriverWait(appiumDriver, 15);
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Login"))).click();

            File base64ScreenShotData = appiumDriver.getScreenshotAs(OutputType.FILE);
            String fileLocation = PATH_PROJECT.concat("/screenshots/").concat("HomeScreen.png");
            FileUtils.copyFile(base64ScreenShotData, new File(fileLocation));

            MobileElement loginFormElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login-screen"));
            File base64SLoginForm = loginFormElem.getScreenshotAs(OutputType.FILE);
            String loginFormLocation = PATH_PROJECT.concat("/screenshots/").concat("LoginScreen.png");
            FileUtils.copyFile(base64SLoginForm, new File(loginFormLocation));

            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            File base64LoginButton = loginBtnElem.getScreenshotAs(OutputType.FILE);
            String loginBtnLocation = PATH_PROJECT.concat("/screenshots/").concat("LoginButton.png");
            FileUtils.copyFile(base64LoginButton, new File(loginBtnLocation));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
