package org.te.app.android.tests.appTests;

import org.te.app.android.assertionConstants.enableLocationScreenConstants;
import org.te.app.android.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnableLocationTest extends BaseTest {

    private int buttons;

    @Test(description = "Verify the title of the screen")
    public void verifyTitle(){
        String screenTitle = enableLocationScreen.getTitle();
        Assert.assertEquals(screenTitle, enableLocationScreenConstants.FindOffersNearYou, "Incorrect screen title, expected title: "+enableLocationScreenConstants.FindOffersNearYou+" Received title : "+screenTitle);
    }

    @Test(priority = 1, description = "Verify the sub-title of the screen")
    public void verifySubTitle(){
        Assert.assertEquals(enableLocationScreen.getSubTitle(), enableLocationScreenConstants.TurnOnLocationServices);
    }

    @Test(priority = 2, description = "Verify show offers button text")
    public void verifyShowOffersBtnText(){
        Assert.assertEquals(enableLocationScreen.getBtnTextShowOffers(), enableLocationScreenConstants.BtnTextShowOffers);
    }

    @Test(priority = 3, description = "Verify skip for now btn text")
    public void verifySkipForNowBtnText(){
        Assert.assertEquals(enableLocationScreen.getBtnSkipText(), enableLocationScreenConstants.BtnTextSkipForNow);
    }

    @Test(priority = 4, description = "Click to switch on location services")
    public void clickShowNearByOffers() throws InterruptedException {
        enableLocationScreen.clickBtnShowOffers();
        Assert.assertTrue(enableLocationScreen.permissionPopupIsBeingDisplayed());
    }

    @Test(priority = 5, description = "Verify text for location permission")
    public void verifyTextForLocationPermissionPopUp(){
        Assert.assertEquals(enableLocationScreen.getPermissionMsgText(), enableLocationScreenConstants.LocationEnableMsgText);
    }

    @Test(priority = 6, description = "Verify permission locations popup contains only 3 buttons")
    public void permissionLocationPopUp(){
        buttons = enableLocationScreen.permissionButtonsCount();
        Assert.assertEquals(buttons, 3);
    }

    @Test(priority = 7, description = "Verify icon is being shown at the top of pop up")
    public void iconToBeDisplayedAtTheTop(){
        Assert.assertTrue(enableLocationScreen.permissionLocationIconIsDisplayed());
    }

    @Test(priority = 8, description = "Verify the two options icons are being displayed")
    public void verifyTwoOptionsIons(){
        Assert.assertTrue(enableLocationScreen.preciseLocationOptionIsDisplayed());
        Assert.assertTrue(enableLocationScreen.approxLocationOptionIsDisplayed());
    }

    @Test(priority = 9, description = "Verify the options text")
    public void verifyOptionButtonsText(){
        for(int i = 0; i< buttons; i++){
            System.out.println(enableLocationScreenConstants.LocationsButtonOptionsText[i]);
            Assert.assertEquals(enableLocationScreen.permissionButtonsText(i), enableLocationScreenConstants.LocationsButtonOptionsText[i]);
        }
    }

    @Test(priority = 10, description = "Switch on location while using the app")
    public void switchOnLocationWhileUsingApp()  {
        showOffersScreen = enableLocationScreen.clickPermissionBtn(0);
    }

}
