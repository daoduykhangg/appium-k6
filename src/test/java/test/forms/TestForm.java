package test.forms;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.forms.FormFlow;

public class TestForm extends BaseTest {
    @Test
    public void testFormsPage() {
        FormFlow formFlow = new FormFlow(getAppiumDriver());
        formFlow.goToFormScreen();
        formFlow.fieldtheForm();
        Assert.fail("[ERR]");
    }
}
