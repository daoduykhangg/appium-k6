package Context;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.WebDriver;

public class WaitContextMoreThanOne implements ExpectedCondition<Boolean> {
    private final AppiumDriver<MobileElement> appiumDriver;

    public WaitContextMoreThanOne(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Override
    public Boolean apply(WebDriver input) {
        return appiumDriver.getContextHandles().size() > 1;
    }
}
