package org.te.app.android.tests.samsung.appTests;

import lombok.extern.slf4j.Slf4j;
import org.te.app.android.assertionConstants.samsung.HomeScreenConstants;
import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class HomeTest extends SamsungBaseTest {

    @Test(description = "Verify location popup is displayed")
    public void verifyLocationPopupAppears(){
        Assert.assertTrue(homeScreen.isLocationPopupDisplayed(), "Location popup is not displayed" );
    }

    @Test(description = "Verify location popup title", dependsOnMethods = "verifyLocationPopupAppears")
    public void verifyLocationPopupTitle(){
        String title = homeScreen.getLocationPopupTitle();
        log.info(title);
        Assert.assertEquals(title, HomeScreenConstants.LOCATION_POPUP_TITLE, "Incorrect title for location pop-up");
    }

    @Test(description = "Verify location popup error message", dependsOnMethods = "verifyLocationPopupAppears")
    public void verifyLocationPopupMessage(){
        String msg = homeScreen.getLocationPopupErrorMessage();
        log.info(msg);
        Assert.assertEquals(msg, HomeScreenConstants.LOCATION_POPUP_ERROR, "Incorrect error message for location pop-up");
    }

    @Test(description = "Verify location popup Yes button", dependsOnMethods = "verifyLocationPopupAppears")
    public void verifyLocationPopupYesButton(){
        String btnYes = homeScreen.getYesButtonText();
        log.info(btnYes);
        Assert.assertEquals(btnYes, HomeScreenConstants.LOCATION_POPUP_YES_BTN, "Incorrect button text for 'Yes' button under location pop-up");
    }

    @Test(description = "Verify location popup Yes button", dependsOnMethods = "verifyLocationPopupAppears")
    public void verifyLocationPopupDontAskAgainButton(){
        String btnDontAsk = homeScreen.getDontAskButtonText();
        log.info(btnDontAsk);
        Assert.assertEquals(btnDontAsk, HomeScreenConstants.LOCATION_POPUP_DONT_ASK_BTN, "Incorrect button text for 'Dont Ask Again' button under location pop-up");
    }

    @Test(description = "Verify location popup Cancel button", dependsOnMethods = "verifyLocationPopupAppears")
    public void verifyLocationPopupCancelButton(){
        String btnCancel = homeScreen.getCancelButtonText();
        log.info(btnCancel);
        Assert.assertEquals(btnCancel, HomeScreenConstants.LOCATION_POPUP_CANCEL_BTN, "Incorrect button text for 'Cancel' button under location pop-up");
    }

    @Test(description = "Verify Access Location Popup", priority = 1)
    public void verifyLocationAccessPopup(){
        homeScreen.clickYesButton();
    }

    @Test(description = "Verify grant access popup is being displayed", priority = 2)
    public void verifyGrantPopUpAccessIsBeingDisplayed(){
        Assert.assertTrue(homeScreen.isGrantLocationAccessPopupDisplayed());
    }

    @Test(description = "Verify grant access popup is being displayed", priority = 2, dependsOnMethods = "verifyGrantPopUpAccessIsBeingDisplayed")
    public void verifyGrantPopUpAccessHasIcon(){
        Assert.assertTrue(homeScreen.isGrantLocationAccessPopupHasIcon());
    }

    @Test(description = "Verify grant access popup message is correct", priority = 2, dependsOnMethods = "verifyGrantPopUpAccessIsBeingDisplayed")
    public void verifyGrantPopUpAccessMessageIsCorrect(){
        String error = homeScreen.getGrantLocationAccessPopupTitle();
        log.info(error);
        Assert.assertEquals(error, HomeScreenConstants.GRANT_LOCATION_POPUP_TITLE);
    }

    @Test(description = "Verify grant access popup has precise location option", priority = 2, dependsOnMethods = "verifyGrantPopUpAccessIsBeingDisplayed")
    public void verifyGrantPopUpAccessOption1(){
        Assert.assertTrue  (homeScreen.isGrantLocationAccessPopUpHasPreciseLocation());
    }

    @Test(description = "Verify grant access popup has approx location option", priority = 2, dependsOnMethods = "verifyGrantPopUpAccessIsBeingDisplayed")
    public void verifyGrantPopUpAccessOption2(){
        Assert.assertTrue(homeScreen.isGrantLocationAccessPopUpHasApproxLocation());
    }

    @Test(description = "Verify grant access popup Button for while using app", priority = 2, dependsOnMethods = "verifyGrantPopUpAccessIsBeingDisplayed")
    public void verifyGrantPopUpAccessWhileUsingAppBtn(){
        String btnText = homeScreen.getGrantLocationAccessButtonForWhileUsingApp();
        log.info(btnText);
        Assert.assertEquals(btnText, HomeScreenConstants.GRANT_LOCATION_POPUP_BTN_WHILE_USING_APP);
    }

    @Test(description = "Verify grant access popup Button for Only this time", priority = 2, dependsOnMethods = "verifyGrantPopUpAccessIsBeingDisplayed")
    public void verifyGrantPopUpAccessOnlyThisTimeBtn(){
        String btnText = homeScreen.getGrantLocationAccessButtonForOnlYThisTime();
        log.info(btnText);
        Assert.assertEquals(btnText, HomeScreenConstants.GRANT_LOCATION_POPUP_BTN_ONLY_THIS_TIME);
    }

    @Test(description = "Verify grant access popup Button for Dont allow", priority = 3, dependsOnMethods = "verifyGrantPopUpAccessIsBeingDisplayed")
    public void verifyGrantPopUpAccessDontAllowBtn(){
        String btnText = homeScreen.getGrantLocationAccessButtonForDontAllow();
        log.info(btnText);
        Assert.assertEquals(btnText, HomeScreenConstants.GRANT_LOCATION_POPUP_BTN_DONT_ALLOW);
        homeScreen.clickGrantLocationAccessWhileUsingApp();
    }




}
