package test.Lesson18;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.BottonNavComponent;
import models.components.LoginComponent;
import models.components.SignupComponent;
import models.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPOM {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver;
        driver = DriverFactory.getDriver(Platforms.android);
        try {
            LoginPage loginPage = new LoginPage(driver);
            BottonNavComponent bottonNavComponent = loginPage.bottonNavComponent();
            bottonNavComponent.clickToLoginNavButton();

            LoginComponent loginComponent = loginPage.loginComponent();
            loginComponent.enterToEmailTextbox("sth@gmail.com");

            loginComponent.enterToPasswordTextbox("12345678");

            loginComponent.clickToLoginBtn();

            System.out.println(loginComponent.getDialogTitle());
            loginComponent.clickToOkBtn();

            SignupComponent signupComponent = loginPage.signupComponent();
            signupComponent.clickToSignupForm();
            signupComponent.enterToEmailTextbox("abc@sth.com");
            signupComponent.enterToPasswordTextbox("123123123");
            signupComponent.enterToConfirmPasswordTextbox("123123123");
            signupComponent.clickToSignupBtn();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
