package org.te.app.android.screens.ent;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class OnboardingScreen {

    public AndroidDriver androidDriver;
    public OnboardingScreen(AndroidDriver driver){
        this.androidDriver = driver;
    }

    private WebElement popUp(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/bottom_sheet"));
    }

    private List<WebElement> preferredLanguages(){
        WebElement preferredLanguageBox = androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/preferredLanguage"));
        List<WebElement> languagesGroup = preferredLanguageBox.findElements(By.className("android.view.ViewGroup"));
        List<WebElement> langs = new ArrayList<>();
        for(int i=0;i<languagesGroup.size()-1;i++){
            langs.add(languagesGroup.get(i).findElement(By.className("android.widget.TextView")));
        }

        return langs;
    }

    private WebElement englishLanguageContainer(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/clEnglishLanguage"));
    }

    private WebElement arabicLanguageContainer(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/clArabicLanguage"));
    }

    private WebElement russianLanguageContainer(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/clRussianLanguage"));
    }

    private WebElement popUpText(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvSelectPreferredLanguage"));
    }

    private WebElement btnContinue(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/btnContinue"));
    }

    private WebElement englishLanguageTick(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/ivEnglishTick"));
    }

    private WebElement arabicLanguageTick(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/ivArabicTick"));
    }

    private WebElement russianLanguageTick(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/ivRussianTick"));
    }

    private WebElement onboardingCloseBtn(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/onboarding_skip"));
    }

    private WebElement tvCardHeading(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/onBoardingTvCardHeading"));
    }

    private WebElement tvCardDescription(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/onBoardingTvCardDescription"));
    }

    private WebElement forwardBtn(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/ivForward"));
    }

    private List<WebElement> sliderElements(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/dotsIndicator")).findElements(By.className("android.widget.RelativeLayout"));
    }

    private WebElement closeBrazeInAppMessageBtn(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/com_braze_inappmessage_full_close_button"));
    }

    private WebElement skipLink(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/onboarding_skip"));
    }







    public boolean isPopUpDisplayed(){
        return popUp().isDisplayed();
    }

    public List<String> languagesText(){
        List<WebElement> languages = preferredLanguages();
        List<String> languagesTet = new ArrayList<>();
        for(WebElement element: languages){
            languagesTet.add(element.getText().trim());
        }
        return languagesTet;
    }

    public String getPopUpText(){
        return popUpText().getText().trim();
    }

    public String btnContinueText(){
        return btnContinue().getText().trim();
    }

    public boolean btnContinueClickable(){
        return btnContinue().isEnabled();
    }

    public boolean isLanguageContainerClickable(String language){
        boolean clickable = false;
        WebElement languageContainer = null;
        if(language.compareToIgnoreCase("arabic")==0){
            languageContainer = arabicLanguageContainer();
        }
        else if(language.compareToIgnoreCase("english")==0){
            languageContainer = englishLanguageContainer();
        }
        else if(language.compareToIgnoreCase("russian")==0){
            languageContainer = russianLanguageContainer();
        }
        if(languageContainer!=null) {
            clickable = Boolean.parseBoolean(languageContainer.getAttribute("clickable"));
        }
        return clickable;
    }

    public boolean englishLanguageTickVisible(){
        return englishLanguageTick().isDisplayed();
    }

    public boolean arabicLanguageTickVisible(){
        return arabicLanguageTick().isDisplayed();
    }

    public boolean russianLanguageTickVisible(){
        return russianLanguageTick().isDisplayed();
    }

    public void selectEnglishLanguage(){
        englishLanguageContainer().click();
    }

    public void selectArabicLanguage(){
        arabicLanguageContainer().click();
    }
    public void selectRussianLanguage(){
        russianLanguageContainer().click();
    }

    public void skipOnboardingScreen(){
        onboardingCloseBtn().click();
    }

    public void clickContinueBtn(){
        btnContinue().click();
    }

    public int totalSliders(){
        return sliderElements().size();
    }

    public String tvCardDescriptionText(){
        return tvCardDescription().getText().trim().replace("\n", " ");
    }

    public String tvCardTitleText(){
        return tvCardHeading().getText().trim().replace("\n", " ");
    }

    public void clickForwardBtn(){
        forwardBtn().click();
    }

    public boolean isSkipButtonAvailable(){
        return skipLink().isDisplayed();
    }

    public boolean isSkipButtonClickable(){
        return skipLink().isEnabled();
    }

    public SignInScreen navigateToSignInScreen(){
        return new SignInScreen(androidDriver);
    }

    public SignUpScreen navigateToSignUpScreen(){
        return new SignUpScreen(androidDriver);
    }

}
