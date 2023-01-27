package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.LoginDialogComponent;

public class FormsPage {
    private final AppiumDriver<MobileElement> appiumDriver;

    public FormsPage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginDialogComponent loginDialogComponent() {
        return new LoginDialogComponent(appiumDriver);
    }
}
