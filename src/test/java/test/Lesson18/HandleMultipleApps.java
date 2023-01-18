package test.Lesson18;

import Context.AppPackages;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import java.time.Duration;
import java.util.List;

public class HandleMultipleApps {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver;
        appiumDriver = DriverFactory.getDriver(Platforms.android);
        try {
            MobileElement navLoginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();

            List<MobileElement> credInputFields = appiumDriver.findElements(MobileBy.xpath("//android.widget.EditText"));
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            credInputFields.get(USERNAME_INDEX).sendKeys("teo@sth.com");
            credInputFields.get(PASSWORD_INDEX).sendKeys("123456789");

            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            loginBtnElem.click();

            //put the app into background || similar with pressing home btn
            appiumDriver.runAppInBackground(Duration.ofSeconds(-1));

            appiumDriver.activateApp(AppPackages.SETTINGS);

            MobileElement netWorkAndInternetElem = appiumDriver.findElement(MobileBy.xpath("//*[@text='Network & internet']"));
            netWorkAndInternetElem.click();

            MobileElement wifiElem = appiumDriver.findElement(MobileBy.xpath("//*[@text='Wi‑Fi']/following-sibling::android.widget.TextView"));
            Boolean isWifiOn = wifiElem.getText().equals("AndroidWifi");
            if (isWifiOn) {
                wifiElem.click();
                MobileElement useWifiElem = appiumDriver.findElement(MobileBy.xpath("//*[@text='Use Wi‑Fi']"));
                useWifiElem.click();
            }

            appiumDriver.activateApp(AppPackages.WIO);
            MobileElement okBtnElem = appiumDriver.findElement(MobileBy.xpath("//*[@text='OK']"));
            okBtnElem.click();

            Thread.sleep(2000);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
