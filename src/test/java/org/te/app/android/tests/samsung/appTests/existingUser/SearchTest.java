package org.te.app.android.tests.samsung.appTests.existingUser;

import lombok.extern.slf4j.Slf4j;
import org.te.app.android.assertionConstants.samsung.SearchScreenConstants;
import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

@Slf4j
public class SearchTest extends SamsungBaseTest {

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
        Assert.assertEquals(title, SearchScreenConstants.TITLE);
    }


    @Test(description = "Verify searching for a few terms", dataProvider = "searchData", priority = 1)
    public void verifySearch(String keyword) throws InterruptedException {
        log.info("Searching for : "+ keyword);
        searchScreen.searchForTerm(keyword);
        String searchFor = searchScreen.getSearchFor();
        log.info(searchFor);
        List<String> results = searchScreen.getConsolidateSearchResults(3);
        log.info(results.toString());
        Assert.assertTrue(searchFor.contains(SearchScreenConstants.RESULT_FOR));
    }

    @Test(description = "Recent search", priority = 100, dataProvider = "searchData")
    public void verifyRecentSearch(String keyword) throws InterruptedException {
        homeScreen = searchScreen.pressBack();
        searchScreen = homeScreen.clickSearchIcon();
        Thread.sleep(2500);
        List<String > latestSearches = searchScreen.getRecentSearches();
        log.info("Searching "+keyword + " to be available in the recent searches "+latestSearches.toString()+" ...");
        Assert.assertTrue(latestSearches.contains(keyword));
    }



    @AfterClass
    public void openFashionCategory(){
        homeScreen = searchScreen.pressBack();
        fashionRetailScreen = homeScreen.openFashionRetail();
    }
}
