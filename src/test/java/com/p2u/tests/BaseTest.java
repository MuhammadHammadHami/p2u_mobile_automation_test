package com.p2u.tests;

import com.p2u.pageObject.HomePage;
import com.p2u.pageObject.LoginPage;
import com.p2u.utils.DriverManager;
import com.p2u.utils.GestureSplash;
import com.p2u.testData.LoginTestData;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected AndroidDriver driver;
    private boolean isLoggedIn = false;
    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = DriverManager.getDriver();
        new GestureSplash().navigateThroughSplashScreen();
        if (!isLoggedIn) {
            performLogin();
            isLoggedIn = true;
        }
    }
    private void performLogin() throws InterruptedException {
        new LoginPage(driver).performGoogleLogin(LoginTestData.GOOGLE_EMAIL, LoginTestData.GOOGLE_PASSWORD);
        HomePage homePage = new HomePage(driver);
        homePage.clickPopup();
        homePage.clickBannerPopup();
    }
    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
