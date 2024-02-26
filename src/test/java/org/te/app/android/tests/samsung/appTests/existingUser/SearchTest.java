package org.te.app.android.tests.samsung.appTests.existingUser;

import lombok.extern.slf4j.Slf4j;
import org.te.app.android.assertionConstants.samsung.SearchScreenConstants;
import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.te.app.android.utils.utils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class SearchTest extends SamsungBaseTest {

    List<String> results = new ArrayList<>();

    @DataProvider(name = "searchData")
    public Object[][] dpMethod(){
        return new Object[][] {
                {"Biryani"},
                {"Pizza"}
        };
    }

    @Test(description = "Verify title")
    public void verifyScreenTitle(){
        String title = searchScreen.getTitle();
        log.info(title);
        Assert.assertEquals(title, SearchScreenConstants.TITLE, "Incorrect screen title");
    }


    @Test(description = "Verify searching for a few terms", dataProvider = "searchData", priority = 1)
    public void verifySearch(String keyword) throws InterruptedException {
        log.info("Searching for : "+ keyword);
        searchScreen.searchForTerm(keyword);
        String searchFor = searchScreen.getSearchFor();
        log.info(searchFor);
        results = searchScreen.getConsolidateSearchResults(3);
        log.info(results.toString());
        Assert.assertTrue(searchFor.contains(SearchScreenConstants.RESULT_FOR),
                "Incorrect information message text, should include '"+SearchScreenConstants.RESULT_FOR+"'");
        SoftAssert softAssert = new SoftAssert();
        for(String item:results){
            softAssert.assertTrue(item.contains(keyword), "Search results does not contain the keyword : "+keyword);
        }
        softAssert.assertAll();
    }

    @Test(description = "Results should be in ascending order w.r.t the distance", priority = 2)
    public void verifyDistanceOrder(){
        List<String> distances = new ArrayList<>();
        for(String item: results){
            String dist = utils.returnDistance(item);
            distances.add(dist);
            log.info(item+" : "+dist);
        }
        List<String > sortedList = distances;
        Collections.sort(sortedList);
        log.info("Distance returned from the app: "+distances.toString());
        log.info("Sorted distance : "+sortedList.toString());
        Assert.assertEquals(distances, sortedList, "Results are not sorted as per distance");
    }

    @Test(description = "Recent search", priority = 100, dataProvider = "searchData")
    public void verifyRecentSearch(String keyword) throws InterruptedException {
        homeScreen = searchScreen.pressBack();
        searchScreen = homeScreen.clickSearchIcon();
        Thread.sleep(2500);
        List<String > latestSearches = searchScreen.getRecentSearches();
        log.info("Searching "+keyword + " to be available in the recent searches "+latestSearches.toString()+" ...");
        Assert.assertTrue(latestSearches.contains(keyword), "Recent search does not contain the latest search keywords");
    }



    @AfterClass
    public void openFashionCategory(){
        homeScreen = searchScreen.pressBack();
        fashionRetailScreen = homeScreen.openFashionRetail();
    }
}
