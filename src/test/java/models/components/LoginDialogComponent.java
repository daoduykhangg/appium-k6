package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginDialogComponent {
    private final AppiumDriver<MobileElement> appiumDriver;


    public LoginDialogComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    private final By OK_BTN = MobileBy.xpath("//*[@text='OK']");

    public void clickToOkBtn() {
        appiumDriver.findElement(OK_BTN).click();
    }
}
