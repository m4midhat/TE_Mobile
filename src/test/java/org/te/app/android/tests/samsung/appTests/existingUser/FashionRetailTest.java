package org.te.app.android.tests.samsung.appTests.existingUser;

import lombok.extern.slf4j.Slf4j;
import org.te.app.android.assertionConstants.samsung.FashionCategoryScreenConstants;
import org.te.app.android.assertionConstants.samsung.FoodDrinksScreenConstants;
import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.te.app.android.utils.utils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FashionRetailTest extends SamsungBaseTest {

    private List<String> getString(){
        List<String> noData = new ArrayList<>();
        noData.add("Baby & Child");
        noData.add("Confectionery");
        noData.add("Electronics");
        noData.add("Fashion");
        noData.add("Grocery & Off-License");
        noData.add("Health & Beauty");
        noData.add("Home & Garden");
        noData.add("Jewellery");
        noData.add("Pets");
        noData.add("Sporting Goods");

        return noData;
    }

    @Test(description = "Verify title")
    public void verifyCategoryTitle(){
        String title = fashionRetailScreen.getScreenTitle();
        log.info(title);
        Assert.assertEquals(title, FashionCategoryScreenConstants.TITLE, "Incorrect screen title");
    }

    @Test(description = "Verify types under filter", priority = 2)
    public void verifyFilterTypes() throws InterruptedException {
        fashionRetailScreen.openFilters();
        fashionRetailScreen.openFiltersType();
        List<String> filterTypes = fashionRetailScreen.getAllFilterTypes();
        log.info(filterTypes.toString());
        fashionRetailScreen.selectFilterTypeAllAndClose();
    }

    @Test(description = "Verify the types filter applied results", priority = 3)
    public void verifyTypeFilersResult() throws InterruptedException {
        fashionRetailScreen.openFilters();
        fashionRetailScreen.clearAllFilters();

        List<String> filtersWithoutData = getString();
        String filter = FashionCategoryScreenConstants.TYPES[utils.generateRandomNumber(1,FashionCategoryScreenConstants.TYPES.length-1)];
        while (filtersWithoutData.contains(filter)){
            filter = FashionCategoryScreenConstants.TYPES[utils.generateRandomNumber(1,FashionCategoryScreenConstants.TYPES.length-1)];
        }

        log.info("Filter under type to be selected : "+filter);
        fashionRetailScreen.openFilters();
        fashionRetailScreen.openFiltersType();
        fashionRetailScreen.selectSingleCheckBoxFromFilters(filter);
        fashionRetailScreen.applyFilters();
        merchantDetailsScreen = fashionRetailScreen.openRandomMerchantDetails();
        log.info("Merchant name : "+merchantDetailsScreen.getMerchantName());
        String type = merchantDetailsScreen.getMerchantCuisineTypeFromOutletDetails();
        log.info("Type from the merchant details : "+type);
        fashionRetailScreen = merchantDetailsScreen.goBackToFashionAndRetailScreenFromBottomScreen();
        fashionRetailScreen.openFilters();
        fashionRetailScreen.openFiltersType();
        Assert.assertTrue(type.contains(filter), "Merchant details does not have selected type"+type+" from filter selected ("+filter+")");
        fashionRetailScreen.selectFilterTypeAllAndClose();
        fashionRetailScreen.applyFilters();
    }



    @AfterClass
    public void openFoodAndDrinks(){
        homeScreen = fashionRetailScreen.goBackToHomeScreen();
        foodAndDrinksScreen = homeScreen.openFoodAndDrinks();
    }
}
