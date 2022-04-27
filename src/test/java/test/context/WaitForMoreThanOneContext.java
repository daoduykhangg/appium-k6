package test.context;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.ExpectedCondition;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.WebDriver;

public class WaitForMoreThanOneContext implements ExpectedCondition<Boolean> {
    private final AppiumDriver<MobileElement> appiumDriver;

    public WaitForMoreThanOneContext(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @NullableDecl
    public Boolean apply(@NullableDecl WebDriver input) {
        return appiumDriver.getContextHandles().size() > 1;
    }
}
