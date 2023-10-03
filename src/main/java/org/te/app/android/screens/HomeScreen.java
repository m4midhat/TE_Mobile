package org.te.app.android.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomeScreen {

    AndroidDriver androidDriver;

    public HomeScreen(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
    }

    private WebElement welcomeScreenPopup(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/design_bottom_sheet"));
    }

    private WebElement welcomeScreenCross(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/ivCross"));
    }

    private WebElement title(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvTitle"));
    }

    private WebElement description(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvDescription"));
    }

    private WebElement btnTakeTour(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/btnTakeTour"));
    }

    private WebElement btnSkip(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvSkip"));
    }

    private WebElement banner(){
        return androidDriver.findElements(By.id("com.theentertainerme.entertainer:id/ivImage")).get(0);
    }

    private WebElement toolbar(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/clToolbar"));
    }

    private WebElement mainRoot(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/cardView"));
    }

    private WebElement cardView(){
        return mainRoot().findElement(By.id("com.theentertainerme.entertainer:id/cardView"));
    }







    public boolean welcomeScreenPopUpDisplayed(){
        return welcomeScreenPopup().isDisplayed();
    }

    public boolean welcomeScreenPopUpHasCross(){
        return welcomeScreenCross().isDisplayed();
    }

    public void clickCrossBtnForPopUp(){
        welcomeScreenCross().click();
    }

    public String getWelcomeScreenTitle(){
        return title().getText().replace("\n", "").trim();
    }

    public String getWelcomeScreenDescription(){
        return description().getText().replace("\n", " ").trim();
    }

    public boolean btnTakeTourIsVisible(){
        return btnTakeTour().isDisplayed();
    }

    public boolean btnTakeTourIsClickable(){
        return Boolean.parseBoolean(btnTakeTour().getAttribute("clickable"));
    }

    public String  getBtnTakeTourText(){
        return btnTakeTour().getText().replace("\n"," ").trim();
    }

    public boolean btnSkipIsVisible(){
        return btnSkip().isDisplayed();
    }

    public String getBtnSkipText(){
        return btnSkip().getText().replace("\n"," ").trim();
    }

    public boolean btnSkipIsClickable(){
        return Boolean.parseBoolean(btnSkip().getAttribute("clickable"));
    }
    public boolean bannerImageIsDisplayed(){
        return banner().isDisplayed();
    }

    public boolean toolBarIsDisplayed(){
        return toolbar().isDisplayed();
    }

    public boolean mainRootIsDisplayed(){
        return mainRoot().isDisplayed();
    }

    public boolean cardIsDisplayed(){
        return cardView().isDisplayed();
    }

}
