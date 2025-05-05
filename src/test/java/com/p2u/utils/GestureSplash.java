package com.p2u.utils;
import com.p2u.pageObject.SplashScreenPage;
public class GestureSplash {
    public void navigateThroughSplashScreen() throws InterruptedException {
        SplashScreenPage splashScreenPage = new SplashScreenPage(DriverManager.getDriver());
        Thread.sleep(5000);
        for (int i = 0; i < 3; i++) {
            Thread.sleep(3000);
            splashScreenPage.swipeScreen();
        }
        splashScreenPage.clickBeginButton();
    }
}

