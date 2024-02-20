package org.te.app.android.screens.samsung;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.te.app.android.mobileGestures.AndroidActions;

import java.time.Duration;
import java.util.List;

public class ProfileScreen extends AndroidActions {

    public AndroidDriver androidDriver;
    public ProfileScreen(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
    }


    private WebElement logoutBtn(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/sign_out"));
    }

    private WebElement logoutYesBtn(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/textview_popup_yes"));
    }

    private WebElement logoutNoBtn(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/textview_popup_no"));
    }

    private WebElement logoutMessage(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/textview_error_message"));
    }

    private WebElement profileFirstAndLastName(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_user_name"));
    }

    private WebElement profileEmailAddress(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_user_email"));
    }

    private WebElement profileDetail(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/btn_profile_detail"));
    }

    private WebElement profileResetPassword(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/btn_reset_pass"));
    }

    private WebElement profileWallet(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/btn_wallet"));
    }

    private WebElement profileActivateCode(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/btn_activate_samsung"));
    }

    private WebElement profileFavorite(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/btn_favourites"));
    }



    private WebElement footerBar(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tabs_bottom_home"));
    }

    private WebElement footerHomeText(){
        return footerBar().findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/tv_tab_name\" and @text=\"Home\"]"));
    }



    public void confirmLogOut(){
        logoutYesBtn().click();
    }

    public void declineLogout(){
        logoutNoBtn().click();
    }

    public void logoutFromApp(){
        performMultipleScrolls(2);
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn()));
        logoutBtn().click();
        confirmLogOut();
    }

    public String getLogoutMessage(){
        return logoutMessage().getText().trim();
    }
    public String getUserFirstAndLastName(){
        return profileFirstAndLastName().getText().trim();
    }

    public String getUserEmailAddress(){
        return profileEmailAddress().getText().trim();
    }

    public ProfileDetailsScreen openProfileDetails(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        profileDetail().click();

        return new ProfileDetailsScreen(androidDriver);
    }

    public void openResetPassword(){
        profileResetPassword().click();
    }

    public void openWallet(){
        profileWallet().click();
    }

    public void openActivateSamsungCode(){
        profileActivateCode().click();
    }

    public FavouriteScreen openFavorites(){
        profileFavorite().click();
        return new FavouriteScreen(androidDriver);
    }

    public HomeScreen goBackToHomeScreen(){
        footerHomeText().click();
        return new HomeScreen(androidDriver);
    }

}
