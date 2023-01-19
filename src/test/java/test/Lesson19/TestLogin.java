package test.Lesson19;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import test_flows.authentication.LoginFlow;

import java.util.HashMap;
import java.util.Map;

public class TestLogin {
    @Test
    public void testLogin() {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);
        try {
            Map<String, String> dataTest = new HashMap<>();
            dataTest.put("teo@", "12345678");
            dataTest.put("teo@sth.xyz", "1234567");
            dataTest.put("teo@sth.com", "12345678");

            for (String email : dataTest.keySet()) {
                LoginFlow loginFlow = new LoginFlow(appiumDriver, email, dataTest.get(email));
                loginFlow.goToLoginScreen();
                loginFlow.login();
                loginFlow.verify();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
