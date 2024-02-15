package org.te.app.android.tests.samsung.appTests.existingUser;

import lombok.extern.slf4j.Slf4j;
import org.te.app.android.assertionConstants.samsung.FashionCategoryScreenConstants;
import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;

@Slf4j
public class FoodAndDrinksTest extends SamsungBaseTest {

    @Test(description = "Verify title")
    public void verifyCategoryTitle(){
        String title = foodAndDrinksScreen.getScreenTitle();
        log.info(title);
    }

    @Test(description = "Verify current offers")
    public void verifyOffers(){
        List<String> results = foodAndDrinksScreen.getConsolidateSearchResults(15);
        log.info(results.toString());
    }



    @AfterClass
    public void openBeautyAndFitness(){
        homeScreen = foodAndDrinksScreen.goBackToHomeScreen();
        beautyAndFitnessScreen = homeScreen.openBeautyAndFitness();
    }
}
