package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class BottonNavComponent {
    private final AppiumDriver<MobileElement> appiumDriver;

    private static final By HOME = MobileBy.AccessibilityId("Home");
    private static final By WEBVIEW = MobileBy.AccessibilityId("Webview");
    private static final By LOGIN = MobileBy.AccessibilityId("Login");
    private static final By FORMS = MobileBy.AccessibilityId("Forms");
    private static final By SWIPE = MobileBy.AccessibilityId("Swipe");
    private static final By DRAG = MobileBy.AccessibilityId("Drag");

    public BottonNavComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickToHomeNavButton() {
        appiumDriver.findElement(HOME).click();
    }

    public void clickToWebviewNavButton() {
        appiumDriver.findElement(WEBVIEW).click();
    }

    public void clickToLoginNavButton() {
        appiumDriver.findElement(LOGIN).click();
    }

    public void clickToFormsNavButton() {
        appiumDriver.findElement(FORMS).click();
    }

    public void clickToSwipeNavButton() {
        appiumDriver.findElement(SWIPE).click();
    }

    public void clickToDragNavButton() {
        appiumDriver.findElement(DRAG).click();
    }
}
