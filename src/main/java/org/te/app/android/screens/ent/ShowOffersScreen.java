package org.te.app.android.screens.ent;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.te.app.android.mobileGestures.AndroidActions;

import java.util.List;

public class ShowOffersScreen extends AndroidActions {

    AndroidDriver androidDriver;

    public ShowOffersScreen(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
    }

    private WebElement descriptionBox(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/cvDescrption"));
    }

    private WebElement descriptionTitle(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvCardHeading"));
    }

    private WebElement descriptionText(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvCardDescription"));
    }

    private WebElement btnNotifyMe(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/btnNotifyMe"));
    }

    private WebElement skipForNow(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvSkipForNow"));
    }

    private WebElement sendNotificationPopUp(){
        return androidDriver.findElement(By.id("com.android.permissioncontroller:id/grant_dialog"));
    }

    private WebElement popUpIcon(){
        return androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_icon"));
    }

    private WebElement popUpMessage(){
        return androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_message"));
    }

    private List<WebElement> popUpButtons(){
        return androidDriver.findElements(By.className("android.widget.Button"));
    }

    private WebElement allowBtn(){
        return androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
    }

    private WebElement denyButton(){
        return androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button"));
    }





    public boolean descriptionBoxIsBeingDisplayed(){
        return descriptionBox().isDisplayed();
    }

    public String getDescriptionTitle(){
        return descriptionTitle().getText().replace("\n", " ").trim();
    }

    public String getDescriptionText(){
        return descriptionText().getText().replace("\n", " ").trim();
    }

    public String getBtnTextNotifyMe(){
        return btnNotifyMe().getText().trim();
    }

    public void clickBtnNotifyMe(){
        btnNotifyMe().click();
    }

    public String getSkipForNowText(){
        return skipForNow().getText().trim();
    }

    public void clickSkipForNow(){
        skipForNow().click();
    }

    public boolean popUpDisplayedForNotifications(){
        return sendNotificationPopUp().isDisplayed();
    }

    public boolean iconDisplayedForNotifications(){
        return popUpIcon().isDisplayed();
    }

    public String getPopUpText(){
        return popUpMessage().getText().replace("\n", " ").trim();
    }

    public int totalButtonsOnNotificationsPopup(){
        return popUpButtons().size();
    }

    public HomeScreen clickAllowBtn(){
        allowBtn().click();
        return new HomeScreen(androidDriver);
    }

    public String allowBtnText(){
        return allowBtn().getText().trim();
    }

    public void clickDenyButton(){
        denyButton().click();
    }

    public String denyBtnText(){
        return denyButton().getText().trim();
    }

}
