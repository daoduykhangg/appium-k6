package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.LoginComponent;
import models.components.LoginDialogComponent;
import models.pages.LoginPage;
import org.apache.commons.validator.routines.EmailValidator;
import org.testng.asserts.SoftAssert;
import test_flows.BaseFlow;

public class LoginFlow extends BaseFlow {
    private final AppiumDriver<MobileElement> appiumDriver;
    private final String email;
    private final String password;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String email, String password) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        this.email = email;
        this.password = password;
    }

    public void login() {
        LoginPage loginPage = new LoginPage(appiumDriver);
        LoginComponent loginComponent = loginPage.loginComponent();
        if (!email.isEmpty()) {
            loginComponent.enterToEmailTextbox(email);
        }
        if (!password.isEmpty()) {
            loginComponent.enterToPasswordTextbox(password);
        }
        loginComponent.clickToLoginBtn();
    }

    public void verify() {
        boolean isEmailValid = EmailValidator.getInstance().isValid(email);
        boolean ispasswordValid = password.length() >= 8;
        LoginPage loginPage = new LoginPage(appiumDriver);
        LoginComponent loginComponent = loginPage.loginComponent();

        if (isEmailValid && ispasswordValid) {
            verifyCorrectEmailAndPassword(loginPage);
        }
        if (!isEmailValid) {
            verifyInCorrectEmail(loginComponent);
        }
        if (!ispasswordValid) {
            verifyInCorrectPassword(loginComponent);
        }
    }

    private void verifyCorrectEmailAndPassword(LoginPage loginPage) {
        loginPage.loginDialogComponent().clickToOkBtn();
    }

    private void verifyInCorrectPassword(LoginComponent loginComponent) {
        String actualInvalidPasswordStr = loginComponent.getInvalidPasswordStr();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualInvalidPasswordStr, "Please enter at least 8 characters.");
        softAssert.assertAll();
    }

    private void verifyInCorrectEmail(LoginComponent loginComponent) {
        String actualInvalidEmailStr = loginComponent.getInvalidEmailStr();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualInvalidEmailStr, "Please enter a valid email address.");
        softAssert.assertAll();
    }
}
