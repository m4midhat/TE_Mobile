package org.te.app.android.tests.appTests.prospectUser;

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
        String screenSubTitle = enableLocationScreen.getSubTitle();
        Assert.assertEquals(screenSubTitle, enableLocationScreenConstants.TurnOnLocationServices, "Incorrect screen sub-title, expected title : "+enableLocationScreenConstants.TurnOnLocationServices+" Received sub-title: "+ screenSubTitle);
    }

    @Test(priority = 2, description = "Verify show offers button text")
    public void verifyShowOffersBtnText(){
        String btnText = enableLocationScreen.getBtnTextShowOffers();
        Assert.assertEquals(btnText, enableLocationScreenConstants.BtnTextShowOffers, "Incorrect button text for show offers, expected title : "+enableLocationScreenConstants.BtnTextShowOffers+" Received title: "+btnText);
    }

    @Test(priority = 3, description = "Verify skip for now btn text")
    public void verifySkipForNowBtnText(){
        String btnText = enableLocationScreen.getBtnSkipText();
        Assert.assertEquals(btnText, enableLocationScreenConstants.BtnTextSkipForNow, "Incorrect button text for skip, expected title : "+enableLocationScreenConstants.BtnTextSkipForNow+" Received title: "+btnText);
    }

    @Test(priority = 4, description = "Click to switch on location services")
    public void clickShowNearByOffers() {
        enableLocationScreen.clickBtnShowOffers();
        Assert.assertTrue(enableLocationScreen.permissionPopupIsBeingDisplayed(), "Permission popup for switch on the location services is not visible");
    }

    @Test(priority = 5, description = "Verify text for location permission")
    public void verifyTextForLocationPermissionPopUp(){
        String popupText = enableLocationScreen.getPermissionMsgText();
        Assert.assertEquals(popupText, enableLocationScreenConstants.LocationEnableMsgText, "Incorrect text for location permission pop-up, expected value : "+enableLocationScreenConstants.LocationEnableMsgText+" Received value: "+popupText);
    }

    @Test(priority = 6, description = "Verify permission locations popup contains only 3 buttons")
    public void permissionLocationPopUp(){
        buttons = enableLocationScreen.permissionButtonsCount();
        Assert.assertEquals(buttons, 3, "Expected button counts : 3 but received : "+buttons);
    }

    @Test(priority = 7, description = "Verify icon is being shown at the top of pop up")
    public void iconToBeDisplayedAtTheTop(){
        Assert.assertTrue(enableLocationScreen.permissionLocationIconIsDisplayed(), "Icon is not being shown at the top of pop up");
    }

    @Test(priority = 8, description = "Verify the two options icons are being displayed")
    public void verifyTwoOptionsIons(){
        Assert.assertTrue(enableLocationScreen.preciseLocationOptionIsDisplayed(), "Option for precise location is not being displayed");
        Assert.assertTrue(enableLocationScreen.approxLocationOptionIsDisplayed(), "Option for approx location is not being displayed");
    }

    @Test(priority = 9, description = "Verify the options text")
    public void verifyOptionButtonsText(){
        for(int i = 0; i< buttons; i++){
            System.out.println(enableLocationScreenConstants.LocationsButtonOptionsText[i]);
            Assert.assertEquals(enableLocationScreen.permissionButtonsText(i), enableLocationScreenConstants.LocationsButtonOptionsText[i], "Allowing the location popup has incorrect button text, expected value : "+ enableLocationScreenConstants.LocationsButtonOptionsText[i]+" Received value: "+enableLocationScreen.permissionButtonsText(i));
        }
    }

    @Test(priority = 10, description = "Switch on location while using the app")
    public void switchOnLocationWhileUsingApp()  {
        showOffersScreen = enableLocationScreen.clickPermissionBtn(0);
    }

}
