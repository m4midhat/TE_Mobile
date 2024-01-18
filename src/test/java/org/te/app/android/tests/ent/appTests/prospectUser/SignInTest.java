package org.te.app.android.tests.ent.appTests.prospectUser;

import org.te.app.android.assertionConstants.ent.signInScreenConstants;
import org.te.app.android.tests.baseTest.ent.EntertainerBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends EntertainerBaseTest {

    @Test(description = "Verify if pop up is displayed")
    public void popUpDisplayed(){
        Assert.assertTrue(signInScreen.popUpMessageIsDisplayed(), "Popup screen is not getting displayed");
    }

    @Test(priority = 1, description = "Verify if the pop up has a close button")
    public void popUpCloseBtn(){
        Assert.assertTrue(signInScreen.popUpMessageCloseBtnIsEnabled(), "Popup screen has closed button and it is enabled");
        Assert.assertTrue(signInScreen.popUpMessageIsDisplayed(), "Popup message gets disappear after clicking the close button");
    }

    @Test(priority = 2, description = "Verify if the pop up text is matching with requirements")
    public void popUpText(){
        String text = signInScreen.getPopUpMessageText();
        Assert.assertEquals(text, signInScreenConstants.signInTextEnglish, "Incorrect text for popup, expected value: "+signInScreenConstants.signInTextEnglish+" Received value: "+text);
    }

    @Test(priority = 3, description = "Verify if the pop up has the closed button")
    public void popUpHasClosedBtn(){
        Assert.assertTrue(signInScreen.popUpMessageHasCloseBtn(), "Close button is not available in popup");
    }

    @Test(priority = 4, description = "Verify the registration text")
    public void verifyContinueText(){
        String registrationText = signInScreen.getContinueWithText();
        Assert.assertEquals(registrationText, signInScreenConstants.registerText, "Incorrect registration text, expected value: "+signInScreenConstants.registerText+" Received value: "+registrationText);
    }

    @Test(priority = 5, description = "Login icons are available")
    public void verify3LoginIcons(){
        Assert.assertTrue(signInScreen.fbIconAvailable(), "Facebook icon is not available");
        Assert.assertTrue(signInScreen.gmailIconAvailable(), "Gmail icon is not available");
        Assert.assertTrue(signInScreen.emailIconAvailable(), "Email icon is not available");
    }

    @Test(priority = 6, description = "Verify login screen interactions are not permitted while popup remains displayed")
    public void verifyLoginFieldsAreDisabled(){
        Assert.assertFalse(signInScreen.isEmailAddressFieldEnabled(), "Email address field is not disabled due to popup");
        Assert.assertFalse(signInScreen.isPasswordFieldEnabled(),  "Password field is not disabled due to popup");
        Assert.assertFalse(signInScreen.isLoginBtnEnabled(),  "Login button is not disabled due to popup");
        signInScreen.closeSignInPopUp();
    }

    @Test(priority = 7, description = "Verify login screen interactions are permitted after popup is closed")
    public void verifyLoginFieldsAreEnabledAfterPopUpIsClosed(){
        Assert.assertTrue(signInScreen.isEmailAddressFieldEnabled(), "Email address field is not enabled after the popup is closed");
        Assert.assertTrue(signInScreen.isPasswordFieldEnabled(), "Password field is not enabled after the popup is closed");
        Assert.assertFalse(signInScreen.isLoginBtnEnabled(), "Login button is not enabled after the popup is closed");
    }

    @Test(priority = 8, description = "Verify if the application logo is available")
    public void applicationLogoIsAvailable(){
        Assert.assertTrue(signInScreen.isLogoAvailable(), "Application logo is not available");
    }

    @Test(priority = 9, description = "Verify if the cross button is available")
    public void crossBtnIsAvailable(){
        Assert.assertTrue(signInScreen.crossBtnIsAvailable(), "Cross('x') button is not available on the screen");
    }

    @Test(priority = 9, description = "Verify if the cross button is clickable")
    public void crossBtnIsClickable(){
        Assert.assertTrue(signInScreen.crossBtnIsClickable(), "Cross('x') button is not intractable on the screen");
    }

    @Test(priority = 10, description = "Verify Welcome header")
    public void verifyWelcomeHeader(){
        String header = signInScreen.welcomeHeadingText();
        Assert.assertEquals(header, signInScreenConstants.LoginScreenHeader, "Incorrect welcome screen header, expected value: "+signInScreenConstants.LoginScreenHeader+" Received value: "+header);
    }

    @Test(priority = 10, description = "Welcome header is being displayed")
    public void welcomeHeaderIsAvailable(){
        Assert.assertTrue(signInScreen.welcomeHeadingIsDisplayed(), "Welcome header is not getting displayed");
    }

    @Test(priority = 11, description = "Verify Welcome Title")
    public void verifyWelcomeTitle(){
        String welcomeTitle = signInScreen.welcomeTitleText();
        Assert.assertEquals(welcomeTitle, signInScreenConstants.LoginScreenTitle, "Incorrect welcome title, expected value: "+signInScreenConstants.LoginScreenTitle+" Received value: "+ welcomeTitle);
    }

    @Test(priority = 11, description = "Verify Welcome Title")
    public void welcomeTitleIsAvailable(){
        Assert.assertTrue(signInScreen.welcomeTitleIsDisplayed(), "Welcome title is not getting displayed");
    }

    @Test(priority = 12, description = "Verify the footer for the license agreement")
    public void verifyFooterText(){
        String footerText = signInScreen.privacyPolicyAndLicenseAgreementText();
        Assert.assertEquals(footerText, signInScreenConstants.UserAgreementFooterText, "Incorrect footer text, expected value: "+ signInScreenConstants.UserAgreementFooterText+" Received value: "+footerText);
    }

    @Test(priority = 12, description = "Verify if footer for the license agreement is displayed")
    public void verifyFooterIsDisplayed(){
        Assert.assertTrue(signInScreen.privacyPolicyAndLicenseAgreementIsDisplayed(), "Footer for the license agreement is not getting displayed");
    }

    @Test(priority = 13, description = "Verify if forgot password link is displayed")
    public void verifyForgotPasswordIsDisplayed(){
        Assert.assertTrue(signInScreen.forgotPasswordIsDisplayed(), "Forgot password link is not being displayed");
    }

    @Test(priority = 13, description = "Verify if forgot password text is matching with requirements")
    public void verifyForgotPasswordText(){
        String forgotPasswordText = signInScreen.forgotPasswordText();
        Assert.assertEquals(forgotPasswordText, signInScreenConstants.ForgotPassword, "Incorrect text for forgot password, expected value: "+ signInScreenConstants.ForgotPassword+" Received value: "+forgotPasswordText);
    }

    @Test(priority = 14, description = "Click on email icon to continue with sign-up")
    public void clickEmailIcon(){
        signUpScreen = signInScreen.clickEmailButton();
    }


    /*@Test(priority = 15, description = "Verify User login")
    public void userSignIn() throws InterruptedException {
        signInScreen.setEmail(userCredentials.getProperty("username"));
        signInScreen.setPassword(userCredentials.getProperty("password"));
        enableLocationScreen = signInScreen.clickLoginBtn();
        Assert.assertTrue(signInScreen.loaderIconIsVisible());
        boolean signedOutPopUp = signInScreen.popUpDisplayedForYouWillBeSignedOutElseWhere();
        logger.info(signedOutPopUp);
        if(signedOutPopUp){
            Assert.assertEquals(signInScreen.getTextYouWillBeLoggedOutElseWhere(), signInScreenConstants.YouWillBeSignOutElseWhere);
            enableLocationScreen = signInScreen.pressLoginBtnForSecondLoginAttempt();
        }
    }*/



}
