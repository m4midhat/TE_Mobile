package org.te.app.android.screens.ent;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.te.app.android.utils.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

    private WebElement heroBanner(){
        return androidDriver.findElements(By.id("com.theentertainerme.entertainer:id/ivImage")).get(0);
    }

    private WebElement toolbar(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/clToolbar"));
    }

    private WebElement mainRoot(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/cardView"));
    }

    private WebElement savingsBanner(){
        return mainRoot().findElement(By.id("com.theentertainerme.entertainer:id/cardView"));
    }

    private WebElement homeElement(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/recyclerHome"));
    }

    private WebElement categoriesElement(){
        return homeElement().findElements(By.id("com.theentertainerme.entertainer:id/clChild")).get(1);
    }

    private List<WebElement> categoriesIcons(){
        return androidDriver.findElements(By.id("com.theentertainerme.entertainer:id/cardView"));
    }

    private void categoriesText(){
        String text;
        WebElement categoriesContainer = androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/rvChild"));
        List<WebElement> categoryCard = categoriesContainer.findElements(By.className("android.view.ViewGroup"));
        System.out.println(categoryCard.size());
        text = categoryCard.get(0).findElement(By.className("android.widget.TextView")).getText();
        System.out.println(text);
    }

    private List<WebElement> heroBannerDots(){
        return androidDriver.findElements(By.id("com.theentertainerme.entertainer:id/dot"));
    }







    public boolean welcomeScreenPopUpDisplayed(){
        return welcomeScreenPopup().isDisplayed();
    }

    public boolean welcomeScreenPopUpHasCross(){
        return welcomeScreenCross().isDisplayed();
    }

    public void clickCrossBtnForPopUp() {
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofMillis(1500));
        wait.until(ExpectedConditions.visibilityOf(welcomeScreenCross()));
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
    public boolean heroBannerImageIsDisplayed(){
        return heroBanner().isDisplayed();
    }

    public boolean toolBarIsDisplayed(){
        return toolbar().isDisplayed();
    }

    public boolean savingBannerIsDisplayed(){
        return savingsBanner().isDisplayed();
    }

    public boolean homeScreenElementIsDisplayed(){
        return homeElement().isDisplayed();
    }

    public boolean categoriesAreBeingDisplayed(){
        return categoriesElement().isDisplayed();
    }

    public int totalCategoriesIcons(){
        List<WebElement> icons = categoriesIcons();
        return icons.size();
    }


    public int heroBannerCount(){
        return heroBannerDots().size();
    }

    public void clickOnFirstDotForHeroBanner(){
        heroBannerDots().get(0).click();
    }

    public List<String> getHeroBannerTitle(){
        List<String> title = new ArrayList<>();
        for(int i=0;i<heroBannerCount();i++){
            heroBannerDots().get(i).click();
            title.add(androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvMarketingTitle")).getText().trim());
        }
        return title;
    }

    public List<String> getHeroBannerSubTitle(){
        List<String> subtitle = new ArrayList<>();
        for(int i=0;i<heroBannerCount();i++){
            heroBannerDots().get(i).click();
            subtitle.add(androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/btnMarketingAction")).getText().trim());
        }
        return subtitle;
    }

    public List<String> getCategoriesText(){
        List<String> categoriesText = new ArrayList<>();
        List<WebElement> categories = androidDriver.findElements(By.id("com.theentertainerme.entertainer:id/tvTitle"));
        for(int i=0;i<categories.size();i++){
            categoriesText.add(categories.get(i).getText().replace("\n"," ").trim());
        }
        return categoriesText;
    }


    public void scrollToEndAction()
    {
        boolean canScrollMore;
        do
        {
            canScrollMore = (Boolean) ((JavascriptExecutor) androidDriver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0

            ));
        }while(canScrollMore);
    }



    public void locations() throws InterruptedException {
        androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/ivArrowDown")).click();
        List<WebElement> countries = androidDriver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.entertainer:id/tvCountryName\"]"));
        List<String> appCountries = new ArrayList<>();
        List<String> countriesBeforeScroll = new ArrayList<>();
        List<String> countriesAfterScroll = new ArrayList<>();
        for (WebElement country : countries) {
            String countryText = country.getText();
            System.out.println(countryText);
            countriesBeforeScroll.add(countryText);
        }
        try {
            androidDriver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
        } catch (InvalidSelectorException e) {
            // ignore
        }
        countries = androidDriver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.entertainer:id/tvCountryName\"]"));
        for (WebElement country : countries) {
            String countryText = country.getText();
            System.out.println(countryText);
            countriesAfterScroll.add(countryText);
        }
        appCountries = utils.combineLists(countriesBeforeScroll, countriesAfterScroll);
        System.out.println("Final List after combining both list");
        for(String country:appCountries){
            System.out.println(country);
        }
        List<String> distinctCountries = utils.removeDuplicatesFromList(appCountries);

        System.out.println("Final List after removing duplicates");
        for(String country:distinctCountries){
            System.out.println(country);
        }
        Thread.sleep(5000);
        //WebElement locationPopup = androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/design_bottom_sheet"));
        //List<WebElement> countries = locationPopup.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.entertainer:id/tvCountryName\""));
        //return androidDriver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.entertainer:id/tvCountryName\""));
    }

}
