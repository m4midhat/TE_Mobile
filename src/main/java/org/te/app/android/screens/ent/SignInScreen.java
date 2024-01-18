package org.te.app.android.screens.ent;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInScreen {


    AndroidDriver androidDriver;
    public SignInScreen(AndroidDriver driver){
        this.androidDriver = driver;
    }

    private WebElement popUpMessage(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/cvEducationPopup"));
    }

    private WebElement closeBtnPopUpMessage(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/ivClosePopup"));
    }

    private WebElement popUpMessageText(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvPopupTitle"));
    }

    private WebElement continueWithText(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvContinueWith"));
    }

    private WebElement fbIcon(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/ivFb"));
    }

    private WebElement googleIcon(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/ivGoogle"));
    }

    private WebElement emailIcon(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/ivEmail"));
    }

    private WebElement fieldEmailAddress(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/etEmail"));
    }

    private WebElement fieldPassword(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/etPassword"));
    }

    private WebElement btnLogin(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/btnLogin"));
    }

    private WebElement logo(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/ivEntertainerLogo"));
    }

    private WebElement crossBtn(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/ivCross"));
    }

    private WebElement welcomeHeading(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvWelcome"));
    }

    private WebElement welcomeTitle(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvTitle"));
    }

    private WebElement forgotPassword(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvForgotPassword"));
    }

    private WebElement privacyPolicyAndLicenseAgreement(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvAcceptLicense"));
    }

    private WebElement incorrectCredentialsText(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvMessage"));
    }

    private WebElement incorrectCredentialsPasswordErrorOKButton(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/btnPrimary"));
    }

    private WebElement loginBtnForSecondLoginAttempt(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/btnLogin"));
    }

    private WebElement youWillBeLoggedOutElseWhere(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvSubtitle"));
    }

    private WebElement loaderIcon(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/lottieProgressbar"));
    }







    public boolean popUpMessageIsDisplayed(){
        return popUpMessage().isDisplayed();
    }

    public boolean popUpMessageHasCloseBtn(){
        return closeBtnPopUpMessage().isDisplayed();
    }

    public boolean popUpMessageCloseBtnIsEnabled(){
        return closeBtnPopUpMessage().isEnabled();
    }

    public String getPopUpMessageText(){
        return popUpMessageText().getText().replace("\n", " ").trim();
    }
    public String getContinueWithText(){
        return continueWithText().getText().replace("\n", " ").trim();
    }

    public boolean fbIconAvailable(){
        return fbIcon().isDisplayed();
    }

    public boolean gmailIconAvailable(){
        return googleIcon().isDisplayed();
    }

    public boolean emailIconAvailable(){
        return emailIcon().isDisplayed();
    }

    public void closeSignInPopUp(){
        closeBtnPopUpMessage().click();
    }

    public boolean isEmailAddressFieldEnabled(){
        return fieldEmailAddress().isEnabled();
    }
    public void setEmail(String emailAddress){
        fieldEmailAddress().clear();
        fieldEmailAddress().sendKeys(emailAddress);
    }

    public void setPassword(String password){
        fieldPassword().clear();
        fieldPassword().sendKeys(password);
    }

    public boolean isPasswordFieldEnabled(){
        return fieldPassword().isEnabled();
    }

    public boolean isLoginBtnEnabled(){
        return btnLogin().isEnabled();
    }
    public boolean isLogoAvailable(){
        return logo().isDisplayed();
    }

    public boolean crossBtnIsAvailable(){
        return crossBtn().isDisplayed();
    }

    public boolean crossBtnIsClickable(){
        return Boolean.parseBoolean(crossBtn().getAttribute("clickable"));
    }

    public boolean welcomeHeadingIsDisplayed(){
        return welcomeHeading().isDisplayed();
    }

    public String welcomeHeadingText(){
        return welcomeHeading().getText().replace("\n"," ").trim();
    }

    public boolean welcomeTitleIsDisplayed(){
        return welcomeTitle().isDisplayed();
    }

    public String welcomeTitleText(){
        return welcomeTitle().getText().replace("\n", " ").trim();
    }

    public boolean forgotPasswordIsDisplayed(){
        return forgotPassword().isDisplayed();
    }

    public String forgotPasswordText(){
        return forgotPassword().getText().replace("\n", " ").trim();
    }

    public boolean privacyPolicyAndLicenseAgreementIsDisplayed(){
        return privacyPolicyAndLicenseAgreement().isDisplayed();
    }

    public String privacyPolicyAndLicenseAgreementText(){
        return privacyPolicyAndLicenseAgreement().getText().replace("\n", " ").trim();
    }

    public void clickFBButton(){
        fbIcon().click();
    }

    public SignUpScreen clickEmailButton(){
        emailIcon().click();
        return new SignUpScreen(androidDriver);
    }

    public EnableLocationScreen clickLoginBtn(){
        btnLogin().click();
        return new EnableLocationScreen(androidDriver);
    }

    public String getIncorrectCredentialsText(){
        return incorrectCredentialsText().getText().replace("\n", " ").trim();
    }

    public void clickIncorrectCredentialsPasswordErrorOKButton(){
        incorrectCredentialsPasswordErrorOKButton().click();
    }

    public boolean popUpDisplayedForYouWillBeSignedOutElseWhere(){
        WebElement element = null;
        try {
            element = androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/design_bottom_sheet"));
            WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (Exception ignored){

        }
        boolean elementAvailability = false;
        if(element!=null) {
            if (element.isDisplayed())
                elementAvailability = true;
        }
        return elementAvailability;
    }

    public boolean loaderIconIsVisible(){
        return loaderIcon().isDisplayed();
    }

    public EnableLocationScreen pressLoginBtnForSecondLoginAttempt(){
        loginBtnForSecondLoginAttempt().click();
        return new EnableLocationScreen(androidDriver);
    }

    public String getTextYouWillBeLoggedOutElseWhere(){
        return youWillBeLoggedOutElseWhere().getText().trim();
    }
}
