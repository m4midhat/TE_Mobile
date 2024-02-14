package org.te.app.android.tests.samsung.appTests.signUp;

import lombok.extern.slf4j.Slf4j;
import org.te.app.android.assertionConstants.samsung.LoginScreenConstants;
import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.te.app.android.utils.TestRailUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Slf4j
public class LoginTest extends SamsungBaseTest {


    public String[] testCaseIDsArray = {"55204", "55205", "55206", "55208", "55209", "55210", "55211", "55212", "55213",
            "55214", "55215", "55216", "55217", "55218", "55219", "55220", "55221", "55222", "55223", "55224", "55225",
            "55226", "55227", "55228", "55229", "55230", "55231"};
    @BeforeClass
    public void addTestCasesToTestRun(){
        TestRailUtils.createTestRun(TestRailUtils.testRailTestPlanID, "Samsung Login Screen", testCaseIDsArray);
    }

    /// availability and text checks
    @Test(description = "Verify if the samsung logo is available")
    public void verifyIfSamsungLogoIsVisible(){
        boolean logoAvailable = loginScreen.samsungIconAvailable();
        TestRailUtils.updateTestCase(Integer.parseInt(testCaseIDsArray[0]), logoAvailable, "Samsung Logo is not available");
        Assert.assertTrue(logoAvailable, "Samsung logo is not visible");
    }

    @Test(description = "Verify if the Entertainer logo is available")
    public void verifyIfEntertainerLogoIsVisible(){
        boolean logoAvailable = loginScreen.entertainerIconAvailable();
        TestRailUtils.updateTestCase(Integer.parseInt(testCaseIDsArray[1]), logoAvailable, "Entertainer Logo is not available");
        Assert.assertTrue(logoAvailable, "Entertainer logo is not visible");
    }

    @Test(description = "Verify if the welcome text is available")
    public void verifyWelcomeTextIsAvailable(){
        Assert.assertTrue(loginScreen.welcomeTextAvailable(), "Welcome text is not available");
    }

    @Test(description = "Verify if the text box for email address is available")
    public void verifyIfEmailTextBoxIsAvailable(){
        Assert.assertTrue(loginScreen.emailAddressTextBoxAvailable(), "Text box for Email Address is not available");
    }

    @Test(description =  "Verify if the text box for password is available")
    public void verifyPasswordTextBoxIsAvailable(){
        Assert.assertTrue(loginScreen.passwordTextBoxAvailable(), "Password text box is not available");
    }

    @Test(description = "Verify if the checkbox for Terms of use is available")
    public void verifyCheckBoxIsAvailableForTermsOfUse(){
        Assert.assertTrue(loginScreen.checkBoxForPrivacyPolicyAvailable(), "Checkbox for privacy policy agreement is not available");
    }

    @Test(description = "Verify the checkbox for License agreement is available")
    public void verifyCheckBoxIsAvailableForLicenseAgreement(){
        Assert.assertTrue(loginScreen.checkBoxForLicenseAgreementAvailable(), "Checkbox for license agreement is not available");
    }

    @Test(description = "Verify the text for the Terms of use is matching up")
    public void verifyTermsOfUseText(){
        String text = loginScreen.getPrivacyPolicyText();
        log.info("Privacy policy text : "+text);
    }

    @Test(description = "Verify if the text for the for the License agreement is matching up")
    public void verifyLicenseAgreementText(){
        String text = loginScreen.getLicenseAgreementText();
        log.info(text);
    }

    @Test(description = "Verify if the button for Login is available")
    public void verifyLoginButtonIsAvailable(){
        Assert.assertTrue(loginScreen.loginButtonAvailable(), "Login button is not available");
    }

    @Test(description = "Verify if the button text for 'Login' is matching up")
    public void verifyLoginButtonText(){
        String btnText = loginScreen.getLoginButtonText();
        log.info(btnText);
    }

    @Test(description = "Verify if the Link for 'Forgot Password' is available")
    public void verifyForgotPasswordLinkIsAvailable(){
        Assert.assertTrue(loginScreen.forgotPasswordLinkAvailable(), "Forgot password link is not available");
    }

    @Test(description = "Verify if the text for 'Forgot Password' is matching up")
    public void verifyForgotPasswordLinkText(){
        String linkText = loginScreen.getForgotPasswordLinkText();
        log.info(linkText);
    }

