package org.te.app.android.tests.samsung.appTests.existingUser;

import lombok.extern.slf4j.Slf4j;
import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

@Slf4j
public class FavouritesTest extends SamsungBaseTest {

    @DataProvider(name = "favouriteData")
    public Object[][] dpMethod(){
        return new Object[][] {
                {"safari"},
                {"Spa"},
                {"Burger king"},
                {"Papa murphy"},
                {"nasma"}
        };
    }

    @Test(description = "Add items into the favourites", dataProvider = "favouriteData")
    public void addItemsToFavourite(String searchItem) throws InterruptedException {
        searchScreen.searchForTerm(searchItem);
        merchantDetailsScreen = searchScreen.openRandomMerchantDetails();
        merchantDetailsScreen.addToFavourite();
        searchScreen = merchantDetailsScreen.goBackToSearchScreen();
        /*homeScreen = searchScreen.pressBack();
        profileScreen = homeScreen.openProfileScreen();
        favouriteScreen = profileScreen.openFavorites();
        List<String> list = favouriteScreen.getFavourites();
        for(String item:list){
            log.info(item);
        }
        profileScreen = favouriteScreen.goBackToProfileScreen();
        homeScreen = profileScreen.goBackToHomeScreen();
        searchScreen = homeScreen.clickSearchIcon();*/
    }

    @Test(description = "Verify cleared favourite", priority = 100)
    public void verifyFavouritesAfterRemoval(){
        homeScreen = searchScreen.pressBack();
        profileScreen = homeScreen.openProfileScreen();
        favouriteScreen = profileScreen.openFavorites();
        List<String> favList = favouriteScreen.getFavourites();
        log.info("Total items in favourites : "+favList.size());
        favouriteScreen.removeRandomlyFromFavourite();
        List<String> favList2 = favouriteScreen.getFavourites();
        log.info("Total items in favourites after removal : "+favList2.size());
        Assert.assertNotEquals(favList, favList2);
    }




    @AfterClass
    public void goBackToHome(){
        profileScreen = favouriteScreen.goBackToProfileScreen();
        profileScreen.goBackToHomeScreen();
    }
}
