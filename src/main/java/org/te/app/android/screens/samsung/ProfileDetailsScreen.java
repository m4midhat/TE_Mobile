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

    public void goBackFromProfileDetails(){
        profileDetailBackButton().click();
    }

    public void closeUpdateCurrencyPreferencePopup(){
        currencyPopupCancelBtn().click();
    }


    public ProfileScreen updatePreferredCurrency(String currencyToBeUpdated) throws InterruptedException {
        profileDetailCurrencyPref().click();
        List<WebElement> currencies = androidDriver.findElements(By.id("com.theentertainerme.sckentertainer:id/textview_countryname"));
        for(WebElement currency:currencies){
            log.info(currency.getText());
            if(currency.getText().compareTo(currencyToBeUpdated)==0){
                androidDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/textview_countryname\" and @text=\""+currencyToBeUpdated+"\"]")).click();
            }
            else {
                scroll();
                currencies = androidDriver.findElements(By.id("com.theentertainerme.sckentertainer:id/textview_countryname"));
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

}