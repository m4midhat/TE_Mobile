package org.te.app.android.screens.samsung;

import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.te.app.android.AppConstants.AppConstants;
import org.te.app.android.mobileGestures.AndroidActions;
import org.te.app.android.utils.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BeautyAndFitnessScreen extends AndroidActions {

    public AndroidDriver androidDriver;
    public BeautyAndFitnessScreen(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
    }


    private WebElement screenTitle(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_offer_cat"));
    }

    private WebElement filters(){
        String locator="com.theentertainerme.sckentertainer:id/iv_filter_alloffers";
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(androidDriver.findElement(By.id(locator))));
        return androidDriver.findElement(By.id(locator));
    }

    private WebElement filterView(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/dragView_bottom_filters"));
    }

    private WebElement filterClearBtn(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/btn_clear_filter"));
    }

    private WebElement filterDoneBtn(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/btn_done_filter"));
    }

    private WebElement filterTitle(){
        return androidDriver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id=\"com.theentertainerme.sckentertainer:id/dragView_bottom_filters\"]/android.widget.RelativeLayout/android.widget.TextView"));
    }

    private List<WebElement> filterSections(){
        return androidDriver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/tv_sperater\"]"));
    }

    private List<WebElement> filtersText(){
        return androidDriver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/tv_filter_name\"]"));
    }

    private WebElement newOffersCheckBox(){
        return androidDriver.findElement(By.xpath("com.theentertainerme.sckentertainer:id/cb_filter_selector"));
    }

    private List<WebElement> merchantName(){
        String locator="com.theentertainerme.sckentertainer:id/textview_offername";
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(androidDriver.findElement(By.id(locator))));
        return androidDriver.findElements(By.id(locator));
    }

    private List<WebElement> merchantLocation(){
        String locator = "com.theentertainerme.sckentertainer:id/textview_offer_location";
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(androidDriver.findElement(By.id(locator))));
        return androidDriver.findElements(By.id(locator));
    }

    private List<WebElement> merchantDistance(){
        String locator = "com.theentertainerme.sckentertainer:id/textview_distance";
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(androidDriver.findElement(By.id(locator))));
        return androidDriver.findElements(By.id(locator));
    }

    private WebElement resultContainer(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/recycler_outlets"));
    }

    private WebElement footerBar(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tabs_bottom_home"));
    }

    private WebElement footerHomeIcon(){
        return footerBar().findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"app!\"])[5]"));
    }

    private WebElement footerHomeText(){
        return footerBar().findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/tv_tab_name\" and @text=\"Home\"]"));
    }

    private WebElement footerDeliveryIcon(){
        return footerBar().findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"app!\"])[6]"));
    }

    private WebElement footerDeliveryText(){
        return footerBar().findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/tv_tab_name\" and @text=\"Delivery\"]"));
    }

    private WebElement footerTravelIcon(){
        return footerBar().findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"app!\"])[7]"));
    }

    private WebElement footerTravelText(){
        return footerBar().findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/tv_tab_name\" and @text=\"Travel\"]"));
    }

    private WebElement footerProfileIcon(){
        return footerBar().findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"app!\"])[8]"));
    }

    private WebElement footerProfileText(){
        return footerBar().findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/tv_tab_name\" and @text=\"Profile\"]"));
    }

    private WebElement filterType(){
        return androidDriver.findElements(By.id("com.theentertainerme.sckentertainer:id/rl_more_con")).get(0);
    }

    private WebElement filterCuisine(){
        return androidDriver.findElements(By.id("com.theentertainerme.sckentertainer:id/rl_more_con")).get(1);
    }

    private List<WebElement> filterTypeNames(){
        return androidDriver.findElements(By.id("com.theentertainerme.sckentertainer:id/tv_filter_name"));
    }

    private WebElement filterTypeAll(){
        return androidDriver.findElement(By.xpath("(//android.widget.CheckBox[@resource-id=\"com.theentertainerme.sckentertainer:id/cb_filter_selector\"])[1]"));
    }

    private WebElement filterTypeBeautyHairAndNails(){
        return androidDriver.findElement(By.xpath("(//android.widget.CheckBox[@resource-id=\"com.theentertainerme.sckentertainer:id/cb_filter_selector\"])[2]"));
    }

    private WebElement filterTypeHealthAndFitness(){
        return androidDriver.findElement(By.xpath("(//android.widget.CheckBox[@resource-id=\"com.theentertainerme.sckentertainer:id/cb_filter_selector\"])[3]"));
    }

    private WebElement filterTypeMedicalAndDental(){
        return androidDriver.findElement(By.xpath("(//android.widget.CheckBox[@resource-id=\"com.theentertainerme.sckentertainer:id/cb_filter_selector\"])[4]"));
    }

    private WebElement filterTypeMensGrooming(){
        return androidDriver.findElement(By.xpath("(//android.widget.CheckBox[@resource-id=\"com.theentertainerme.sckentertainer:id/cb_filter_selector\"])[5]"));
    }

    private WebElement filterTypeSpas(){
        return androidDriver.findElement(By.xpath("(//android.widget.CheckBox[@resource-id=\"com.theentertainerme.sckentertainer:id/cb_filter_selector\"])[6]"));
    }

    private List<WebElement> filtersName(){
        String locator = "com.theentertainerme.sckentertainer:id/tv_filter_name";
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(androidDriver.findElement(By.id(locator))));
        return androidDriver.findElements(By.id(locator));
    }

    private List<WebElement> clearFiltersX(){
        return androidDriver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/tv_filter_remove\"]"));
    }

    private WebElement checkBoxForTheFilter(String filterText){
        return androidDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/tv_filter_name\" and @text=\""+filterText+"\"]/parent::android.widget.RelativeLayout[@resource-id=\"com.theentertainerme.sckentertainer:id/aditional_cotainer\"]//android.widget.LinearLayout[@resource-id=\"com.theentertainerme.sckentertainer:id/ll_checks_contaienr\"]"));
    }

    private WebElement filterCount(){
        return androidDriver.findElement(By.id("com.theentertainerme.sckentertainer:id/tv_filter_counts"));
    }

    private WebElement noResultsFound(){
        return androidDriver.findElement(By.xpath("//android.widget.TextView[@text=\"Sorry no results found.\"]"));
    }







    public String getScreenTitle(){
        return screenTitle().getText().trim();
    }

    public HomeScreen goBackToHomeScreen(){
        footerHomeText().click();
        return new HomeScreen(androidDriver);
    }

    public List<String> getConsolidateSearchResults(int scrollCount){
        List<String > searchResults = new ArrayList<>();
        List<WebElement > names = new ArrayList<>();
        List<WebElement> loc = new ArrayList<>();
        List<WebElement> distance = new ArrayList<>();
        names = merchantName();
        log.info("Merchant count : "+names.size());
        if(names.size()>=4) {
            for (int searchCount = 0; searchCount < scrollCount; searchCount++) {  //search & scroll x times
                names = merchantName();
                loc = merchantLocation();
                distance = merchantDistance();
                for (int i = 0; i < names.size()-1; i++) {
                    if (!searchResults.contains(names.get(i).getText().trim() + ":" + loc.get(i).getText().trim()+"("+ distance.get(i).getText().trim() +")")) {
                        log.info(names.get(i).getText().trim() + ":" + loc.get(i).getText().trim()+"("+ merchantDistance().get(i).getText().trim() +")");
                        searchResults.add(names.get(i).getText().trim() + ":" + loc.get(i).getText().trim()+"("+ merchantDistance().get(i).getText().trim() +")");
                    }
                }
                scroll();
            }
        }
        else
        {
            for (int i = 0; i < names.size() ; i++) {
                names = merchantName();
                loc = merchantLocation();
                distance = merchantDistance();
                //if (!searchResults.contains(names.get(i).getText().trim() + ":" + loc.get(i).getText().trim()+"("+ distance.get(i).getText().trim() +")")) {
                searchResults.add(names.get(i).getText().trim() + ":" + loc.get(i).getText().trim()+"("+ merchantDistance().get(i).getText().trim() +")");
                log.info(names.get(i).getText().trim() + ":" + loc.get(i).getText().trim()+"("+ merchantDistance().get(i).getText().trim() +")");
                //}
            }
        }
        return searchResults;
    }

    public void openFilters(){
        log.info("Opening filter ...");
        filters().click();
    }

    public boolean isFilterViewOpened(){
        return filterView().isDisplayed();
    }

    public void applyFilters(){
        log.info("Applying filter ...");
        filterDoneBtn().click();
        try {
            Thread.sleep(AppConstants.SEARCH_RESULTS_TIMEOUT);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getFiltersPopupTitle(){
        return filterTitle().getText().trim();
    }

    public List<String > getFiltersSections(){
        List<WebElement> sections = filterSections();
        List<String> sectionTitles = new ArrayList<>();
        for(WebElement section:sections){
            sectionTitles.add(section.getText().trim());
        }
        return sectionTitles;
    }

    public List<String> getAllFilterOptions(){
        List<WebElement> filters = filtersText();
        List<String> filterOptions = new ArrayList<>();
        for(WebElement filter:filters){
            filterOptions.add(filter.getText().trim());
        }

        scrollToEndAction();

        filters = filtersText();
        filterOptions = new ArrayList<>();
        for(WebElement filter:filters){
            filterOptions.add(filter.getText().trim());
        }

        return filterOptions;
    }

    public void selectNewOffers(){
        String checked = newOffersCheckBox().getAttribute("checked");
        if(checked.compareToIgnoreCase("true")==0)
            newOffersCheckBox().click();
    }

    public void unselectNewOffers(){
        String checked = newOffersCheckBox().getAttribute("checked");
        if(checked.compareToIgnoreCase("false")==0)
            newOffersCheckBox().click();
    }

    public void openFiltersType() throws InterruptedException {
        log.info("Opening filter type ...");
        filterType().click();
        Thread.sleep(500);
    }

    public List<String> getAllFilterTypes(){
        List<WebElement> filterTypes = filterTypeNames();
        List<String > filterNames = new ArrayList<>();
        for(WebElement element:filterTypes){
            filterNames.add(element.getText().trim());
        }
        return filterNames;
    }

    public void selectTypeAll(){
        filterTypeAll().click();
    }
    public void selectTypeBeautyHairAndNails(){
        filterTypeBeautyHairAndNails().click();
    }

    public void selectTypeHealthAndFitness(){
        filterTypeHealthAndFitness().click();
    }

    public void  selectTypeMedicalAndDental(){
        filterTypeMedicalAndDental().click();
    }

    public void selectTypeMensGrooming(){
        filterTypeMensGrooming().click();
    }

    public void selectTypeSpas(){
        filterTypeSpas().click();
    }

    public void selectFilterTypeAllAndClose() throws InterruptedException {
        log.info("Selecting filter type 'All' to close the popup ...");
        selectTypeAll();
        Thread.sleep(500);
    }

    public void selectSingleCheckBoxFromFilters(String filter) throws InterruptedException {
        boolean filterApplied = false;

        List<WebElement> filterElements = filtersName();
        for (WebElement element : filterElements) {
            if (element.getText().trim().compareTo(filter) == 0) {
                log.info(element.getText());
                checkBoxForTheFilter(filter).click();
                filterApplied = true;
                Thread.sleep(750);
                break;
            }
        }
    }

    public List<String> getAllTypesUnderFilter() {
        List<WebElement> filters = filtersName();
        List<String> filterValues = new ArrayList<>();
        //log.info("Total cuisine count : " + cuisineElements.size());

        for (WebElement filter : filters) {
            filterValues.add(filter.getText().trim());
            log.info(filter.getText().trim());
        }
        return filterValues;
    }

    public List<String> getAllAmenitiesOffered(){
        List<WebElement> amenities = filtersName();
        List<String> amenitiesOffer = new ArrayList<>();
        for(int count=0;count<4;count++) {
            for (int i = 1; i < amenities.size(); i++) {     // first element is for "New Offers"
                if (!amenitiesOffer.contains(amenities.get(i).getText().trim())) {
                    log.info(amenities.get(i).getText().trim());
                    amenitiesOffer.add(amenities.get(i).getText().trim());
                }
            }
            scroll();
            amenities = filtersName();
        }
        return amenitiesOffer;
    }

    public void resetSelectedAmenities(){
        resetFiltersView();
        for(int i =0;i<4;i++){
            List<WebElement> noElements = androidDriver.findElements(By.xpath("//android.widget.CheckBox[@resource-id=\"com.theentertainerme.sckentertainer:id/cb_filter_no\" and @checked=\"true\"]"));;
            List<WebElement> yesElements = androidDriver.findElements(By.xpath("//android.widget.CheckBox[@resource-id=\"com.theentertainerme.sckentertainer:id/cb_filter_yes\" and @checked=\"true\"]"));
            for(WebElement element:yesElements){
                element.click();
            }
            for(WebElement element:noElements){
                element.click();
            }
        }

    }

    public MerchantDetailsScreen openRandomMerchantDetails(){
        log.info("Opening random merchant ...");
        List<WebElement > names = new ArrayList<>();
        names = merchantName();
        int randomMerchant = utils.generateRandomNumber(0, names.size()-1);
        names.get(randomMerchant).click();
        return new MerchantDetailsScreen(androidDriver);
    }

    public void clearFilter() throws InterruptedException {
        List<WebElement> xButtons = clearFiltersX();
        xButtons.get(0).click();
        Thread.sleep(AppConstants.SEARCH_RESULTS_TIMEOUT);
    }

    public void clearAllFilters() throws InterruptedException {
        log.info("Clearing all filter ...");
        filterClearBtn().click();
        openFilters();
        openFiltersType();
        selectFilterTypeAllAndClose();
        applyFilters();
    }

    public boolean isThereMoreDataInResult(){
        return Boolean.parseBoolean(resultContainer().getAttribute("scrollable"));
    }

    public void selectSingleAmenity(String amenity, String type) throws InterruptedException {
        boolean applied = false;
        List<WebElement> amenities = filtersName();
        for(int count=0;count<3;count++) {
            for (WebElement element:amenities) {     // first element is for "New Offers"
                if (element.getText().trim().compareTo(amenity)==0) {
                    androidDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.theentertainerme.sckentertainer:id/tv_filter_name\" and @text=\""+amenity+"\"]//parent::android.widget.RelativeLayout[@resource-id=\"com.theentertainerme.sckentertainer:id/aditional_cotainer\"]//android.widget.CheckBox[@resource-id=\"com.theentertainerme.sckentertainer:id/cb_filter_"+type.toLowerCase()+"\"]")).click();
                    applied = true;
                    Thread.sleep(700);
                }
            }
            if(!applied) {
                scroll();
                amenities = filtersName();
            }
            if(applied){
                break;
            }
        }

    }

    public void resetFiltersView(){
        openFilters();
        for(int i=0;i<3;i++) {
            scrollToTop();
        }
        openFilters();
    }

    public String getCurrentlySelectedFiltersCountFromTopBar(){
        return filterCount().getText().trim();
    }

    public boolean noDataFound(){
        return noResultsFound().isDisplayed();
    }

    public void resetPositiveAmenities() throws InterruptedException {
        List<WebElement> positive = androidDriver.findElements(By.xpath("//android.widget.CheckBox[@resource-id=\"com.theentertainerme.sckentertainer:id/cb_filter_yes\" and @checked=\"true\"]"));
        for(WebElement element:positive){
            element.click();
            Thread.sleep(250);
        }
    }


    public void resetNegativeAmenities() throws InterruptedException {
        List<WebElement> negative = androidDriver.findElements(By.xpath("//android.widget.CheckBox[@resource-id=\"com.theentertainerme.sckentertainer:id/cb_filter_no\" and @checked=\"true\"]"));
        for(WebElement element:negative){
            element.click();
            Thread.sleep(250);
        }
    }

}
