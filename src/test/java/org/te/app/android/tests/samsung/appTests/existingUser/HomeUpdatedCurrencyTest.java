package org.te.app.android.tests.samsung.appTests.existingUser;

import lombok.extern.slf4j.Slf4j;
import org.te.app.android.AppConstants.AppConstants;
import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@Slf4j
public class HomeUpdatedCurrencyTest extends SamsungBaseTest {

    @Test(description = "Verify the updated currency")
    public void verifyUpdatedCurrency(){
        String amount = homeScreen.getSavingAmount();
        log.info(amount);
        log.info("Previously selected currency : "+currency_at_home.trim());
        log.info("Currently selected currency : "+AppConstants.SELECTED_CURRENCY_FROM_PROFILE_DETAILS);
        Assert.assertTrue(amount.contains(AppConstants.SELECTED_CURRENCY_FROM_PROFILE_DETAILS),
                "Home section savings should contain the updated currency");
    }


    @AfterClass
    public void navigateToSearchScreenForFavourites(){
        searchScreen = homeScreen.clickSearchIcon();
    }

}
