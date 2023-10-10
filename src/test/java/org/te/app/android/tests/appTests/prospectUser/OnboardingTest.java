package org.te.app.android.tests.appTests.prospectUser;

import org.te.app.android.tests.baseTest.BaseTest;
import org.te.app.android.assertionConstants.onboardingScreenConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class OnboardingTest extends BaseTest {


    @Test(description = "Pop-up message is being displayed upon fresh installation")
    public void languagePopUpDisplayed(){
        Assert.assertTrue(onboardingScreen.isPopUpDisplayed(), "Language popup is not being displayed");
    }

    @Test(priority = 1, description = "Verify the languages supported")
    public void verifySupportedLanguages(){
        List<String> supportedLanguages = onboardingScreen.languagesText();
        for(int i=0;i<supportedLanguages.size();i++) {
            System.out.println(supportedLanguages.get(i));
            Assert.assertEquals(supportedLanguages.get(i), onboardingScreenConstants.languages[i], "Incorrect language text, expected value : "+onboardingScreenConstants.languages[i]+" Received value: "+supportedLanguages.get(i));
        }
    }

    @Test(priority = 2, description = "Verify the pop-up text")
    public void verifyPopupText(){
        String text = onboardingScreen.getPopUpText();
        Assert.assertEquals(text, onboardingScreenConstants.popUpTextEnglish, "Incorrect popup text, expected value : "+onboardingScreenConstants.popUpTextEnglish+ " Received value : "+text);
    }

    @Test(priority = 3, description = "Verify continue button text")
    public void verifyContinueBtnText(){
        String btnText = onboardingScreen.btnContinueText();
        Assert.assertEquals(btnText, onboardingScreenConstants.continueBtnEnglish, "Incorrect button text for Continue, expected value: "+onboardingScreenConstants.continueBtnEnglish+" Received value: "+btnText);
    }

    @Test(priority = 4, description = "Verify continue button text")
    public void verifyContinueBtnEnable(){
        Assert.assertTrue(onboardingScreen.btnContinueClickable(), "Continue button is not clickable");
    }

    @Test(priority = 5, description = "Verify if English container is clickable")
    public void englishContainerClickable(){
        Assert.assertTrue(onboardingScreen.isLanguageContainerClickable("english"), "English language container is not clickable");
    }

    @Test(priority = 6, description = "Verify if Arabic container is clickable")
    public void arabicContainerClickable(){
        Assert.assertTrue(onboardingScreen.isLanguageContainerClickable("arabic"), "Arabic language container is not clickable");
    }

    @Test(priority = 7, description = "Verify if Russian container is clickable")
    public void russianContainerClickable(){
        Assert.assertTrue(onboardingScreen.isLanguageContainerClickable("russian"), "Russian language container is not clickable");
    }

    @Test(priority = 8, description = "Verify if English language is selected by default")
    public void englishLanguageSelectedByDefault(){
        Assert.assertTrue(onboardingScreen.englishLanguageTickVisible(), "English language is not selected by-default");
    }

    @Test(priority = 9, description = "Verify if arabic language is getting selected")
    public void verifyArabicLanguageBeingSelected(){
        onboardingScreen.selectArabicLanguage();
        Assert.assertTrue(onboardingScreen.arabicLanguageTickVisible(), "Arabic language is not getting selected");
    }

    @Test(priority = 10, description = "Verify if russian language is getting selected")
    public void verifyRussianLanguageBeingSelected(){
        onboardingScreen.selectRussianLanguage();
        Assert.assertTrue(onboardingScreen.russianLanguageTickVisible(), "Russian language is not getting selected");
    }

    @Test(priority = 11, description = "Select English language and press continue button")
    public void selectEnglishAndContinue() {
        onboardingScreen.selectEnglishLanguage();
        onboardingScreen.clickContinueBtn();
        //onboardingScreen.skipOnboardingScreen();
        //onboardingScreen.closeBrazeInAppMessage();
    }

    @Test(priority = 12, description = "Verify if the skip link is available")
    public void verifySkipLinkIsAvailable(){
        Assert.assertTrue(onboardingScreen.isSkipButtonAvailable(), "Skip link is not available on the onboarding screen");
    }

    @Test(priority = 12, description = "Verify if the skip link is clickable")
    public void verifySkipLinkIsClickable(){
        Assert.assertTrue(onboardingScreen.isSkipButtonClickable(), "Skip link is not clickable");
    }

    @Test(priority = 13, description = "Total sliders count")
    public void sliders(){
        int sliders = onboardingScreen.totalSliders();
        System.out.println("Total sliders : "+sliders);
        Assert.assertEquals(sliders, onboardingScreenConstants.onBoardingSlidersCount, "Incorrect sliders count, expected value: "+onboardingScreenConstants.onBoardingSlidersCount+" Received value: "+sliders);
    }

    @Test(priority = 14, description = "Get sliders header and boxy text")
    public void getSliderText() throws InterruptedException {
        int totalSliders =  onboardingScreen.totalSliders();
        for(int i=0;i<totalSliders;i++){
            System.out.println(onboardingScreen.tvCardTitleText() + " : " + onboardingScreen.tvCardDescriptionText());
            String title = onboardingScreen.tvCardTitleText();
            String description = onboardingScreen.tvCardDescriptionText();
            Assert.assertEquals(title, onboardingScreenConstants.onBoardingTVCardEnglishTitle[i], "Incorrect title for TV Card, expected value: "+ title+" Received value: "+onboardingScreenConstants.onBoardingTVCardEnglishTitle[i]);
            Assert.assertEquals(description, onboardingScreenConstants.onBoardingTVCardEnglishDescription[i], "Incorrect description for TV Card, expected value: "+ description+" Received value: "+onboardingScreenConstants.onBoardingTVCardEnglishDescription[i]);

            onboardingScreen.clickForwardBtn();
        }
        //Thread.sleep(5000);
        signInScreen = onboardingScreen.navigateToSignInScreen();
    }


}
