package test.forms;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.forms.FormFlow;

public class TestForm extends BaseTest {
    @Test
    public void testFormsPage() {
        FormFlow formFlow = new FormFlow(appiumDriver);
        formFlow.goToFormScreen();
        formFlow.fieldtheForm();
    }
}
