package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.BottonNavComponent;
import models.pages.HomePage;
import models.pages.LoginPage;

public class BaseFlow {
    AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void goToLoginScreen() {
        HomePage homePage = new HomePage(appiumDriver);
        BottonNavComponent bottonNavComponent = homePage.bottonNavComponent();
        bottonNavComponent.clickToLoginNavButton();
    }

    public void goToFormScreen() {
        new HomePage(appiumDriver).bottonNavComponent().clickToFormsNavButton();
    }
}
