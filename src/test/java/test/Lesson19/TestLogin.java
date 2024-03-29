package test.Lesson19;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.DataObjectBuilder;
import test_data.models.LoginCredData;
import test_flows.authentication.LoginFlow;

public class TestLogin {
    @Test(dataProvider = "loginCredData")
    public void testLogin(LoginCredData loginCredData) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);
        try {
            String email = loginCredData.getEmail();
            String password = loginCredData.getPassword();
            LoginFlow loginFlow = new LoginFlow(appiumDriver, email, password);
            loginFlow.goToLoginScreen();
            loginFlow.login();
            loginFlow.verify();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }

    }

    @DataProvider
    public LoginCredData[] loginCredData() {
        String filePath = "/src/test/java/test_data/authen/loginCreds.json";
        return DataObjectBuilder.buildDataObject(filePath, LoginCredData[].class);
    }
}

