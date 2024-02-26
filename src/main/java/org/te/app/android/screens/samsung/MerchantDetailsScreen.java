package org.te.app.android.screens.samsung;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.te.app.android.mobileGestures.AndroidActions;

public class MerchantDetailsScreen extends AndroidActions {

    public AndroidDriver androidDriver;


    public MerchantDetailsScreen(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
    }

    private WebElement favourite(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/ivFavourit"));
    }

    private WebElement backButton(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/ivBack"));
    }




    public void addToFavourite(){
        favourite().click();
    }

    public void removeFromFavourite(){
        favourite().click();
    }

    public boolean isMerchantFavourite(){
        return favourite().isSelected();
    }

    public SearchScreen goBackToSearchScreen(){
        backButton().click();
        return new SearchScreen(androidDriver);
    }

    public FavouriteScreen goBackToFavouriteScreen(){
        backButton().click();
        return new FavouriteScreen(androidDriver);
    }

}
