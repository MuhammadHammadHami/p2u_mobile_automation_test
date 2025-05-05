package com.p2u.pageObject;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final AndroidDriver driver;
    private final By signWithGoogle = By.xpath("//android.widget.ImageView[@content-desc=\" Sign with Google\"]");
    private final By emailField = By.xpath("(//android.widget.EditText)[1]");
    private final By nextButton = By.xpath("//android.widget.Button[@text=\"NEXT\"]");
    private final By passwordField = By.xpath("//android.widget.EditText");
    private final By agreeButton = By.xpath("//android.widget.Button[@text=\"I agree\"]");
    private final By moreButton = By.xpath("//android.widget.Button[@text=\"MORE\"]");
    private final By acceptButton = By.xpath("//android.widget.Button[@text=\"ACCEPT\"]");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }
    public void clickGoogleLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(signWithGoogle));
        driver.findElement(signWithGoogle).click();
    }
    public void enterEmail(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(username);
    }
    public void clickNextButton() throws InterruptedException {
        driver.findElement(nextButton).click();
        Thread.sleep(3000);
    }
    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }
    public void performGoogleLogin(String email, String password) throws InterruptedException {
        clickGoogleLogin();
        enterEmail(email);
        clickNextButton();
        enterPassword(password);
        clickNextButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(agreeButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(moreButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(acceptButton)).click();
    }
}
