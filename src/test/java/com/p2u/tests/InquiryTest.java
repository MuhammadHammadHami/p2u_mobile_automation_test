package com.p2u.tests;

import com.p2u.pageObject.InquiryPage;
import com.p2u.pageObject.SettingsPage;
import com.p2u.testData.InquiryTestData;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InquiryTest extends BaseTest {

    @Test
    public void testInquirySubmission() throws InterruptedException {
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.clickSettingsMenu();
        InquiryPage inquiryPage = settingsPage.navigateToInquiry();
        inquiryPage.clickCreateNewInquiryButton();
        inquiryPage.enterTestField(inquiryPage.getSubjectField, InquiryTestData.SUBJECT);
        inquiryPage.selectCategory(InquiryTestData.CATEGORY);
        inquiryPage.enterTestField(inquiryPage.getMessageField, InquiryTestData.MESSAGE);
        inquiryPage.submitInquiry();
        Assert.assertTrue(inquiryPage.isSubmissionSuccessful(), "Inquiry should be submitted successfully.");
        inquiryPage.clickTrackButton();
    }
}
