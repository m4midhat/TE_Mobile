package org.te.app.android.screens.samsung;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class loginScreen {

    public AndroidDriver androidDriver;
    public loginScreen(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
    }


    public WebElement txtEmailAddress(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/et_email"));
    }

    public WebElement txtPassword(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/et_password"));
    }

    public WebElement chkBoxPrivacyPolicy(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/checkbox_privacy_policy"));
    }



    public boolean samsungIconAvailable(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/ivSamsung")).isDisplayed();
    }

    public boolean entertainerIconAvailable(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/ivEntertainer")).isDisplayed();
    }

    public boolean welcomeTextAvailable(){
        return androidDriver.findElement(By.xpath("//android.widget.TextView[@text=\"Welcome\" and @class=\"android.widget.TextView\"]")).isDisplayed()
    }

    public boolean emailAddressTextBoxAvailable(){
        return txtEmailAddress().isDisplayed();
    }

    public boolean passwordTextBoxAvailable(){
        return txtPassword().isDisplayed();
    }

}