    @Test(description = "Verify if the link for 'Create account' is available")
    public void verifyCreateAccountLinkIsAvailable(){
        Assert.assertTrue(loginScreen.isCreateLoginLinkAvailable(), "Create login link is not available");
    }

    @Test(description = "Verify if the text for 'Create account' is matching up")
    public void verifyCreateAccountText(){
        String linkText = loginScreen.getCreateLoginLinkText();
        log.info(linkText);
    }


    /// Login Scenarios
    @Test(description = "Verify if the error message is being displayed if no credentials are provided to login screen", priority = 1)
    public void verifyErrorMessageInCaseOfBlankCredentials(){
        loginScreen.pressLoginButton();
        String errorText = loginScreen.getLoginErrorText();
        log.info(errorText);
        Assert.assertEquals(errorText, LoginScreenConstants.ERROR_BLANK_CREDENTIALS, "Incorrect error message in case of blank credentials");
    }

    @Test(description = "Verify if the error message is being displayed if only username is provided to login screen", priority = 1)
    public void verifyErrorMessageWhenOnlyUserNameIsProvided(){
        String emailAddress = faker.internet().emailAddress();
        log.info(emailAddress);
        loginScreen.loginToApplication(emailAddress, "");
        String errorText = loginScreen.getLoginErrorText();
        log.info(errorText);
        Assert.assertEquals(errorText, LoginScreenConstants.ERROR_NO_PASSWORD);
    }

    @Test(description = "Verify if the error message is being displayed if invalid username is provided to login screen", priority = 1)
    public void verifyErrorMessageWhenInvalidUserNameIsProvided(){
        String emailAddress = faker.internet().emailAddress().replace("@","");
        log.info(emailAddress);
        loginScreen.loginToApplication(emailAddress, "");
        String errorText = loginScreen.getLoginErrorText();
        log.info(errorText);
        Assert.assertEquals(errorText, LoginScreenConstants.INVALID_USERNAME);
    }


    @Test(description = "Verify if the error message is being displayed if only password is provided to the login screen", priority = 1)
    public void verifyErrorMessageWhenOnlyPasswordIsProvided(){
        String password = faker.internet().password(8,15, true, true,true);
        log.info(password);
        loginScreen.loginToApplication("", password);
        String errorText = loginScreen.getLoginErrorText();
        log.info(errorText);
        //Assert.assertEquals(errorText, LoginScreenConstants.ERROR_NO_PASSWORD);
    }


    @Test(description = "Verify if the popup screen is being displayed when user clicks on forgot password", priority = 2)
    public void verifyPopUpScreenForForgotPasswordGetsDisplayed(){
        loginScreen.clickForgotPassword();
        Assert.assertTrue(loginScreen.forgotPasswordPopupDisplays(), "Forgot password popup is not being displayed");
    }

    @Test(description = "Verify if the forgot password popup has a title", priority = 3)
    public void verifyForgotPasswordPopupTitle(){
        Assert.assertTrue(loginScreen.isForgotPasswordPopupHasTitle(), "Forgot password popup does not have a title");
    }

    @Test(description = "Verify if the forgot password popup title is matching up", priority = 3)
    public void verifyForgotPasswordPopupTitleText(){
        String title = loginScreen.getForgotPasswordPopupTitle();
        log.info(title);
        Assert.assertEquals(title, LoginScreenConstants.TITLE_FORGOT_PASSWORD, "Incorrect title of forgot password pop-up");
    }

    @Test(description = "Verify if the forgot password popup has a sub title", priority = 3)
    public void verifyForgotPasswordPopupHasSubTitle(){
        Assert.assertTrue(loginScreen.isForgotPasswordPopupHasTitle());
    }

    @Test(description = "Verify if the forgot password popup sub title is matching up", priority = 3)
    public void verifyForgotPasswordPopupSubTitleIsMatching(){
        String subTitle = loginScreen.getForgotPasswordPopupMessage();
        log.info(subTitle);
        Assert.assertEquals(subTitle, LoginScreenConstants.FORGOT_PASSWORD_POPUP_MESSAGE, "Forgot password popup does not have a message");
    }


    /// Creating account
    @Test(description = "Create account", priority = 1000)
    public void createAccountTest(){
        loginScreen.closeForgotPasswordPopup();
        createAccount = loginScreen.clickCreateAccount();
    }

}
