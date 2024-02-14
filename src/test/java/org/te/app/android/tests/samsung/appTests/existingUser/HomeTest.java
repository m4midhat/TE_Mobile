package org.te.app.android.tests.samsung.appTests.existingUser;

import lombok.extern.slf4j.Slf4j;
import org.te.app.android.assertionConstants.samsung.HomeScreenConstants;
import org.te.app.android.screens.samsung.SearchScreen;
import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.te.app.android.utils.utils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Slf4j
public class HomeTest extends SamsungBaseTest {

    @BeforeClass
    public void navigateToLoginScreen() throws IOException {
        loginScreen = introWizardScreen.navigateToLoginScreenFromIntroScreen();
        Properties credentials = utils.initProperties("userCredentials");
        selectLocationScreen = loginScreen.signInToApplication(credentials.getProperty("samsungUser"), credentials.getProperty("samsungPassword"));
        selectLocationScreen.allowNotifications();
        selectLocationScreen.clickOKButton();
        selectLocationScreen.selectNationalityCheckbox(0);
        homeScreen = selectLocationScreen.clickDoneButton();
        homeScreen.clickYesButton();
        homeScreen.clickGrantLocationAccessWhileUsingApp();
    }

    @Test(description = "Saving widget should not have zero savings")
    public void verifySavings()  {
        String savings = homeScreen.getSavingAmount();
        int dSavings = utils.returnSavings(savings);
        log.info(String.valueOf(dSavings));
        Assert.assertTrue(dSavings>0);
    }

    @Test(description = "Saving widget should have currency")
    public void verifySavingCurrency(){
        String savings = homeScreen.getSavingAmount();
        String currency = utils.returnCurrency(savings);
        log.info(currency);
        Assert.assertFalse(currency.isEmpty());
    }

    @Test(description = "Verify the selected location")
    public void verifyLocationSelected(){
        String location = homeScreen.getLocationText();
        Assert.assertEquals(location, HomeScreenConstants.LOCATION_ABU_DHABI);
    }

    @Test(description = "Verify categories title")
    public void verifyCategories() throws InterruptedException {
        List<String> categories = homeScreen.getAllCategories();
        log.info("Final category list : "+categories.toString());
        SoftAssert softAssert = new SoftAssert();
        for(int i=0;i< categories.size();i++) {
            softAssert.assertEquals(categories.get(i), HomeScreenConstants.CATEGORIES[i]);
            i++;
        }
        softAssert.assertAll();
    }



    @AfterClass
    public void clickSearch(){
        searchScreen = homeScreen.clickSearchIcon();
    }

}
