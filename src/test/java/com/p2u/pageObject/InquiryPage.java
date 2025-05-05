package com.p2u.pageObject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class InquiryPage extends CommonPage {
    private final AndroidDriver driver;
    public By getCreateNewInquiry = AppiumBy.accessibilityId("Create New Inquiry");
    public By getSubjectField = By.xpath("(//android.view.View[@content-desc=\"Category\"])/../android.widget.EditText[1]");
    public By getCategoryDropdown = AppiumBy.accessibilityId("Category");
    public By getMessageField = By.xpath("(//android.view.View[@content-desc=\"Category\"])/../android.widget.EditText[2]");
    public By getSubmitButton = AppiumBy.accessibilityId("Submit");
    public By getSuccessMessage = AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '1:1 Inquiry Received')]");
    public By getTrackInquiryButton = AppiumBy.accessibilityId("Track Inquiry");
    public InquiryPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void clickCreateNewInquiryButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getCreateNewInquiry));
        driver.findElement(getCreateNewInquiry).click();
    }
    public void enterTestField(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
        driver.findElement(locator).sendKeys(text);
    }
    public void selectCategory(String category) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(getCategoryDropdown));
        categoryElement.click();
        By optionLocator = AppiumBy.accessibilityId(category);
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        optionElement.click();
    }
    public void submitInquiry() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(getSubmitButton));
        button.click();
    }

    public boolean isSubmissionSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(getSuccessMessage));
            return successMessageElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clickTrackButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(getTrackInquiryButton));
        button.click();
    }
}