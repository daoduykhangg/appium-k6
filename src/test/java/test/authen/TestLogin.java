package test.authen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.DataObjectBuilder;
import test_data.models.LoginCredData;
import test_flows.authentication.LoginFlow;

public class TestLogin extends BaseTest {

    @Test(dataProvider = "loginCredData")
    public void testLogin(LoginCredData loginCredData) {
        String email = loginCredData.getEmail();
        String password = loginCredData.getPassword();
        LoginFlow loginFlow = new LoginFlow(getAppiumDriver(), email, password);
        loginFlow.goToLoginScreen();
        loginFlow.login();
        loginFlow.verify();
    }

    @DataProvider
    public LoginCredData[] loginCredData() {
        String filePath = "/src/test/java/test_data/authen/loginCreds.json";
        return DataObjectBuilder.buildDataObject(filePath, LoginCredData[].class);
    }
}

