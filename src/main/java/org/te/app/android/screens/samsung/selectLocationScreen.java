package org.te.app.android.screens.samsung;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.te.app.android.androidActions.AndroidActions;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class selectLocationScreen extends AndroidActions {

    AndroidDriver androidDriver;
    Logger logger = Logger.getLogger(String.valueOf(selectLocationScreen.class));
    public selectLocationScreen(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
    }


    private WebElement topMessage(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_serch_guide"));
    }

    private WebElement arrowSign(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/iv_arrow_location"));
    }

    private WebElement searchMessage(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_serch_location"));
    }

    private WebElement btnOK(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/btn_next_ok"));
    }

    private WebElement locationList(){
        return androidDriver.findElement(By.className("android.widget.ExpandableListView"));
    }





    public void clickOKButton(){
        btnOK().click();
    }

    public String getTopMessage(){
        return topMessage().getText().trim();
    }

    public boolean arrowSignAvailable(){
        return arrowSign().isDisplayed();
    }

    public String getScreenMessage(){
        return searchMessage().getText().trim();
    }

    public List<String> getLocationsList(){
        List<WebElement> listLocationsElement = locationList().findElements(By.className("android.widget.TextView"));
        List<String > locations = new ArrayList<>();
        for(WebElement location:listLocationsElement){
            locations.add(location.getText().trim());
        }
        return locations;
    }


}
