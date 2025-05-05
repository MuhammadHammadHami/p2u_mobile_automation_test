package com.p2u.pageObject;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private final AndroidDriver driver;
    private final By handlePopup = By.xpath("//android.widget.Button[@content-desc=\"Close\"]");
    private final By handleBannerPopup = By.xpath("//android.widget.ImageView/android.widget.Button");
    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }
    public void clickPopup() throws InterruptedException {
        Thread.sleep(10000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(handlePopup));
        driver.findElement(handlePopup).click();
    }
    public void clickBannerPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(handleBannerPopup));
        driver.findElement(handleBannerPopup).click();
    }
}
