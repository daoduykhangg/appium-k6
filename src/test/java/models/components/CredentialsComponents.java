package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class CredentialsComponents {
    private final AppiumDriver<MobileElement> appiumDriver;
    private final By LOGIN_FORM = MobileBy.AccessibilityId("button-login-container");
    private final By SIGNUP_FORM = MobileBy.AccessibilityId("button-sign-up-container");
    private final By EMAIL_TEXTBOX = MobileBy.AccessibilityId("input-email");
    private final By PASSWORD_TEXTBOX = MobileBy.AccessibilityId("input-password");

    public CredentialsComponents(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickToLoginForm() {
        appiumDriver.findElement(LOGIN_FORM).click();
    }

    public void clickToSignupForm() {
        appiumDriver.findElement(SIGNUP_FORM).click();
    }

    public void enterToEmailTextbox(String email){
        if(!email.isEmpty()){
            appiumDriver.findElement(EMAIL_TEXTBOX).sendKeys(email);
        }
    }

    public void enterToPasswordTextbox(String password){
        if(!password.isEmpty()){
            appiumDriver.findElement(PASSWORD_TEXTBOX).sendKeys(password);
        }
    }
}
