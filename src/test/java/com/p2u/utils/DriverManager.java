package com.p2u.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static AndroidDriver driver;
    public static AndroidDriver getDriver() {
        if (driver == null) {
            startDriver();
        }
        return driver;
    }
    private static void startDriver() {
        String appiumServerUrl = "http://192.168.0.60:4723/";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:deviceName", "8c530bc8");
        capabilities.setCapability("appium:platformVersion", "12");
        capabilities.setCapability("appium:app", System.getProperty("user.dir") + ".app/1.8.0-dev-app.apk");
        capabilities.setCapability("appium:automationName", "UIAutomator2");
        capabilities.setCapability("appium:autoGrantPermissions", true);
        capabilities.setCapability("appium:noReset", true);
        capabilities.setCapability("appium:fullReset", true);

        try {
            driver = new AndroidDriver(new URL(appiumServerUrl), capabilities);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
