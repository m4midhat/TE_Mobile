package org.te.app.android.tests.samsung.appTests.existingUser;

import lombok.extern.slf4j.Slf4j;
import org.te.app.android.AppConstants.AppConstants;
import org.te.app.android.assertionConstants.samsung.ProfileDetailsScreenConstants;
import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.te.app.android.utils.utils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@Slf4j
public class ProfileDetailsTest extends SamsungBaseTest {

    @Test(description = "Verify screen title")
    public void verifyScreenTitle(){
        String title = profileDetailsScreen.getScreenTitle();
        log.info(title);
        Assert.assertEquals(title, ProfileDetailsScreenConstants.TITLE, "Incorrect screen title");
    }

    @Test(description = "Verify the user first name under profile details")
    public void verifyUserFirstName(){
        String fName = profileDetailsScreen.getFirstNameFromProfileDetails();
        log.info("User First Name : "+fName);
        Assert.assertFalse(fName.isEmpty(), "First name should be populated");
    }

    @Test(description = "Verify the user last name under profile details")
    public void verifyUserLastName(){
        String lName = profileDetailsScreen.getLastNameFromProfileDetails();
        log.info("User Last Name : "+lName);
        Assert.assertFalse(lName.isEmpty(), "Last name should e populated");
    }

    @Test(description = "Verify the user email under profile details")
    public void verifyUserEmailAddress(){
        String email = profileDetailsScreen.getEmailAddressFromProfileDetails();
        log.info("User Email Address : "+email);
        Assert.assertFalse(email.isEmpty(), "Email address should be populated");
    }

    @Test(description = "Verify the user country of residence profile details")
    public void verifyUserResidence(){
        String residence = profileDetailsScreen.getCountryOfResidenceFromProfileDetails();
        log.info("User Residence : "+residence);
        Assert.assertFalse(residence.isEmpty(), "Country of residence should be populated");
    }

    @Test(description = "Verify if first name field is not editable")
    public void verifyFirstNameIsNotEditable(){
        Assert.assertFalse(profileDetailsScreen.isFirstNameEditable(), "First name field should not be editable");
    }

    @Test(description = "Verify if last name field is not editable")
    public void verifyLastNameIsNotEditable(){
        Assert.assertFalse(profileDetailsScreen.isLastNameEditable(), "Last name field should not be editable");
    }

    @Test(description = "Verify if email address field is not editable")
    public void verifyEmailAddressIsNotEditable(){
        Assert.assertFalse(profileDetailsScreen.isEmailEditable(), "Email address field should not be editable");
    }

    @Test(description = "Verify if residence field is editable")
    public void verifyCODIsEditable(){
        Assert.assertTrue(profileDetailsScreen.isCODEditable(), "Country of residence field should be editable");
    }

    @Test(description = "Verify if currency field is editable")
    public void verifyCurrencyIsNotEditable(){
        Assert.assertTrue(profileDetailsScreen.isCurrencyEditable(), "Currency field should be editable");
    }

    @Test(description = "Verify save button is displayed")
    public void verifySaveButtonAvailability() {
        Assert.assertTrue(profileDetailsScreen.isBtnSaveDisplayed(), "Save button is not displayed");
    }


    @Test(description = "Verify save button text", dependsOnMethods = "verifySaveButtonAvailability")
    public void verifySaveButtonText(){
        String btnText = profileDetailsScreen.getBtnSaveText();
        log.info(btnText);
        Assert.assertEquals(btnText, ProfileDetailsScreenConstants.BTN_SAVE, "Incorrect button title for 'Save'");
    }



    @AfterClass
    public void goBackToHomeAfterUpdatingCurrency() throws InterruptedException {
        log.info("Currency already selected : "+currency_at_home);
        int randomNumber = utils.generateRandomNumber(0, ProfileDetailsScreenConstants.CURRENCIES.length - 1);
        AppConstants.SELECTED_CURRENCY_FROM_PROFILE_DETAILS = ProfileDetailsScreenConstants.CURRENCIES[randomNumber];
        while (ProfileDetailsScreenConstants.CURRENCIES[randomNumber].compareTo(currency_at_home)==0) {
            randomNumber = utils.generateRandomNumber(0, ProfileDetailsScreenConstants.CURRENCIES.length - 1);
            AppConstants.SELECTED_CURRENCY_FROM_PROFILE_DETAILS = ProfileDetailsScreenConstants.CURRENCIES[randomNumber];
            log.info("Updating the currency to : "+ProfileDetailsScreenConstants.CURRENCIES[randomNumber]);
        }
        profileScreen = profileDetailsScreen.updatePreferredCurrency(ProfileDetailsScreenConstants.CURRENCIES[randomNumber]);
        homeScreen = profileScreen.goBackToHomeScreen();
    }
}
