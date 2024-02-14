package org.te.app.android.screens.samsung;

import com.aventstack.extentreports.gherkin.model.And;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.te.app.android.mobileGestures.AndroidActions;
import org.te.app.android.utils.utils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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

    private WebElement headerContainer(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/clHeader"));
    }

    private WebElement headerSamsungIcon(){
        return headerContainer().findElement(By.id("com.theentertainerme.sckentertainer:id/ivHeaderLogoMain"));
    }

    private WebElement headerSavingDescription(){
        return headerContainer().findElement(By.id("com.theentertainerme.sckentertainer:id/tvSavingDes"));
    }

    private WebElement headerSavingAmount(){
        return headerContainer().findElement(By.id("com.theentertainerme.sckentertainer:id/tvSaving"));
    }

    private WebElement headerLocation(){
        return headerContainer().findElement(By.id("com.theentertainerme.sckentertainer:id/tv_search_location"));
    }

    private WebElement headerSearchIcon(){
        return headerContainer().findElement(By.id("com.theentertainerme.sckentertainer:id/iv_search_app_bar"));
    }

    private WebElement headerNotificationIcon(){
        return headerContainer().findElement(By.id("com.theentertainerme.sckentertainer:id/ivNotification"));
    }

    private WebElement samsungAdHeader(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/ivHeader"));
    }

    private WebElement footerBar(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tabs_bottom_home"));
    }

    private WebElement footerHomeIcon(){
        return footerBar().findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"app!\"])[5]"));
    }

    private WebElement footerHomeText(){
        return footerBar().findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/tv_tab_name\" and @text=\"Home\"]"));
    }

    private WebElement footerDeliveryIcon(){
        return footerBar().findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"app!\"])[6]"));
    }

    private WebElement footerDeliveryText(){
        return footerBar().findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/tv_tab_name\" and @text=\"Delivery\"]"));
    }

    private WebElement footerTravelIcon(){
        return footerBar().findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"app!\"])[7]"));
    }

    private WebElement footerTravelText(){
        return footerBar().findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/tv_tab_name\" and @text=\"Travel\"]"));
    }

    private WebElement footerProfileIcon(){
        return footerBar().findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"app!\"])[8]"));
    }

    private WebElement footerProfileText(){
        return footerBar().findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/tv_tab_name\" and @text=\"Profile\"]"));
    }

    private WebElement sectionCategory(){
        return androidDriver.findElement(By.xpath("(//android.view.ViewGroup[@class=\"android.view.ViewGroup\"])[6]"));
    }

    private WebElement sectionFeaturedOffers(){
        return androidDriver.findElement(By.xpath("(//android.view.ViewGroup[@class=\"android.view.ViewGroup\"])[11]"));
    }

    private WebElement sectionSamsungOffers(){
        return androidDriver.findElement(By.xpath("(//android.view.ViewGroup[@class=\"android.view.ViewGroup\"])[12]"));
    }

    private WebElement sectionTitleCategories(){
        return sectionCategory().findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/tvLiveUp\" and @text=\"Categories\"]"));
    }

    private WebElement sectionTitleFeaturedOffers(){
        return sectionFeaturedOffers().findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/tvLiveUp\" and @text=\"Featured Offers\"]"));
    }

    private WebElement categoriesCarousel(){
        return sectionCategory().findElement(By.xpath("((//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.theentertainerme.sckentertainer:id/rvLiveItUp\"])[2]"));
    }

    private List<WebElement> categoryCarouselImages(){
        return sectionCategory().findElements(By.xpath("//android.widget.ImageView"));
    }

    private List<WebElement> categoryCarouselTexts(){
        return sectionCategory().findElements(By.xpath("//android.widget.TextView"));
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
    public String getSavingText(){
        return headerSavingDescription().getText().trim();
    }

    public String getSavingAmount(){
        return headerSavingAmount().getText().trim();
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

    public List<String> getAllCategories() throws InterruptedException {
        List<String> categories = new ArrayList<>();
        List<WebElement> elemCategories = categoryCarouselTexts();
        String toBounds, fromBounds;
        List<Integer> sourceCoordinates = new ArrayList<>();
        List<Integer> destinationCoordinates = new ArrayList<>();
        for(int i=1;i<=3;i++){
            log.info(elemCategories.get(i).getText().trim());
            categories.add(elemCategories.get(i).getText().trim());
            if(i==1){
                toBounds = elemCategories.get(i).getAttribute("bounds");
                log.info(toBounds);
                destinationCoordinates = utils.extractBounds(toBounds);
            }
            if(i==3){
                fromBounds = elemCategories.get(i).getAttribute("bounds");
                log.info(fromBounds);
                sourceCoordinates = utils.extractBounds(fromBounds);
                swipeTwoCoordinates(sourceCoordinates, destinationCoordinates);
                Thread.sleep(1000);
                elemCategories = categoryCarouselTexts();
                for(int j=1;j<elemCategories.size();j++){
                    if(!categories.contains(elemCategories.get(j).getText().trim())){
                        log.info(elemCategories.get(j).getText().trim());
                        categories.add(elemCategories.get(j).getText().trim());
                    }
                }
            }

        }

        return categories;
    }


    public ProfileScreen openProfileScreen(){
        footerProfileText().click();
        return new ProfileScreen(androidDriver);
    }

    public String getLocationText(){
        return headerLocation().getText().trim();
    }
    public SearchScreen clickSearchIcon(){
        headerSearchIcon().click();
        return new SearchScreen(androidDriver);
    }

}
