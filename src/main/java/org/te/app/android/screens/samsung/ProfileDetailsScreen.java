package org.te.app.android.screens.samsung;

import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.te.app.android.mobileGestures.AndroidActions;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProfileDetailsScreen extends AndroidActions {

    public AndroidDriver androidDriver;
    public ProfileDetailsScreen(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
    }

    private WebElement screenTitle(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_header_title"));
    }

    private WebElement profileDetailFirstName(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/etFirstName"));
    }

    private WebElement profileDetailLastName(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/etLastName"));
    }

    private WebElement profileDetailEmail(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/etEmail"));
    }

    private WebElement profileDetailCOD(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/etCOR"));
    }

    private WebElement profileDetailCurrencyPref(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/etCurrencyPreference"));
    }

    private WebElement profileDetailBackButton(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/iv_back"));
    }

    private WebElement profileDetailUpdateCurrencyDoneButton(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/btn_done"));
    }

    private WebElement profileDetailDoneButton(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/btnUpdate"));
    }

    private WebElement currencyPopupCancelBtn(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/btn_cancal"));
    }

    private List<WebElement> currencies(){
        return androidDriver.findElements(By.id("com.theentertainerme.sckentertainer:id/textview_countryname"));
    }

    private WebElement currencyTickIcon(String currency){
        return androidDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/textview_countryname\" and @text=\""+currency+"\"]//following-sibling::android.widget.ImageView"));
    }





    public String getFirstNameFromProfileDetails(){
        return profileDetailFirstName().getText();
    }

    public String getLastNameFromProfileDetails(){
        return profileDetailLastName().getText();
    }

    public String getEmailAddressFromProfileDetails(){
        return profileDetailEmail().getText();
    }

    public String getCountryOfResidenceFromProfileDetails(){
        return profileDetailCOD().getText();
    }

    public String getPreferredCurrency(){
        return profileDetailCurrencyPref().getText();
    }

    public ProfileScreen goBackFromProfileDetails(){
        profileDetailBackButton().click();
        return new ProfileScreen(androidDriver);
    }

    public ProfileScreen closeUpdateCurrencyPreferencePopup(){
        currencyPopupCancelBtn().click();
        return new ProfileScreen(androidDriver);
    }

public void openCurrencyPreferences(){
    profileDetailCurrencyPref().click();
}
    public ProfileScreen updatePreferredCurrency(String currencyToBeUpdated) throws InterruptedException {
        profileDetailCurrencyPref().click();
        List<WebElement> currencies = currencies();
        for(WebElement currency:currencies){
            log.info(currency.getText());
            if(currency.getText().compareTo(currencyToBeUpdated)==0){
                androidDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/textview_countryname\" and @text=\""+currencyToBeUpdated+"\"]")).click();
            }
            else {
                scroll();
                currencies = currencies();
            }
        }
        profileDetailUpdateCurrencyDoneButton().click();
        profileDetailDoneButton().click();
        return new ProfileScreen(androidDriver);
    }

    public String getBtnSaveText(){
        return profileDetailDoneButton().getText().trim();
    }

    public boolean isBtnSaveDisplayed(){
        return profileDetailDoneButton().isEnabled();
    }

    public boolean isFirstNameEditable(){
        return profileDetailFirstName().isEnabled();
    }

    public boolean isLastNameEditable(){
        return profileDetailLastName().isEnabled();
    }

    public boolean isEmailEditable(){
        return profileDetailEmail().isEnabled();
    }

    public boolean isCODEditable(){
        return profileDetailCOD().isEnabled();
    }

    public boolean isCurrencyEditable(){
        return profileDetailCurrencyPref().isEnabled();
    }

    public String getScreenTitle(){
        return screenTitle().getText().trim();
    }
    public boolean currencySelectedIconVisible(String currency){
        return currencyTickIcon(currency).isDisplayed();
    }

}
