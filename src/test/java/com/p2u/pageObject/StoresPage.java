package com.p2u.pageObject;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.Arrays;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput;
public class StoresPage extends CommonPage {
    private AndroidDriver driver;
    public StoresPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void clickAddButton() {
        By addButton = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[2]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
        driver.findElement(addButton).click();
    }
    public By getCompanyRegField() {
        return By.xpath("//android.view.View[@content-desc=\"Company Registration Number\"]/following-sibling::android.widget.EditText");
    }
    public By getCheckButton() {
        return AppiumBy.accessibilityId("Check");
    }
    public By getAddPhoto() {
        return By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[9]");
    }
    public By getAddCompanyDocument() {
        return AppiumBy.accessibilityId("Add Company Document");
    }
    public By getStoreNameField() {
        return By.xpath("//android.view.View[@content-desc=\"Store Name\"]/following-sibling::android.widget.EditText");
    }
    public By getCategoryDropDown() {
        return AppiumBy.accessibilityId("Select Category");
    }
    public By getStoreDetailField() {
        return By.xpath("//android.view.View[@content-desc=\"Store Detail\"]/following-sibling::android.widget.EditText");
    }
    public By getNaverSearchLink() {
        return By.xpath("//android.view.View[@content-desc='Naver Search Link']/following-sibling::android.widget.EditText[2]");
    }
    public By getCityCountryDropDown() {
        return AppiumBy.accessibilityId("Select City/County");
    }
    public By getAddressField() {
        return By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[20]");
    }
    public By getRegisterButton() {
        return AppiumBy.accessibilityId("Register Store");
    }
    public void fillTextField(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
        driver.findElement(locator).sendKeys(text);
        if (locator.equals(getStoreNameField())) {
            scrollSlightly();
        }
    }
    private void scrollSlightly() {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        int screenHeight = driver.manage().window().getSize().height;
        int scrollStartY = (int) (screenHeight * 0.5);
        int scrollEndY = (int) (screenHeight * 0.2);

        Sequence scroll = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 0, scrollStartY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), 0, scrollEndY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(scroll));
    }

    public void clickCheckButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getCheckButton()));
        driver.findElement(getCheckButton()).click();
    }
    public void uploadImage(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement fileChooserTrigger = wait.until(ExpectedConditions.elementToBeClickable(locator));
        fileChooserTrigger.click();
        WebElement firstPhoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[3]")));
        firstPhoto.click();
        WebElement cropButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Crop")));
        cropButton.click();
        System.out.println("Image selected, cropped, and uploaded successfully.");
    }

    public void uploadDocument(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement fileChooserTrigger = wait.until(ExpectedConditions.elementToBeClickable(locator));
        fileChooserTrigger.click();
        WebElement firstDocument = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Add Company Document")));
        firstDocument.click();
        System.out.println("Document selected and uploaded successfully.");
    }
    public void selectDropdownOption(By locator, String optionText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        dropdownElement.click();
        By optionLocator = AppiumBy.accessibilityId(optionText);
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        optionElement.click();
        if (locator.equals(getCategoryDropDown())) {
            scrollSlightly();
        }
    }
    public void selectCountryCityDropdownOption(By locator, String optionText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        dropdownElement.click();
        By optionLocator = AppiumBy.accessibilityId(optionText);
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        optionElement.click();
    }
    public void clickButton(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(locator));
        button.click();
    }
    public boolean isFormSubmittedSuccessfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Store added successfully']")));
            return successMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
