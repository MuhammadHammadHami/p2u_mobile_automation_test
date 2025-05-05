package com.p2u.pageObject;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CommonPage {
    protected AndroidDriver driver;
    private final By backButton = By.id("");
    private final By menuButton = By.id("");
    public CommonPage(AndroidDriver driver) {
        this.driver = driver;
    }
    public void goBack() {
        driver.findElement(backButton).click();
    }
    public void openMenu() {
        driver.findElement(menuButton).click();
    }
}
