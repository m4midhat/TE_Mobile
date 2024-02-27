package org.te.app.android.screens.samsung;

import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.te.app.android.mobileGestures.AndroidActions;

import java.time.Duration;

@Slf4j
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
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/checkbox_new_user"));
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

    private WebElement errorMessage(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tvHaveNotRegistered"));
    }

    private WebElement forceLoginYes(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/btn_reset_pass"));
    }

    private WebElement samsungIcon(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/ivSamsung"));
    }

    private WebElement entertainerIcon(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/ivEntertainer"));
    }

    private WebElement welcomeText(){
        return androidDriver.findElement(By.xpath("//android.widget.TextView[@text=\"Welcome\" and @class=\"android.widget.TextView\"]"));
    }




    public boolean samsungIconAvailable(){
        return samsungIcon().isDisplayed();
    }

    public boolean entertainerIconAvailable(){
        return entertainerIcon().isDisplayed();
    }

    public boolean welcomeTextAvailable(){
        return welcomeText().isDisplayed();
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
    public boolean loginButtonAvailable(){ return loginBtn().isDisplayed(); }
    public String getLoginButtonText(){ return loginBtn().getText().trim(); }
    public void pressLoginButton(){
        loginBtn().click();
    }

    public void loginToApplication(String username, String password){
        txtEmailAddress().sendKeys(username);
        txtPassword().sendKeys(password);
        pressLoginButton();
    }

    public void agreeToMultipleLogin(){
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(forceLoginYes()));
        forceLoginYes().click();
    }

    public selectLocationScreen signInToApplication(String username, String password){
        log.info("Login to the application via user name: "+ username);
        txtEmailAddress().sendKeys(username);
        txtPassword().sendKeys(password);
        agreeToPrivacyPolicy();
        agreeToLicense();
        pressLoginButton();
        return new selectLocationScreen(androidDriver);
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

    public boolean forgotPasswordLinkAvailable(){
        return forgotPassword().isDisplayed();
    }

    public String getForgotPasswordLinkText(){
        return forgotPassword().getText().trim();
    }

    public boolean isCreateLoginLinkAvailable(){
        return doNotHaveAccountCreateOne().isDisplayed();
    }

    public String getCreateLoginLinkText(){
        return doNotHaveAccountCreateOne().getText().trim();
    }

    public boolean isErrorMessageDisplayed(){
        return errorMessage().isDisplayed();
    }

    public String getErrorMessage(){
        return errorMessage().getText().trim();
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
    public boolean isForgotPasswordPopupHasTitle(){
        return forgotPasswordTitle().isDisplayed();
    }

    public boolean forgotPasswordPopupHasSubTitle(){
        return forgotPasswordMessage().isDisplayed();
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

    public void closeForgotPasswordPopup(){
        forgotPasswordCloseBtn().click();
    }

    public void agreeToPrivacyPolicy(){
        log.info("Agreeing to privacy policy ...");
        chkBoxPrivacyPolicy().click();
    }

    public void agreeToLicense(){
        log.info("Agreeing to license ...");
        chkBoxLicenseAgreement().click();
    }

    public void resetPassword(String userName){
        clickForgotPassword();
        forgotPasswordEmailTextBox().sendKeys(userName);
        forgotPasswordDoneBtn().click();
    }



}
