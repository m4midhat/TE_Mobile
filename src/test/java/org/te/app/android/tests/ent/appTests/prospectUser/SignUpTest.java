package org.te.app.android.tests.ent.appTests.prospectUser;

import com.github.javafaker.Faker;
import org.te.app.android.assertionConstants.ent.signUpScreenConstants;
import org.te.app.android.tests.baseTest.ent.EntertainerBaseTest;
import org.te.app.android.utils.dbDriver;
import org.te.app.android.utils.utils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.io.IOException;


public class SignUpTest extends EntertainerBaseTest {

    private static final Logger logger = Logger.getLogger(SignUpTest.class);
    @Test(description = "Verify screen header")
    public void verifyScreenHeader(){
        String header = signUpScreen.getHeader();
        logger.info(header);
        Assert.assertEquals(header, signUpScreenConstants.HEADER, "Incorrect text for screen header, expected value: "+ signUpScreenConstants.HEADER+" Received value: "+ header);
    }

    @Test(description = "Verify screen title")
    public void verifyScreenTitle(){
        String title = signUpScreen.getTitle();
        Assert.assertEquals(title, signUpScreenConstants.TITLE, "Incorrect screen title, expected value: "+ signUpScreenConstants.TITLE+" Received value: "+ title);
    }

    @Test(priority = 1, description = "Sign up to Application")
    public void signUpToApplicationTest() throws InterruptedException, IOException {
        String mm = utils.extractMonth();
        String dd = utils.extractDate();
        String yyyy = utils.getYearForAge(18);
        String dob = mm+dd+yyyy;
        logger.info("Selected DOB : "+dob);
        Faker faker = new Faker();
        String nationality = dbDriver.getRandomCountry();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String emailAddress = faker.internet().emailAddress();
        logger.info("Signing in with First Name : "+ firstName+ " Last name : " + lastName+" Email Address : " + emailAddress+" DOB : "+dob+" Nationality : "+ nationality);

        enableLocationScreen = signUpScreen.signUp(firstName, lastName, emailAddress, "P@ssword123", dob, nationality);
    }

}
