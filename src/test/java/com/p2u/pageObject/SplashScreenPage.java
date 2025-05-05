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

public class SplashScreenPage extends CommonPage {
    private final By beginButton = AppiumBy.accessibilityId("Next");
    public SplashScreenPage(AndroidDriver driver) {
        super(driver);
    }
    public void swipeScreen() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        int startX = (int) (screenWidth * 0.8);
        int endX = (int) (screenWidth * 0.2);
        int startY = (int) (screenHeight * 0.6);
        System.out.println("Swipe from: (" + startX + ", " + startY + ") to (" + endX + ", " + startY + ")");
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), endX, startY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
    }
    public void clickBeginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(beginButton));
        System.out.println("Clicking the 'Begin' button now.");
        button.click();
        System.out.println("'Begin' button clicked successfully.");
    }
}