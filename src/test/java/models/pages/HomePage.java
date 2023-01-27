package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.BottonNavComponent;
import models.components.LoginComponent;
import models.components.SignupComponent;

public class HomePage {
    private final AppiumDriver<MobileElement> appiumDriver;

    public HomePage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public BottonNavComponent bottonNavComponent() {
        return new BottonNavComponent(appiumDriver);
    }
    
    public SignupComponent signupComponent() {
        return new SignupComponent(appiumDriver);
    }
}
