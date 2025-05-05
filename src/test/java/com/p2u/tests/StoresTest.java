package com.p2u.tests;

import com.p2u.pageObject.SettingsPage;
import com.p2u.pageObject.StoresPage;
import com.p2u.testData.StoresTestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StoresTest extends BaseTest {

    @Test
    public void testAddP2UStore() throws InterruptedException {
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.clickSettingsMenu();
        StoresPage storesPage = settingsPage.navigateToAddP2UStores();
        storesPage.clickAddButton();
        storesPage.fillTextField(storesPage.getCompanyRegField(), StoresTestData.COMPANY_REGISTER_NUMBER);
        storesPage.clickCheckButton();
        storesPage.uploadImage(storesPage.getAddPhoto());
        storesPage.uploadDocument(storesPage.getAddCompanyDocument());
        storesPage.fillTextField(storesPage.getStoreNameField(), StoresTestData.STORE_NAME);
        storesPage.fillTextField(storesPage.getStoreDetailField(), StoresTestData.STORE_DETAIL);
        storesPage.fillTextField(storesPage.getNaverSearchLink(), StoresTestData.NAVER_LINK);
        storesPage.selectDropdownOption(storesPage.getCategoryDropDown(), StoresTestData.CATEGORY);
        storesPage.selectCountryCityDropdownOption(storesPage.getCityCountryDropDown(), StoresTestData.CITY_COUNTRY);
        storesPage.clickButton(storesPage.getNaverSearchLink());
        storesPage.fillTextField(storesPage.getAddressField(), StoresTestData.STORE_LOCATION);
        storesPage.clickButton(storesPage.getRegisterButton());
        Assert.assertTrue(storesPage.isFormSubmittedSuccessfully(), "Store should be added successfully.");
    }
}
