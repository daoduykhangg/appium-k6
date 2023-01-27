package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BaseTest {
    protected static AppiumDriver<MobileElement> appiumDriver;

    @BeforeTest
    public void initAppiumDriver() {
        appiumDriver = DriverFactory.getDriver(Platforms.android);
    }

    @AfterTest(alwaysRun = true)
    public void quitAppiumDriver() {
        appiumDriver.quit();
    }

    @AfterMethod
    public void takeScreenShort(ITestResult testResult) {
        if (testResult.getStatus() == testResult.FAILURE) {
            String testMethodName = testResult.getName();
            Calendar calendar = new GregorianCalendar();
            int y = calendar.get(Calendar.YEAR);
            int m = calendar.get(Calendar.MONTH) + 1;
            int d = calendar.get(Calendar.DATE);
            int h = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);
            String dateTaken = y + "-" + m + "-" + d + "-" + h + "-" + min + "-" + sec;
            String fileLocation = System.getProperty("user.dir") + "/screenshots/".concat(testMethodName).concat("-").concat(dateTaken).concat(".png");
            try {
                File screenShort = appiumDriver.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenShort, new File(fileLocation));

                Path screenShortContentPath = Paths.get(fileLocation);
                InputStream inputStream = Files.newInputStream(screenShortContentPath);
                Allure.addAttachment(testMethodName.concat("-").concat(dateTaken), inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
