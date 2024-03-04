package org.te.app.android.screens.samsung;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.te.app.android.mobileGestures.AndroidActions;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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

    private WebElement attributes(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/attritubtesCotainer"));
    }

    private List<WebElement> allAttributes(){
        return attributes().findElements(By.className("android.widget.TextView"));
    }

    private WebElement merchantName(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tvMerchantName"));
    }

    private WebElement outletName(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_outlet_name"));
    }

    private WebElement outletDetail(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/rl_nested_container"));
    }

    private WebElement outletDetailsHeading(){
        return outletDetail().findElement(By.id("com.theentertainerme.sckentertainer:id/tv_outlet_detail_title"));
    }

    private WebElement outletDetailsOutletName(){
        return outletDetail().findElement(By.id("com.theentertainerme.sckentertainer:id/tv_outlet_name"));
    }

    private WebElement outletDetailsLocations(){
        return outletDetail().findElement(By.id("com.theentertainerme.sckentertainer:id/tv_human_location"));
    }

    private WebElement outletDetailsHotel(){
        return outletDetail().findElement(By.id("com.theentertainerme.sckentertainer:id/tv_human_location"));
    }

    private WebElement outletDetailsArea(){
        return outletDetail().findElement(By.id("com.theentertainerme.sckentertainer:id/textview_area_outlet"));
    }

    private WebElement outletDetailsDistance(){
        return outletDetail().findElement(By.id("com.theentertainerme.sckentertainer:id/tv_distance_value"));
    }

    private WebElement outletDetailsCuisineType(){
        return outletDetail().findElement(By.id("com.theentertainerme.sckentertainer:id/tv_cuisine_value"));
    }

    private WebElement viewMoreAmenitiesBtn(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/iv_view_more"));
    }

    private List<WebElement> amenitiesText(){
        return androidDriver.findElements(By.xpath("//android.widget.GridView[@resource-id=\"com.theentertainerme.sckentertainer:id/recycler_attributes\"]//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/tv_filter_name\"]"));
    }




    public String getMerchantName(){
        return merchantName().getText().trim();
    }

    public String getMerchantOutletName(){
        return outletName().getText().trim();
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

    public FoodAndDrinksScreen goBackToFoodAndDrinksScreenFromBottomScreen(){
        log.info("Going back to food and drinks screen ...");
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
        return new FoodAndDrinksScreen(androidDriver);
    }

    public FoodAndDrinksScreen goBackToFoodAndDrinksScreen(){
        backButton().click();
        return new FoodAndDrinksScreen(androidDriver);
    }

    public FavouriteScreen goBackToFavouriteScreen(){
        backButton().click();
        return new FavouriteScreen(androidDriver);
    }

    public List<String> getMerchantAttributes(){
        List<String> merchantAttributes = new ArrayList<>();
        List<WebElement> attributesElements = allAttributes();
        for(WebElement attribute:attributesElements){
            merchantAttributes.add(attribute.getText().trim());
        }
        return merchantAttributes;
    }

    public String getMerchantNameFromOutletDetails(){
        return outletDetailsOutletName().getText().trim();
    }

    public String getMerchantLocationFromOutletDetails(){
        return outletDetailsLocations().getText().trim();
    }

    public String getMerchantHotelNameFromOutletDetails(){
        return outletDetailsHotel().getText().trim();
    }

    public String getMerchantAreaFromOutletDetails(){
        return outletDetailsArea().getText().trim();
    }

    public String getDistanceFromOutletDetails(){
        return outletDetailsDistance().getText().trim();
    }

    public String getMerchantCuisineTypeFromOutletDetails(){
        scroll();
        return outletDetailsCuisineType().getText().trim();
    }

    public void viewMoreAmenities(){
        viewMoreAmenitiesBtn().click();
    }

    public List<String> getAllAmenitiesOffered(){
        scroll();
        viewMoreAmenities();
        List<WebElement> amenitiesElements = amenitiesText();
        List<String> amenities = new ArrayList<>();
        for(WebElement element:amenitiesElements){
            amenities.add(element.getText().trim());
        }
        return amenities;
    }

}
