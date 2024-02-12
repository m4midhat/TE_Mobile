package org.te.app.android.tests.samsung.appTests;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.te.app.android.assertionConstants.samsung.CreateAccountScreenConstants;
import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.*;

@Slf4j
public class CreateAccountTest extends SamsungBaseTest {

    private List<String> countries = new ArrayList<>();
    private Faker faker = new Faker(Locale.US);


    @BeforeClass
    private void getCountries(){
        createAccount.openCountryOfResidenceDropDown();
        countries = createAccount.getAllCountries();
        createAccount.closeCountryDropDown();
    }

    @BeforeMethod
    public void scrollToTheTop(){
        createAccount.scrollToTop();
        log.info("Scrolling to the top .....");
    }


    @Test(description = "Verify the countries list", priority = 1)
    public void verifyCountriesList(){
        log.info("Countries from the app: "+ countries);
        log.info("Countries expected : "+ Arrays.toString(CreateAccountScreenConstants.NATIONALITIES));
        SoftAssert softAssert = new SoftAssert();
        int index = 0;
       // Assert.assertEquals(countries, Arrays. CreateAccountScreen.NATIONALITIES);
        for(String nationality: CreateAccountScreenConstants.NATIONALITIES){
            softAssert.assertEquals(nationality, countries.get(index));
            index++;
        }
        softAssert.assertAll();
    }

    @Test(description = "Verify error message when no information is provided")
    public void verifyErrorMessageWhenNoInformationIsProvided() throws InterruptedException {
        createAccount.registerNewUser("", "","", "", "", false, false);
        createAccount.setVoucherCode("");
        createAccount.hideKeyboard();
        String errorForFirstName = createAccount.getErrorTextForFirstName();
        String errorForLastName = createAccount.getErrorTextForLastName();
        String errorForEmail = createAccount.getErrorTextForEmail();
        String errorForPassword = createAccount.getErrorTextPassword();
        String errorForConfirmedPassword = createAccount.getErrorTextForConfirmPassword();
        log.info(errorForFirstName);
        log.info(errorForLastName);
        log.info(errorForEmail);
        log.info(errorForPassword);
        log.info(errorForConfirmedPassword);
    }


    @Test(description = "Verify error message when no first name is provided", priority = 1)
    public void verifyErrorMessageWhenFirstNameIsNotProvided() throws InterruptedException {
        createAccount.registerNewUser("", faker.name().lastName(), faker.internet().emailAddress(), "", "P@ssword1", false, false);
        String errorMessage = createAccount.getErrorTextForFirstName();
        log.info("Error message : "+ errorMessage);
        Assert.assertEquals(errorMessage, CreateAccountScreenConstants.ERROR_NO_FIRST_NAME);
        Assert.assertTrue(createAccount.isErrorForFirstNameVisible(), "Error message for first name is not displayed");
    }

    @Test(description = "Verify error message when no last name is provided", priority = 1)
    public void verifyErrorMessageWhenLastNameIsNotProvided() throws InterruptedException {
        createAccount.registerNewUser(faker.name().firstName(), "", faker.internet().emailAddress(), "", "P@ssword1", false, false);
        createAccount.setVoucherCode("");
        String errorMessage = createAccount.getErrorTextForLastName();
        log.info("Error message : "+ errorMessage);
        Assert.assertEquals(errorMessage, CreateAccountScreenConstants.ERROR_NO_LAST_NAME);
        Assert.assertTrue(createAccount.isErrorForLastNameVisible(), "Error message for last name is not displayed");
    }

    @Test(description = "Verify error message when no email is provided", priority = 1)
    public void verifyErrorMessageWhenEmailIsNotProvided() throws InterruptedException {
        createAccount.registerNewUser(faker.name().firstName(), faker.name().lastName(), "", "", "P@ssword1", false, false);
        String errorMessage = createAccount.getErrorTextForEmail();
        log.info("Error message : "+ errorMessage);
        Assert.assertEquals(errorMessage, CreateAccountScreenConstants.ERROR_NO_EMAIL);
        Assert.assertTrue(createAccount.isErrorForEmailVisible(), "Error message for email is not displayed");
    }

    @Test(description = "Verify error message when valid email is not provided", priority = 1)
    public void verifyErrorMessageWhenInvalidEmailIsProvided() throws InterruptedException {
        createAccount.registerNewUser(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress().replace("@",""), "", "P@ssword1", false, false);
        String errorMessage = createAccount.getErrorTextForEmail();
        log.info("Error message : "+ errorMessage);
        Assert.assertEquals(errorMessage, CreateAccountScreenConstants.ERROR_INVALID_EMAIL);
        Assert.assertTrue(createAccount.isErrorForEmailVisible(), "Error message for email is not displayed");
    }

    @AfterClass
    public void registrationTest() throws InterruptedException {
        createAccount.scrollToTop();
        selectLocationScreen = createAccount.registerNewUser(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), "", "P@ssword1", true, true);

    }
}
