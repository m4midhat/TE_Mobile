package org.te.app.android.tests.appTests;

import org.te.app.android.assertionConstants.showOffersScreenConstants;
import org.te.app.android.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShowOffersTest extends BaseTest {

    @Test(description = "Description Box Is Being Displayed")
    public void descriptionBoxIsBeingDisplayed(){
        Assert.assertTrue(showOffersScreen.descriptionBoxIsBeingDisplayed());
    }

    @Test(description = "verify Description Title")
    public void verifyDescriptionTitle(){
        Assert.assertEquals(showOffersScreen.getDescriptionTitle(), showOffersScreenConstants.PreviewHeader);
    }

    @Test(description = "verify Description sub-title")
    public void verifyDescriptionSubTitle(){
        Assert.assertEquals(showOffersScreen.getDescriptionText(), showOffersScreenConstants.PreviewSubText);
    }

    @Test(description = "verify notify me button")
    public void verifyNotifyMeButtonText(){
        Assert.assertEquals(showOffersScreen.getBtnTextNotifyMe(), showOffersScreenConstants.NotifyMe);
    }

    @Test(description = "verify skip button")
    public void verifySkipButtonText(){
        Assert.assertEquals(showOffersScreen.getSkipForNowText(), showOffersScreenConstants.SkipForNow);
    }

    @Test(priority = 1, description = "Click on Continue button to view next activity")
    public void clickNotifyMe()  {
        showOffersScreen.clickBtnNotifyMe();

    }

    @Test(priority = 2, description = "Verify the pop-up is being displayed to send notifications")
    public void popupIsShownForNotifications(){
        Assert.assertTrue(showOffersScreen.popUpDisplayedForNotifications());
    }

    @Test(priority = 3, description = "Verify the icon on the pop-up")
    public void iconIsBeingDisplayedOnPopUp(){
        Assert.assertTrue(showOffersScreen.iconDisplayedForNotifications());
    }

    @Test(priority = 3, description = "Verify the text on the pop-up")
    public void verifyTextUnderPopUp(){
        Assert.assertEquals(showOffersScreen.getPopUpText(), showOffersScreenConstants.SendNotificationsPopUpText);
    }

    @Test(priority = 3, description = "Verify there should only be 2 buttons on pop-up")
    public void verifyButtonCount(){
        Assert.assertEquals(showOffersScreen.totalButtonsOnNotificationsPopup(), 2);
    }

    @Test(priority = 3, description = "Verify allow button text")
    public void verifyAllowButtonText(){
        Assert.assertEquals(showOffersScreen.allowBtnText(), showOffersScreenConstants.AllowBtn);
    }

    @Test(priority = 3, description = "Verify deny button text")
    public void verifyDenyButtonText(){
        Assert.assertEquals(showOffersScreen.denyBtnText(), showOffersScreenConstants.DenyBtn);
    }

    @Test(priority = 4, description = "Continue on the next screen")
    public void continueToNextScreen() throws InterruptedException {
        homeScreen = showOffersScreen.clickAllowBtn();
        Thread.sleep(5000);
    }

}
