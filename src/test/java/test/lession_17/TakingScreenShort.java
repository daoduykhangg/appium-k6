package test.lession_17;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;

public class TakingScreenShort {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);
        try {
            MobileElement navLoginBtnElem = driver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();

            //whole Screen
            File base64ScreenshortData = driver.getScreenshotAs(OutputType.FILE);
            String projectPath = System.getProperty("user.dir");
            FileUtils.copyFile(base64ScreenshortData, new File(projectPath + "/screenshorts/" + "HomeScreen.png"));

            //An Area
            MobileElement loginFormElem = driver.findElement(MobileBy.AccessibilityId("Login-screen"));
            File base64LoginFormData = loginFormElem.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(base64LoginFormData, new File(projectPath + "/screenshorts/" + "LoginForm.png"));

            //An Element
            MobileElement loginBtnElem = driver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            File base64LoginBtnData = loginBtnElem.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(base64LoginBtnData, new File(projectPath + "/screenshorts/" + "LoginButton.png"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }

}
