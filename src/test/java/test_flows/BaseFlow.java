package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.BottonNavComponent;
import models.pages.LoginPage;

public class BaseFlow {
    AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void goToLoginScreen() {
        LoginPage loginPage = new LoginPage(appiumDriver);
        BottonNavComponent bottonNavComponent = loginPage.bottonNavComponent();
        bottonNavComponent.clickToLoginNavButton();
    }
}
