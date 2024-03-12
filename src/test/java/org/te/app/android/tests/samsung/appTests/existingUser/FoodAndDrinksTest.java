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
        String filter = FoodDrinksScreenConstants.TYPES[utils.generateRandomNumber(1,FoodDrinksScreenConstants.TYPES.length-1)];
        log.info("Filter under type to be selected : "+filter);
        foodAndDrinksScreen.openFilters();
        foodAndDrinksScreen.openFiltersType();
        foodAndDrinksScreen.selectSingleCheckBoxFromFilters(filter);
        foodAndDrinksScreen.applyFilters();
        merchantDetailsScreen = foodAndDrinksScreen.openRandomMerchantDetails();
        log.info("Merchant name : "+merchantDetailsScreen.getMerchantName());
        String type = merchantDetailsScreen.getMerchantCuisineTypeFromOutletDetails();
        log.info("Type from the merchant details : "+type);
        foodAndDrinksScreen = merchantDetailsScreen.goBackToFoodAndDrinksScreenFromBottomScreen();
        foodAndDrinksScreen.openFilters();
        foodAndDrinksScreen.openFiltersType();
        Assert.assertTrue(type.contains(filter), "Merchant details does not have selected type"+type+" from filter selected ("+filter+")");
        foodAndDrinksScreen.selectFilterTypeAllAndClose();
    }


    @Test(description = "Verify the types filter and multiple filters under cuisine applied results", priority = 7)
    public void verifyTypeFilersAndMultipleFiltersResult() throws InterruptedException {

        foodAndDrinksScreen.openFilters();
        foodAndDrinksScreen.clearAllFilters();
        int randomIndex = utils.generateRandomNumber(1,FoodDrinksScreenConstants.TYPES.length-1);
        log.info("Random Index : "+randomIndex);
        String filterType = FoodDrinksScreenConstants.TYPES[randomIndex];
        log.info("Filter under type to be selected : "+filterType);
        foodAndDrinksScreen.openFilters();
        foodAndDrinksScreen.openFiltersType();
        foodAndDrinksScreen.selectSingleCheckBoxFromFilters(filterType);

        filtersCount = utils.generateRandomNumber(2,5);
        log.info("Filter count :" + filtersCount);
        List<String> filterData = foodAndDrinksScreen.getRelevantCuisines(filterType);
        log.info("Data is available against : "+filterData);
        List<String> filter = new ArrayList<>();
        //String filter = FoodDrinksScreenConstants.CUISINES[utils.generateRandomNumber(0,44)];
        for(int i=0;i<filtersCount;i++) {
            String string = filterData.get(utils.generateRandomNumber(0, filterData.size()-1));
            while (filter.contains(string)) {
                string = filterData.get(utils.generateRandomNumber(0, filterData.size()-1));
            }
            filter.add(string);
        }
        log.info("Filter to be applied: "+filter);


        foodAndDrinksScreen.openFiltersCuisine();
        log.info("Applying filter : "+filter.toString());
        foodAndDrinksScreen.selectMultipleCuisineFilter(filter);


        foodAndDrinksScreen.applyFilters();
        merchantDetailsScreen = foodAndDrinksScreen.openRandomMerchantDetails();
        log.info("Merchant name : "+merchantDetailsScreen.getMerchantName());
        List<String> attributes = merchantDetailsScreen.getMerchantAttributes();
        String type = merchantDetailsScreen.getMerchantCuisineTypeFromOutletDetails();
        log.info("Type from the merchant details : "+type);
        log.info("Merchant Attributes : "+ attributes.toString());
        foodAndDrinksScreen = merchantDetailsScreen.goBackToFoodAndDrinksScreenFromBottomScreen();
        Assert.assertTrue(type.contains(filterType), "Merchant details does not have selected type"+type+" from filter selected ("+filterType+")");
    }

    @Test(description = "Apply random amenity with yes", priority = 10)
    public void verifyRandomAmenityYesResults() throws InterruptedException {
        foodAndDrinksScreen.openFilters();
        foodAndDrinksScreen.clearAllFilters();
        foodAndDrinksScreen.openFilters();
        String amenity = FoodDrinksScreenConstants.AMENITY[utils.generateRandomNumber(0,8)];
        log.info("Amenity to be selected : "+amenity);
        foodAndDrinksScreen.selectSingleAmenity(amenity, "yes");
        foodAndDrinksScreen.applyFilters();
        merchantDetailsScreen = foodAndDrinksScreen.openRandomMerchantDetails();
        log.info("Merchant name : "+merchantDetailsScreen.getMerchantName());
        merchantDetailsScreen.scroll();
        merchantDetailsScreen.viewMoreAmenities();
        List<String> amenitiesOffered = merchantDetailsScreen.getAllAmenitiesOffered();
        if(!amenitiesOffered.isEmpty()) {
            log.info("Amenities offered : "+amenitiesOffered.toString());
        }
        foodAndDrinksScreen = merchantDetailsScreen.goBackToFoodAndDrinksScreenFromBottomScreen();
        foodAndDrinksScreen.openFilters();
        foodAndDrinksScreen.resetPositiveAmenities();
        foodAndDrinksScreen.applyFilters();
        if(!amenitiesOffered.isEmpty()) {
            if(amenity.compareTo("Outdoor Seating")!=0) {
                Assert.assertTrue(amenitiesOffered.contains(amenity));
            }
            else {
                for(String amenityOffered:amenitiesOffered){
                    log.info(amenityOffered);
                    if(amenityOffered.contains(":")){
                        String text = amenityOffered.substring(0,amenityOffered.indexOf(":"));
                        log.info("Found : "+text);
                        Assert.assertEquals(text, amenity);
                    }
                }
            }
        }
    }

    @Test(description = "Apply random amenity with no", priority = 11)
    public void verifyRandomAmenityNoResults() throws InterruptedException {
        foodAndDrinksScreen.openFilters();
        foodAndDrinksScreen.clearAllFilters();
        foodAndDrinksScreen.openFilters();
        String amenity = FoodDrinksScreenConstants.AMENITY[utils.generateRandomNumber(0,8)];
        log.info("Amenity to be selected : "+amenity);
        foodAndDrinksScreen.selectSingleAmenity(amenity,"no");
        foodAndDrinksScreen.applyFilters();
        merchantDetailsScreen = foodAndDrinksScreen.openRandomMerchantDetails();
        log.info("Merchant name : "+merchantDetailsScreen.getMerchantName());
        merchantDetailsScreen.scroll();
        merchantDetailsScreen.viewMoreAmenities();
        List<String> amenitiesOffered = merchantDetailsScreen.getAllAmenitiesOffered();
        if(!amenitiesOffered.isEmpty()) {
            log.info("Amenities offered : "+amenitiesOffered.toString());
        }
        foodAndDrinksScreen = merchantDetailsScreen.goBackToFoodAndDrinksScreenFromBottomScreen();
        foodAndDrinksScreen.openFilters();
        foodAndDrinksScreen.resetNegativeAmenities();
        foodAndDrinksScreen.applyFilters();
        if(!amenitiesOffered.isEmpty()) {
            Assert.assertFalse(amenitiesOffered.contains(amenity));
        }
    }




    // multiple filters; type, cuisines & amenities
    //@Test(description = "Apply random amenity with yes & no, filter type and cuisine type", priority = 12)
    public void verifyAllFilterResults() throws InterruptedException {
        foodAndDrinksScreen.openFilters();
        foodAndDrinksScreen.clearAllFilters();
        int randomIndex = utils.generateRandomNumber(1,FoodDrinksScreenConstants.TYPES.length-1);
        log.info("Random Index : "+randomIndex);
        String type = FoodDrinksScreenConstants.TYPES[randomIndex];
        log.info("Filter under type to be selected : "+type);
        foodAndDrinksScreen.openFilters();
        foodAndDrinksScreen.openFiltersType();
        foodAndDrinksScreen.selectSingleCheckBoxFromFilters(type);

        filtersCount = utils.generateRandomNumber(2,5);
        log.info("Filter count :" + filtersCount);
        List<String> filterData = foodAndDrinksScreen.getRelevantCuisines(type);
        log.info("Data is available against : "+filterData);
        List<String> cuisines = new ArrayList<>();
        //String filter = FoodDrinksScreenConstants.CUISINES[utils.generateRandomNumber(0,44)];
        for(int i=0;i<filtersCount;i++) {
            String string = filterData.get(utils.generateRandomNumber(0, filterData.size()-1));
            while (cuisines.contains(string)) {
                string = filterData.get(utils.generateRandomNumber(0, filterData.size()-1));
            }
            cuisines.add(string);
        }
        log.info("Filter to be applied: "+cuisines);
        foodAndDrinksScreen.openFiltersCuisine();
        log.info("Applying filter : "+cuisines.toString());
        foodAndDrinksScreen.selectMultipleCuisineFilter(cuisines);
        int amenitySelection = utils.generateRandomNumber(0,1);
        String amenity;
        amenity = FoodDrinksScreenConstants.AMENITY[utils.generateRandomNumber(0, 8)];
        if(amenitySelection==0) {
            log.info("Positive amenity to be selected : " + amenity);
            foodAndDrinksScreen.selectSingleAmenity(amenity, "yes");
        }
        else {
            log.info("Negative amenity to be selected : " + amenity);
            foodAndDrinksScreen.selectSingleAmenity(amenity, "no");
        }
        foodAndDrinksScreen.applyFilters();






        





            while (foodAndDrinksScreen.noDataFound()) {
                foodAndDrinksScreen.openFilters();
                foodAndDrinksScreen.resetPositiveAmenities();
                foodAndDrinksScreen.resetNegativeAmenities();

                // new amenity to be selected
                amenity = FoodDrinksScreenConstants.AMENITY[utils.generateRandomNumber(0, 8)];
                if (amenitySelection == 0) {
                    log.info("Positive amenity to be selected : " + amenity);
                    foodAndDrinksScreen.selectSingleAmenity(amenity, "yes");
                } else {
                    log.info("Negative amenity to be selected : " + amenity);
                    foodAndDrinksScreen.selectSingleAmenity(amenity, "no");
                }
                foodAndDrinksScreen.applyFilters();
            }
        SoftAssert softAssert = new SoftAssert();
        merchantDetailsScreen = foodAndDrinksScreen.openRandomMerchantDetails();
        String merchantName = merchantDetailsScreen.getMerchantName();
        List<String> merchantAttributes = merchantDetailsScreen.getMerchantAttributes();
        String merchantType = merchantDetailsScreen.getMerchantCuisineTypeFromOutletDetails();
        String merchantAmenities = merchantDetailsScreen.getAllAmenitiesOffered().toString();
        log.info("Merchant name : "+merchantName);
        log.info("Merchant attributes : "+merchantAttributes);
        log.info("Merchant type : "+merchantType);
        log.info("Merchant amenities : "+merchantAmenities);
        foodAndDrinksScreen = merchantDetailsScreen.goBackToFoodAndDrinksScreenFromBottomScreen();
        foodAndDrinksScreen.openFilters();
        if(amenitySelection==0) {
            log.info("Positive amenity to be selected : " + amenity);
            foodAndDrinksScreen.selectSingleAmenity(amenity, "yes");
        }
        else {
            log.info("Negative amenity to be selected : " + amenity);
            foodAndDrinksScreen.selectSingleAmenity(amenity, "no");
        }
        foodAndDrinksScreen.applyFilters();
        softAssert.assertTrue(merchantType.contains(type), "Incorrect merchant type. Applied type :"+type+" Random merchant type : "+merchantType);
        if(amenitySelection==0) {
            softAssert.assertTrue(merchantAmenities.contains(amenity), "Incorrect merchant amenities. Applied amenity :"+amenity+" Random merchant amenities : "+merchantAmenities);
        }
        else {
            softAssert.assertFalse(merchantAmenities.contains(amenity),"Issue in negative amenity");
        }
        boolean found = false;
        for(String attribute:merchantAttributes) {
            if (cuisines.contains(attribute)) {
                found = true;
                break;
            }
        }
        softAssert.assertTrue(found, "Cuisines applied: "+cuisines.toString()+ "Unable to find the cuisine in the merchant attributes "+merchantAttributes);
        //softAssert.assertTrue(merchantAttributes.contains(cuisines.toString()), "Issues in the merchant attributes ");
        softAssert.assertAll();
    }




    @Test(description = "Verify amenities offered", priority = 50)
    public void verifyVerifyAmenities(){
        foodAndDrinksScreen.resetFiltersView();
        List<String> amenities = foodAndDrinksScreen.getAllAmenitiesOffered();
        log.info(amenities.toString());
        SoftAssert softAssert = new SoftAssert();
        for (int i=0;i< amenities.size();i++){
            log.info(amenities.get(i));
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
