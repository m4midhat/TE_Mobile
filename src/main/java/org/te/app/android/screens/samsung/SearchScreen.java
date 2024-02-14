package org.te.app.android.screens.samsung;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.te.app.android.mobileGestures.AndroidActions;

import java.util.ArrayList;
import java.util.List;

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





    public HomeScreen pressBack(){
        backIcon().click();
        return new HomeScreen(androidDriver);
    }

    public void searchForTerm(String keyword) throws InterruptedException {
        searchTextBox().click();
        searchTextBox().sendKeys(keyword);
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(5000);
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
}
