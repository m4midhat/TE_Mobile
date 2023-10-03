package org.te.app.android.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EnableLocationScreen {
    AndroidDriver androidDriver;
    public EnableLocationScreen(AndroidDriver driver){
        this.androidDriver = driver;
    }

    private WebElement title(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvTitle"));
    }

    private WebElement subTitle(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvSubTitle"));
    }

    private WebElement btnShowOffers(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvPrimary"));
    }

    private WebElement btnSkip(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvSkipForNow"));
    }

    private WebElement grantPermissionDialog(){
        return androidDriver.findElement(By.id("com.android.permissioncontroller:id/grant_dialog"));
    }

    private WebElement permissionMsg(){
        return androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_message"));
    }

    private WebElement preciseLocation(){
        return androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_location_accuracy_radio_fine"));
    }

    private WebElement approximateLocation(){
        return androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_location_accuracy_radio_coarse"));
    }

    private WebElement permissionLocationIcon(){
        return androidDriver.findElement(By.id("com.android.permissioncontroller:id/permission_icon"));
    }

    private List<WebElement> permissionButtons(){
        return androidDriver.findElements(By.className("android.widget.Button"));
    }








    public String getTitle(){
        return title().getText().replace("\n", " ").trim();
    }

    public String getSubTitle(){
        return subTitle().getText().replace("\n", " ").trim();
    }

    public String getBtnTextShowOffers(){
        return btnShowOffers().getText().trim();
    }

    public void clickBtnShowOffers(){
        btnShowOffers().click();
    }

    public String getBtnSkipText(){
        return btnSkip().getText().trim();
    }

    public boolean permissionPopupIsBeingDisplayed(){
        return grantPermissionDialog().isDisplayed();
    }

    public String getPermissionMsgText(){
        return permissionMsg().getText().replace("\n", " ").trim();
    }

    public boolean preciseLocationOptionIsDisplayed(){
        return preciseLocation().isDisplayed();
    }

    public boolean approxLocationOptionIsDisplayed(){
        return approximateLocation().isDisplayed();
    }

    public boolean permissionLocationIconIsDisplayed(){
        return permissionLocationIcon().isDisplayed();
    }

    public int permissionButtonsCount(){
        List<WebElement> btns = permissionButtons();
        return btns.size();
    }

    public String permissionButtonsText(int index){
        List<WebElement> btns = permissionButtons();
        return btns.get(index).getText().trim();
    }

    public ShowOffersScreen clickPermissionBtn(int index){
        List<WebElement> btns = permissionButtons();
        btns.get(index).click();
        return new ShowOffersScreen(androidDriver);
    }

}
