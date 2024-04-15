package org.te.app.android.tests.samsung.appTests.existingUser;

import lombok.extern.slf4j.Slf4j;
import org.te.app.android.assertionConstants.samsung.BeautyAndFitnessScreenConstants;
import org.te.app.android.assertionConstants.samsung.FashionCategoryScreenConstants;
import org.te.app.android.assertionConstants.samsung.FoodDrinksScreenConstants;
import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.te.app.android.utils.utils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BeautyAndFitnessTest extends SamsungBaseTest {

    @Test(description = "Verify title")
    public void verifyCategoryTitle(){
        String title = beautyAndFitnessScreen.getScreenTitle();
        log.info(title);
        Assert.assertEquals(title, BeautyAndFitnessScreenConstants.TITLE, "Incorrect screen title");
    }

    @Test(description = "Verify types under filter", priority = 1)
    public void verifyFilterSections() throws InterruptedException {
        beautyAndFitnessScreen.openFilters();
        List<String> sections = beautyAndFitnessScreen.getFiltersSections();
        log.info(sections.toString());
    }

    @Test(description = "Verify types under filter", priority = 2)
    public void verifyFilterTypes() throws InterruptedException {
        beautyAndFitnessScreen.openFiltersType();
        List<String> filterTypes = beautyAndFitnessScreen.getAllFilterTypes();
        log.info(filterTypes.toString());
        beautyAndFitnessScreen.selectFilterTypeAllAndClose();
    }


    @Test(description = "Verify the types filter applied results", priority = 6)
    public void verifyTypeFilersResult() throws InterruptedException {
        beautyAndFitnessScreen.openFilters();
        beautyAndFitnessScreen.clearAllFilters();
        List<String> filtersWithoutData = noData();
        String filter = BeautyAndFitnessScreenConstants.TYPES[utils.generateRandomNumber(1,BeautyAndFitnessScreenConstants.TYPES.length-1)];
        while (filtersWithoutData.contains(filter)){
            filter = BeautyAndFitnessScreenConstants.TYPES[utils.generateRandomNumber(1,BeautyAndFitnessScreenConstants.TYPES.length-1)];
        }
        log.info("Filter under type to be selected : "+filter);
        beautyAndFitnessScreen.openFilters();
        beautyAndFitnessScreen.openFiltersType();
        beautyAndFitnessScreen.selectSingleCheckBoxFromFilters(filter);
        beautyAndFitnessScreen.applyFilters();
        merchantDetailsScreen = beautyAndFitnessScreen.openRandomMerchantDetails();
        log.info("Merchant name : "+merchantDetailsScreen.getMerchantName());
        String type = merchantDetailsScreen.getMerchantCuisineTypeFromOutletDetails();
        log.info("Type from the merchant details : "+type);
        beautyAndFitnessScreen = merchantDetailsScreen.goBackToBeautyAndFitnessScreenFromBottomScreen();
        beautyAndFitnessScreen.openFilters();
        beautyAndFitnessScreen.openFiltersType();
        Assert.assertTrue(type.contains(filter), "Merchant details does not have selected type"+type+" from filter selected ("+filter+")");
        beautyAndFitnessScreen.selectFilterTypeAllAndClose();
    }

    @Test(description = "Apply random amenity with yes", priority = 10)
    public void verifyRandomAmenityYesResults() throws InterruptedException {
        beautyAndFitnessScreen.openFilters();
        beautyAndFitnessScreen.clearAllFilters();
        beautyAndFitnessScreen.openFilters();
        String amenity = BeautyAndFitnessScreenConstants.AMENITIES[utils.generateRandomNumber(0,8)];
        log.info("Amenity to be selected : "+amenity);
        beautyAndFitnessScreen.selectSingleAmenity(amenity, "yes");
        beautyAndFitnessScreen.applyFilters();
        merchantDetailsScreen = beautyAndFitnessScreen.openRandomMerchantDetails();
        log.info("Merchant name : "+merchantDetailsScreen.getMerchantName());
        merchantDetailsScreen.scroll();
        merchantDetailsScreen.viewMoreAmenities();
        List<String> amenitiesOffered = merchantDetailsScreen.getAllAmenitiesOffered();
        if(!amenitiesOffered.isEmpty()) {
            log.info("Amenities offered : "+amenitiesOffered.toString());
        }
        beautyAndFitnessScreen = merchantDetailsScreen.goBackToBeautyAndFitnessScreenFromBottomScreen();
        beautyAndFitnessScreen.openFilters();
        beautyAndFitnessScreen.resetPositiveAmenities();
        beautyAndFitnessScreen.applyFilters();
        if(!amenitiesOffered.isEmpty()) {
            Assert.assertTrue(amenitiesOffered.contains(amenity));
        }
    }

    @Test(description = "Apply random amenity with no", priority = 11)
    public void verifyRandomAmenityNoResults() throws InterruptedException {
        beautyAndFitnessScreen.openFilters();
        beautyAndFitnessScreen.clearAllFilters();
        beautyAndFitnessScreen.openFilters();
        String amenity = BeautyAndFitnessScreenConstants.AMENITIES[utils.generateRandomNumber(0,8)];
        log.info("Amenity to be selected : "+amenity);
        beautyAndFitnessScreen.selectSingleAmenity(amenity,"no");
        beautyAndFitnessScreen.applyFilters();
        merchantDetailsScreen = beautyAndFitnessScreen.openRandomMerchantDetails();
        log.info("Merchant name : "+merchantDetailsScreen.getMerchantName());
        merchantDetailsScreen.scroll();
        merchantDetailsScreen.viewMoreAmenities();
        List<String> amenitiesOffered = merchantDetailsScreen.getAllAmenitiesOffered();
        if(!amenitiesOffered.isEmpty()) {
            log.info("Amenities offered : "+amenitiesOffered.toString());
        }
        beautyAndFitnessScreen = merchantDetailsScreen.goBackToBeautyAndFitnessScreenFromBottomScreen();
        beautyAndFitnessScreen.openFilters();
        beautyAndFitnessScreen.resetNegativeAmenities();
        beautyAndFitnessScreen.applyFilters();
        if(!amenitiesOffered.isEmpty()) {
            Assert.assertFalse(amenitiesOffered.contains(amenity));
        }
    }

    public List<String> noData() {
        List<String> noDataFilterType = new ArrayList<>();
        noDataFilterType.add("Medical & Dental");
        noDataFilterType.add("Men's Grooming");
        return noDataFilterType;
    }


    @AfterClass
    public void navigateToProfileDetails(){
        homeScreen = beautyAndFitnessScreen.goBackToHomeScreen();
        profileScreen = homeScreen.openProfileScreen();
        profileDetailsScreen = profileScreen.openProfileDetails();
    }
}
