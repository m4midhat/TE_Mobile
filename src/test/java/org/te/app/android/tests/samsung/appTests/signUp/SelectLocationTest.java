package org.te.app.android.tests.samsung.appTests.signUp;

import org.te.app.android.assertionConstants.samsung.SelectLocationScreenConstants;
import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.te.app.android.utils.utils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class SelectLocationTest extends SamsungBaseTest {

    Logger logger = Logger.getLogger(String.valueOf(SelectLocationTest.class));


    @BeforeClass
    public void clickOKToContinue(){
        selectLocationScreen.allowNotifications();
    }

    @Test(description = "Verify screen title")
    public void verifyScreenTitle(){
        String title = selectLocationScreen.getTopMessage();
        logger.info(title);
        Assert.assertEquals(title, SelectLocationScreenConstants.SCREEN_TITLE, "Incorrect screen title");
    }


    @Test(description = "Verify screen sub-title/message")
    public void verifySubTitle(){
        String subtitle = selectLocationScreen.getScreenMessage();
        //selectLocationScreen.clickOKButton();
        logger.info(subtitle);
        Assert.assertEquals(subtitle, SelectLocationScreenConstants.SCREEN_MSG, "Incorrect screen message");
    }

    @Test(description = "Verify if button 'OK, i have got it' is available", priority = 2)
    public void verifyBtnIGotItIsAvailable(){
        boolean btnOKAvailable = selectLocationScreen.isOKButtonAvailable();
        selectLocationScreen.clickOKButton();
        Assert.assertTrue(btnOKAvailable, "OK button is not available");

    }


    @Test(description = "Verify if DONE button is available", priority = 3)
    public void verifyIfDoneButtonIsAvailable(){
        boolean doneBtn = selectLocationScreen.isDoneButtonAvailable();
        Assert.assertTrue(doneBtn, "Done button is not available");
    }


    @Test(description = "Verify locations", priority = 3)
    public void verifyLocations() {
        List<String> locationsList = new ArrayList<>();
        List<String> allLocations = selectLocationScreen.getLocationsList();
        for (String location : allLocations) {
            logger.info(location);
            locationsList.add(location);
        }
        SoftAssert softAssert = new SoftAssert();
        for(int i=0;i<locationsList.size();i++){
            softAssert.assertEquals(locationsList.get(i), SelectLocationScreenConstants.LOCATIONS[i],
                    "Incorrect location. Expected Location : "+SelectLocationScreenConstants.LOCATIONS[i]+" Received : "+locationsList.get(i));
        }
        softAssert.assertAll();
    }

    @Test(description = "Verify all checkboxes are un-checked at load", priority = 3)
    public void verifyCheckboxStatus(){
        int totalCheckboxes = selectLocationScreen.getAllLocationsCount();
        logger.info("Total checkboxes : "+ totalCheckboxes);
        SoftAssert softAssert = new SoftAssert();
        for(int i=0;i<totalCheckboxes;i++){
            softAssert.assertFalse(selectLocationScreen.isCheckboxChecked(i), "Checkbox is not un-checked by-default");
        }
        softAssert.assertAll();
    }

    @Test(description = "Verify the checkbox status after selection", priority = 4)
    public void verifyCheckBoxStatusAfterSelection(){
        int totalCheckboxes = selectLocationScreen.getAllLocationsCount();
        int randomSelection = utils.generateRandomNumber(0, totalCheckboxes-1);
        logger.info("Random selection made : "+ randomSelection);
        selectLocationScreen.selectNationalityCheckbox(randomSelection-1);
        boolean randomStatusCheck = selectLocationScreen.isCheckboxChecked(randomSelection-1);
        selectLocationScreen.selectNationalityCheckbox(randomSelection-1);
        Assert.assertTrue(randomStatusCheck, "Checkbox is not updated correctly");
    }

    @AfterClass
    public void navigateToHome(){
        selectLocationScreen.selectNationalityCheckbox(0);  //select abu dhabi & al ain
        homeScreen = selectLocationScreen.clickDoneButton();
    }

}
