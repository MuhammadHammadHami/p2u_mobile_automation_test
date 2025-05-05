package com.p2u.pageObject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class SettingsPage extends CommonPage {
    private final By settingsMenu = AppiumBy.accessibilityId("Settings\nTab 4 of 4");
    private final By addP2UStores = AppiumBy.accessibilityId("My P2U Stores (0)");
    private final By inquiry = AppiumBy.accessibilityId("1:1 Inquiry");
    public SettingsPage(AndroidDriver driver) {
        super(driver);
    }
    public void clickSettingsMenu() {
        System.out.println("Waiting for settings menu to be clickable...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(settingsMenu));
        System.out.println("Clicking on settings menu...");
        driver.findElement(settingsMenu).click();
    }
    public StoresPage navigateToAddP2UStores() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addP2UStores));
        driver.findElement(addP2UStores).click();
        return new StoresPage(driver);
    }
    public InquiryPage navigateToInquiry() {
        scrollToElement(inquiry);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(inquiry));
        driver.findElement(inquiry).click();
        return new InquiryPage(driver);
    }
    private void scrollToElement(By elementLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = null;
        while (element == null) {
            try {
                element = driver.findElement(elementLocator);
                if (element.isDisplayed()) {
                    break;
                }
            } catch (Exception e) {
                scrollDown();
            }
        }
    }
    private void scrollDown() {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        int screenHeight = driver.manage().window().getSize().height;
        int screenWidth = driver.manage().window().getSize().width;
        int startX = screenWidth / 2;
        int startY = (int) (screenHeight * 0.8);
        int endY = (int) (screenHeight * 0.2);
        Sequence scroll = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(scroll));
    }
}
