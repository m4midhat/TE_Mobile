package org.te.app.android.screens.samsung;

import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.te.app.android.AppConstants.AppConstants;
import org.te.app.android.mobileGestures.AndroidActions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FashionRetailScreen extends AndroidActions {

    public AndroidDriver androidDriver;
    public FashionRetailScreen(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
    }

    private WebElement screenTitle(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_offer_cat"));
    }

    private List<WebElement> merchantName(){
        String locator="com.theentertainerme.sckentertainer:id/textview_offername";
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(androidDriver.findElement(By.id(locator))));
        return androidDriver.findElements(By.id(locator));
    }

    private List<WebElement> merchantLocation(){
        String locator = "com.theentertainerme.sckentertainer:id/textview_offer_location";
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(androidDriver.findElement(By.id(locator))));
        return androidDriver.findElements(By.id(locator));
    }

    private List<WebElement> merchantDistance(){
        String locator = "com.theentertainerme.sckentertainer:id/textview_distance";
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(androidDriver.findElement(By.id(locator))));
        return androidDriver.findElements(By.id(locator));
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







    public String getScreenTitle(){
        return screenTitle().getText().trim();
    }

    public HomeScreen goBackToHomeScreen(){
        footerHomeText().click();
        return new HomeScreen(androidDriver);
    }


    public List<String> getConsolidateSearchResults(){
        List<String > searchResults = new ArrayList<>();
        List<WebElement > names = new ArrayList<>();
        List<WebElement> loc = new ArrayList<>();
            names = merchantName();
            loc = merchantLocation();
            for (int i = 0; i < names.size()-1; i++) {
                if(!searchResults.contains(names.get(i).getText().trim() + ":" + loc.get(i).getText().trim())) {
                    searchResults.add(names.get(i).getText().trim() + ":" + loc.get(i).getText().trim());
                }
            }
        return searchResults;
    }

    public List<String> getConsolidateSearchResults(int scrollCount){
        List<String > searchResults = new ArrayList<>();
        List<WebElement > names = new ArrayList<>();
        List<WebElement> loc = new ArrayList<>();
        List<WebElement> distance = new ArrayList<>();
        names = merchantName();
        log.info("Merchant count : "+names.size());
        if(names.size()>=4) {
            for (int searchCount = 0; searchCount < scrollCount; searchCount++) {  //search & scroll x times
                names = merchantName();
                loc = merchantLocation();
                distance = merchantDistance();
                for (int i = 0; i < names.size()-1; i++) {
                    if (!searchResults.contains(names.get(i).getText().trim() + ":" + loc.get(i).getText().trim()+"("+ distance.get(i).getText().trim() +")")) {
                        log.info(names.get(i).getText().trim() + ":" + loc.get(i).getText().trim()+"("+ merchantDistance().get(i).getText().trim() +")");
                        searchResults.add(names.get(i).getText().trim() + ":" + loc.get(i).getText().trim()+"("+ merchantDistance().get(i).getText().trim() +")");
                    }
                }
                scroll();
            }
        }
        else
        {
            for (int i = 0; i < names.size() ; i++) {
                names = merchantName();
                loc = merchantLocation();
                distance = merchantDistance();
                //if (!searchResults.contains(names.get(i).getText().trim() + ":" + loc.get(i).getText().trim()+"("+ distance.get(i).getText().trim() +")")) {
                searchResults.add(names.get(i).getText().trim() + ":" + loc.get(i).getText().trim()+"("+ merchantDistance().get(i).getText().trim() +")");
                log.info(names.get(i).getText().trim() + ":" + loc.get(i).getText().trim()+"("+ merchantDistance().get(i).getText().trim() +")");
                //}
            }
        }
        return searchResults;
    }
}
