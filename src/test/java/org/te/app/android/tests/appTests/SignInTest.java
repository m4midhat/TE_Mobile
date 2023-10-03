package org.te.app.android.tests.appTests;

import org.te.app.android.assertionConstants.signInScreenConstants;
import org.te.app.android.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {


    @Test(description = "Verify if pop up is displayed")
    public void popUpDisplayed(){
        Assert.assertTrue(signInScreen.popUpMessageIsDisplayed());
    }

    @Test(priority = 1, description = "Verify if the pop up has a close button")
    public void popUpCloseBtn(){
        Assert.assertTrue(signInScreen.popUpMessageCloseBtnIsEnabled());
        Assert.assertTrue(signInScreen.popUpMessageIsDisplayed());
    }

    @Test(priority = 2, description = "Verify if the pop up text is matching with requirements")
    public void popUpText(){
        Assert.assertEquals(signInScreen.getPopUpMessageText(), signInScreenConstants.signInTextEnglish);
    }

    @Test(priority = 3, description = "Verify if the pop up has the closed button")
    public void popUpHasClosedBtn(){
        Assert.assertTrue(signInScreen.popUpMessageHasCloseBtn());
    }

    @Test(priority = 4, description = "Verify the registration text")
    public void verifyContinueText(){
        Assert.assertEquals(signInScreen.getContinueWithText(), signInScreenConstants.registerText );
    }

    @Test(priority = 5, description = "Login icons are available")
    public void verify3LoginIcons(){
        Assert.assertTrue(signInScreen.fbIconAvailable());
        Assert.assertTrue(signInScreen.gmailIconAvailable());
        Assert.assertTrue(signInScreen.emailIconAvailable());
    }

    @Test(priority = 6, description = "Verify login screen interactions are not permitted while popup remains displayed")
    public void verifyLoginFieldsAreDisabled(){
        Assert.assertFalse(signInScreen.isEmailAddressFieldEnabled());
        Assert.assertFalse(signInScreen.isPasswordFieldEnabled());
        Assert.assertFalse(signInScreen.isLoginBtnEnabled());
        signInScreen.closeSignInPopUp();
    }

    @Test(priority = 7, description = "Verify login screen interactions are permitted after popup is closed")
    public void verifyLoginFieldsAreEnabledAfterPopUpIsClosed(){
        Assert.assertTrue(signInScreen.isEmailAddressFieldEnabled());
        Assert.assertTrue(signInScreen.isPasswordFieldEnabled());
        Assert.assertFalse(signInScreen.isLoginBtnEnabled());
    }

    @Test(priority = 8, description = "Verify if the application logo is available")
    public void applicationLogoIsAvailable(){
        Assert.assertTrue(signInScreen.isLogoAvailable());
    }

    @Test(priority = 9, description = "Verify if the cross button is available")
    public void crossBtnIsAvailable(){
        Assert.assertTrue(signInScreen.crossBtnIsAvailable());
    }

    @Test(priority = 9, description = "Verify if the cross button is clickable")
    public void crossBtnIsClickable(){
        Assert.assertTrue(signInScreen.crossBtnIsClickable());
    }

    @Test(priority = 10, description = "Verify Welcome header")
    public void verifyWelcomeHeader(){
        Assert.assertEquals(signInScreen.welcomeHeadingText(), signInScreenConstants.LoginScreenHeader);
    }

    @Test(priority = 10, description = "Verify Welcome header")
    public void welcomeHeaderIsAvailable(){
        Assert.assertTrue(signInScreen.welcomeHeadingIsDisplayed());
    }

    @Test(priority = 11, description = "Verify Welcome Title")
    public void verifyWelcomeTitle(){
        Assert.assertEquals(signInScreen.welcomeTitleText(), signInScreenConstants.LoginScreenTitle);
    }

    @Test(priority = 11, description = "Verify Welcome Title")
    public void welcomeTitleIsAvailable(){
        Assert.assertTrue(signInScreen.welcomeTitleIsDisplayed());
    }

    @Test(priority = 12, description = "Verify the footer for the license agreement")
    public void verifyFooterText(){
        Assert.assertEquals(signInScreen.privacyPolicyAndLicenseAgreementText(), signInScreenConstants.UserAgreementFooterText);
    }

    @Test(priority = 12, description = "Verify if footer for the license agreement is displayed")
    public void verifyFooterIsDisplayed(){
        Assert.assertTrue(signInScreen.privacyPolicyAndLicenseAgreementIsDisplayed());
    }

    @Test(priority = 13, description = "Verify if forgot password link is displayed")
    public void verifyForgotPasswordIsDisplayed(){
        Assert.assertTrue(signInScreen.forgotPasswordIsDisplayed());
    }

    @Test(priority = 13, description = "Verify if forgot password text is matching with requirements")
    public void verifyForgotPasswordText(){
        Assert.assertEquals(signInScreen.forgotPasswordText(), signInScreenConstants.ForgotPassword);
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
        System.out.println(signedOutPopUp);
        if(signedOutPopUp){
            Assert.assertEquals(signInScreen.getTextYouWillBeLoggedOutElseWhere(), signInScreenConstants.YouWillBeSignOutElseWhere);
            enableLocationScreen = signInScreen.pressLoginBtnForSecondLoginAttempt();
        }
    }*/



}
