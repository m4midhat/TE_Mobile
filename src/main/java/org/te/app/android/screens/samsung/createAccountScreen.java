package org.te.app.android.screens.samsung;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.te.app.android.mobileGestures.AndroidActions;
import org.te.app.android.utils.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Slf4j
public class createAccountScreen extends AndroidActions {

    public AndroidDriver androidDriver;
    public List<String> countries = new ArrayList<>();
    Logger logger = Logger.getLogger(String.valueOf(createAccountScreen.class));


    public createAccountScreen(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
    }

    private WebElement title(){
        return androidDriver.findElements(By.xpath("//android.widget.LinearLayout[@resource-id=\"com.theentertainerme.sckentertainer:id/singup_container\"]/android.widget.TextView")).get(0);
    }

    private WebElement subTitle(){
        return androidDriver.findElements(By.xpath("//android.widget.LinearLayout[@resource-id=\"com.theentertainerme.sckentertainer:id/singup_container\"]/android.widget.TextView")).get(1);
    }

    private WebElement txtFirstName(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/et_first_name"));
    }

    private WebElement txtLastName(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/et_last_name"));
    }

    private WebElement txtEmailAddress(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/et_email"));
    }

    private WebElement txtVoucherCode(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/etVoucherCode"));
    }

    private WebElement voucherCodeInfo(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/icInfo"));
    }

    private WebElement txtPassword(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/et_password"));
    }

    private WebElement txtConfirmPassword(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/et_confirm_password"));
    }

    private WebElement checkBoxPrivacyPolicy(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/checkbox_privacy_policy"));
    }

    private WebElement checkBoxLicenseAgreement(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/checkbox_new_user"));
    }

    private WebElement lblPrivacyPolicy(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_privacy_policy"));
    }

    private WebElement lblLicenseAgreement(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_accept_terms"));
    }

    private WebElement btnRegister(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/btnAction"));
    }

    private WebElement dropDownCountryOfResidence(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/iv_arrow"));
    }

    private WebElement btnCloseCountryDropDown(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/ivClose"));
    }

    private WebElement lblFirstNameError(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tvFirstNameError"));
    }

    private WebElement lblLastNameError(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tvLastNameError"));
    }

    private WebElement lblEmailError(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tvEmailError"));
    }

    private WebElement lblPasswordError(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tvPasswordError"));
    }

    private WebElement lblConfirmPasswordError(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tvConPasswordError"));
    }

    private WebElement lblResidenceError(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tvCountError"));
    }

    private WebElement lblMinimumPasswordLengthError(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tvMinLenght"));
    }

    private WebElement lblLowerCasePasswordError(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tvLowerCase"));
    }

    private WebElement lblUpperCasePasswordError(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tvUpperCase"));
    }

    private WebElement lblIncludeDigitPasswordError(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tvIncludeNo"));
    }

    private WebElement lblIncludeSpecialCharacterPasswordError(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tvSepecialCharacter"));
    }






    public boolean samsungIconAvailable(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/ivSamsung")).isDisplayed();
    }

    public boolean entertainerIconAvailable(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/ivEntertainer")).isDisplayed();
    }

    public String getScreenTitle(){
        return title().getText().trim();
    }

    public String getScreenSubTitle(){
        return subTitle().getText().trim();
    }

    public void setFirstName(String firstName){
        txtFirstName().click();
        txtFirstName().sendKeys(firstName);
    }

    public void setLastName(String lastName){
        txtLastName().click();
        txtLastName().sendKeys(lastName);
    }

    public void setEmailAddress(String emailAddress){
        txtEmailAddress().click();
        txtEmailAddress().sendKeys(emailAddress);
    }

    public void setVoucherCode(String code){
        txtVoucherCode().click();
        txtVoucherCode().sendKeys(code);
    }

    public void clickOptionalVoucherCodeInfoButton(){
        voucherCodeInfo().click();
    }

    public void setPassword(String password){
        txtPassword().click();
        txtPassword().sendKeys(password);
    }

    public void setConfirmedPassword(String confirmedPassword){
        txtConfirmPassword().click();
        txtConfirmPassword().sendKeys(confirmedPassword);
    }

    public void agreeToPrivacyPolicy() throws InterruptedException {
        Thread.sleep(250);
        checkBoxPrivacyPolicy().click();
    }

    private void agreeToLicenseAgreement() throws InterruptedException {
        Thread.sleep(250);
        checkBoxLicenseAgreement().click();
    }

    public boolean isVoucherCodeOptionalInfoAvailable(){
        return voucherCodeInfo().isDisplayed();
    }

    public String  isPasswordFieldSetToPassword(){
        return txtPassword().getAttribute("password");
    }

    public String isConfirmedPasswordFieldSetToPassword(){
        return txtConfirmPassword().getAttribute("password");
    }

    public void openCountryOfResidenceDropDown(){
        dropDownCountryOfResidence().click();
    }

