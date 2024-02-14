package org.te.app.android.screens.samsung;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.te.app.android.mobileGestures.AndroidActions;

public class introWizardScreen extends AndroidActions {

    public AndroidDriver androidDriver;
    public introWizardScreen(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
    }

    public String screenTitle(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_title")).getText().trim();
    }

    public boolean imageIsBeingDisplayed(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/ivBg")).isDisplayed();
    }

    public boolean skipButtonAvailable(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_skip")).isDisplayed();
    }

    public boolean paginationControlsAvailable(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/circleIndicator")).isDisplayed();
    }

    public String stepTitle(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_step_count")).getText().trim();
    }

    public String stepSubTitle(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_sub_title")).getText().trim();
    }

    public WebElement nextButton(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/btn_continue"));
    }

    public boolean nextButtonAvailable(){
        return nextButton().isDisplayed();
    }

    public String nextButtonText(){
        return nextButton().getText().trim();
    }

    public void pressNextButton(){
        nextButton().click();
    }

    public loginScreen navigateToLoginScreen(){
        nextButton().click();
        return new loginScreen(androidDriver);
    }

    public loginScreen navigateToLoginScreenFromIntroScreen(){
        for(int i=0;i<4;i++) {
            nextButton().click();
        }
        return new loginScreen(androidDriver);
    }
}
