package org.te.app.android.screens.samsung;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.te.app.android.mobileGestures.AndroidActions;

import java.time.Duration;

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

}
