package org.te.app.android.tests.appTests.prospectUser;

import com.github.javafaker.Faker;
import org.te.app.android.assertionConstants.signUpScreenConstants;
import org.te.app.android.tests.baseTest.BaseTest;
import org.te.app.android.utils.utils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.util.Calendar.*;

public class SignUpTest extends BaseTest {

    @Test(description = "Verify screen header")
    public void verifyScreenHeader(){
        String header = signUpScreen.getHeader();
        Assert.assertEquals(header, signUpScreenConstants.HEADER, "Incorrect text for screen header, expected value: "+ signUpScreenConstants.HEADER+" Received value: "+ header);
    }

    @Test(description = "Verify screen title")
    public void verifyScreenTitle(){
        String title = signUpScreen.getTitle();
        Assert.assertEquals(title, signUpScreenConstants.TITLE, "Incorrect screen title, expected value: "+ signUpScreenConstants.TITLE+" Received value: "+ title);
    }

    @Test(priority = 1, description = "Sign up to Application")
    public void signUpToApplicationTest() throws InterruptedException {
        String mm = utils.extractMonth();
        String dd = utils.extractDate();
        String yyyy = utils.getYearForAge(18);
        String dob = mm+dd+yyyy;
        System.out.println("Selected DOB : "+dob);
        Faker faker = new Faker();
        String nationality = faker.nation().nationality();
        enableLocationScreen = signUpScreen.signUp(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), "P@ssword123", dob, nationality.substring(0, 1));
    }

}
