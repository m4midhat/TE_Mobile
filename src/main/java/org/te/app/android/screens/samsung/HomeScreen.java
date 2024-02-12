package org.te.app.android.screens.samsung;

import com.aventstack.extentreports.gherkin.model.And;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.te.app.android.mobileGestures.AndroidActions;

public class HomeScreen extends AndroidActions {
    public AndroidDriver androidDriver;

    public HomeScreen(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
    }

    private WebElement LocationPopup(){
        return androidDriver.findElement(By.xpath("(//android.widget.LinearLayout[@class=\"android.widget.LinearLayout\"])[3]"));
    }

    private WebElement LocationPopupTitle(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/textview_title_setting_pop"));
    }

    private WebElement LocationPopupErrorMessage(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/textview_error_message"));
    }

    private WebElement LocationPopupYesButton(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_yes_please"));
    }

    private WebElement LocationPopupDontAskAgainButton(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_popup_not_show"));
    }

    private WebElement LocationPopupCancelButton(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/textview_popup_cancel"));
    }

    private WebElement grantLocationAccessPopup(){
        return androidDriver.findElement(By.id("com.android.permissioncontroller:id/grant_dialog"));
    }

    private WebElement grantLocationAccessIcon(){
        return androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_icon"));
    }

    private WebElement grantLocationAccessMessage(){
        return androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_message"));
    }

    private WebElement grantLocationPreciseLocationIcon(){
        return androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_location_accuracy_radio_fine"));
    }

    private WebElement grantLocationApproxLocationIcon(){
        return androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_location_accuracy_radio_coarse"));
    }

    private WebElement grantLocationWhileUsingAppButton(){
        return androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
    }

    private WebElement grantLocationOnlyThisTimeButton(){
        return androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_one_time_button"));
    }

    private WebElement grantLocationDontAllowButton(){
        return androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button"));
    }





    public boolean isLocationPopupDisplayed(){
        return LocationPopup().isDisplayed();
    }

    public String getLocationPopupTitle(){
        return LocationPopupTitle().getText().trim();
    }

    public String getLocationPopupErrorMessage(){
        return LocationPopupErrorMessage().getText().trim();
    }

    public String getYesButtonText(){
        return LocationPopupYesButton().getText().trim();
    }

    public String getDontAskButtonText(){
        return LocationPopupDontAskAgainButton().getText().trim();
    }

    public String getCancelButtonText(){
        return LocationPopupCancelButton().getText().trim();
    }

    public void clickYesButton(){
        LocationPopupYesButton().click();
    }

    public void clickDontAskAgainButton(){
        LocationPopupDontAskAgainButton().click();
    }

    public void clickCancelButton(){
        LocationPopupYesButton().click();
    }

    public boolean isGrantLocationAccessPopupDisplayed(){
        return grantLocationAccessPopup().isDisplayed();
    }

    public String getGrantLocationAccessPopupTitle(){
        return grantLocationAccessMessage().getText().trim();
    }

    public boolean isGrantLocationAccessPopupHasIcon(){
        return grantLocationAccessIcon().isDisplayed();
    }

    public boolean isGrantLocationAccessPopUpHasPreciseLocation(){
        return grantLocationPreciseLocationIcon().isDisplayed();
    }

    public boolean isGrantLocationAccessPopUpHasApproxLocation(){
        return grantLocationApproxLocationIcon().isDisplayed();
    }

    public boolean isGrantLocationAccessPopupHasWhileUsingAppButton(){
        return grantLocationWhileUsingAppButton().isDisplayed();
    }

    public boolean isGrantLocationAccessPopupHasOnlyThisTimeButton(){
        return grantLocationOnlyThisTimeButton().isDisplayed();
    }

    public boolean isGrantLocationAccessPopupHasDontAllowButton(){
        return grantLocationDontAllowButton().isDisplayed();
    }

    public String getGrantLocationAccessButtonForWhileUsingApp(){
        return grantLocationWhileUsingAppButton().getText().trim();
    }

    public String getGrantLocationAccessButtonForOnlYThisTime(){
        return grantLocationOnlyThisTimeButton().getText().trim();
    }

    public String getGrantLocationAccessButtonForDontAllow(){
        return grantLocationDontAllowButton().getText().trim();
    }

    public void clickGrantLocationAccessWhileUsingApp(){
        grantLocationWhileUsingAppButton().click();
    }

    public void clickGrantLocationAccessOnlyThisTime(){
        grantLocationOnlyThisTimeButton().click();
    }

    public void clickGrantLocationAccessDontAllow(){
        grantLocationDontAllowButton().click();
    }
}
