package org.te.app.android.tests.samsung.appTests.existingUser;

import lombok.extern.slf4j.Slf4j;
import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

@Slf4j
public class RedemptionsTest extends SamsungBaseTest {

    @BeforeClass
    public void navigateToFoodScreen(){
        foodAndDrinksScreen = homeScreen.openFoodAndDrinks();
    }

    @Test
    public void verifyNothing() throws InterruptedException {
        foodAndDrinksScreen.openFilters();
        foodAndDrinksScreen.selectSingleAmenity("Buffet","yes");
        foodAndDrinksScreen.applyFilters();
        List<String> merchantsInfo = foodAndDrinksScreen.getAllMerchantInformation();
        log.info("FINAL LIST");
        log.info(merchantsInfo.toString());
    }


    @AfterClass
    public void goToHome(){
        homeScreen = foodAndDrinksScreen.goBackToHomeScreen();
    }
}
