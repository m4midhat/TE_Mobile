package org.te.app.android.tests.samsung.appTests.existingUser;

import lombok.extern.slf4j.Slf4j;
import org.te.app.android.AppConstants.AppConstants;
import org.te.app.android.assertionConstants.samsung.HomeScreenConstants;
import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.te.app.android.utils.utils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
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
        String dSavings = utils.returnSavings(savings);
        log.info(dSavings);
        Assert.assertTrue(Integer.parseInt(dSavings.replace(",",""))>0);
    }

    @Test(description = "Saving widget should have currency")
    public void verifySavingCurrency(){
        String savings = homeScreen.getSavingAmount();
        currency_at_home = utils.returnCurrency(savings);
        log.info(currency_at_home);
        Assert.assertFalse(currency_at_home.isEmpty());
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

    @Test(description = "Verify footer bar items")
    public void verifyFooterControls(){
        String homeTabText = homeScreen.getFooterControlTextForHome();
        String deliveryTabText = homeScreen.getFooterControlTextForDelivery();
        String travelTabText = homeScreen.getFooterControlTextForTravel();
        String profileTabText = homeScreen.getFooterControlTextForProfile();
        log.info("Controls/Tabs at the bottom : "+homeTabText+" , "+deliveryTabText+ " , "+travelTabText+ " , "+ profileTabText);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homeTabText, HomeScreenConstants.SCREEN_CONTROLS[0]);
        softAssert.assertEquals(deliveryTabText, HomeScreenConstants.SCREEN_CONTROLS[1]);
        softAssert.assertEquals(travelTabText, HomeScreenConstants.SCREEN_CONTROLS[2]);
        softAssert.assertEquals(profileTabText, HomeScreenConstants.SCREEN_CONTROLS[3]);
        softAssert.assertAll();
    }

    @Test(description = "Verify section titles")
    public void verifySectionTitles(){
        List<String> titles = homeScreen.getHomeScreenSectionsTitle();
        SoftAssert softAssert = new SoftAssert();
        for(int i=0;i< titles.size();i++) {
            softAssert.assertEquals(titles.get(i), HomeScreenConstants.SCREEN_SECTIONS[i]);
        }
        softAssert.assertAll();
        log.info(titles.toString());
    }



    @AfterClass
    public void clickSearch() throws InterruptedException {
        homeScreen.resetCategories();
        searchScreen = homeScreen.clickSearchIcon();
    }

}
