package org.te.app.android.tests.samsung.appTests.existingUser;

import lombok.extern.slf4j.Slf4j;
import org.te.app.android.assertionConstants.samsung.FoodDrinksScreenConstants;
import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.te.app.android.utils.utils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class FoodAndDrinksTest extends SamsungBaseTest {

    int filtersCount = 0;
    @Test(description = "Verify title")
    public void verifyCategoryTitle(){
        String title = foodAndDrinksScreen.getScreenTitle();
        log.info(title);
        Assert.assertEquals(title, FoodDrinksScreenConstants.TITLE, "Incorrect screen title");
    }

    @Test(description = "Verify types under filter", priority = 1)
    public void verifyFilterSections(){
        foodAndDrinksScreen.openFilters();
        List<String> sections = foodAndDrinksScreen.getFiltersSections();
        log.info(sections.toString());
    }

    @Test(description = "Verify types under filter", priority = 2)
    public void verifyFilterTypes() throws InterruptedException {
        foodAndDrinksScreen.openFiltersType();
        List<String> filterTypes = foodAndDrinksScreen.getAllFilterTypes();
        log.info(filterTypes.toString());
        foodAndDrinksScreen.selectFilterTypeAllAndClose();
    }

    @Test(description = "Verify cuisines under filters", priority = 3)
    public void verifyCuisines() throws InterruptedException {
        foodAndDrinksScreen.openFiltersCuisine();
        List<String> cuisines = foodAndDrinksScreen.getAllCuisinesFromFilters();
        log.info("App : "+String.valueOf(cuisines.size()) + " : "+cuisines.toString());
        log.info("Const : "+String.valueOf(FoodDrinksScreenConstants.CUISINES.length) + " : "+ Arrays.toString(FoodDrinksScreenConstants.CUISINES));
        SoftAssert softAssert = new SoftAssert();
        for(int i=0;i< FoodDrinksScreenConstants.CUISINES.length-1;i++){
            softAssert.assertEquals(cuisines.get(i), FoodDrinksScreenConstants.CUISINES[i], "Incorrect cuisine text." +
                    "\nExpected : "+FoodDrinksScreenConstants.CUISINES[i]+
                    "\nReceived : "+cuisines.get(i));
        }
        foodAndDrinksScreen.applyCuisineFilters();
    }


    @Test(description = "Verify the filters after applying", priority = 4)
    public void verifyCuisineFiltersResults() throws InterruptedException {
        List<String> filtersWithoutData = getStrings();
        String filter = FoodDrinksScreenConstants.CUISINES[utils.generateRandomNumber(0,44)];
        while (filtersWithoutData.contains(filter)){
            filter = FoodDrinksScreenConstants.CUISINES[utils.generateRandomNumber(0,44)];
        }
        filter = "French";
        foodAndDrinksScreen.openFiltersCuisine();
        log.info("Applying filter : "+filter);
        foodAndDrinksScreen.selectSingleCheckBoxFromFiltersWithScroll(filter);
        foodAndDrinksScreen.applyCuisineFilters();
        foodAndDrinksScreen.applyFilters();
        List<String> results = foodAndDrinksScreen.getConsolidateSearchResults(1);
        log.info(results.toString());
        merchantDetailsScreen = foodAndDrinksScreen.openRandomMerchantDetails();
        List<String> attributes = merchantDetailsScreen.getMerchantAttributes();
        log.info("Merchant Name : " + merchantDetailsScreen.getMerchantName());
        log.info("Merchant outlet : " + merchantDetailsScreen.getMerchantOutletName());
        log.info("Merchant attributes : " + merchantDetailsScreen.getMerchantAttributes());
        foodAndDrinksScreen = merchantDetailsScreen.goBackToFoodAndDrinksScreen();
        foodAndDrinksScreen.clearFilter();
        Assert.assertTrue(attributes.contains(filter), "Merchant attributes does not contain the selected filter ("+filter+")");
    }

    @Test(description = "Verify the filters after applying", priority = 4)
    public void verifyCuisineMultipleFiltersResults() throws InterruptedException {
        foodAndDrinksScreen.openFilters();
        filtersCount = utils.generateRandomNumber(2,5);
        List<String> filtersWithoutData = getStrings();
        List<String> filter = new ArrayList<>();
        //String filter = FoodDrinksScreenConstants.CUISINES[utils.generateRandomNumber(0,44)];
        for(int i=0;i<filtersCount;i++) {
            String string = FoodDrinksScreenConstants.CUISINES[utils.generateRandomNumber(0,44)];
            while (filtersWithoutData.contains(string) || filter.contains(string)) {
                string = FoodDrinksScreenConstants.CUISINES[utils.generateRandomNumber(0, 44)];
            }
            filter.add(string);
        }
        foodAndDrinksScreen.openFiltersCuisine();
        log.info("Applying filter : "+filter.toString());
        foodAndDrinksScreen.selectMultipleCuisineFilter(filter);
        //foodAndDrinksScreen.applyCuisineFilters();
        foodAndDrinksScreen.applyFilters();
        List<String> results = foodAndDrinksScreen.getConsolidateSearchResults(2);
        log.info(results.toString());
        merchantDetailsScreen = foodAndDrinksScreen.openRandomMerchantDetails();
        List<String> attributes = merchantDetailsScreen.getMerchantAttributes();
        log.info("Merchant Name : " + merchantDetailsScreen.getMerchantName());
        log.info("Merchant outlet : " + merchantDetailsScreen.getMerchantOutletName());
        log.info("Merchant attributes : " + attributes);
        foodAndDrinksScreen = merchantDetailsScreen.goBackToFoodAndDrinksScreen();
        boolean check = false;
        for (String attribute : attributes) {
            for (int j = 0; j < filtersCount; j++) {
                log.info("Attribute : "+attribute+" to be checked with filters applied: "+filter);
                if (attribute.compareTo(filter.get(j)) == 0) {
                    check = true;
                    break;
                }
            }
        }
        Assert.assertTrue(check);
        //Assert.assertTrue(attributes.contains(filter));
        //Assert.assertTrue(attributes.contains(filter), "Merchant attributes does not contain the selected filter ("+filter+")");
    }

    private static List<String> getStrings() {
        List<String > filtersWithoutData = new ArrayList<>();
        filtersWithoutData.add("Argentinian");
        filtersWithoutData.add("Asian Fusion");
        filtersWithoutData.add("Australian");
        filtersWithoutData.add("Caribbean");
        filtersWithoutData.add("Cuban");
        filtersWithoutData.add("Egyptian");
        filtersWithoutData.add("Emirati");
        filtersWithoutData.add("Fusion");
        filtersWithoutData.add("German");
        filtersWithoutData.add("Greek");
        filtersWithoutData.add("Ice Cream");
        filtersWithoutData.add("Informal Dining");
        filtersWithoutData.add("Latin American");
        filtersWithoutData.add("Malaysian");
        filtersWithoutData.add("Maltese");
        filtersWithoutData.add("Modern Australian");
        filtersWithoutData.add("Moroccan");
        return filtersWithoutData;
    }

    @Test(description = "Verify the filter count in the top bar", priority = 5)
    public void verifyFilterCount() throws InterruptedException {
        String filterCountInTopBar = foodAndDrinksScreen.getCurrentlySelectedFiltersCountFromTopBar();
        log.info(filterCountInTopBar);
        //foodAndDrinksScreen.clearFilter();
        Assert.assertEquals(filterCountInTopBar, String.valueOf(filtersCount));
    }

    @Test(description = "Verify the types filter applied results", priority = 6)
    public void verifyTypeFilersResult() throws InterruptedException {
        foodAndDrinksScreen.openFilters();
        foodAndDrinksScreen.clearAllFilters();
        String filter = FoodDrinksScreenConstants.TYPES[utils.generateRandomNumber(1,FoodDrinksScreenConstants.TYPES.length)];
        log.info("Filter under type to be selected : "+filter);
        foodAndDrinksScreen.openFilters();
        foodAndDrinksScreen.openFiltersType();
        foodAndDrinksScreen.selectSingleCheckBoxFromFilters(filter);
        foodAndDrinksScreen.applyFilters();
        merchantDetailsScreen = foodAndDrinksScreen.openRandomMerchantDetails();
        String type = merchantDetailsScreen.getMerchantCuisineTypeFromOutletDetails();
        log.info("Merchant name : "+merchantDetailsScreen.getMerchantName());
        log.info("Type from the merchant details : "+type);
        foodAndDrinksScreen = merchantDetailsScreen.goBackToFoodAndDrinksScreenFromBottomScreen();
        foodAndDrinksScreen.openFilters();
        foodAndDrinksScreen.openFiltersType();
        Assert.assertEquals(type, filter, "Merchant details does not have selected type"+type+" from filter selected ("+filter+")");
        foodAndDrinksScreen.selectFilterTypeAllAndClose();
    }


    @Test(description = "Verify the types filter and multiple filters under cuisine applied results", priority = 7)
    public void verifyTypeFilersAndMultipleFiltersResult() throws InterruptedException {

        filtersCount = utils.generateRandomNumber(2,5);
        log.info("Filter count :" + filtersCount);
        List<String> filtersWithoutData = getStrings();
        List<String> filter = new ArrayList<>();
        //String filter = FoodDrinksScreenConstants.CUISINES[utils.generateRandomNumber(0,44)];
        for(int i=0;i<filtersCount;i++) {
            String string = FoodDrinksScreenConstants.CUISINES[utils.generateRandomNumber(0,44)];
            while (filtersWithoutData.contains(string) || filter.contains(string)) {
                string = FoodDrinksScreenConstants.CUISINES[utils.generateRandomNumber(0, 44)];
            }
            filter.add(string);
        }
        log.info("Filter to be applied: "+filter);
        foodAndDrinksScreen.openFilters();
        foodAndDrinksScreen.clearAllFilters();
        String filterType = FoodDrinksScreenConstants.TYPES[utils.generateRandomNumber(1,FoodDrinksScreenConstants.TYPES.length)];
        log.info("Filter under type to be selected : "+filterType);
        foodAndDrinksScreen.openFilters();
        foodAndDrinksScreen.openFiltersType();
        foodAndDrinksScreen.selectSingleCheckBoxFromFilters(filterType);

        foodAndDrinksScreen.openFiltersCuisine();
        log.info("Applying filter : "+filter.toString());
        foodAndDrinksScreen.selectMultipleCuisineFilter(filter);


        foodAndDrinksScreen.applyFilters();
        merchantDetailsScreen = foodAndDrinksScreen.openRandomMerchantDetails();
        String type = merchantDetailsScreen.getMerchantCuisineTypeFromOutletDetails();
        List<String> attributes = merchantDetailsScreen.getMerchantAttributes();
        log.info("Merchant name : "+merchantDetailsScreen.getMerchantName());
        log.info("Type from the merchant details : "+type);
        log.info("Merchant Attributes : "+ attributes.toString());
        foodAndDrinksScreen = merchantDetailsScreen.goBackToFoodAndDrinksScreenFromBottomScreen();
        foodAndDrinksScreen.openFilters();
        foodAndDrinksScreen.openFiltersType();
        Assert.assertEquals(type, filterType, "Merchant details does not have selected type"+type+" from filter selected ("+filterType+")");
        foodAndDrinksScreen.selectFilterTypeAllAndClose();
    }


    @Test(description = "Verify amenities offered", priority = 50)
    public void verifyVerifyAmenities(){
        foodAndDrinksScreen.openFilters();
        List<String> amenities = foodAndDrinksScreen.getAllAmenitiesOffered();
        SoftAssert softAssert = new SoftAssert();
        for (int i=0;i< amenities.size();i++){
            softAssert.assertEquals(amenities.get(i), FoodDrinksScreenConstants.AMENITY[i]);
        }
        foodAndDrinksScreen.applyFilters();
        softAssert.assertAll();
    }



    @AfterClass
    public void openBeautyAndFitness(){
        homeScreen = foodAndDrinksScreen.goBackToHomeScreen();
        beautyAndFitnessScreen = homeScreen.openBeautyAndFitness();
    }
}
