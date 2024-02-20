package org.te.app.android.screens.samsung;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.te.app.android.AppConstants.AppConstants;
import org.te.app.android.mobileGestures.AndroidActions;
import org.te.app.android.utils.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SearchScreen extends AndroidActions {

    public AndroidDriver androidDriver;

    public SearchScreen(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
    }

    private WebElement searchTextBox(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/et_search_keyword"));
    }

    private WebElement backIcon(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/iv_back"));
    }

    private WebElement searchFor(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_result_for"));
    }

    private WebElement searchTitle(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_search"));
    }

    private WebElement recentSearchResultsContainer(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/lv_1"));
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






    public HomeScreen pressBack(){
        log.info("Press back button to go back to home screen ...");
        backIcon().click();
        return new HomeScreen(androidDriver);
    }

    public void searchForTerm(String keyword) throws InterruptedException {
        searchTextBox().click();
        searchTextBox().sendKeys(keyword);
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(AppConstants.SEARCH_RESULTS_TIMEOUT);
    }


    public String getTitle(){
        return searchTitle().getText().trim();
    }

    public String getSearchFor(){
        return searchFor().getText().trim();
    }

    public List<String > getRecentSearches(){
        List<WebElement> searchResults = recentSearchResultsContainer().findElements(By.className("android.widget.TextView"));
        List<String> res = new ArrayList<>();
        for(WebElement element:searchResults)
            res.add(element.getText().trim());
        return res;
    }


    public List<String> getConsolidateSearchResults(int scrollCount){
        try {
            Thread.sleep(AppConstants.SEARCH_RESULTS_TIMEOUT);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<String > searchResults = new ArrayList<>();
        List<WebElement > names = new ArrayList<>();
        List<WebElement> loc = new ArrayList<>();
        List<WebElement> distance = new ArrayList<>();
        names = merchantName();
        if(names.size()>=4) {
            for (int searchCount = 0; searchCount < scrollCount; searchCount++) {  //search & scroll x times
                names = merchantName();
                loc = merchantLocation();
                distance = merchantDistance();
                for (int i = 0; i < names.size() - 1; i++) {
                    if (!searchResults.contains(names.get(i).getText().trim() + ":" + loc.get(i).getText().trim()+"("+ distance.get(i).getText().trim() +")")) {
                        searchResults.add(names.get(i).getText().trim() + ":" + loc.get(i).getText().trim()+"("+ merchantDistance().get(i).getText().trim() +")");
                    }
                }
                scroll();
            }
        }
        return searchResults;
    }


    public MerchantDetailsScreen openRandomMerchantDetails(){
        List<WebElement > names = new ArrayList<>();
        names = merchantName();
        int randomMerchant = utils.generateRandomNumber(0, names.size()-1);
        names.get(randomMerchant).click();
        return new MerchantDetailsScreen(androidDriver);
    }

}
