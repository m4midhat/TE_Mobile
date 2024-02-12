package org.te.app.android.screens.samsung;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.te.app.android.mobileGestures.AndroidActions;

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

    private WebElement btnDone(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/btn_done_location"));
    }

    private WebElement checkBoxNationality(int index){
        List<WebElement> checkBoxes = androidDriver.findElements(By.className("android.widget.CheckBox"));
        return checkBoxes.get(index);
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
    public boolean isOKButtonAvailable(){ return btnOK().isDisplayed(); }

    public List<String> getLocationsList(){
        List<WebElement> listLocationsElement = locationList().findElements(By.className("android.widget.TextView"));
        List<String > locations = new ArrayList<>();
        for(WebElement location:listLocationsElement){
            locations.add(location.getText().trim());
        }
        return locations;
    }

    public HomeScreen clickDoneButton(){
        btnDone().click();
        return new HomeScreen(androidDriver);
    }

    public boolean isDoneButtonAvailable(){
        return btnDone().isDisplayed();
    }

    public String getBtnDoneText(){
        return btnDone().getText().trim();
    }

    public void selectNationalityCheckbox(int checkboxIndex){
        checkBoxNationality(checkboxIndex).click();
    }

    public boolean isCheckboxChecked(int checkboxIndex){
        return Boolean.parseBoolean(checkBoxNationality(checkboxIndex).getAttribute("checked"));
    }

    public int getAllLocationsCount(){
        return androidDriver.findElements(By.className("android.widget.CheckBox")).size();
    }

    public void allowNotifications(){
        androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
    }


}
