package org.te.app.android.tests.appTests;

import org.te.app.android.assertionConstants.homeScreenConstants;
import org.te.app.android.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test(description = "Verify if home screen popup is being displayed")
    public void verifyPopUpIsBeingDisplayed(){
        Assert.assertTrue(homeScreen.welcomeScreenPopUpDisplayed());
    }

    @Test(priority = 1, description = "Verify if popup title is matching up")
    public void verifyPopUpTitle(){
        Assert.assertEquals(homeScreen.getWelcomeScreenTitle(), homeScreenConstants.homeScreenPopUpTitle);
    }

    @Test(priority = 1, description = "Verify if popup description is matching up")
    public void verifyPopUpDescription(){
        Assert.assertEquals(homeScreen.getWelcomeScreenDescription(), homeScreenConstants.homeScreenPopUpDescription);
    }

    @Test(priority = 1, description = "Verify if popup has a cross btn")
    public void verifyPopUpHasCrossBtn(){
        Assert.assertTrue(homeScreen.welcomeScreenPopUpHasCross());
    }

    @Test(priority = 1, description = "Verify if popup has both buttons")
    public void verifyPopUpHasRequiredButtons(){
        Assert.assertTrue(homeScreen.btnSkipIsVisible());
        Assert.assertTrue(homeScreen.btnTakeTourIsVisible());
    }

    @Test(priority = 1, description = "Verify if both buttons under the popup screen is clickable")
    public void verifyPopUpButtonsAreClickable(){
        Assert.assertTrue(homeScreen.btnSkipIsClickable());
        Assert.assertTrue(homeScreen.btnTakeTourIsClickable());
    }

    @Test(priority = 1, description = "Verify button text for take tour")
    public void verifyBtnTextForTakeTour(){
        Assert.assertEquals(homeScreen.getBtnTakeTourText(),homeScreenConstants.btnTakeATour);
    }

    @Test(priority = 1, description = "Verify button text for skip")
    public void verifyBtnTextForSkip(){
        Assert.assertEquals(homeScreen.getBtnSkipText(),homeScreenConstants.btnSkip);
    }

    @Test(priority = 2, description = "Verify pop-up get disappear upon clicking cross button")
    public void verifyPopUpDisappearanceOnClickingCross(){
        homeScreen.clickCrossBtnForPopUp();
        Assert.assertTrue(homeScreen.mainRootIsDisplayed());
        Assert.assertTrue(homeScreen.cardIsDisplayed());
        Assert.assertTrue(homeScreen.bannerImageIsDisplayed());
        Assert.assertTrue(homeScreen.toolBarIsDisplayed());
    }

}
