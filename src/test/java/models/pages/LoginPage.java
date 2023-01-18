package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.BottonNavComponent;
import models.components.LoginComponent;
import models.components.SignupComponent;

public class LoginPage {
    private final AppiumDriver<MobileElement> appiumDriver;

    public LoginPage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public BottonNavComponent bottonNavComponent() {
        return new BottonNavComponent(appiumDriver);
    }

    public LoginComponent loginComponent() {
        return new LoginComponent(appiumDriver);
    }

    public SignupComponent signupComponent() {
        return new SignupComponent(appiumDriver);
    }
}
