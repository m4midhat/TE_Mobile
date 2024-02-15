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
        return androidDriver.findElements(By.id("com.theentertainerme.sckentertainer:id/textview_offername"));
    }

    private List<WebElement> merchantLocation(){
        return androidDriver.findElements(By.id("com.theentertainerme.sckentertainer:id/textview_offer_location"));
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
        Thread.sleep(7500);
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
        List<String > searchResults = new ArrayList<>();
        List<WebElement > names = new ArrayList<>();
        List<WebElement> loc = new ArrayList<>();
                for(int searchCount = 0;searchCount<scrollCount;searchCount++) {  //search & scroll 5 times
                    names = merchantName();
                    loc = merchantLocation();
                    for (int i = 0; i < names.size(); i++) {
                        if(!searchResults.contains(names.get(i).getText().trim() + ":" + loc.get(i).getText().trim())) {
                            searchResults.add(names.get(i).getText().trim() + ":" + loc.get(i).getText().trim());
                        }
                    }
                    scroll();
                }
        return searchResults;
    }
}
