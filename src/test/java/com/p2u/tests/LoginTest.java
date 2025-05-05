package com.p2u.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    @Test
    public void testGoogleLogin() {
        try {
            Assert.assertTrue(driver.findElement(By.id("homePageIdentifier")).isDisplayed(),
                    "User should be logged in successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Login verification failed.");
        }
    }
}


