package test.lab_16;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

public class Swipe {
    public void swipeUp(Dimension windowsize, AppiumDriver<MobileElement> driver) {
        int midPoint = 50;
        int screenHeight = windowsize.getHeight();
        int screenWidth = windowsize.getWidth();

        int xStartPoint = midPoint * screenWidth / 100;
        int xEndPoint = midPoint * screenWidth / 100;

        int yStartPoint = midPoint * screenHeight / 100;
        int yEndPoint = 35 * screenHeight / 100;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .longPress(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public void swipeUp(Dimension windowsize, int percentage, AppiumDriver<MobileElement> driver) {
        int midPoint = 50;
        int screenHeight = windowsize.getHeight();
        int screenWidth = windowsize.getWidth();

        int xStartPoint = midPoint * screenWidth / 100;
        int xEndPoint = midPoint * screenWidth / 100;

        int yStartPoint = midPoint * screenHeight / 100;
        int yEndPoint = (midPoint - percentage) * screenHeight / 100;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .longPress(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public void swipedown(Dimension windowsize, AppiumDriver<MobileElement> driver) {
        int midPoint = 50;
        int screenHeight = windowsize.getHeight();
        int screenWidth = windowsize.getWidth();

        int xStartPoint = midPoint * screenWidth / 100;
        int xEndPoint = midPoint * screenWidth / 100;

        int yStartPoint = midPoint * screenHeight / 100;
        int yEndPoint = 65 * screenHeight / 100;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .longPress(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public void swipedown(Dimension windowsize, int percentage, AppiumDriver<MobileElement> driver) {
        int midPoint = 50;
        int screenHeight = windowsize.getHeight();
        int screenWidth = windowsize.getWidth();

        int xStartPoint = midPoint * screenWidth / 100;
        int xEndPoint = midPoint * screenWidth / 100;

        int yStartPoint = midPoint * screenHeight / 100;
        int yEndPoint = (midPoint + percentage) * screenHeight / 100;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .longPress(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public void swipeFromLeftToRight(Dimension windowsize, AppiumDriver<MobileElement> driver) {
        int screenHeight = windowsize.getHeight();
        int screenWidth = windowsize.getWidth();

        int xStartPoint = 5 * screenWidth / 100;
        int xEndPoint = 70 * screenWidth / 100;

        int yStartPoint = 70 * screenHeight / 100;
        int yEndPoint = 70 * screenHeight / 100;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .longPress(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public void swipeFromRightToLeft(Dimension windowsize, AppiumDriver<MobileElement> driver) {
        int screenHeight = windowsize.getHeight();
        int screenWidth = windowsize.getWidth();

        int xStartPoint = 70 * screenWidth / 100;
        int xEndPoint = 5 * screenWidth / 100;

        int yStartPoint = 70 * screenHeight / 100;
        int yEndPoint = 70 * screenHeight / 100;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .longPress(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }
}
