package test.lession_17;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.context.Contexts;
import test.context.WaitForMoreThanOneContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HybridContext {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);
        try {
            MobileElement navWebviewBtnElem = driver.findElement(MobileBy.AccessibilityId("Webview"));
            navWebviewBtnElem.click();

            WebDriverWait explicitwait = new WebDriverWait(driver, 10L);
            explicitwait.until(new WaitForMoreThanOneContext(driver));

            //Switch to Webview
            driver.context(Contexts.WEB_VIEW);

            WebElement toggleBtnElem = driver.findElementByCssSelector(".navbar__toggle");
            toggleBtnElem.click();

            Map<String, String> menuItemList = new HashMap<String, String>();
            List<MobileElement> menuItemElems = driver.findElementsByCssSelector(".menu__list li a");
            for (MobileElement menuItemElem : menuItemElems) {
                String itemText = menuItemElem.getText();
                String itemHref = menuItemElem.getAttribute("href");
                if (itemText.isEmpty()) {
                    menuItemList.put("gitHub", itemHref);
                } else {
                    menuItemList.put(itemText, itemHref);
                }
            }

            menuItemList.keySet().forEach(key -> {
                System.out.println(key + ": " + menuItemList.get(key));
            });

            //switch to Native
            driver.context(Contexts.NATIVE);

            MobileElement navLoginBtnElem = driver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();

            MobileElement emailTextboxElem = driver.findElement(MobileBy.AccessibilityId("input-email"));
            emailTextboxElem.clear();
            emailTextboxElem.sendKeys("khang@sth.com");

            MobileElement passwordTextboxElem = driver.findElement(MobileBy.AccessibilityId("input-password"));
            passwordTextboxElem.clear();
            passwordTextboxElem.sendKeys("12345678");

            MobileElement loginButtonElem = driver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            loginButtonElem.click();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }


}
