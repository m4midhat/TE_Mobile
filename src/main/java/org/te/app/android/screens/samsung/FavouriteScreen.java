package org.te.app.android.screens.samsung;

import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.te.app.android.mobileGestures.AndroidActions;
import org.te.app.android.utils.utils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FavouriteScreen extends AndroidActions {

    public AndroidDriver androidDriver;
    public FavouriteScreen(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
    }

    private WebElement favCleared(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/recycler_outlets"));
    }

    private List<WebElement> favouriteList(){
        return androidDriver.findElements(By.id("com.theentertainerme.sckentertainer:id/tv_merchent_name"));
    }

    private WebElement btnBack(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/iv_back"));
    }

    public List<String> getFavourites(){
        List<String> res = new ArrayList<>();
        List<WebElement> merchants = favouriteList();
        for(WebElement mer:merchants){
            res.add(mer.getText().trim());
        }
        return res;
    }

    public MerchantDetailsScreen openMerchantDetail(WebElement merchantName){
        merchantName.click();
        return new MerchantDetailsScreen(androidDriver);
    }

    public void removeRandomlyFromFavourite(){
        List<WebElement> merchants = favouriteList();
        int randomIndex = utils.generateRandomNumber(0, merchants.size()-1);

            log.info("Removing "+merchants.get(randomIndex).getText().trim()+" from favourites ...");
            MerchantDetailsScreen merchantDetailsScreen = openMerchantDetail(merchants.get(randomIndex));
            merchantDetailsScreen.removeFromFavourite();
            merchantDetailsScreen.goBackToFavouriteScreen();

    }


    public ProfileScreen goBackToProfileScreen(){
        btnBack().click();
        return new ProfileScreen(androidDriver);
    }

}
