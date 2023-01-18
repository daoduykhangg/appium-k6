package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginComponent extends CredentialsComponents {
    private AppiumDriver<MobileElement> appiumDriver;
    private final By LOGIN_BTN = MobileBy.AccessibilityId("button-LOGIN");
    private final By OK_BTN = MobileBy.xpath("//*[@text='OK']");
    private final By DIALOG_TITLE = MobileBy.id("android:id/alertTitle");

    public LoginComponent(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
    }

    public String getDialogTitle() {
        return appiumDriver.findElement(DIALOG_TITLE).getText();
    }

    public void clickToLoginBtn() {
        appiumDriver.findElement(LOGIN_BTN).click();
    }

    public void clickToOkBtn() {
        appiumDriver.findElement(OK_BTN).click();
    }
}
