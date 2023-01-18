package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class SignupComponent extends CredentialsComponents {
    private AppiumDriver<MobileElement> appiumDriver;
    private final By SIGNUP_BTN = MobileBy.AccessibilityId("button-SIGN UP");
    private final By CONFIRM_PASSWORD_TEXTBOX = MobileBy.AccessibilityId("input-repeat-password");

    public SignupComponent(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
    }

    public void clickToSignupBtn() {
        appiumDriver.findElement(SIGNUP_BTN).click();
    }

    public void enterToConfirmPasswordTextbox(String password) {
        if (!password.isEmpty()) {
            appiumDriver.findElement(CONFIRM_PASSWORD_TEXTBOX).sendKeys(password);
        }
    }
}
