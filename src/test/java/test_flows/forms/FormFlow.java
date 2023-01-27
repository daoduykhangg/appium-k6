package test_flows.forms;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_flows.BaseFlow;

public class FormFlow extends BaseFlow {
    private AppiumDriver<MobileElement> appiumDriver;

    public FormFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
    }


    public void fieldtheForm() {
        WebDriverWait explicitWait = new WebDriverWait(appiumDriver, 15);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.TextView[contains(@text,'Form components')]")));

        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        int xStartpoint = (50 * screenWidth) / 100;
        int xEndpoint = (50 * screenWidth) / 100;

        int yStartpoint = (50 * screenHeight) / 100;
        int yEndpoint = (10 * screenHeight) / 100;

        PointOption startPoint = new PointOption().withCoordinates(xStartpoint, yStartpoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndpoint, yEndpoint);

        TouchAction ta = new TouchAction(appiumDriver);
        ta.longPress(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }
}