    public void closeCountryDropDown(){
        btnCloseCountryDropDown().click();
    }

    public List<String> getAllCountries(){
        List<WebElement> countriesElement = new ArrayList<>();

        for(int i=0;i<62;i++){
            countriesElement = androidDriver.findElements(By.id("com.theentertainerme.sckentertainer:id/tvCountName"));
            for(WebElement element:countriesElement) {
                if(!countries.contains(element.getText())) {
                    countries.add(element.getText());
                    logger.info(element.getText());
                }
            }
            scroll();
            countriesElement = androidDriver.findElements(By.id("com.theentertainerme.sckentertainer:id/tvCountName"));
        }
        return countries;
    }

    public void selectRandomResidency(){
        int randomIndex = utils.generateRandomNumber(0, 12);
        //int randomIndex = utils.generateRandomNumber(0, countries.size());

        String randomNationality = countries.get(randomIndex);
        System.out.println("Random Nationality : "+ randomNationality);
        openCountryOfResidenceDropDown();
        List<WebElement> countriesElement = new ArrayList<>();
        boolean selectionDone = false;
        for(int i=0;i<62;i++){
            if(!selectionDone) {
                countriesElement = androidDriver.findElements(By.id("com.theentertainerme.sckentertainer:id/tvCountName"));
                for (WebElement element : countriesElement) {
                    if (element.getText().compareTo(randomNationality) == 0) {
                        element.click();
                        selectionDone = true;
                        break;
                    }
                }
                scroll();
            }
            //countriesElement = androidDriver.findElements(By.id("com.theentertainerme.sckentertainer:id/tvCountName"));
        }
    }

    public String getPrivacyPolicyText(){
        return lblPrivacyPolicy().getText().trim();
    }

    public String getLicenseAgreementText(){
        return lblLicenseAgreement().getText().trim();
    }

    public void closePopup(){
        androidDriver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void clickRegisterButton(){
        btnRegister().click();
        closePopup();
    }

    public boolean isErrorForFirstNameVisible(){
        return lblFirstNameError().isDisplayed();
    }

    public String getErrorTextForFirstName(){
        return lblFirstNameError().getText();
    }

    public boolean isErrorForLastNameVisible(){
        return lblLastNameError().isDisplayed();
    }

    public String getErrorTextForLastName(){
        return lblLastNameError().getText();
    }

    public boolean isErrorForMinimumCharacterVisible(){
        return lblMinimumPasswordLengthError().isDisplayed();
    }

    public String getErrorTextForMinimumCharacter(){
        return lblMinimumPasswordLengthError().getText();
    }

    public boolean isErrorForLowerCaseCharacterVisible(){
        return lblLowerCasePasswordError().isDisplayed();
    }

    public String getErrorTextForLowerCaseCharacter(){
        return lblLowerCasePasswordError().getText();
    }

    public boolean isErrorForUpperCaseCharacterVisible(){
        return lblUpperCasePasswordError().isDisplayed();
    }

    public String getErrorTextForUpperCaseCharacter(){
        return lblUpperCasePasswordError().getText();
    }

    public boolean isErrorForDigitVisible(){
        return lblIncludeDigitPasswordError().isDisplayed();
    }

    public String getErrorTextForDigitCharacter(){
        return lblIncludeDigitPasswordError().getText();
    }


    public boolean isErrorForSpecialCharacterVisible(){
        return lblIncludeSpecialCharacterPasswordError().isDisplayed();
    }

    public String getErrorTextForSpecialCharacter(){
        return lblIncludeSpecialCharacterPasswordError().getText();
    }

    public boolean isErrorForConfirmPasswordVisible(){
        scrollToEndAction();
        return lblConfirmPasswordError().isDisplayed();
    }

    public String getErrorTextForConfirmPassword(){
        scrollToEndAction();
        return lblConfirmPasswordError().getText();
    }

    public boolean isErrorForNationalityVisible(){
        scrollToEndAction();
        return lblConfirmPasswordError().isDisplayed();
    }

    public String getErrorTextNationality(){
        scrollToEndAction();
        return lblConfirmPasswordError().getText();
    }



    public selectLocationScreen registerNewUser(String firstName, String lastName, String emailAddress, String voucherCode, String password) throws InterruptedException {
        setFirstName(firstName.replace("'",""));
        setLastName(lastName.replace("'",""));
        setEmailAddress(emailAddress);
        setVoucherCode(voucherCode);
        setPassword(password);
        hideKeyboard();
        setConfirmedPassword(password);
        hideKeyboard();
        selectRandomResidency();
        agreeToPrivacyPolicy();
        agreeToLicenseAgreement();

        log.info("Login in with the "+emailAddress+" : "+password);

        clickRegisterButton();
        Thread.sleep(7000);
        return new selectLocationScreen(androidDriver);
    }



}
