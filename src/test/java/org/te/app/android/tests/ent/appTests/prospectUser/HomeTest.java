package org.te.app.android.tests.ent.appTests.prospectUser;

import org.apache.log4j.Logger;
import org.te.app.android.assertionConstants.ent.homeScreenConstants;
import org.te.app.android.tests.baseTest.ent.EntertainerBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest extends EntertainerBaseTest {

    private static final Logger logger = Logger.getLogger(HomeTest.class);

    @Test(description = "Verify if home screen popup is being displayed")
    public void verifyPopUpIsBeingDisplayed(){
        Assert.assertTrue(homeScreen.welcomeScreenPopUpDisplayed(), "Home screen popup is not being displayed");
    }

    @Test(priority = 1, description = "Verify if popup title is matching up")
    public void verifyPopUpTitle(){
        String title = homeScreen.getWelcomeScreenTitle();
        Assert.assertEquals(title, homeScreenConstants.homeScreenPopUpTitle, "Incorrect popup title, expected title : "+title+" Received value : "+homeScreenConstants.homeScreenPopUpTitle);
    }

    @Test(priority = 1, description = "Verify if popup description is matching up")
    public void verifyPopUpDescription(){
        String description = homeScreen.getWelcomeScreenDescription();
        Assert.assertEquals(description, homeScreenConstants.homeScreenPopUpDescription, "Incorrect popup description, expected value : "+description+" Received value: "+homeScreenConstants.homeScreenPopUpDescription);
    }

    @Test(priority = 1, description = "Verify if popup has a cross btn")
    public void verifyPopUpHasCrossBtn(){
        Assert.assertTrue(homeScreen.welcomeScreenPopUpHasCross(), "Welcome screen popup does not have cross('x') button");
    }

    @Test(priority = 1, description = "Verify if popup has both buttons")
    public void verifyPopUpHasRequiredButtons(){
        Assert.assertTrue(homeScreen.btnSkipIsVisible(), "Welcome screen popup does not have skip button");
        Assert.assertTrue(homeScreen.btnTakeTourIsVisible(), "Welcome screen popup does not have take tour button");
    }

    @Test(priority = 1, description = "Verify if both buttons under the popup screen is clickable")
    public void verifyPopUpButtonsAreClickable(){
        Assert.assertTrue(homeScreen.btnSkipIsClickable(), "Welcome screen popup's skip button is not clickable");
        Assert.assertTrue(homeScreen.btnTakeTourIsClickable(), "Welcome screen popup's take tour button is not clickable");
    }

    @Test(priority = 1, description = "Verify button text for take tour")
    public void verifyBtnTextForTakeTour(){
        String btnText = homeScreen.getBtnTakeTourText();
        Assert.assertEquals(btnText, homeScreenConstants.btnTakeATour, "Incorrect button text for Take tour, expected value : "+ btnText+ " Received value: "+homeScreenConstants.btnTakeATour);
    }

    @Test(priority = 1, description = "Verify button text for skip")
    public void verifyBtnTextForSkip(){
        String btnText = homeScreen.getBtnSkipText();
        Assert.assertEquals(btnText, homeScreenConstants.btnSkip, "Incorrect button text for Skip, expected value : "+ btnText+" Received value : "+ homeScreenConstants.btnSkip);
    }

    @Test(priority = 2, description = "Verify pop-up get disappear upon clicking cross button")
    public void verifyPopUpDisappearanceOnClickingCross() {
        homeScreen.clickCrossBtnForPopUp();
        Assert.assertTrue(homeScreen.homeScreenElementIsDisplayed(), "Home screen is being displayed");
        Assert.assertTrue(homeScreen.savingBannerIsDisplayed(), "Saving banner is not getting displayed");
        Assert.assertTrue(homeScreen.heroBannerImageIsDisplayed(), "Banner is not getting displayed");
        Assert.assertTrue(homeScreen.toolBarIsDisplayed(), "Toolbar is not getting displayed");
        Assert.assertTrue(homeScreen.categoriesAreBeingDisplayed(), "Categories are not being displayed");
    }

    @Test(priority = 3, description = "Verify total categories are being displayed")
    public void verifyCategories(){
        int categories = homeScreen.totalCategoriesIcons();
        logger.info("Total categories found : "+ categories);
        Assert.assertEquals(categories, 6, "Total categories should be 6, instead received: "+ categories);
    }



    @Test(priority = 4, description = "Verify the count of hero banners")
    public void verifyHeroBannerCount(){
        int heroBanners = homeScreen.heroBannerCount();
        logger.info("Total hero banners : "+heroBanners);
        Assert.assertEquals(heroBanners, 6, "There should be 6 hero banners but "+heroBanners+" were received");
    }

    @Test(priority = 5, description = "Hero banner title verification")
    public void verifyHeroBannerTitles(){
        logger.info(homeScreen.getHeroBannerTitle());
    }

    @Test(priority = 5, description = "Hero banner sub title verification")
    public void verifyHeroBannerSubTitles(){
        logger.info(homeScreen.getHeroBannerSubTitle());
    }

    @Test(priority = 6, description = "Verify categories text")
    public void verifyCategoriesText(){
        List<String> categories = homeScreen.getCategoriesText();
        logger.info(categories);
    }

    @Test(priority = 7, description = "Verify categories text")
    public void locations() throws InterruptedException {
        homeScreen.locations();
    }

}
