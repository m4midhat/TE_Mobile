package org.te.app.android.tests.appTests.prospectUser;

import org.te.app.android.assertionConstants.homeScreenConstants;
import org.te.app.android.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

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
        Assert.assertTrue(homeScreen.mainRootIsDisplayed(), "Main Root panel is not displayed");
        Assert.assertTrue(homeScreen.cardIsDisplayed(), "Card is not displayed");
        Assert.assertTrue(homeScreen.bannerImageIsDisplayed(), "Banner is not displayed");
        Assert.assertTrue(homeScreen.toolBarIsDisplayed(), "Toolbar is not displayed");
    }

}
