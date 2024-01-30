package org.te.app.android.screens.samsung;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.te.app.android.androidActions.AndroidActions;

public class loginScreen extends AndroidActions {

    public AndroidDriver androidDriver;
    public loginScreen(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
    }


    private WebElement txtEmailAddress(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/et_email"));
    }

    private WebElement txtPassword(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/et_password"));
    }

    private WebElement chkBoxPrivacyPolicy(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/checkbox_privacy_policy"));
    }

    private  WebElement privacyPolicyText(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_privacy_policy"));
    }

    private WebElement chkBoxLicenseAgreement(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/checkbox_privacy_policy"));
    }

    private WebElement licenseAgreementText(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_accept_terms"));
    }

    private WebElement loginBtn(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/btnContinue"));
    }

    private WebElement forgotPassword(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_forget_pass"));
    }

    private WebElement doNotHaveAccountCreateOne(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_dont_have_acount"));
    }

    private WebElement loginError(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tvHaveNotRegistered"));
    }

    private WebElement forgotPasswordBottomSheet(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/design_bottom_sheet"));
    }

    private WebElement forgotPasswordTitle(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tvTitle"));
    }

    private WebElement forgotPasswordMessage(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tvSubTitle"));
    }

    private WebElement forgotPasswordEmailTextBox(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/et_email"));
    }

    private WebElement forgotPasswordDoneBtn(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/btnAction"));
    }

    private WebElement forgotPasswordCloseBtn(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/ivClose"));
    }




    public boolean samsungIconAvailable(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/ivSamsung")).isDisplayed();
    }

    public boolean entertainerIconAvailable(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/ivEntertainer")).isDisplayed();
    }

    public boolean welcomeTextAvailable(){
        return androidDriver.findElement(By.xpath("//android.widget.TextView[@text=\"Welcome\" and @class=\"android.widget.TextView\"]")).isDisplayed();
    }

    public boolean emailAddressTextBoxAvailable(){
        return txtEmailAddress().isDisplayed();
    }

    public boolean passwordTextBoxAvailable(){
        return txtPassword().isDisplayed();
    }

    public boolean checkBoxForPrivacyPolicyAvailable(){
        return chkBoxPrivacyPolicy().isDisplayed();
    }

    public boolean checkBoxForLicenseAgreementAvailable(){
        return chkBoxLicenseAgreement().isDisplayed();
    }

    public String getPrivacyPolicyText(){
        return privacyPolicyText().getText().trim();
    }

    public String getLicenseAgreementText(){
        return licenseAgreementText().getText().trim();
    }

    public void loginToApplication(String username, String password){
        txtEmailAddress().sendKeys(username);
        txtPassword().sendKeys(password);
        loginBtn().click();
    }

    public boolean loginErrorIsDisplayed(){
        return loginError().isDisplayed();
    }

    public String getLoginErrorText(){
        return loginError().getText().trim();
    }

    public void clickForgotPassword(){
        forgotPassword().click();
    }

    public createAccountScreen clickCreateAccount(){
        doNotHaveAccountCreateOne().click();
        return new createAccountScreen(androidDriver);
    }

    public boolean forgotPasswordPopupDisplays(){
        return forgotPasswordBottomSheet().isDisplayed();
    }

    public String getForgotPasswordPopupTitle(){
        return forgotPasswordTitle().getText().trim();
    }

    public String getForgotPasswordPopupMessage(){
        return forgotPasswordMessage().getText().trim();
    }

    public String getForgotPasswordResetBtnText(){
        return forgotPasswordDoneBtn().getText().trim();
    }

    public boolean isResetButtonAvailableInForgotPasswordPopup(){
        return forgotPasswordDoneBtn().isDisplayed();
    }

    public boolean isCloseButtonAvailableInForgotPasswordPopup(){
        return forgotPasswordCloseBtn().isDisplayed();
    }

    public void agreeToPrivacyPolicy(){
        chkBoxPrivacyPolicy().click();
    }

    public void agreeToLicense(){
        chkBoxLicenseAgreement().click();
    }

    public void resetPassword(String userName){
        clickForgotPassword();
        forgotPasswordEmailTextBox().sendKeys(userName);
        forgotPasswordDoneBtn().click();
    }



}